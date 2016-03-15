import main.lib._

import scala.scalajs.js.annotation.JSExport

/**
 * Circles
 * Perlin Noise
 */

@JSExport
class ThreeJSApp22 extends BasicCanvas with DrawingUtils with SimplexNoise{
  Setup._2D.LeftBottom.asCanvas.noClear.withStats.antialiasing
  RectMode.leftBottom

  val perlin = Simplex(-15,15)


  val dots = (0 to 1000).map{ i=>
    (random2D ,Palette.iDemandPancake.getRandom.opacity(0.003))
  }

  def render():Unit = {

    dots.foreach {
      case (c: Vector3, _) =>
        c.add(vecXYAngle(perlin.noise(c.x * 0.01, c.y * 0.01, frameCount * 0.002)))
        if (c.x < 0) c.add((width, 0, 0))
        if (c.x > width) c.add((-width, 0, 0))
        if (c.y < 0) c.add((0, height, 0))
        if (c.y > height) c.add((0, -height, 0))
    }

    point5(dots:_*)
  }


}
