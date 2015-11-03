package main

import main.lib._

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################

@JSExport
class ThreeJSApp15 extends JSApp with SimplexNoise with DrawingUtils with BasicCanvas {

  Setup._3D.asScene.withControls.withStats


  val step = 5
  val points = for{
    x <- -20 to 20
    y <- -20 to 20
  } yield new Vector3(x*step,y*step,0) :: new Vector3(x*step+step,y*step,0) :: new Vector3(x*step+step,y*step+step,0) :: Nil

  val geo = new Geometry()
  geo.vertices.push(points.flatten:_*)
  geo.faces.push(points.map(_=>new Face3(0, 1, 2)):_*)
  geo.colors.push(points.flatten.map(_=>iDemandPancake.getRandom):_*)
  geo.colorsNeedUpdate=true
  geo.computeBoundingSphere()
  geo.computeFaceNormals()

  fill(new Color(1,0,0)){
    val mesh = new Mesh(geo, meshMaterial)
    scene.add(mesh)
  }


  def render():Unit = {

  }


}

