

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
import main.lib._

import scala.scalajs.js.annotation.JSExport

/**
 * Line Dashed Material (Not working)
 * Scala Collections Functions (Sliding)
 */

@JSExport
class ThreeJSApp27 extends BasicCanvas with DrawingUtils with StatsDisplay with SimplexNoise with AutoClear{
  Setup._2D.LeftBottom.asCanvas.size(600,600)

  onKeyPress {
      case "p" => toogle
  }

  def render():Unit = {
    line((randomWidth, randomHeight), (randomWidth, randomHeight), (0,1,0))
  }


}
