package main.recorder

import main.lib.BasicCanvas
import org.scalajs.dom
import org.scalajs.dom.raw._

import scala.scalajs.js

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

case class RecorderConfig(
                           recorderKeys: Seq[String],
                           verbose: Boolean= false,
                           display: Boolean= true,
                           framerate: Int= 30,
                           motionBlurFrames: Int= 0,
                           quality: Int= 50,
                           workersPath: String= "js/",
                           timeLimit:Int = -1,
                           frameLimit:Int = -1,
                           autoSaveTime:Int = -1,
                           onProgress: Int=>Any = { _ => Unit }
                         )

trait Recorder extends BasicCanvas{
  //TODO: Support multiple configs and Recorders on the same sketch
  val recorderConfig: RecorderConfig
  def recorderBuilder:CCapture
  private lazy val recorder = recorderBuilder
  protected var start = 0

  dom.window.onkeypress = { e: KeyboardEvent =>
    if(recorderConfig.recorderKeys.contains(js.Dynamic.global.String.applyDynamic("fromCharCode")(e.charCode.asInstanceOf[js.Any]).asInstanceOf[String])){
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
    //TODO: Get rid of IFs please
    if(start>0) {
      recorder.capture(renderer.domElement)
      start+=1
    }
    if(start == recorderConfig.frameLimit || start == -1){
      recorder.stop()
      recorder.save({ blob:Location => dom.window.location = blob})
      start = 0
    }
  }
}


trait WebMRecorder extends Recorder{
  def recorderBuilder:CCapture = new CCapture(js.Dynamic.literal(format = "webm",
    verbose = recorderConfig.verbose,
    display = recorderConfig.display,
    framerate = recorderConfig.framerate,
    motionBlurFrames = recorderConfig.motionBlurFrames,
    quality = recorderConfig.quality,
    workersPath = recorderConfig.workersPath,
    timeLimit = recorderConfig.timeLimit,
    frameLimit = recorderConfig.frameLimit,
    autoSaveTime = recorderConfig.autoSaveTime,
    onProgress = recorderConfig.onProgress
  ))
}

//TODO: Not working with current CCapture version, check it out !

//trait GifRecorder extends Recorder{
//  //TODO: The gif does not download automatically, check that out
//  println("[WARNING]: remember that GIF recorder takes some time to generate the GIF file.")
//  def recorderBuilder:CCapture = new CCapture(js.Dynamic.literal(format = "gif",
//    verbose = recorderConfig.verbose,
//    display = recorderConfig.display,
//    framerate = recorderConfig.framerate,
//    motionBlurFrames = recorderConfig.motionBlurFrames,
//    quality = recorderConfig.quality,
//    workersPath = recorderConfig.workersPath,
//    timeLimit = recorderConfig.timeLimit,
//    frameLimit = recorderConfig.frameLimit,
//    autoSaveTime = recorderConfig.autoSaveTime,
//    onProgress = recorderConfig.onProgress
//  ))
//}
//
//trait PNGRecorder extends Recorder{
//  //TODO: The gif does not download automatically, check that out
//  def recorderBuilder:CCapture = new CCapture(js.Dynamic.literal(format = "png",
//    verbose = recorderConfig.verbose,
//    display = recorderConfig.display,
//    framerate = recorderConfig.framerate,
//    motionBlurFrames = recorderConfig.motionBlurFrames,
//    quality = recorderConfig.quality,
//    workersPath = recorderConfig.workersPath,
//    timeLimit = recorderConfig.timeLimit,
//    frameLimit = recorderConfig.frameLimit,
//    autoSaveTime = recorderConfig.autoSaveTime,
//    onProgress = recorderConfig.onProgress
//  ))
//}
//
//trait JPEGRecorder extends Recorder{
//  //TODO: The gif does not download automatically, check that out
//  def recorderBuilder:CCapture = new CCapture(js.Dynamic.literal(format = "jpeg",
//    verbose = recorderConfig.verbose,
//    display = recorderConfig.display,
//    framerate = recorderConfig.framerate,
//    motionBlurFrames = recorderConfig.motionBlurFrames,
//    quality = recorderConfig.quality,
//    workersPath = recorderConfig.workersPath,
//    timeLimit = recorderConfig.timeLimit,
//    frameLimit = recorderConfig.frameLimit,
//    autoSaveTime = recorderConfig.autoSaveTime,
//    onProgress = recorderConfig.onProgress
//  ))
//}

trait ManualSnapshotter extends BasicCanvas{
  val snapshotKeys: Seq[String]

  dom.window.onkeypress = { e: KeyboardEvent =>
    if(snapshotKeys.contains(js.Dynamic.global.String.applyDynamic("fromCharCode")(e.charCode.asInstanceOf[js.Any]).asInstanceOf[String])){
      FileSaver.saveAs(FileSaver.dataURLtoBlob(renderer.domElement.toDataURL("image/png")), "snapshot.png")
    }
  }
}