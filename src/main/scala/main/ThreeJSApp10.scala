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
    val div = map(mouseX,0,width,5,30).toInt

    val lst = (1 to div).map(_*TWO_PI/div).toList ::: (1 to div).map(_*TWO_PI/div).toList.take(div)
    for(x<-lst.sliding(div+1); y<-x.drop(1)){
        line((sin(x.head)*200, cos(x.head)*200), (sin(y)*200, cos(y)*200))
    }

    stats.update()
  }


}
