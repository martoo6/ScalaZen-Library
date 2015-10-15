package main

import org.scalajs.dom
import org.scalajs.dom.raw.MouseEvent

import scala.scalajs.js

/**
 * Created by martin on 09/10/15.
 */
trait BasicCanvas extends Canvas{
  self: Helpers=>

  val r = new WebGLRenderer(js.Dynamic.literal(preserveDrawingBuffer=true, antialias = true))
  r.autoClear = false

  implicit val canvasData = CanvasData(
    new LineBasicMaterial(js.Dynamic.literal(color = white, side= THREE.DoubleSide)),
    new MeshBasicMaterial(js.Dynamic.literal(color= white, side= THREE.DoubleSide)),
    new Scene(),
    new OrthographicCamera( width / - 2, width / 2, height / 2, height / - 2, -1000, 1000 ),
    r,
    new Clock()
  )

  start

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

  dom.onmousemove = {
    event:MouseEvent =>
      mouseX = event.clientX
      mouseY = height - event.clientY
  }

  def render():Unit

  def renderLoop(timestamp: Double){
    delta = clock.getDelta()
    frameCount+=1

    if(!Setup.canvasStyle)  renderer.clear()
    if(Setup.clearObjects){
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


    dom.requestAnimationFrame(renderLoop _)
    render
    renderer.render(scene, camera)
    camera.updateMatrix()
  }

}
