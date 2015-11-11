package main.examples

import main.lib._

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################

@JSExport
class ThreeJSApp14 extends JSApp with PerlinNoise with DrawingUtils with BasicCanvas {

  Setup._2D.LeftBottom.asScene.withStats


  val data = for{
    x <- 0 until width
    y <- 0 until height
  } yield (new Vector3(x,y,0), new Color(((x+y*height)*0.01)%1,0,0))

  val geo = point2(data:_*).geometry

  def render():Unit = {
    val rr = iDemandPancake.getRandom

    for(i <- (0 until geo.colors.size by rand(50,100).toInt).flatMap(x=> x to x + rand(10).toInt)){
    //for(i <- 0 until geo.colors.size by random(40).toInt){
      geo.colors(i).setRGB(rr.r, rr.g, rr.b)
    }
    geo.colorsNeedUpdate=true
  }


}

