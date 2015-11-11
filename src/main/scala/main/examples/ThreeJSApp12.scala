package main.examples

import main.lib._

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################

@JSExport
class ThreeJSApp12 extends JSApp with PerlinNoise with DrawingUtils with BasicCanvas {

  Setup._2D.LeftBottom.asScene.withStats


  val data = for{
    x <- 0 until width
    y <- 0 until height
  } yield (new Vector3(x,y,0), new Color(((x+y*height)*0.01)%1,0,0))

  val geo = point2(data:_*).geometry

  def render():Unit = {
//    if(a) point2(data:_*) else point3(data:_*)


    //data.foreach{case (pos,_) => pos.setX(pos.x+1%width)}
//    for(i <- 0 until geo.colors.size by random(40).toInt){
//      geo.colors(i).r = (i-frameCount)*0.03%1
//    }
//    geo.colorsNeedUpdate=true
  }


}

