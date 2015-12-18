package main.examples

import main.lib._

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

/**
 */

@JSExport
class ThreeJSApp21 extends BasicCanvas with SimplexNoise with DrawingUtils {
  Setup._2D.asScene.withControls.withStats.autoClear

  def render(): Unit = {

    val list = 1 to (abs(sin(frameCount * 0.01)) * 100).toInt

    for (i <- 0 to 25) {
      val res = list.foldLeft((0.0, 0.0, 0.0) :: Nil) { (lst, n) =>
        val (x, y, z) = lst.head
        val p = (noise(n * 0.01, i, 0) * 10 + x, noise(n * 0.01, i, 10) * 10 + y, noise(n * 0.01, i, 20) * 10 + z)
        //val p = (noise(n*0.01,i,0)*200, noise(n*0.01,i,10)*200, noise(n*0.01,i,20)*200)
        p :: lst
      }
      mspline(res, list.size * 5, Rgb(noise(i), 0, 1))
    }
  }

}

