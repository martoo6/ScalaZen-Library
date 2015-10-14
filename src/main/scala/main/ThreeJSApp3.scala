package main

import scala.scalajs.js._

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

object ThreeJSApp3 extends JSApp with BasicCanvas with Helpers with PerlinNoise{

  def main():Unit = {
    Setup.Dim2.LeftBottom.asScene.noClear
    RectMode.leftBottomMode
    //Should be the last thing to be executed, else, weird things happen
    renderLoop(now)
  }


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
    stats.update()
  }


}
