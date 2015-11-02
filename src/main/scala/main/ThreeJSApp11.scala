package main

import main.lib._

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################

@JSExport
class ThreeJSApp11 extends JSApp with PerlinNoise with DrawingUtils with BasicCanvas {

  Setup._3D.Center.asScene.noClear.withStats.withControls

  val step = 5
  val cubes = for{
    x <- -20 to 20
    y <- -20 to 20
  }
    yield{
      fill(new Color(Simplex.noise(x*0.06+100,y*0.06).map(-1,1,0,1),0,0.5))
      cube((x*step,-250,y*step),step)
    }


  def render():Unit = {
    cubes.foreach { c =>
      val pos = c.position
      val n = Simplex.noise(pos.x * 0.005, pos.z * 0.005, frameCount * 0.01)
      c.material.asInstanceOf[MeshBasicMaterial].color.setRGB(n.map(-1,1,0,1), 0, 0.5)
      pos.setY(map(n, -1, 1, 0, 100))
    }
  }


}
