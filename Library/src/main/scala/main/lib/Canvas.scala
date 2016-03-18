package main.lib

import main.recorder.CCapture
import org.scalajs.dom
import org.scalajs.dom.{html, MouseEvent}
import org.scalajs.dom.raw.{Node, Location, KeyboardEvent}

import scala.scalajs.js
import scala.scalajs.js.JSApp

/**
  * Created by martin on 20/10/15.
  */
trait Canvas extends WorldCoordinates{

  case class CanvasState(
                          scene:Scene,
                          camera: Camera,
                          renderer: WebGLRenderer,
                          clock: Clock,
                          body: dom.Node,
                          currentTime: Long
                        )

  //self: Helpers=>
  def setup():Unit = {

  }

  def run():Unit = {
    setup()
    composer = new EffectComposer(renderer)
    renderLoop()(System.currentTimeMillis())
  }

  var faceSide: Side = THREE.FrontSide
  val _center = new Vector3(0,0,500)
  val leftBottomPosition = new Vector3(width / 2, height / 2, 1000)
  var position = _center

  var renderAction: Canvas => Unit = { c: Canvas => c.renderer.render(c.scene, c.camera, forceClear = !c.canvasStyle)}
  var clearObjectsAction: Canvas => Unit = {c=>}
  var canvasStyle = false
  var withStatsRender = false
  var withControlsRender = false
  var withAntialiasing = false
  var aliasingAction: Canvas => Unit = {c=>}

  val canvasData: CanvasData

  //var lineMaterial: LineBasicMaterial


  val stats = new Stats()
  var controls:OrbitControls = null
  var composer:EffectComposer = null

  var delta:Double = 0
  var frameCount:Long = 0

  var mouseX = 0.0
  var mouseY = 0.0

  dom.window.onmousemove = {
    event:MouseEvent =>
      mouseX = event.clientX
      mouseY = dom.window.innerHeight - event.clientY
  }

  def render():Unit

  val minFrameRate = 1
  var times = 0


  val capturer = new CCapture(js.Dynamic.literal(format = "webm", verbose= true))
  var aaa = false

  dom.window.onkeypress = { e: KeyboardEvent =>
    aaa = !aaa
    if(aaa)
      capturer.start
    else {
      capturer.stop
      capturer.save({blob:Location => dom.window.location = blob})
    }
  }

  def renderLoop(canvasState: CanvasState)(timestamp: Double){

    delta = canvasState.clock.getDelta() //seconds
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

    dom.window.requestAnimationFrame(renderLoop(canvasState.copy())) _)
    render
    if(aaa) capturer.capture(renderer.domElement)
    renderAction(this)
    clearObjectsAction(this)
    camera.updateMatrix()
  }

  object Setup{
    case class SetupConfig(
                            renderAction: Canvas => Canvas,
                            clearObjectsAction: Canvas => Canvas,
                            aliasingAction: Canvas => Canvas,
                            positionAction: Canvas => Canvas
                          )

    private def resetPosition = camera.position.set(position.x, position.y, position.z)

    var renderAction: Canvas => Canvas = { c: Canvas => c.renderer.render(c.scene, c.camera, forceClear = !c.canvasStyle)}
    var clearObjectsAction: Canvas => Canvas = {c=>c}
    var aliasingAction: Canvas => Canvas = {c=>c}

    var canvasStyle = false
    var withStatsRender = false
    var withControlsRender = false
    var withAntialiasing = false

    def getConfig:SetupConfig = SetupConfig(renderAction, clearObjectsAction, aliasingAction)

    def Center= {
      position = _center
      worldCoordinates = CenterCoordiantes
      resetPosition
      this
    }
    def LeftBottom={
      position = leftBottomPosition
      worldCoordinates = LeftBottomCoordiantes
      resetPosition
      this
    }

    def _3D = {
      //new MeshBasicMaterial(js.Dynamic.literal(color= 0xffff00, side= THREE.DoubleSide))
      camera = new PerspectiveCamera( 45, width / height, 1, 1000 )
      faceSide = THREE.DoubleSide
      resetPosition
      this
    }
    def _2D = {
      //new MeshBasicMaterial(js.Dynamic.literal(color= 0xffff00))
      renderer.sortObjects = false
      camera = new OrthographicCamera( width / - 2, width / 2, height / 2, height / - 2, -1000, 1000 )
      faceSide = THREE.FrontSide
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
      clearObjectsAction = {
        scene.children.foreach {
          case m: Mesh[_] =>
            //scene.remove(m) //Doesn't seem necesary
            m.geometry.dispose()
            m.material.dispose()
          case _ =>
        }
        scene = new Scene()
        aliasingAction
      }
      this
    }
    def noClear = {
      clearObjectsAction = {c=>}
      this
    }
    def asCanvas={
      canvasStyle=true
      renderer.autoClear = false
      renderer.autoClearColor = false
      autoClear
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
      controls.center = _center
      this
    }
    def antialiasing = {

      val effect = new ShaderPass(FXAAShader)

      //TODO: render to screen should be the last one, check on that later
      effect.renderToScreen = true

      aliasingAction = { c =>
        effect.uniforms.resolution.value.set(1.0 / c.width, 1.0 / c.height)
        c.composer = new EffectComposer( c.renderer )
        c.composer.addPass(effect)
        val rp = new RenderPass(c.scene, c.camera)
        c.composer.addPass(rp)
      }

      renderAction = c => c.composer.render(1)
      this
    }
    def noAntialiasing = {
      aliasingAction = { c =>
        renderAction = c => c.renderer.render(scene, camera, forceClear = !canvasStyle)
      }
    }
  }
}
