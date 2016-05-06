import main.lib._

import scala.scalajs.js.annotation.JSExport

/**
 * Points
 */

@JSExport
class ThreeJSApp14 extends BasicCanvas with SimplexNoise with DrawingUtils with StatsDisplay{

  Setup._2D.LeftBottom.asScene


  val data = for{
    x <- 0 until width
    y <- 0 until height
  } yield (new Vector3(x,y,0), new Color(((x+y*height)*0.01)%1,0,0))

  val geo = point(data:_*).geometry

  def render():Unit = {
    val rr = iDemandPancake.getRandom

    for(i <- (0 until geo.colors.size-10 by rand(50,100).toInt).flatMap(x=> x to x + rand(10).toInt)){
    //for(i <- 0 until geo.colors.size by random(40).toInt){
      geo.colors(i).setRGB(rr.r, rr.g, rr.b)
    }
    geo.colorsNeedUpdate=true
  }


}

