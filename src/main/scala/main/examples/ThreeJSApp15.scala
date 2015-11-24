package main.examples

import main.lib._

import scala.scalajs.js
import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

/**
 * mspline (Curves, change name to curves ???)
 * constrain
 * Simplex Noise
 * Rgb color factory
 * FrameCount
 */

@JSExport
class ThreeJSApp15 extends JSApp with SimplexNoise with DrawingUtils with BasicCanvas {
  Setup._2D.asScene.withControls.withStats.autoClear


  def render():Unit = {
    stroke(Rgb(noise(frameCount*0.01)*0.5+0.5,0,0))
    val res = for(x <- -width/2 to width/2) yield generateLine(x,0)
    //res.grouped(width).foreach(x=>spline(x.toSeq :_*))
    mspline(res)
  }

  def generateLine(x:Int,y:Double) = {
    val v1 = noise(x*0.01,frameCount*0.01)*10
    val v2 = cos((x*0.01).constrain(-Math.PI,Math.PI))*100
    (x,v1+v2+y)
  }

}

