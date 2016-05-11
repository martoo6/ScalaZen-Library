import main.lib.{CameraControls, _}

import scala.scalajs.js.annotation.JSExport

@JSExport
class ThreeJSApp19 extends BasicCanvas with DrawingUtils with StatsDisplay with SimplexNoise with CameraControls{
  Setup._2D.asScene

  val radius = 100

  val cols = List(0x2537b5, 0xff3804, 0xffffff).map(Hex(_))

  val polarCoords = for {
    g <- (0 to 40).map(_ * TWO_PI / 20)
    t <- (-20 to 20).map(_ * PI / 20)
  } yield (g, t)

  val sPos = polarCoords.map { case (g, t) => (sin(g) * cos(t) * radius, cos(g) * cos(t) * radius, sin(t) * radius) }
  val rPos = polarCoords.map { case (g, t) => (sin(g) * cos(t) * radius, cos(g) * tan(t) * radius, sin(t) * radius) }

  val vals = sPos.map(_ => segSphere(center, 2, 6, cols(randInt(cols.size))))

  val all = (sPos, rPos, vals).zipped

  val g = group(vals)

  def render(): Unit = {
    all.foreach {
      case (sp, rp, s) =>
        s.position.lerpVectors(sp, rp, sin(frameCount.map(0, 60 * 5, 0, TWO_PI)).map(-1, 1, 0, 1))
    }
    g.setRotationFromAxisAngle(yAxis, frameCount.map(0, 60 * 5, 0, TWO_PI))
  }

}
