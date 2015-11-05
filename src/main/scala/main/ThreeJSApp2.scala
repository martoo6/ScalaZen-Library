package main

import main.lib._

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

@JSExport
class ThreeJSApp2 extends BasicCanvas with DrawingUtils with PerlinNoise with Converters{
  Setup._2D.LeftBottom.asCanvas.withStats
  RectMode.leftBottom

  def render():Unit = {
    val pos = (mouseX - (mouseX % 50), 0)
    //Wold be great to reeplace materialize with implicit conversion
    rect(pos,50,height)(Palette.iDemandPancake.getRandom.materialize())
  }

}
