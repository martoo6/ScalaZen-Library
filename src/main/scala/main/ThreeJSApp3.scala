package main

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

@JSExport
class ThreeJSApp3 extends JSApp with BasicCanvas with DrawingUtils with PerlinNoise{
  Setup.Dim2.LeftBottom.asScene.noClear.withStats
  RectMode.leftBottom

  fill(Palette.iDemandPancake(0))
  val t1 = triangle(leftTop,rightTop,(mouseX,mouseY))
  fill(Palette.iDemandPancake(1))
  val t2 = triangle(leftBottom,rightBottom,(mouseX,mouseY))
  fill(Palette.iDemandPancake(2))
  val t3 = triangle(leftTop,leftBottom,(mouseX,mouseY))
  fill(Palette.iDemandPancake(3))
  val t4 = triangle(rightTop,rightBottom,(mouseX,mouseY))

  val lst = t1::t2::t3::t4::Nil


  def render():Unit = {
    lst.foreach(_.geometry.vertices.last.set(mouseX,mouseY,0))
    lst.foreach(_.geometry.verticesNeedUpdate=true)
  }


}
