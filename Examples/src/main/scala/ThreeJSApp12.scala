import main.lib._

import scala.scalajs.js.annotation.JSExport

/**
 * Points
 */

@JSExport
class ThreeJSApp12 extends BasicCanvas with PerlinNoise with DrawingUtils {

  Setup._2D.LeftBottom.asScene.withStats


  val data = for{
    x <- 0 until width
    y <- 0 until height
  } yield (new Vector3(x,y,0), new Color(((x+y*height)*0.01)%1,0,0))

  val geo = point(data:_*).geometry

  def render():Unit = {
    data.foreach{case (pos,_) => pos.setX(pos.x+1%width)}
    for(i <- 0 until geo.colors.size by rand(40).toInt){
      geo.colors(i).r = (i-frameCount)*0.03%1
    }
    geo.colorsNeedUpdate=true
  }


}

