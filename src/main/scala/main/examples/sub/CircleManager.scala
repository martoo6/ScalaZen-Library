package main.examples.sub

import java.lang.Math._

import main.lib.{Perlin, DrawingUtils, BasicCanvas}

/**
 * Created by martin on 15/10/15.
 */
class CircleManager extends BasicCanvas with DrawingUtils{
  val perlin = Perlin(PI)

  val circles = (0 to 1000).map{ i=>
    val c = circle((randomWidth, randomHeight, rand(500)), 5)(iDemandPancake.getRandom.materialize())
    c.rotateX(rand(PI))
    c.rotateY(rand(PI))
    c.rotateZ(rand(PI))
    c
  }

  def render():Unit = {}

  def draw = {
    circles.foreach{ c =>
      c.rotateY(0.1)
      val pos = c.position
      //pos.add(new Vector3(0,5,0).applyAxisAngle((0,0,1),perlin.noise(c.position.x*0.01, c.position.y*0.01, frameCount*0.002)))
      pos.add(vecXYAngle(PI+perlin.noise(pos.x*0.01, pos.y*0.01, pos.z*0.01 + frameCount*0.002)))

      if(pos.x < 0) pos.add((width,0,0))
      if(pos.x > width) pos.add((-width,0,0))
      if(pos.y < 0) pos.add((0,height,0))
      if(pos.y > height) pos.add((0,-height,0))
    }
  }
}
