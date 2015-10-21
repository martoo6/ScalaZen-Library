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

  object Setup
  {
    val center = new Vector3(0,0,500)
    val leftBottom = new Vector3(width / 2, height / 2, 1000)
    var position = center

    var clearObjectsAction: Unit => Unit = {_=>}
    var canvasStyle = false
    var withStatsRender = false
    var withControlsRender = false

    def Center= {
      position = center
      camera.position.set(position.x, position.y, position.z)
      this
    }
    def LeftBottom={
      position = leftBottom
      camera.position.set(position.x, position.y, position.z)
      this
    }
    def _3D = {
      //new MeshBasicMaterial(js.Dynamic.literal(color= 0xffff00, side= THREE.DoubleSide))
      camera = new PerspectiveCamera( 45, width / height, 1, 1000 )
      camera.position.set(position.x, position.y, position.z)
      this
    }
    def _2D = {
      //new MeshBasicMaterial(js.Dynamic.literal(color= 0xffff00))
      camera = new OrthographicCamera( width / - 2, width / 2, height / 2, height / - 2, -1000, 1000 )
      camera.position.set(position.x, position.y, position.z)
      this
    }
    def ortho = {
      camera = new OrthographicCamera( width / - 2, width / 2, height / 2, height / - 2, -1000, 1000 )
      camera.position.set(position.x, position.y, position.z)
      this
    }
    def perspective = {
      camera = new PerspectiveCamera( 45, width / height, 1, 1000 )
      camera.position.set(position.x, position.y, position.z)
      this
    }
    def autoClear = {
      clearObjectsAction = { _ =>
        val l = scene.children.length
        (0 to l).reverse.foreach{ i=>
          val c = scene.children(i)
          c match{
            case m:Mesh=>
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
      this
    }
    def asScene={
      canvasStyle=false
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
  }


  val canvasData: CanvasData

//  var lineMaterial: LineBasicMaterial  = null
//  var meshMaterial: Material           = null
//  var scene:Scene                      = null
//  var camera: Camera                   = null
//  var renderer: WebGLRenderer          = null
//  var clock: Clock                     = null
//  var body: dom.Node                   = null

  var lineMaterial: LineBasicMaterial
  var meshMaterial: Material
  var scene:Scene
  var camera: Camera
  var renderer: WebGLRenderer
  var clock: Clock
  var body: dom.Node


  val stats = new Stats()
  var controls:OrbitControls = null


  def start() = {
    println(canvasData)
    lineMaterial = canvasData.lineMaterial
    meshMaterial = canvasData.meshMaterial
    scene        = canvasData.scene
    camera       = canvasData.camera
    renderer     = canvasData.renderer
    clock        = canvasData.clock
    body         = canvasData.body
    println("started")
  }

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

  def renderLoop(timestamp: Double){
    delta = clock.getDelta()
    frameCount+=1

    //Should replace for function/s that execute whats needed instead of ugly ifs
    if(Setup.withControlsRender) controls.update()
    if(Setup.withStatsRender) stats.update()
    Setup.clearObjectsAction()


    dom.requestAnimationFrame(renderLoop _)
    render
    renderer.render(scene, camera, forceClear = !Setup.canvasStyle)
    camera.updateMatrix()
  }
}
