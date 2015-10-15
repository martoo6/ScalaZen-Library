package main

import scala.scalajs.js._

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

object ThreeJSApp2 extends JSApp with BasicCanvas with Helpers with PerlinNoise{

  def main():Unit = {
    Setup.Dim2.LeftBottom.asCanvas
    RectMode.leftBottom
    //Should be the last thing to be executed, else, weird things happen
    renderLoop(now)
  }

  def render():Unit = {
    val pos = mouseX - (mouseX % 50)
    fill(Palette.iDemandPancake.getRandom)
    rect(pos,0,50,height)

    stats.update()

  }


}
