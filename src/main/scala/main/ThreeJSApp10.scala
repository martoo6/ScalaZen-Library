package main

import scala.scalajs.js._

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
import java.lang.Math._

object ThreeJSApp10 extends JSApp with BasicCanvas with Helpers with PerlinNoise{

  def main():Unit = {
    Setup.Dim3.Center.asScene.autoClear
    //Should be the last thing to be executed, else, weird things happen
    stroke(0xFFFFFF)
    renderLoop(now)
  }


  def render():Unit = {
    val div = map(mouseX,0,width,5,20).toInt

    val lst = (1 to div).map(_*TWO_PI/div)
    lst.zipWithIndex.foreach{ case (x,i)=>
      val si = lst.size

      val s = if(i+1<si) lst(i+1) else lst(i+1-si)
      val t = if(i+2<si) lst(i+2) else lst(i+2-si)
      val f = if(i+3<si) lst(i+3) else lst(i+3-si)

      line((sin(x)*200, cos(x)*200), (sin(s)*200, cos(s)*200))
      line((sin(x)*200, cos(x)*200), (sin(t)*200, cos(t)*200))
      line((sin(x)*200, cos(x)*200), (sin(f)*200, cos(f)*200))
    }

    stats.update()
  }


}
