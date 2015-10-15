package main

import scala.scalajs.js._

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

object ThreeJSApp4 extends JSApp with BasicCanvas with Helpers with PerlinNoise{

  def main():Unit = {
    Setup.Dim2.LeftBottom.asScene.autoClear
    RectMode.leftBottomMode
    //Should be the last thing to be executed, else, weird things happen
    renderLoop(now)
  }



  def render():Unit = {
    fill(Palette.iDemandPancake(0))
    triangle(leftTop,rightTop,(mouseX,mouseY))
    fill(Palette.iDemandPancake(1))
    triangle(leftBottom,rightBottom,(mouseX,mouseY))
    fill(Palette.iDemandPancake(2))
    triangle(leftTop,leftBottom,(mouseX,mouseY))
    fill(Palette.iDemandPancake(3))
    triangle(rightTop,rightBottom,(mouseX,mouseY))
    stats.update()
  }


}