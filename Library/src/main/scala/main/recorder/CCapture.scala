package main.recorder


import main.lib.Renderer
import org.scalajs.dom.raw.{Location, HTMLCanvasElement}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
 * Created by martin on 01/12/15.
 */

@js.native
@JSName("CCapture")
class CCapture(settings: js.Dynamic = ???) extends js.Object {
  def start(): Unit = js.native
  def stop(): Unit = js.native
  def capture(canvas: HTMLCanvasElement): Unit = js.native
  def save(f: js.Function1[Location,_]):Unit = js.native
  def save():Unit = js.native
}
