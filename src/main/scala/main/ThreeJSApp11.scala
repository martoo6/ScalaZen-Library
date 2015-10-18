package main

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################

@JSExport
class ThreeJSApp11 extends JSApp with PerlinNoise with DrawingUtils with BasicCanvas {

  Setup.Dim3.Center.asScene.noClear.withStats.withControls

  val step = 10
  val cubes = for{
    x <- -20 to 20
    y <- -20 to 20
  }
    yield{
      fill(new Color(noise(x*0.06+100,y*0.06).map(-1,1,0,1),0,0.5))
      cube((x*step,-250,y*step-20*step-50),step)
    }


  def render():Unit = {
    cubes.foreach { c =>
      val pos = c.position
      c.material.asInstanceOf[MeshBasicMaterial].color.set(new Color(noise(pos.x * 0.005 + 100, pos.z * 0.005, frameCount * 0.01).map(-1,1,0,1), 0, 0.5))
      pos.set(pos.x, map(noise(pos.x * 0.005 + 100, pos.z * 0.005, frameCount * 0.01), -1, 1, 0, 10), pos.z)
    }
  }


}
