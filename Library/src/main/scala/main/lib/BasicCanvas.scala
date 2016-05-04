package main.lib

/**
 * Created by martin on 09/10/15.
 */
trait BasicCanvas extends Canvas{
  val canvasData = DefaultCanvas.canvasData

  //TODO: implicit vs default parametrs, I prefer dafault parameters, so wipe it off

  implicit var meshMaterial = canvasData.meshMaterial
  var scene        = canvasData.scene
  var camera       = canvasData.camera
  var renderer     = canvasData.renderer
  var clock        = canvasData.clock
  var body         = canvasData.body
  val composer     = new EffectComposer( renderer )

}
