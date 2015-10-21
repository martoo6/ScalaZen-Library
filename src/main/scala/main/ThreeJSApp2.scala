package main

import main.lib.{Palette, BasicCanvas, DrawingUtils, PerlinNoise}

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

@JSExport
class ThreeJSApp2 extends BasicCanvas with DrawingUtils with PerlinNoise{
  Setup._2D.LeftBottom.asCanvas.withStats
  RectMode.leftBottom

  def render():Unit = {
    val pos = mouseX - (mouseX % 50)
    fill(Palette.iDemandPancake.getRandom)
    rect(pos,0,50,height)
  }

}
