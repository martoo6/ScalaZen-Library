import main.lib._

import scala.scalajs.js.annotation.JSExport

/**
 * Triangles (Not working, must fix)
 */

@JSExport
class ThreeJSApp4 extends BasicCanvas with DrawingUtils with StatsDisplay with SimplexNoise with AutoClear{
  Setup._2D.LeftBottom.asScene
  RectMode.leftBottom

  def render():Unit = {
      triangle(leftTop,rightTop,(mouseX,mouseY)).fill(Palette.iDemandPancake(0))
      triangle(leftBottom,rightBottom,(mouseX,mouseY)).fill(Palette.iDemandPancake(1))
      triangle(leftTop,leftBottom,(mouseX,mouseY)).fill(Palette.iDemandPancake(2))
      triangle(rightTop,rightBottom,(mouseX,mouseY)).fill(Palette.iDemandPancake(3))
  }


}
