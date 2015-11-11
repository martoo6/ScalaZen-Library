package main.examples

import main.lib.{BasicCanvas, DrawingUtils, PerlinNoise}

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

@JSExport
class ThreeJSApp6 extends JSApp with BasicCanvas with DrawingUtils with PerlinNoise{

  Setup._2D.LeftBottom.asCanvas.noClear.withStats.antialiasing
  RectMode.leftBottom


  val circles = (0 to 1000).map{ i=>
    circle(random2D, rand(2,6))(blueSaddness.getRandom.materialize())
  }

  def render():Unit = {
    val mult = map(Math.sin(frameCount*0.01),-1,1,0.00001,0.01)
    circles.foreach{ c=>
      val pos = c.position
      pos.add((noise(pos.x*mult, pos.y*mult, frameCount*0.01),-rand(1)))
      if(pos.x < 0) pos.add((width,0,0))
      if(pos.x > width) pos.add((-width,0,0))
      if(pos.y < 0) pos.add((0,height,0))
      if(pos.y > height) pos.add((0,-height,0))
    }
  }


}
