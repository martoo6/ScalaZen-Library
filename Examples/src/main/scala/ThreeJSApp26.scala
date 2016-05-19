

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
import main.lib._

import scala.scalajs.js.annotation.JSExport

/**
 * Line Dashed Material (Not working)
 * Scala Collections Functions (Sliding)
 */

@JSExport
class ThreeJSApp26 extends BasicCanvas with DrawingUtils with StatsDisplay with SimplexNoise with AutoClear{

  Setup._3D.Center.asScene

  stroke(0xFFFFFF)

  //onKeyPress(_ => toogle)
  var m = true

  onKeyPress { x=> x match{
      case "p" => toogle
      case "m" => m= !m
    }
  }

    val div = 20
    val aux = (1 to div).map(_*TWO_PI/div)
    val auxLst = aux ++: aux.take(div)
    val lst = (for{
      x<-auxLst.sliding(div+1)
      y<-x.drop(1)
      item <- new Vector3(fSin(x.head)*200, fCos(x.head)*200) :: new Vector3(fSin(y)*200, fCos(y)*200) :: Nil
    } yield item).toSeq


  lineWeight(2)

  val lst2 = lst.indices.map{
    case x if x%9==0 => (new Vector3().copy(lst(x)).add((fSin(frameCount*0.02)*20, -fCos(frameCount*0.02)*20, 0)), RGB(x*0.01%1, 0, 1))
    case x if x%9==0 => (new Vector3().copy(lst(x)).add((-fSin(frameCount*0.02)*20, fCos(frameCount*0.02)*20, 0)), RGB(x*0.01%1, 0, 1))
    case x if x%8==0 => (new Vector3().copy(lst(x)).add((-fSin(frameCount*0.01)*20, fCos(frameCount*0.01)*20, 0)), RGB(x*0.01%1, 0, 1))
    case x if x%7==0 => (new Vector3().copy(lst(x)).add((fSin(frameCount*0.01)*20, -fCos(frameCount*0.01)*20, 0)), RGB(x*0.01%1, 0, 1))
    case x if x%6==0 => (new Vector3().copy(lst(x)).add((-fSin(frameCount*0.01)*20, -fCos(frameCount*0.01)*20, 0)), RGB(x*0.01%1, 0, 1))
    case x if x%5==0 => (new Vector3().copy(lst(x)).add((fSin(frameCount*0.1)*20, fCos(frameCount*0.1)*20, 0)), RGB(x*0.01%1, 0, 1))
    case x if x%4==0 => (new Vector3().copy(lst(x)).add((-fSin(frameCount*0.1)*20, -fCos(frameCount*0.1)*20, 0)), RGB(x*0.01%1, 0, 1))
    case x if x%3==0 => (new Vector3().copy(lst(x)).add((fSin(frameCount*0.01)*20, fCos(frameCount*0.01)*20, 0)), RGB(x*0.01%1, 0, 1))
    case x if x%2==0 => (new Vector3().copy(lst(x)).add((-fSin(frameCount*0.1)*20, -fCos(frameCount*0.1)*20, 0)), RGB(x*0.01%1, 0, 1))
    case x =>           (new Vector3().copy(lst(x)).add((fSin(frameCount*0.1)*20, fCos(frameCount*0.1)*20, 0)), RGB(x*0.01%1, 0, 1))
  }

  val linesMesh = mline(lst2.map(_._1), lst2.map(_._2))

  def render():Unit = {
    linesMesh.scale.set(fSin(frameCount*0.01)*2, fSin(frameCount*0.01)*2, 1)
    scene.add(linesMesh)
  }


}
