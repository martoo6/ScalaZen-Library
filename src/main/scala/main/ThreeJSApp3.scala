package main

import scala.scalajs.js._

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

object ThreeJSApp3 extends JSApp with BasicCanvas with Helpers with PerlinNoise{

  def main():Unit = {
    Setup.Dim2.LeftBottom.autoClear
    RectMode.leftBottomMode
    //Should be the last thing to be executed, else, weird things happen
    renderLoop(now)
  }

  val c1 = Palette.iDemandPancake(0)
  val c2 = Palette.iDemandPancake(1)
  val c3 = Palette.iDemandPancake(2)
  val c4 = Palette.iDemandPancake(3)

  def render():Unit = {
    fill(c1)
    triangle(leftTop,rightTop,(mouseX,mouseY))
    fill(c2)
    triangle(leftBottom,rightBottom,(mouseX,mouseY))
    fill(c3)
    triangle(leftTop,leftBottom,(mouseX,mouseY))
    fill(c4)
    triangle(rightTop,rightBottom,(mouseX,mouseY))

    stats.update()
  }


}
