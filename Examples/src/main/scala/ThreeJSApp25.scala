import main.lib._
import org.scalajs.dom.AudioBuffer
import org.scalajs.dom.ext.Ajax
import org.scalajs.dom.raw.{AudioContext, OfflineAudioContext}

import scala.concurrent.{Await, Future, Promise}
import scala.scalajs.js.annotation.JSExport
import scala.scalajs.js.typedarray.ArrayBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

/**
 * Circles
 * Perlin Noise
 */

@JSExport
class ThreeJSApp25 extends BasicCanvas with DrawingUtils with StatsDisplay with SimplexNoise with AutoClear{
  Setup._2D
  val context = new AudioContext()


  val song = for{
    song <- loadSong()
    filteredSong <- filterSongOffline(song)
    _ = println("Filtered Song !")
    _ = playSong(filteredSong)
  } yield filteredSong



  def playSong(buffer: AudioBuffer): Unit ={
    val source = context.createBufferSource()
    source.buffer = buffer
    source.connect(context.destination)

    // Schedule the song to start playing at time:0
    source.start()

    onKeyPress(s => if(s=="p") source.stop())

    println("Started to play song !")
  }

  def playFilteredSong(buffer: AudioBuffer, filterType:String = "lowpass")= {
    val source = context.createBufferSource()
    source.buffer=buffer

    val filter = context.createBiquadFilter()
    filter.`type`= filterType

    source.connect(filter)
    filter.connect(context.destination)

    source.start()
  }

  def filterSongOffline(buffer: AudioBuffer, filterType:String = "lowpass"): Future[AudioBuffer] = {
    val offlineContext = new OfflineAudioContext(1, buffer.length, buffer.sampleRate.toInt)
    val offlineSource = offlineContext.createBufferSource()
    offlineSource.buffer=buffer

    val filter = offlineContext.createBiquadFilter()
    filter.`type`= filterType

    offlineSource.connect(filter)
    filter.connect(offlineContext.destination)

    offlineSource.start()
    offlineContext.startRendering().toFuture
  }

  def loadSong(verbose: Boolean = false): Future[AudioBuffer] = {
    val p = Promise[AudioBuffer]()

    val url = "http://127.0.0.1:8080/Examples/html/song.mp3"
    Ajax.get(url, responseType = "arraybuffer").onSuccess { case x =>
      if(verbose){
        println(s"Response type: ${x.responseType}")
        println(s"Response Headers: ${x.getAllResponseHeaders()}")
      }
      context.decodeAudioData(x.response.asInstanceOf[ArrayBuffer],  {buffer: AudioBuffer => p.success(buffer)})
    }
    p.future
  }

  var s: AudioBuffer = null

  var startTime:Double = System.currentTimeMillis()

  song.onSuccess{case e => s = e }



  def render():Unit = {
    if(s!=null)
    {
      val lines = (0 to s.getChannelData(0).length by 20000).map{ i =>
        val xx = i.map(0,s.getChannelData(0).length, -width/2, width)
        val yy = s.getChannelData(0).get(i)
        ((xx, 0), (xx, yy.map(0,1,-100,100)), new Color(0, 0, yy))
      }


      lines.foreach{ case (v1,v2,c) =>
        line(v1, v2, c)
      }
      //Draw Position
      val xPos = System.currentTimeMillis().map(startTime,startTime + s.duration, -width/2, width/2)
      line((xPos, - 50), (xPos, 50), new Color(1,0,0))
    }
  }


}
