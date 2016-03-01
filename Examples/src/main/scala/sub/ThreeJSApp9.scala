package sub

import main.lib.{PerlinNoise, DrawingUtils, BasicCanvas}

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

@JSExport
class ThreeJSApp9 extends ThreeJSApp9T

trait ThreeJSApp9T extends BasicCanvas with DrawingUtils with PerlinNoise{

  Setup._3D.LeftBottom.asScene.noClear.withStats
  RectMode.leftBottom
  val circlemanager = new CircleManager

  def render():Unit = {
    circlemanager.draw
  }
}
