package main

import scala.scalajs.js._

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

object ThreeJSApp7 extends JSApp with BasicCanvas with Helpers with PerlinNoise{

  val perlin = Perlin(-15,15)

  def main():Unit = {
    Setup.Dim2.LeftBottom.asCanvas.noClear
    RectMode.leftBottom
    //Should be the last thing to be executed, else, weird things happen
    renderLoop(now)
  }

  val circles = (0 to 1000).map{ i=>
    fill(Palette.iDemandPancake.getRandom)
    circle(random2D, 5)
  }


  def render():Unit = {
    circles.foreach{ c=>
      val pos = c.position
      //pos.add(new Vector3(0,5,0).applyAxisAngle((0,0,1),perlin.noise(c.position.x*0.01, c.position.y*0.01, frameCount*0.002)))
      pos.add(vecXYAngle(perlin.noise(c.position.x*0.01, c.position.y*0.01, frameCount*0.002)))
      if(pos.x < 0) pos.add((width,0,0))
      if(pos.x > width) pos.add((-width,0,0))
      if(pos.y < 0) pos.add((0,height,0))
      if(pos.y > height) pos.add((0,-height,0))
    }

    stats.update()
  }


}
