package main.lib

import org.scalajs.dom

import scala.scalajs.js

/**
 * Created by martin on 10/17/15.
 */
object DefaultCanvas{
  def width: Int = dom.window.innerWidth.toInt
  def height: Int = dom.window.innerHeight.toInt

  val renderer = new WebGLRenderer(js.Dynamic.literal(preserveDrawingBuffer=true, clearColor="0xFFFFFF"))

  //Check if i can force other renderers for better quality or other uses
  //val renderer = new CanvasRenderer(js.Dynamic.literal(preserveDrawingBuffer=true))

  renderer.setSize(width, height)
  //renderer.setPixelRatio( dom.window.devicePixelRatio )

  val e = renderer.domElement

  val body: dom.Node = dom.document.body
  body.appendChild(e)

  val canvasData = CanvasData(
    new LineBasicMaterial(js.Dynamic.literal(color = 0xFFFFFF, side= THREE.FloatSide)),
    new MeshBasicMaterial(js.Dynamic.literal(color= 0xFFFFFF, side= THREE.FloatSide)),
    new Scene(),
    new OrthographicCamera( width / - 2, width / 2, height / 2, height / - 2, -1000, 1000 ),
    renderer,
    new Clock(),
    body
  )
}
