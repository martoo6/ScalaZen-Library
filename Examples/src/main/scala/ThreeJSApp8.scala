

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
import main.lib._

import scala.scalajs.js.annotation.JSExport

//########################

@JSExport
class ThreeJSApp8 extends BasicCanvas with DrawingUtils with StatsDisplay with SimplexNoise{

  Setup._3D.LeftBottom.asScene.noClear
  RectMode.leftBottom

  val perlin = Simplex(PI)

  val circles = (0 to 1000).map{ i=>
    val c =  circle((randomWidth, randomHeight, rand(500)), 5, 100, Palette.iDemandPancake.getRandom.opacity(0.3))
    c.rotateX(rand(PI))
    c.rotateY(rand(PI))
    c.rotateZ(rand(PI))
    c
  }

  def render():Unit = {
    //line(center, center.add(vecXYAngle(0)))

    circles.foreach{ c =>
      c.rotateY(0.1)
      val pos = c.position
      pos.add(vecXYAngle(HALF_PI*3+perlin.noise(c.position.x*0.01, c.position.y*0.01, c.position.z*0.01 + frameCount*0.002)/2))

      if(pos.x < 0) pos.add((width,0,0))
      if(pos.x > width) pos.add((-width,0,0))
      if(pos.y < 0) pos.add((0,height,0))
      if(pos.y > height) pos.add((0,-height,0))
    }
  }


}
