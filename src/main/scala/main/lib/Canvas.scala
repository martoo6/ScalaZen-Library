package main.lib

import org.scalajs.dom
import org.scalajs.dom.MouseEvent

import scala.scalajs.js.JSApp

/**
 * Created by martin on 20/10/15.
 */
trait Canvas extends JSApp with WorldCoordinates{
  //self: Helpers=>

  override def main():Unit = {
    renderLoop(System.currentTimeMillis())
  }

  val center = new Vector3(0,0,500)
  val leftBottomPosition = new Vector3(width / 2, height / 2, 1000)
  var position = center

  var renderAction: Unit => Unit = {_=>renderer.render(scene, camera, forceClear = !canvasStyle)}
  var clearObjectsAction: Unit => Unit = {_=>}
  var canvasStyle = false
  var withStatsRender = false
  var withControlsRender = false

  object Setup
  {
    private def resetPosition = camera.position.set(position.x, position.y, position.z)

    def Center= {
      position = center
      resetPosition
      this
    }
    def LeftBottom={
      position = leftBottomPosition
      resetPosition
      this
    }
    def _3D = {
      //new MeshBasicMaterial(js.Dynamic.literal(color= 0xffff00, side= THREE.DoubleSide))
      camera = new PerspectiveCamera( 45, width / height, 1, 1000 )
      resetPosition
      this
    }
    def _2D = {
      //new MeshBasicMaterial(js.Dynamic.literal(color= 0xffff00))
      camera = new OrthographicCamera( width / - 2, width / 2, height / 2, height / - 2, -1000, 1000 )
      resetPosition
      this
    }
    def ortho = {
      camera = new OrthographicCamera( width / - 2, width / 2, height / 2, height / - 2, -1000, 1000 )
      resetPosition
      this
    }
    def perspective = {
      camera = new PerspectiveCamera( 45, width / height, 1, 1000 )
      resetPosition
      this
    }
    def autoClear = {
      clearObjectsAction = { _ =>
        val l = scene.children.length
        (0 to l).reverse.foreach{ i=>
          val c = scene.children(i)
          c match{
            case m:Mesh[_]=>
              m.material.dispose()
              m.geometry.dispose()
            case _ =>
          }
          scene.remove(c)
        }
      }
      this
    }
    def noClear = {
      clearObjectsAction = {_=>}
      this
    }
    def asCanvas={
      canvasStyle=true
      renderer.autoClear = false
      renderer.autoClearColor = false
      this
    }
    def asScene={
      canvasStyle=false
      renderer.autoClear = true
      renderer.autoClearColor = true
      this
    }
    def withStats={
      withStatsRender = true
      stats.domElement.style.position = "absolute"
      stats.domElement.style.top = "0px"
      body.appendChild( stats.domElement )
      this
    }
    def withControls={
      controls = new OrbitControls(camera , renderer.domElement)
      withControlsRender = true
      controls.center = origin
      this
    }
    def antialiasing = {
      composer.addPass( new RenderPass( scene, camera ) )

      val effect = new ShaderPass(FXAAShader)
      effect.uniforms.resolution.value.set( 1.0 / width, 1.0 / height )

      //TODO: render to screen should be the last one, check on that later
      effect.renderToScreen = true
      composer.addPass( effect )
      renderAction = _ => composer.render(1)
      this
    }
  }


  val canvasData: CanvasData

  var lineMaterial: LineBasicMaterial
  var scene:Scene
  var camera: Camera
  var renderer: WebGLRenderer
  var clock: Clock
  var body: dom.Node


  val stats = new Stats()
  var controls:OrbitControls = null
  val composer:EffectComposer

  var delta:Double = 0
  var frameCount:Long = 0

  var mouseX = 0.0
  var mouseY = 0.0

  dom.onmousemove = {
    event:MouseEvent =>
      mouseX = event.clientX
      mouseY = dom.window.innerHeight - event.clientY
  }

  def render():Unit

  val minFrameRate = 1
  var times = 0
  def renderLoop(timestamp: Double){

    delta = clock.getDelta() //seconds
    frameCount+=1

    //Should replace for function/s that execute whats needed instead of ugly ifs
    if(withControlsRender) controls.update()
    if(withStatsRender) stats.update()
    if(delta>1/minFrameRate && frameCount>60){
      times+=1
      if(times > 15) throw new Error(s"Im preventing your machine from exploding, optimize your code! Last delta was: $delta")
    } else {
      times=0
    }

    clearObjectsAction()

    dom.requestAnimationFrame(renderLoop _)
    render
    renderAction()
    camera.updateMatrix()
  }
}
