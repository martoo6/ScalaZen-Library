import main.lib._

import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################

@JSExport
class ThreeJSApp13 extends BasicCanvas with PerlinNoise with DrawingUtils{

  Setup._2D.LeftBottom.asScene.withStats


  val data = for{
    x <- 0 until width
    y <- 0 until height
  } yield (new Vector3(x,y,0), new Color(((x+y*height)*0.01)%1,0,0))

  val geo = point(data:_*).geometry

  def render():Unit = {
    geo.colors.foreach{ c=>
      c.setHex(frameCount*10)
    }
    geo.colorsNeedUpdate=true
  }


}

