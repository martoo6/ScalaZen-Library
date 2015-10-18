package main

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

@JSExport
class ThreeJSApp2 extends JSApp with BasicCanvas with DrawingUtils with PerlinNoise{
  Setup.Dim2.LeftBottom.asCanvas.withStats
  RectMode.leftBottom

  def render():Unit = {
    val pos = mouseX - (mouseX % 50)
    fill(Palette.iDemandPancake.getRandom)
    rect(pos,0,50,height)
  }

}
