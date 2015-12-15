package main.examples

import main.lib._

import scala.scalajs.js
import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
import java.lang.Math._

/**
 * Line Dashed Material (Not working)
 * Scala Collections Functions (Sliding)
 */

@JSExport
class ThreeJSApp10 extends BasicCanvas with DrawingUtils with PerlinNoise{

  Setup._3D.Center.asScene.autoClear

  stroke(0xFFFFFF)

  def render():Unit = {
    val div = mouseX.map(0,width,5,30).toInt

    val lst = (1 to div).map(_*TWO_PI/div).toList ::: (1 to div).map(_*TWO_PI/div).toList.take(div)
    val m = new LineDashedMaterial()
    m.color.setRGB(1,0,1)
    for(x<-lst.sliding(div+1); y<-x.drop(1)){
        line((sin(x.head)*200, cos(x.head)*200), (sin(y)*200, cos(y)*200), m)
    }
  }


}
