package main

import scala.scalajs.js._

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
import java.lang.Math._
//########################

object ThreeJSApp8 extends JSApp with BasicCanvas with Helpers with PerlinNoise{

  val perlin = Perlin(PI)

  def main():Unit = {
    Setup.Dim3.LeftBottom.asScene.noClear
    RectMode.leftBottom
    //Should be the last thing to be executed, else, weird things happen
    renderLoop(now)
  }

  val circles = (0 to 1000).map{ i=>
    fill(Palette.iDemandPancake.getRandom)
    val c = circle((randomWidth, randomHeight, random(500)), 5)
    c.rotateX(random(PI))
    c.rotateY(random(PI))
    c.rotateZ(random(PI))
    c
  }


  def render():Unit = {
    circles.foreach{ c=>
    c.rotateY(0.1)
      val pos = c.position
      //pos.add(new Vector3(0,5,0).applyAxisAngle((0,0,1),perlin.noise(c.position.x*0.01, c.position.y*0.01, frameCount*0.002)))
      pos.add(vecXYAngle(PI+perlin.noise(c.position.x*0.01, c.position.y*0.01, frameCount*0.002)))
      if(pos.x < 0) pos.add((width,0,0))
      if(pos.x > width) pos.add((-width,0,0))
      if(pos.y < 0) pos.add((0,height,0))
      if(pos.y > height) pos.add((0,-height,0))
    }

    stats.update()
  }


}
