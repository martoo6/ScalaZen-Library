package main.examples

import main.lib.{BasicCanvas, DrawingUtils, Palette, PerlinNoise}

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

/**
 * Triangles (Not working, must fix)
 */

@JSExport
class ThreeJSApp3 extends BasicCanvas with DrawingUtils with PerlinNoise{
  Setup._2D.LeftBottom.asScene.noClear.withStats
  RectMode.leftBottom


  val t1 = triangle(leftTop,rightTop,(mouseX,mouseY), Palette.iDemandPancake(0))
  val t2 = triangle(leftBottom,rightBottom,(mouseX,mouseY), Palette.iDemandPancake(1))
  val t3 = triangle(leftTop,leftBottom,(mouseX,mouseY), Palette.iDemandPancake(2))
  val t4 = triangle(rightTop,rightBottom,(mouseX,mouseY), Palette.iDemandPancake(3))

  val lst = t1::t2::t3::t4::Nil


  def render():Unit = {
    lst.foreach(_.geometry.vertices.last.set(mouseX,mouseY,0))
    lst.foreach(_.geometry.verticesNeedUpdate=true)
  }


}
