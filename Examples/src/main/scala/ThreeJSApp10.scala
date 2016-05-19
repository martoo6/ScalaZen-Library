

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
import main.lib._
import org.scalajs.dom
import org.scalajs.dom.raw.KeyboardEvent

import scala.scalajs.js.annotation.JSExport

/**
 * Line Dashed Material (Not working)
 * Scala Collections Functions (Sliding)
 */

@JSExport
class ThreeJSApp10 extends BasicCanvas with DrawingUtils with StatsDisplay with SimplexNoise with AutoClear{

  Setup._3D.Center.asScene

  stroke(0xFFFFFF)

  //onKeyPress(_ => toogle)
  var m = 0

  onKeyPress { x=> x match{
      case "p" => toogle
      case "m" => m = (m+1) % 3
    }
  }

  val radius = height/2

  val lst = for{
    div <- 0 to 200
  } yield{
    val s = 1 to div
    val l = for {
      x <- s
      xx = x * TWO_PI / div
      y <- s.drop(x)
      yy = y * TWO_PI / div
      item <- new Vector3(fSin(xx) * radius, fCos(xx) * radius) :: new Vector3(fSin(yy) * radius, fCos(yy) * radius) :: Nil
    } yield item
    (l, l.map(x => Rgb(abs(x.x)*0.01%1,1,abs(x.y)*0.01%1)), l.flatMap(x => Rgb(abs(x.x)*0.01%1,1,abs(x.y)*0.01%1) :: Rgb(1,abs(x.x)*0.01%1,abs(x.y)*0.01%1) :: Nil))
  }

  def render():Unit = {
    val div = mouseX.map(0,width,0,200).toInt

    m match{
      case 0 => line(lst(div)._1, lst(div)._3)
      case 1 =>
        stroke((1,0,1))
        line(lst(div)._1)
      case 2 =>
        stroke((0,1,1))
        lst(div)._1.view.sliding(2,2).foreach(x=>line(x.head, x.last))
    }
    if(frameCount%5==0) {
      println(lst(div)._1.size)
      println(m)
    }
  }


}
