import main.lib._
import main.recorder.{GifRecorder, RecorderConfig}

import scala.scalajs.js.JSConverters
import scala.scalajs.js.annotation.JSExport
import JSConverters._
import scala.util.Try

/**
 */

@JSExport
class ThreeJSApp21 extends BasicCanvas with SimplexNoise with DrawingUtils with StatsDisplay with GifRecorder{
  Setup._2D.asScene.withControls.autoClear

  val totalFrames = 30*10
  val recorderConfig: RecorderConfig = RecorderConfig(Nil, frameLimit = totalFrames / 2, motionBlurFrames = 2, quality = 20)

  lineWeight(3)

  val p = Palette(new Color(0x2D4059), new Color(0xFF5722), new Color(0xEEEEEE))

  val scale = 10
  val similarity = 0.001

  val stripLength = 5000

  val steps = (2 to stripLength).map(_*0.5).toArray

  val list = for{
    i <- 0 to 50
    lineNoiseSeed = i *similarity
  } yield {
    steps.foldLeft(new Vector3(0.0, 0.0, 0.0) :: Nil) { (lst, n) =>
      val v = lst.head
      new Vector3(noise(n, lineNoiseSeed + 200) * scale + v.x, noise(n, lineNoiseSeed + 300) * scale + v.y, noise(n, lineNoiseSeed + 400) * scale + v.z) :: lst
    }.toJSArray
  }

  //org.scalajs.dom.document.body.style.backgroundColor = "#222831"

  def render(): Unit = {
    //org.scalajs.dom.document.body.style.backgroundColor = "#222831"
    rect((0, 0, -500), width*100, height*100, new Color(0x222831))

    if(frameCount == 1){
      start = 1
      Try(recorder.start())
    }

    val slice = fCos(TWO_PI*frameCount/(totalFrames)).map(-1,1,0,stripLength - 2).toInt

    val g = list.indices.map { i =>
      mspline(list(i).drop(slice), list(i).size-slice, p(i % p.colors.size))
    }
    group(g).setRotationFromAxisAngle(yAxis, frameCount.map(0, totalFrames, 0, TWO_PI))
  }
}

