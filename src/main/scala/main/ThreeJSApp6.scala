package main

import scala.scalajs.js._

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

object ThreeJSApp6 extends JSApp with BasicCanvas with Helpers with PerlinNoise{

  def main():Unit = {
    Setup.Dim2.LeftBottom.asCanvas.noClear
    RectMode.leftBottomMode
    //Should be the last thing to be executed, else, weird things happen
    renderLoop(now)
  }

  val circles = (0 to 1000).map{ i=>
    fill(Palette.blue.getRandom)
    circle((randomWidth,height), random(2,6))
  }


  def render():Unit = {
    val mult = map(Math.sin(frameCount*0.01),-1,1,0.00001,0.01)
    circles.foreach{ c=>
      val pos = c.position
      pos.add(new Vector3(noise(pos.x*mult, pos.y*mult, frameCount*0.01)* -4,-random(4),0))
      if(pos.x < 0) pos.add((width,0,0))
      if(pos.x > width) pos.add((-width,0,0))
      if(pos.y < 0) pos.add((0,height,0))
      if(pos.y > height) pos.add((0,-height,0))
    }

    stats.update()
  }


}
