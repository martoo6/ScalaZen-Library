package main

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

@JSExport
class ThreeJSApp4 extends JSApp with BasicCanvas with DrawingUtils with PerlinNoise{
  Setup.Dim2.LeftBottom.asScene.autoClear.withStats
  RectMode.leftBottom

  def render():Unit = {
    fill(Palette.iDemandPancake(0))
    triangle(leftTop,rightTop,(mouseX,mouseY))
    fill(Palette.iDemandPancake(1))
    triangle(leftBottom,rightBottom,(mouseX,mouseY))
    fill(Palette.iDemandPancake(2))
    triangle(leftTop,leftBottom,(mouseX,mouseY))
    fill(Palette.iDemandPancake(3))
    triangle(rightTop,rightBottom,(mouseX,mouseY))
  }


}
