package main

import main.lib._

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################

@JSExport
class ThreeJSApp12 extends JSApp with PerlinNoise with DrawingUtils with BasicCanvas {

  Setup._2D.LeftBottom.asCanvas.withStats.antialiasing

  def render():Unit = {
    val pos = random2D
    val c = pos.x.map(0,width,0,1)
    fill(new Color(random(1),0,c))
    val radio = pos.y.map(0,height, 10,50)
    circle(pos, radio, 8)
  }


}
