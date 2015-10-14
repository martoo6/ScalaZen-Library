package main

import org.scalajs.dom
import org.scalajs.dom.raw.MouseEvent

import scala.scalajs.js

/**
 * Created by martin on 09/10/15.
 */
trait BasicCanvas {
  self: Helpers=>

  var lineMaterial            = new LineBasicMaterial(js.Dynamic.literal(color = white, side= THREE.DoubleSide))
  var meshMaterial: Material  = new MeshBasicMaterial(js.Dynamic.literal(color= white, side= THREE.DoubleSide))
  val scene                   = new Scene()
  var camera: Camera          = new OrthographicCamera( width / - 2, width / 2, height / 2, height / - 2, -1000, 1000 )

  val renderer = new WebGLRenderer(js.Dynamic.literal(preserveDrawingBuffer=true))
  renderer.autoClear = false

  renderer.setSize(dom.window.innerWidth, dom.window.innerHeight)
  val e =renderer.domElement
  val b: dom.Node = dom.document.body
  b.appendChild(e)


  val stats = new Stats()
  stats.domElement.style.position = "absolute"
  stats.domElement.style.top = "0px"
  b.appendChild( stats.domElement )


  var clock = new Clock()
  var delta:Double = 0
  var frameCount:Long = 0

  val canvasData = (lineMaterial, meshMaterial, scene, camera, renderer, clock)

  dom.onmousemove = {
    event:MouseEvent =>
      mouseX = event.clientX
      mouseY = event.clientY
  }

  def render():Unit

  def renderLoop(timestamp: Double){
    delta = clock.getDelta()
    frameCount+=1

    if(!Setup.canvasStyle) renderer.clear()
    if(Setup.clearObjects){
      val l = scene.children.length
      (0 to l).reverse.foreach{ i=>
        scene.remove(scene.children(i))
      }
    }


    dom.requestAnimationFrame(renderLoop _)
    render
    renderer.render(scene, camera)
    camera.updateMatrix()
  }

}
