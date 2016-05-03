package main.recorder

import org.scalajs.dom.raw.{Blob, HTMLCanvasElement, Location}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
 * Created by martin on 01/12/15.
 */

@js.native
object FileSaver extends js.GlobalScope {
  def saveAs(blob: Blob, name: String):Unit = js.native

  def dataURLtoBlob(dataUrl: String):Blob =js.native
}

