

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
  RectMode.leftBottom

  onKeyPress {
      case "p" => toogle
  }

  (1 to 100).foreach(_=>line((randomWidth, randomHeight), (randomWidth, randomHeight), (0,0,1)))

  def render():Unit = {
    fill((1,0,0, 0.01))
    rect((0,0), width, height)

    noFill
    stroke((1,1,1))
    rect(random2D, 10, 10)

    line((randomWidth, randomHeight), (randomWidth, randomHeight), (0,1,0))
  }


}
