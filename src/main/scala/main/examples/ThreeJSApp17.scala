package main.examples

import main.lib._

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

@JSExport
class ThreeJSApp17 extends JSApp with BasicCanvas with DrawingUtils with SimplexNoise{
  Setup._2D.asCanvas.withStats.autoClear
  val pos = random2D

  def render():Unit = {
    circle(leftBottom, 10)
    circle(rightTop, 10)
    circle(leftTop, 10)
    circle(rightBottom, 10)
    rect(center, 30)
  }


}
