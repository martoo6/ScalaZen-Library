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


  def rect[RT <: Material](pos:Vector3, width:Double, height:Double)(implicit material: RT):Mesh[RT] = {

    //val geo = addMeshInPlace(new PlaneBufferGeometry(width, height), pos)
    val mesh = addMeshInPlace(new PlaneGeometry(width, height), pos, material)
    mesh.geometry.vertices = mesh.geometry.vertices.map(x=>RectMode.rectMode(x, (width, height)))
    mesh
  }

  def rect[RT <: Material](pos:Vector3, width:Double)(implicit material: RT):Mesh[RT] = {

    //val geo = addMeshInPlace(new PlaneBufferGeometry(width, height), pos)
    val mesh = addMeshInPlace(new PlaneGeometry(width, width), pos, material)
    mesh.position = RectMode.rectMode(mesh.position, (width, width))
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


  def circle[CT <: Material](pos:Vector3, radius:Double, segments:Int = 8)(implicit material: CT ): Mesh[CT] = {
    addMeshInPlace(new CircleGeometry(radius, segments), pos, material)
  }

  //########################   Triangle   ############################

  def triangle[TT <: Material](pos1:Vector3, pos2:Vector3, pos3:Vector3)(implicit material:TT ): Mesh[TT] = {
    val geometry = new Geometry()
    geometry.vertices.push(pos1)
    geometry.vertices.push(pos2)
    geometry.vertices.push(pos3)

    geometry.faces.push(new Face3(0, 2, 1))
    addMeshInPlace(geometry, origin, material)
  }


  // WONT WORK !
  //  implicit class RichMesh[T <: Material](m: T => Mesh[T]){
  //    def fill(color:Color): Mesh[T] ={
  //      m(new MeshBasicMaterial(js.Dynamic.literal(color = color)))
  //    }
  //  }

    implicit class RichMesh(m: Mesh[MeshBasicMaterial]){
      def fill(color:Color): Mesh[MeshBasicMaterial] ={
        m.material.color.set(color)
        m
      }
    }

  implicit class RichColor(color: Color){
    def materialize  = new MeshBasicMaterial(js.Dynamic.literal(color = color))
    def materializeL = new MeshLambertMaterial(js.Dynamic.literal(color = color))
    def materializeP = new MeshPhongMaterial(js.Dynamic.literal(color = color))
  }

  implicit class RichMaterial(material: Material){
    def setColor(color:Color): Unit ={
      material match{
        case m:MeshBasicMaterial => m.color.set(color)
        case m:MeshLambertMaterial => m.color.set(color)
        case _ =>
      }
    }
    def getColor:Option[Color]={
      material match{
        case m:MeshBasicMaterial => Some(m.color)
        case m:MeshLambertMaterial => Some(m.color)
        case _ => None
      }
    }
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


  //NOT WORKING EITHER
  def fill[FT](color:Color)(f: =>FT):FT = {
    implicit val material = new MeshBasicMaterial(js.Dynamic.literal(color = color))
    f
  }

  def fillLambert[FT](color:Color)(f: =>FT):FT = {
    implicit val material = new MeshLambertMaterial(js.Dynamic.literal(color = color))
    f
  }

//  def fillLambert(color:Color) = {
//    val nMeshMaterial = new MeshLambertMaterial(js.Dynamic.literal(color = color))
//    meshMaterial = nMeshMaterial
//  }

  //#######################  CUBE #############################

  def cube[ST <: Material](pos:Vector3, width:Double)(implicit material:ST )={
    addMeshInPlace(new BoxGeometry(width, width, width), pos, material)
  }
  
  def cube[ST <: Material](pos:Vector3, width:Double, height:Double, deep:Double)(implicit material:ST )={
    addMeshInPlace(new BoxGeometry(width, height, deep), pos, material)
  }

  //#######################  SPHERE #############################

  def sphere[ST <: Material](pos:Vector3, radius:Double)(implicit material:ST ): Mesh[ST] ={
    addMeshInPlace(new SphereGeometry(radius), pos, material)
  }

  def sphere[ST <: Material](pos:Vector3, radius:Double, segments: Int)(implicit material:ST ): Mesh[ST] ={
    addMeshInPlace(new SphereGeometry(radius, segments, segments), pos, material)
  }

  def addMeshInPlace[MT <: Material](geometry: Geometry, pos:Vector3, material:MT): Mesh[MT] = {
    val mesh = new Mesh(geometry, material)
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

  def addHemisphereLight(skyColorHex: Int, groundColorHex: Int, intensity: Double) = {
    val light = new HemisphereLight(skyColorHex, groundColorHex, intensity)
    scene.add( light )
    light
  }


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
