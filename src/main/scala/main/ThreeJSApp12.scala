package main

import main.lib._

import scala.scalajs.js
import scala.scalajs.js._
import scala.scalajs.js.annotation.{JSName, JSExport}

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
import java.lang.Math._
//########################

@JSExport
class ThreeJSApp12 extends JSApp with PerlinNoise with DrawingUtils with BasicCanvas {

  Setup._2D.LeftBottom.asCanvas.autoClear.withStats

  def render():Unit = {
    //stroke(iDemandPancake.getRandom)
    for(x <- 1 to width/30; y <- 1 to height/30){
      stroke(new Color(sin(x*0.01).map(-1,1,0,1),0,0.5))
      point((x,y))
    }

  }


}

