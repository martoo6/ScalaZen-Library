package main.lib

import org.scalajs.dom

/**
 * Created by martin on 15/10/15.
 */
case class CanvasData(lineMaterial :LineBasicMaterial,meshMaterial: Material,scene: Scene,camera: Camera,renderer: WebGLRenderer,clock: Clock, body: dom.Node)
