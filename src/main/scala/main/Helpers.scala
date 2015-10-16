package main

import main.ThreeJSApp._
import org.scalajs.dom

import scala.scalajs.js
import scala.util.Random

/**
 * Created by martin on 07/10/15.
 */
trait Helpers extends MathUtils{
  var lineMaterial: LineBasicMaterial
  var meshMaterial: Material
  var scene: Scene
  var camera: Camera

  type vec3Double = (Double, Double, Double)
  type vec3Int    = (Int, Int, Int)
  type vec2Double = (Double, Double)
  type vec2Int    = (Int, Int)

  type vec2DoubleInt = (Double, Int)
  type vec2IntDouble = (Int, Double)

  type vec3IntDoubleDouble = (Int, Double, Double)
  type vec3DoubleIntDouble = (Double, Int, Double)
  type vec3DoubleDoubleInt = (Double, Double, Int)
  type vec3IntIntDouble = (Int, Int, Double)
  type vec3DoubleIntInt = (Double, Int, Int)
  type vec3IntDoubleInt = (Int, Double, Int)

  implicit def Vec3IntToDouble(i: vec3Int): vec3Double = (i._1.toDouble, i._2.toDouble, i._3.toDouble)

  implicit def Vec2IntToDouble(i: vec2Int): vec2Double = (i._1.toDouble, i._2.toDouble)

  implicit def Vec3ToVector3(i: vec3Double): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec2ToVector3(i: vec2Double): Vector3 = new Vector3(i._1, i._2, 0)

  implicit def Vec3IntToVector3(i: vec3Int): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec3IntDoubleDoubleToVector3(i: vec3IntDoubleDouble): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec3DoubleIntDoubleToVector3(i: vec3DoubleIntDouble): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec3DoubleDoubleIntToVector3(i: vec3DoubleDoubleInt): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec3IntIntDoubleToVector3(i: vec3IntIntDouble): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec3DoubleIntIntToVector3(i: vec3DoubleIntInt): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec3IntDoubleIntToVector3(i: vec3IntDoubleInt): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec2IntToVector3(i: vec2Int): Vector3 = new Vector3(i._1, i._2, 0)

  implicit def Vec2DoubleIntToVector3(i: vec2DoubleInt): Vector3 = new Vector3(i._1, i._2, 0)

  implicit def Vec2IntDoubleToVector3(i: vec2IntDouble): Vector3 = new Vector3(i._1, i._2, 0)

  implicit def IntToDouble(i: Int): Double = i.toDouble

  implicit def SeqVec3ToVector3(lst:Seq[vec3Double]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}

  implicit def SeqVec2ToVector3(lst:Seq[vec2Double]): Seq[Vector3] = lst.map{case(x,y)=>new Vector3(x,y,0)}

  def width = dom.window.innerWidth
  def height = dom.window.innerHeight

  def now = System.currentTimeMillis()

  val xAxis = (1,0,0)
  val yAxis = (0,1,0)
  val zAxis = (0,0,1)

  //Should re calculate acording to origin
  def random2D = new Vector3(random(width), random(height),0)
  def randomWidth = random(width)
  def randomHeight = random(height)

  def vecXYAngle(angle:Double, size:Double=1) = new Vector3(size,0,0).applyAxisAngle(zAxis, angle)

  val origin = new Vector3(0.0,0.0,0.0)

  //Should re calculate acording to origin
  val leftTop     = new Vector3(0.0,height,0.0)
  val rightTop    = new Vector3(width,height,0.0)
  val leftBottom  = new Vector3(0.0,0.0,0.0)
  val rightBottom = new Vector3(width,0.0,0.0)

  val white = 0xffffff
  val black = 0x000000
  val red = 0xFF0000
  val green = 0x00FF00
  val blue = 0x0000FF

  var mouseX = 0.0
  var mouseY = 0.0

  object Setup
  {
    val center = new Vector3(0,0,500)
    val leftBottom = (width / 2, height / 2, 1000)
    var position = center

    var clearObjects = false
    var canvasStyle = false

