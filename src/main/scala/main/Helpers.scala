package main

import org.scalajs.dom

import scala.reflect.ClassTag

/**
 * Created by martin on 07/10/15.
 */
trait Helpers {
  type vec3Double = (Double, Double, Double)
  type vec3Int = (Int, Int, Int)

  implicit def toDouble(i:vec3Int):vec3Double = (i._1.toDouble, i._2.toDouble, i._3.toDouble)

  def random(Min: Double,Max: Double) = Min + (Math.random * ((Max - Min) + 1))

  def random(ceil: Double) = Math.random*ceil

  def width = dom.window.innerWidth
  def height = dom.window.innerHeight

  trait World
  case object Center extends World
  case object LeftBottom extends World

  def setup(w: World)(implicit camera: OrthographicCamera) = w match{
    case Center =>
      camera.left=width / - 2
      camera.right=width / 2
      camera.top=height / 2
      camera.bottom=height / - 2
      camera.near =1
      camera.far=1000
    case LeftBottom =>
      //TODO: ver q onda
      camera.left=width / - 2
      camera.right=width / 2
      camera.top=height / 2
      camera.bottom=height / - 2
      camera.near =1
      camera.far=1000
  }

  //########################   LINE   ############################

  def line(vertexes :Vector3*)(implicit material: Material, scene:Scene):Unit = {
    val geometry = new Geometry()
    geometry.vertices.push(vertexes:_*)
    //geometry.vertices.push(vertex2)
    //new THREE.Vector3( -10, 0, 0 )
    val l = new Line(geometry, material.clone())
    scene.add(l)
  }

  def line[X: ClassTag](vertexes: vec3Double*)(implicit material: Material, scene:Scene):Unit = {
    line(vertexes.map(x=>new Vector3(x._1, x._2, x._3)):_*)
  }

  def line(origX: Double,origY: Double,origZ: Double,destX: Double,destY: Double,destZ: Double)(implicit material: Material, scene:Scene):Unit = {
    line(new Vector3(origX, origY, origZ), new Vector3(destX, destY, destZ))
  }

  //########################   RECT   ############################

  def rect(width:Double, height:Double, x:Double, y:Double, z:Double=0)(implicit material: Material, scene:Scene):Unit = {
    val geometry  = new PlaneGeometry(width, height)
    //val material  = new MeshBasicMaterial( {color: 0xffff00, side: THREE.DoubleSide} )
    geometry.vertices = geometry.vertices.map{v3 => v3.add(new Vector3(x,y,z))}
    val plane     = new Mesh( geometry, material.clone() )
    scene.add(plane)
  }


  def stroke(color:Color)(implicit material: LineBasicMaterial) = {
    material.color= color
  }
}

object Helpers extends Helpers