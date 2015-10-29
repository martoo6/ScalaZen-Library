package main.lib

import scala.scalajs.js
import scala.scalajs.js.typedarray.Float32Array

/**
 * Created by martin on 07/10/15.
 */
trait DrawingUtils extends MathUtils with Converters with PaletteT with WorldCoordinates{
  self:Canvas=>

  def now = System.currentTimeMillis()

  //Should re calculate acording to origin
  def random2D = new Vector3(random(width), random(height),0)
  def randomWidth = random(width)
  def randomHeight = random(height)

  def vecXYAngle(angle:Double, size:Double=1) = new Vector3(size,0,0).applyAxisAngle(zAxis, angle)

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

  def rect(pos: Vector3, width:Double):Mesh = rect(pos,width,width)

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


  def circle(pos:Vector3, radius:Double, segments:Int = 8): Mesh = {
    addMeshInPlace(new CircleGeometry(radius, segments), pos)
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

  //

  def point(positions:Vector3*): Unit ={
    val geometry = new Geometry()

    positions.foreach{ pos =>
      geometry.vertices.push( pos )
      geometry.colors.push(lineMaterial.color)
    }

    //Check for options
    val material = new PointsMaterial(js.Dynamic.literal(size= 1.0, vertexColors= THREE.VertexColors, depthTest= false, opacity= 1, sizeAttenuation= false, transparent= false))

    val mesh = new Points( geometry, material )
    scene.add( mesh )
  }

  //Check for options
  val pMaterial = new PointsMaterial(js.Dynamic.literal(size= 1.0, vertexColors= THREE.VertexColors, depthTest= false, opacity= 1, sizeAttenuation= false, transparent= false))

  def point2(data: (Vector3,Color)*) ={
    val geometry = new Geometry()

    data.foreach{ case (pos,col) =>
      geometry.vertices.push(pos)
      geometry.colors.push(col)
    }

    val mesh = new Points( geometry, pMaterial )
    scene.add( mesh )
    mesh
  }

  def point3(data: (Vector3,Color)*) ={


    val positions = new Float32Array( data.length * 3 )
    val colors = new Float32Array( data.length * 3 )
    //val size = new Float32Array( data.length)


    //geometry.addAttribute( "size", new BufferAttribute( sizes, 1 ) );

    data.zipWithIndex.foreach{ case ((pos,col),i) =>
      //size(i) = 1
      positions(i*3) = pos.x.toFloat
      positions(i*3+1) = pos.y.toFloat
      positions(i*3+2) = pos.z.toFloat
      colors(i*3) = col.r.toFloat
      colors(i*3+1) = col.g.toFloat
      colors(i*3+2) = col.b.toFloat
    }

    val geo = new BufferGeometry()

    geo.addAttribute( "position", new BufferAttribute( positions, 3 ) )
    geo.addAttribute( "color", new BufferAttribute( colors, 3 ) )
    //geo.addAttribute( "size", new BufferAttribute( size, 1 ) )

    geo.computeBoundingSphere()

    val mesh = new Points( geo, pMaterial )
    scene.add( mesh )
    mesh
  }

  def point4(data: (Vector3,Color)*) ={
    val geometry = new Geometry()

    data.foreach{ case (pos,col) =>
      geometry.vertices.push(pos)
      geometry.colors.push(col)
    }

    val geo = new BufferGeometry().fromGeometry(geometry)

    val mesh = new Points( geo, pMaterial )
    scene.add( mesh )
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
}
