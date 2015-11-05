package main

import main.lib._

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
import java.lang.Math._
//########################

@JSExport
class ThreeJSApp8 extends JSApp with BasicCanvas with DrawingUtils with PerlinNoise{

  Setup._3D.LeftBottom.asScene.noClear.withStats
  RectMode.leftBottom

  val perlin = Perlin(PI)

  val circles = (0 to 1000).map{ i=>
    val c =  circle((randomWidth, randomHeight, rand(500)), 5, 15).fill(Palette.iDemandPancake.getRandom)
    c.rotateX(rand(PI))
    c.rotateY(rand(PI))
    c.rotateZ(rand(PI))
    c
  }

  def render():Unit = {
    circles.foreach{ c =>
      c.rotateY(0.1)
      val pos = c.position
      //pos.add(new Vector3(0,5,0).applyAxisAngle((0,0,1),perlin.noise(c.position.x*0.01, c.position.y*0.01, frameCount*0.002)))
      pos.add(vecXYAngle(PI+perlin.noise(c.position.x*0.01, c.position.y*0.01, c.position.z*0.01 + frameCount*0.002)))

      if(pos.x < 0) pos.add((width,0,0))
      if(pos.x > width) pos.add((-width,0,0))
      if(pos.y < 0) pos.add((0,height,0))
      if(pos.y > height) pos.add((0,-height,0))
    }

    stats.update()
  }


}
