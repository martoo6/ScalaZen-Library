package main

import main.lib._

import scala.scalajs.js
import scala.scalajs.js._
import scala.scalajs.js.annotation.{JSName, JSExport}

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################

@JSExport
class ThreeJSApp12 extends JSApp with PerlinNoise with DrawingUtils with BasicCanvas {

  Setup._2D.LeftBottom.asCanvas.withStats

  var geometry = new Geometry()

  (1 to 2000).foreach{ _ =>
    geometry.vertices.push( random2D )
    geometry.colors.push(iDemandPancake.getRandom)
  }

  var material = new PointsMaterial(js.Dynamic.literal(size= 1, vertexColors= THREE.VertexColors, depthTest= false, opacity= 0.5, sizeAttenuation= false, transparent= true))

  var mesh = new Points( geometry, material )
  scene.add( mesh )

  def render():Unit = {

  }


}

@js.native
@JSName("THREE.PointsMaterial")
class PointsMaterial extends Material{
  def this(parameters: js.Dynamic = ???) = this()
//  //var `type` = js.native
//  var color: Color = js.native
//  var map: Texture = js.native
//  var size: Double = js.native
//  var sizeAttenuation: Double = js.native
//  var vertexColors: Colors = js.native
//  var fog: Boolean = js.native
}

@js.native
@JSName("THREE.Points")
class Points(var geometry: Geometry, var material:Material) extends Object3D{
  //var `type` = js.native
}