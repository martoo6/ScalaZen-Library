import main.lib._

import scala.scalajs.js.annotation.JSExport

@JSExport
class ThreeJSApp20 extends BasicCanvas with DrawingUtils with StatsDisplay with SimplexNoise with CameraControls{
  Setup._2D.asScene

  val radius = height*0.20

  val polarCoords = for {
    g <- (0 to 50).map(_ * TWO_PI / 50)
    t <- (-30 to 30).map(_ * PI / 60)
  } yield (g, t)

  val radius2 = radius * 0.3
  val coords =
      polarCoords.map { case (g, t) => new Vector3(sin(g) * cos(t) * radius, cos(g) * sin(t) * radius, sin(t) * radius) }.toVector ::
      polarCoords.map { case (g, t) => new Vector3(sin(g) * cos(t) * radius, cos(g) * sin(t) * radius, sin(t) * radius) }.toVector ::
      polarCoords.map { case (g, t) => new Vector3(cos(g) * tanh(t) * radius, sin(g) * sin(t) * radius, sin(t) * radius) }.toVector ::
      polarCoords.map { case (g, t) => new Vector3(sin(g) * tanh(t) * radius, sin(g) * sin(t) * radius, sin(t) * radius) }.toVector ::
        polarCoords.map { case (g, t) => new Vector3(cos(g) * cos(t) * radius, sin(g*t) * sin(t) * radius, sin(t*t) * radius) }.toVector ::
        polarCoords.map { case (g, t) => new Vector3(cos(g) * cos(t) * radius, sin(g*t) * sin(t) * radius, sin(t*t) * radius) }.toVector ::
        polarCoords.map { case (g, t) => new Vector3(cos(g*g) * cos(t*t) * radius, cos(g*t) * sin(t) * radius, sin(t*t) * radius) }.toVector ::
        polarCoords.map { case (g, t) => new Vector3(cos(g*g) * cos(t*t) * radius, cos(g*t) * sin(t) * radius, sin(t*t) * radius) }.toVector ::
        polarCoords.map { case (g, t) => new Vector3(tan(g) * cos(t) * radius, cos(g) * sin(t/5) * radius, tan(t/2) * radius) }.toVector ::
        polarCoords.map { case (g, t) => new Vector3(tan(g) * cos(t) * radius, cos(g) * sin(t/5) * radius, tan(t/2) * radius) }.toVector ::
      Nil

  val vals = coords.head.map(_ => segSphere(center, 2, 1, Rgb(0, 0, 0)))

  val all = vals.zipWithIndex

  val g = group(vals)

  var a = true
  var b = true

  def render(): Unit = {
    val time = frameCount*0.02
    val t1 = (time).toInt % coords.size
    val t2 = (time + 1).toInt % coords.size
    all.foreach {
      case (v, i) =>
        val pos = v.position
        pos.lerpVectors(coords(t1)(i), coords(t2)(i), time % 1)
        v.material.color.setRGB(pos.x * 0.01.constrain(0, 1), pos.y * 0.01.constrain(0, 1), pos.z * 0.01.constrain(0, 1))
    }
    g.setRotationFromAxisAngle(yAxis, map(frameCount, 0, 60 * 5, 0, TWO_PI))
  }

}
