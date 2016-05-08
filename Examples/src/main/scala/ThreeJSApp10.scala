

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

  dom.window.addEventListener("keypress", {e: KeyboardEvent =>
    toogle
  })

  def render():Unit = {
    val div = mouseX.map(0,width,5,20).toInt
    val aux = (1 to div).map(_*TWO_PI/div)
    val lst = aux ++: aux.take(div)
    val m = new LineDashedMaterial()
    m.color.setRGB(1,0,1)
    for(x<-lst.sliding(div+1); y<-x.drop(1)){
        line((fSin(x.head)*200, fCos(x.head)*200), (fSin(y)*200, fCos(y)*200), m)
    }

  }


}
