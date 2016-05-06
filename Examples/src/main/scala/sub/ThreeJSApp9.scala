package sub

import main.lib.{BasicCanvas, DrawingUtils, SimplexNoise, StatsDisplay}

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

@JSExport
class ThreeJSApp9 extends ThreeJSApp9T

trait ThreeJSApp9T extends BasicCanvas with DrawingUtils with StatsDisplay with SimplexNoise{

  Setup._3D.LeftBottom.asScene.noClear
  RectMode.leftBottom
  val circlemanager = new CircleManager

  def render():Unit = {
    circlemanager.draw
  }
}
