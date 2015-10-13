package main

import org.scalajs.dom.raw.HTMLDivElement

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
 * Created by martin on 13/10/15.
 */


@js.native
@JSName("Stats")
class Stats extends js.Object{
  var REVISION: Int              = js.native
  var domElement: HTMLDivElement = js.native
  def setMode(value: Double): Unit = js.native
  def begin(): Unit = js.native
  def end(): Double = js.native
  def update(): Unit = js.native
}