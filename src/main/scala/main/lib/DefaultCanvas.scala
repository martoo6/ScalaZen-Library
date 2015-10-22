package main.lib

import org.scalajs.dom

import scala.scalajs.js

/**
 * Created by martin on 10/17/15.
 */
object DefaultCanvas{
  def width = dom.window.innerWidth
  def height = dom.window.innerHeight

  val renderer = new WebGLRenderer(js.Dynamic.literal(preserveDrawingBuffer=true))

  renderer.setSize(width, height)
  val e =renderer.domElement

  val body: dom.Node = dom.document.body
  body.appendChild(e)

  val canvasData = CanvasData(
    new LineBasicMaterial(js.Dynamic.literal(color = 0xFFFFFF, side= THREE.DoubleSide)),
    new MeshBasicMaterial(js.Dynamic.literal(color= 0xFFFFFF, side= THREE.DoubleSide)),
    new Scene(),
    new OrthographicCamera( width / - 2, width / 2, height / 2, height / - 2, -1000, 1000 ),
    renderer,
    new Clock(),
    body
  )
}
