package main

import main.ThreeJSApp._

import scala.scalajs.js

/**
 * Created by martin on 09/10/15.
 */
trait BasicCanvas {
  implicit var lineMaterial = new LineBasicMaterial(js.Dynamic.literal(color = 0xffffff, side= THREE.DoubleSide))
  //implicit var meshMaterial  = new MeshBasicMaterial(js.Dynamic.literal(color= 0xffff00, side= THREE.DoubleSide))
  implicit var meshMaterial:Material  = new MeshBasicMaterial(js.Dynamic.literal(color= 0xffff00, side= THREE.DoubleSide))
  implicit val scene = new Scene()
  implicit var camera = new OrthographicCamera( width / - 2, width / 2, height / 2, height / - 2, 1, 1000 )
}
