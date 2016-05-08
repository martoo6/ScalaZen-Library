import main.lib.{Vector3, _}

import scala.scalajs.js.annotation.JSExport

/**
 * Circles
 * Perlin Noise
 */

@JSExport
class ThreeJSApp24 extends BasicCanvas with DrawingUtils with StatsDisplay with SimplexNoise with AutoClear{
  Setup._2D.LeftBottom.asCanvas.antialiasing
  RectMode.leftBottom

  val simplex = Simplex(0,1)

  val dots =
  for{
    x <- 0 to width/2 by 2
    y <- 0 to height/2 by 2
  } yield (new Vector3(x,y,0), new Color(simplex.noise(x * 0.01, y * 0.01),0,1))

  def render():Unit = {
    dots.foreach{case (v,c) => c.r = simplex.noise(v.x * 0.01, v.y * 0.01, frameCount*0.1)}
    point(dots:_*)
  }


}
