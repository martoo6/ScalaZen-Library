package main

import scala.scalajs.js

/**
 * Created by martin on 15/10/15.
 */
case class CanvasData(lineMaterial :LineBasicMaterial,meshMaterial: Material,scene: Scene,camera: Camera,renderer: WebGLRenderer,clock: Clock)

trait Canvas {
  self: Helpers=>

  implicit val canvasData: CanvasData

  var lineMaterial: LineBasicMaterial  = null
  var meshMaterial: Material           = null
  var scene:Scene                      = null
  var camera: Camera                   = null
  var renderer: WebGLRenderer          = null

  def start = {
    lineMaterial = canvasData.lineMaterial
    meshMaterial = canvasData.meshMaterial
    scene = canvasData.scene
    camera = canvasData.camera
    renderer = canvasData.renderer
  }
}