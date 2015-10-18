package main.sub

import main.{BasicCanvas, DrawingUtils, PerlinNoise}

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

@JSExport
class ThreeJSApp9 extends ThreeJSApp9T

trait ThreeJSApp9T extends JSApp with BasicCanvas with DrawingUtils with PerlinNoise{

  Setup.Dim3.LeftBottom.asScene.noClear.withStats
  RectMode.leftBottom
  val circlemanager = new CircleManager

  def render():Unit = {
    circlemanager.draw
    stats.update()
  }
}
