package main

import org.scalajs.dom

import scala.scalajs.js
import scala.util.Random

/**
 * Created by martin on 07/10/15.
 */
trait Helpers extends MathUtils{
  self: BasicCanvas =>

  type vec3Double = (Double, Double, Double)
  type vec3Int = (Int, Int, Int)
  type vec2Double = (Double, Double)
  type vec2Int = (Int, Int)

  implicit def Vec3IntToDouble(i: vec3Int): vec3Double = (i._1.toDouble, i._2.toDouble, i._3.toDouble)

  implicit def Vec2IntToDouble(i: vec2Int): vec2Double = (i._1.toDouble, i._2.toDouble)

  implicit def Vec3ToVector3(i: vec3Double): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec2ToVector3(i: vec2Double): Vector3 = new Vector3(i._1, i._2, 0)

  implicit def Vec3IntToVector3(i: vec3Int): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec2IntToVector3(i: vec2Int): Vector3 = new Vector3(i._1, i._2, 0)

  implicit def IntToDouble(i: Int): Double = i.toDouble

  implicit def SeqVec3ToVector3(lst:Seq[vec3Double]) = lst.map{case(x,y,z)=>new Vector3(x,y,z)}

  implicit def SeqVec2ToVector3(lst:Seq[vec2Double]) = lst.map{case(x,y)=>new Vector3(x,y,0)}

  def width = dom.window.innerWidth

  def height = dom.window.innerHeight

  object Setup
  {
    def Center(implicit camera: OrthographicCamera) = {
      camera.left = width / -2
      camera.right = width / 2
      camera.top = height / 2
      camera.bottom = height / -2
      camera.near = 1
      camera.far = 1000
      camera.position.z = 1
      this
    }
    def LeftBottom(implicit camera: OrthographicCamera) ={
      //TODO: ver q onda
      camera.left = width / -2
      camera.right = width / 2
      camera.top = height / 2
      camera.bottom = height / -2
      camera.near = 1
      camera.far = 1000
      camera.position.z = 1
      camera.position.set(width / 2, height / 2, 1)
      this
    }
    def Dim3(implicit meshMaterial: MeshBasicMaterial) = new MeshBasicMaterial(js.Dynamic.literal(color= 0xffff00, side= THREE.DoubleSide))
    def Dim2(implicit meshMaterial: MeshBasicMaterial) = new MeshBasicMaterial(js.Dynamic.literal(color= 0xffff00))
  }
  //########################   LINE   ############################

  def line(vertexes :Vector3*):Geometry = {
    val geometry = new Geometry()
    geometry.vertices.push(vertexes:_*)
    //geometry.vertices.push(vertex2)
    //new THREE.Vector3( -10, 0, 0 )
    val l = new Line(geometry, lineMaterial)
    scene.add(l)
    geometry
  }

  //  def line[X: ClassTag](vertexes: vec3Double*)(implicit material: Material, scene:Scene):Unit = {
  //    line(vertexes.map(x=>new Vector3(x._1, x._2, x._3)):_*)
  //  }
  //
  //  def line[X: ClassTag, Y: ClassTag](vertexes: vec2Double*)(implicit material: Material, scene:Scene):Unit = {
  //    line(vertexes.map(x=>new Vector3(x._1, x._2, 0)):_*)
  //  }

  def line(origX: Double,origY: Double,origZ: Double,destX: Double,destY: Double,destZ: Double):Unit = {
    line(new Vector3(origX, origY, origZ), new Vector3(destX, destY, destZ))
  }

  //########################   RECT   ############################

  //  def rect(width:Double, height:Double, x:Double, y:Double, z:Double=0)(implicit material: Material, scene:Scene):Unit = {
  //    val geometry  = new PlaneGeometry(width, height)
  //    //val material  = new MeshBasicMaterial( {color: 0xffff00, side: THREE.DoubleSide} )
  //    geometry.vertices = geometry.vertices.map{v3 => v3.add(new Vector3(x,y,z))}
  //    val plane     = new Mesh( geometry, material.clone() )
  //    scene.add(plane)
  //  }

  def rect(x:Double, y:Double, width:Double, height:Double):Geometry =  rect(new Vector3(x,y,0),width,height)

  def rect(x:Double, y:Double, z:Double, width:Double, height:Double):Geometry =  rect(new Vector3(x,y,z),width,height)

  def rect(pos:(Double, Double), width:Double, height:Double):Geometry = rect(new Vector3(pos._1,pos._2,0),width,height)

  def rect(pos:(Double, Double, Double), width:Double, height:Double):Geometry = rect(new Vector3(pos._1,pos._2,pos._3),width,height)

  def rect(pos:Vector3, width:Double, height:Double):Geometry = {
    addMeshInPlace(new PlaneGeometry(width, height), pos)
  }


  //########################   Circle   ############################

  def circle(x: Double, y: Double, radius: Double): Geometry = {
    circle(new Vector3(x,y,0), radius)
  }

  def circle(x: Double, y: Double,z: Double, radius: Double): Geometry = {
    circle(new Vector3(x,y,z), radius)
  }

  def circle(pos:Vector3, radius:Double): Geometry = {
    addMeshInPlace(new CircleGeometry(radius), pos)
  }

  def stroke(color:Color) = {
    lineMaterial = lineMaterial.clone().asInstanceOf[LineBasicMaterial]
    lineMaterial.color = color
  }

  //Should check default attributes for world (3D, 2D)
  def fill(color:Color) = {
    val nMeshMaterial = meshMaterial.clone().asInstanceOf[MeshBasicMaterial]
    nMeshMaterial.color = color
    meshMaterial = nMeshMaterial
  }

  def fillLambert(color:Color) = {
    val nMeshMaterial = new MeshLambertMaterial(js.Dynamic.literal(color = color))
    meshMaterial = nMeshMaterial
  }

  //#######################  CUBE #############################

  def cube(pos:Vector3, sideSize:Double): Geometry ={
    addMeshInPlace(new BoxGeometry(sideSize, sideSize, sideSize), pos)
  }

  //#######################  SPHERE #############################

  def sphere(pos:Vector3, radius:Double): Geometry ={
    addMeshInPlace(new SphereGeometry(radius), pos)
  }

  def addMeshInPlace(geometry: Geometry, pos:Vector3) = {
    geometry.vertices = geometry.vertices.map(_.add(pos))
    scene.add(new Mesh(geometry, meshMaterial))
    geometry
  }

  implicit def SeqIntToColor(lst:Seq[Int]): Seq[Color] = lst.map{new Color(_)}

  implicit def IntToColor(value:Int): Color = new Color(value)

  case class Palette(colors:Color*){
    def getRandom: Color = colors(Random.nextInt(colors.size))
    //Mayble use math to set it in range would be faster
    def getRandom(amount: Int): Color = colors(Random.nextInt(if (amount>colors.size) colors.size else amount))
  }

  object Palette {
    val blue = Palette(0xEAEAEA :: 0xCBC5EA :: 0x73628A :: 0x313D5A :: 0x183642 :: Nil: _*)
    val pop = Palette(0xC1ABA6 :: 0x533B4D :: 0xF564A9 :: 0xFAA4BD :: 0xFAE3C6 :: Nil :_*)
  }
}