import main.lib._

import scala.scalajs.js.annotation.JSExport

/**
 * Rect
 * Mouse Position
 */

@JSExport
class ThreeJSApp2 extends BasicCanvas with DrawingUtils with StatsDisplay with SimplexNoise{
  Setup._2D.LeftBottom.asCanvas
  RectMode.leftBottom

  def render():Unit = {
    val pos = (mouseX - (mouseX % 50), 0)
    //Wold be great to reeplace materialize with implicit conversion
    rect(pos,50,height, Palette.iDemandPancake.getRandom)
  }

}
