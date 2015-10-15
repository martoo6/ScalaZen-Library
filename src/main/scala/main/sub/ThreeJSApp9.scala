package main.sub

import main.{BasicCanvas, Helpers, Perlin, PerlinNoise}

import scala.scalajs.js._

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
import java.lang.Math._
//########################

object ThreeJSApp9 extends ThreeJSApp9

trait ThreeJSApp9 extends JSApp with BasicCanvas with Helpers with PerlinNoise{

  val circlemanager = new CircleManager

  def main():Unit = {
    Setup.Dim3.LeftBottom.asScene.noClear
    RectMode.leftBottom
    //Should be the last thing to be executed, else, weird things happen
    renderLoop(now)
  }

  def render():Unit = {
    circlemanager.draw
    stats.update()
  }
}
