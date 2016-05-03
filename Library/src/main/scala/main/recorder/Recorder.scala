package main.recorder

import main.lib.BasicCanvas
import org.scalajs.dom
import org.scalajs.dom.raw._

import scala.scalajs.js
import scala.scalajs.js.JSON

/**
  * Created by martin on 03/05/16.
  */
//trait WebMRecorder {
//
////  verbose: false,
////  display: true,
////  framerate: framerate,
////  motionBlurFrames: ( 960 / framerate ) * ( document.querySelector('input[name="motion-blur"]').checked ? 1 : 0 ),
////  quality: 100,
////  format: document.querySelector('input[name="encoder"]:checked').value,
////  workersPath: '../../src/',
////  timeLimit: 4,
////  frameLimit: 0,
////  autoSaveTime: 0,
////  onProgress: function( p ) { progress.style.width = ( p * 100 ) + '%' }
//
//
//  //val capturer = new CCapture(js.Dynamic.literal(format = "webm", verbose= true))
//  val capturer = new CCapture(js.Dynamic.literal(format = "webm"))
//  var aaa = false
//
//  dom.window.onkeypress = { e: KeyboardEvent =>
//    aaa = !aaa
//    if(aaa)
//      capturer.start
//    else {
//      capturer.stop
//      capturer.save({blob:Location => dom.window.location = blob})
//    }
//  }
//}

//Simple snapshoter from keypress
trait WebMRecorder extends BasicCanvas{
  val recorderKeys = collection.mutable.HashSet[String]()

  val recorder = new CCapture(js.Dynamic.literal(format = "webm", verbose= true, display=true))
  var start = 0
  val frames:Option[Int] = None

  dom.window.onkeypress = { e: KeyboardEvent =>
    if(recorderKeys.contains(js.Dynamic.global.String.applyDynamic("fromCharCode")(e.charCode.asInstanceOf[js.Any]).asInstanceOf[String])){
      if(start==0) {
        start = 1
        recorder.start()
      }else{
         start = -1
      }

    }
  }

  override def renderLoop(timestamp: Double) ={
    super.renderLoop(timestamp)
    if(start>0) {
      recorder.capture(renderer.domElement)
      start+=1
    }
    if(frames.map(_==start).getOrElse(start == -1)){
      recorder.stop()
      recorder.save({ blob:Location => dom.window.location = blob})
      start = 0
    }
  }
}

trait ManualSnapshotter extends BasicCanvas{
  val snapshotKeys = collection.mutable.HashSet[String]()

  dom.window.onkeypress = { e: KeyboardEvent =>
    if(snapshotKeys.contains(js.Dynamic.global.String.applyDynamic("fromCharCode")(e.charCode.asInstanceOf[js.Any]).asInstanceOf[String])){
      FileSaver.saveAs(FileSaver.dataURLtoBlob(renderer.domElement.toDataURL("image/png")), "snapshot.png")
    }
  }
}