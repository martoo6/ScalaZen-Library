import main.lib._

import scala.scalajs.js.annotation.JSExport

/**
 * Circles
 * Perlin Noise
 */

@JSExport
class ThreeJSApp23 extends BasicCanvas with DrawingUtils with SimplexNoise{
  Setup._2D.LeftBottom.asCanvas.noClear.withStats.antialiasing
  RectMode.leftBottom

  val simplex = Simplex(0,TWO_PI)
  val simplex2 = Simplex(0,15)
  val r = rand(TWO_PI)

  val dots = (0 to 2000).map{ i=>
    (random2D,Palette.iDemandPancake.getRandom.opacity(0.008))
  }

  def render():Unit = {
    dots.foreach {
      case (c: Vector3, _) =>
        c.add(vecXYAngle(r).multiplyScalar(simplex2.noise(c.x * 0.001, c.y * 0.001)))
        if (c.x < 0 || c.x > width) c.set(randomWidth, randomHeight, 0)
        if (c.y < 0 || c.y > height) c.set(randomWidth, randomHeight, 0)
    }

    pointShader(dots:_*)
  }


}
