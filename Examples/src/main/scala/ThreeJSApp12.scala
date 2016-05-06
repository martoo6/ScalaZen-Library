import main.lib._

import scala.scalajs.js.annotation.JSExport

/**
 * Points
 */

@JSExport
class ThreeJSApp12 extends BasicCanvas with SimplexNoise with DrawingUtils with StatsDisplay {

  Setup._2D.LeftBottom.asScene


  val data = for{
    x <- 0 until width
    y <- 0 until height
  } yield (new Vector3(x,y,0), new Color())

  val geo = point(data:_*).geometry

  def render():Unit = {
    for(i <- 0 until geo.colors.length){
      geo.colors(i).g = i*.1%1
    }
    geo.colorsNeedUpdate=true
  }

}

