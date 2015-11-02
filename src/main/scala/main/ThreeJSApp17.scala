package main

import main.lib._

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

@JSExport
class ThreeJSApp17 extends JSApp with BasicCanvas with DrawingUtils with SimplexNoise{
  Setup._2D.LeftBottom.asCanvas.withStats.autoClear
  val pos = random2D

  def render():Unit = {
    for(i<- 0 to 100){
      fill(Palette.giantGoldfish.getRandom)
      val p = circle(pos,40,30)
      pos.add((1,noise(frameCount)))
      if(pos.x>width+40) pos.x-=(width+40)
      if(pos.y>height+40) pos.y-=(height+40)
      if(pos.x-40<0) pos.x+=width+40
      if(pos.y-40<0) pos.y+=height+40
    }

  }


}