    def Center= {
      position = center
      camera.position.set(position.x, position.y, position.z)
      this
    }
    def LeftBottom={
      position = leftBottom
      camera.position.set(position.x, position.y, position.z)
      this
    }
    def Dim3 = {
      //new MeshBasicMaterial(js.Dynamic.literal(color= 0xffff00, side= THREE.DoubleSide))
      camera = new PerspectiveCamera( 45, width / height, 1, 1000 )
      camera.position.set(position.x, position.y, position.z)
      this
    }
    def Dim2 = {
      //new MeshBasicMaterial(js.Dynamic.literal(color= 0xffff00))
      camera = new OrthographicCamera( width / - 2, width / 2, height / 2, height / - 2, -1000, 1000 )
      camera.position.set(position.x, position.y, position.z)
      this
    }
    def ortho = {
      camera = new OrthographicCamera( width / - 2, width / 2, height / 2, height / - 2, -1000, 1000 )
      camera.position.set(position.x, position.y, position.z)
      this
    }
    def perspective = {
      camera = new PerspectiveCamera( 45, width / height, 1, 1000 )
      camera.position.set(position.x, position.y, position.z)
      this
    }
    def autoClear = {
      clearObjects= true
      this
    }
    def noClear = {
      clearObjects= false
      this
    }
    def asCanvas={
      canvasStyle=true
      this
    }
    def asScene={
      canvasStyle=false
      this
    }
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

  def rect(x:Double, y:Double, width:Double, height:Double):Mesh =  rect(new Vector3(x,y,0),width,height)

  def rect(x:Double, y:Double, z:Double, width:Double, height:Double):Mesh =  rect(new Vector3(x,y,z),width,height)

  def rect(pos:(Double, Double), width:Double, height:Double):Mesh = rect(new Vector3(pos._1,pos._2,0),width,height)

  def rect(pos:(Double, Double, Double), width:Double, height:Double):Mesh = rect(new Vector3(pos._1,pos._2,pos._3),width,height)

  def rect(pos:Vector3, width:Double, height:Double):Mesh = {

    //val geo = addMeshInPlace(new PlaneBufferGeometry(width, height), pos)
    val mesh = addMeshInPlace(new PlaneGeometry(width, height), pos)
    mesh.geometry.vertices = mesh.geometry.vertices.map(x=>RectMode.rectMode(x, (width, height)))
    mesh
  }

  object RectMode{
    private val half = new Vector3(2,2,2)
    private val _centerMode     =  (v: Vector3, volume:Vector3) => v
    private val _leftBottomMode =  (v: Vector3, volume:Vector3) => v.add(volume.divide(half))
    var rectMode: (Vector3, Vector3) => Vector3  = _centerMode

    def center     = rectMode = _centerMode
    def leftBottom = rectMode = _leftBottomMode
  }

  //########################   Circle   ############################

  def circle(x: Double, y: Double, radius: Double): Mesh = {
    circle(new Vector3(x,y,0), radius)
  }

  def circle(x: Double, y: Double,z: Double, radius: Double): Mesh = {
    circle(new Vector3(x,y,z), radius)
  }

  def circle(pos:Vector3, radius:Double): Mesh = {
    addMeshInPlace(new CircleGeometry(radius), pos)
  }

  //########################   Triangle   ############################

  def triangle(pos1:Vector3, pos2:Vector3, pos3:Vector3): Mesh = {
    val geometry = new Geometry()
    geometry.vertices.push(pos1)
    geometry.vertices.push(pos2)
    geometry.vertices.push(pos3)

    geometry.faces.push(new Face3(0, 2, 1))
    addMeshInPlace(geometry, origin)
  }

  //############# STROKE AND FILL ##################

