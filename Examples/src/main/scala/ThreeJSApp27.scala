

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
import main.lib._

import scala.collection.mutable.ListBuffer
import scala.scalajs.js.annotation.JSExport

/**
 * Line Dashed Material (Not working)
 * Scala Collections Functions (Sliding)
 */

@JSExport
class ThreeJSApp27 extends BasicCanvas with DrawingUtils with StatsDisplay with SimplexNoise with AutoClear{
  Setup._2D.LeftBottom.asScene.size(600,600)
  RectMode.leftBottom

  onKeyPress {
      case "p" => toogle
  }

  val lst = ListBuffer[(Vector3, Float)]()

  for(i <- 1 to 100){
    rand2D
//    var p = new Vector3(rand(width), rand(height), 0)
    var p = rand2D
    var s = rand(2,80)
    while(!isValid(p, s)){
//      p = new Vector3(rand(width), rand(height), 0)
      p = rand2D
      s = rand(2,80)
    }
    lst+=((p, s))
  }

  fill(black)
  rect((0,0), width, height)
  def render():Unit = {
    //fill((1,0,0, 0.1))
    //rect((0,0), width, height)
    noFill


    lst.foreach{ case(pos, radius) =>
      line(center, pos)
      circle(pos, radius*abs(sin(frameCount*0.1))).outline(white)
    }
  }

  def isValid(pos: Vector3, radius: Float) = {
    !lst.exists{case (pos2, r)=> pos.distanceTo(pos2) < (r + radius)}
  }
}

