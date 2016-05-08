import main.lib._

import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

@JSExport
class ThreeJSApp17 extends BasicCanvas with DrawingUtils with StatsDisplay with SimplexNoise with AutoClear{
  Setup._2D.asCanvas.LeftBottom
  val pos = random2D

  def render():Unit = {
    circle(leftBottom, 10)
    circle(rightTop, 10)
    circle(leftTop, 10)
    circle(rightBottom, 10)
    square(center, 30)
  }


}