  def lineWeight(weight: Double) = {
    lineMaterial = lineMaterial.clone().asInstanceOf[LineBasicMaterial]
    lineMaterial.linewidth = weight
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

  def cube(pos:Vector3, sideSize:Double)={
    addMeshInPlace(new BoxGeometry(sideSize, sideSize, sideSize), pos)
  }

  def cube(pos:Vector3, width:Double, height:Double, deep:Double)={
    addMeshInPlace(new BoxGeometry(width, height, deep), pos)
  }

  //#######################  SPHERE #############################

  def sphere(pos:Vector3, radius:Double): Mesh ={
    addMeshInPlace(new SphereGeometry(radius), pos)
  }

  def sphere(pos:Vector3, radius:Double, segments: Int): Mesh ={
    addMeshInPlace(new SphereGeometry(radius, segments, segments), pos)
  }

  def addMeshInPlace(geometry: Geometry, pos:Vector3) = {
    //geometry.vertices = geometry.vertices.map(_.add(pos))
    val mesh = new Mesh(geometry, meshMaterial)
    mesh.position.add(pos)
    scene.add(mesh)
    mesh
  }

  //#######################  LIGHTS #############################

  def addAmbientLight(color: Int) = {
    val light = new AmbientLight(color)
    scene.add( light )
    light
  }

  def addDirectionalLight(color:Int, intensity: Double, position: Vector3)= {
    val directionalLight = new DirectionalLight(color, intensity)
    directionalLight.position.add(position)
    scene.add(directionalLight)
    directionalLight
  }

  //############## ADD CONTROLS ###################

  def addOrbitControls(coordinate: Vector3) ={
    val controls = new OrbitControls(camera , renderer.domElement)
    controls.center = coordinate
    //controls.addEventListener("change", render _)
    controls
  }

  implicit def SeqIntToColor(lst:Seq[Int]): Seq[Color] = lst.map{new Color(_)}

  implicit def IntToColor(value:Int): Color = new Color(value)


  case class Palette(colors:Color*){
    def apply(pos:Int) = colors(pos)
    def getRandom: Color = colors(Random.nextInt(colors.size))
    //Mayble use math to set it in range would be faster
    def getRandom(amount: Int): Color = colors(Random.nextInt(if (amount>colors.size) colors.size else amount))
  }

  /**
   * Should make a library out of this, get values out of a json
   * Get Palettes sorted by categories such as mood, etc.
   * Generate palettes from images, etc.
   */

  object Palette {
    val blue = Palette(0xEAEAEA :: 0xCBC5EA :: 0x73628A :: 0x313D5A :: 0x183642 :: Nil: _*)
    val pop = Palette(0xC1ABA6 :: 0x533B4D :: 0xF564A9 :: 0xFAA4BD :: 0xFAE3C6 :: Nil :_*)

    //From http://www.colourlovers.com/
    val giantGoldfish       = Palette(0x69D2E7 :: 0xA7DBD8 :: 0xE0E4CC :: 0xF38630 :: 0xFA6900 :: Nil :_*)
    val sugar01             = Palette(0xFE4365 :: 0xFC9D9A :: 0xF9CDAD :: 0xC8C8A9 :: 0x83AF9B :: Nil :_*)
    val thoughtProvoking    = Palette(0xECD078 :: 0xD95B43 :: 0xC02942 :: 0x542437 :: 0x53777A :: Nil :_*)
    val adriftInDreams      = Palette(0xCFF09E :: 0xA8DBA8 :: 0x79BD9A :: 0x3B8686 :: 0x0B486B :: Nil :_*)
    val cheerUpEmoKid       = Palette(0x556270 :: 0x4ECDC4 :: 0xC7F464 :: 0xFF6B6B :: 0xC44D58 :: Nil :_*)
    val letThemEatCake      = Palette(0x774F38 :: 0xE08E79 :: 0xF1D4AF :: 0xECE5CE :: 0xC5E0DC :: Nil :_*)
    val mellonBallSurprise  = Palette(0xD1F2A5 :: 0xEFFAB4 :: 0xFFC48C :: 0xFF9F80 :: 0xF56991 :: Nil :_*)
    val oceanFive           = Palette(0x00A0B0 :: 0x6A4A3C :: 0xCC333F :: 0xEB6841 :: 0xEDC951 :: Nil :_*)
    val iDemandPancake      = Palette(0x594F4F :: 0x547980 :: 0x45ADA8 :: 0x9DE0AD :: 0xE5FCC2 :: Nil :_*)
  }

}