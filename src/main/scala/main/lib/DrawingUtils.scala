package main.lib

import scala.scalajs.js
import scala.scalajs.js.typedarray.Float32Array
import js.JSConverters._

/**
 * Created by martin on 07/10/15.
 */
trait DrawingUtils extends MathUtils with Converters with PaletteT with WorldCoordinates{
  self:Canvas=>

  def now = System.currentTimeMillis()

  //Should re calculate acording to origin
  def random2D = new Vector3(rand(width), rand(height),0)
  def randomWidth = rand(width)
  def randomHeight = rand(height)

  def vecXYAngle(angle:Double, size:Double=1) = new Vector3(size,0,0).applyAxisAngle(zAxis, angle)




  //########################   LINE   ############################


  //Not working goddamit..
  case class LineMaterial[T <: Material](wrappedMaterial :T)
  def basicLineMaterialToLineMaterial(lineBasicMaterial: LineBasicMaterial): LineMaterial[_] = LineMaterial(lineBasicMaterial)
  def dashedLineMaterialToLineMaterial(dashedMaterial: LineDashedMaterial): LineMaterial[_] =  LineMaterial(dashedMaterial)

  implicit var lineMaterial: LineMaterial[LineBasicMaterial] = new LineMaterial(new LineBasicMaterial(js.Dynamic.literal(color = 0xFFFFFF, side= THREE.DoubleSide)))

  def line[LM <: Material](vertexes :Vector3*)(implicit material: LineMaterial[LM]):Geometry = {
    val geometry = new Geometry()
    geometry.vertices = vertexes.toJSArray
    //geometry.vertices.push(vertex2)
    //new THREE.Vector3( -10, 0, 0 )
    val l = new Line(geometry, material.wrappedMaterial)
    scene.add(l)
    geometry
  }

  //########################   SPLINE ############################


  def spline[LM <: Material](points: Vector3*)(implicit lineMaterial: LineMaterial[LM]) = {
    val curve = new SplineCurve3(points.toJSArray)
    val geometry = new Geometry()
    //TODO: look at divisions, what the heck ?
    geometry.vertices = curve.getPoints(500)
    //Create the final Object3d to add to the scene
    val splineObject = new Line(geometry, lineMaterial.wrappedMaterial)
    scene.add(splineObject)
    splineObject
  }

  //########################   RECT   ############################

  val planeGeometry =   new PlaneGeometry(1, 1)

  def rect[RT <: Material](pos:Vector3, _width:Double, _height:Double)(implicit material: RT):Mesh[RT] = {
    val mesh = addMeshInPlace(planeGeometry, RectMode.rectMode(pos, (_width, _height)), material)
    mesh.scale.set(_width, _height, 1)
    mesh
  }

  def rect[RT <: Material](pos:Vector3, _width:Double)(implicit material: RT):Mesh[RT] = {
    val mesh = addMeshInPlace(planeGeometry, RectMode.rectMode(pos, (_width, _width)), material)
    mesh.scale.set(_width, _width, 1)
    mesh
  }

  def rectXZ[RT <: Material](pos:Vector3, _width:Double, _height:Double)(implicit material: RT):Mesh[RT] = {
    val mesh = addMeshInPlace(planeGeometry, RectMode.rectMode(pos, (_width, _height)), material)
    mesh.scale.set(_width, _height, 1)
    mesh.rotateX(HALF_PI)
    mesh
  }

  def rectXZ[RT <: Material](pos:Vector3, _width:Double)(implicit material: RT):Mesh[RT] = {
    val mesh = addMeshInPlace(planeGeometry, RectMode.rectMode(pos, (_width, _width)), material)
    mesh.scale.set(_width, _width, 1)
    mesh.rotateX(HALF_PI)
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

  //Create several geometries depending on size of circle or create on demand
  val circleGeometries =  (1 to 8).map(x=> new CircleGeometry(1, Math.pow(2,x))).toArray

  def circle[CT <: Material](pos:Vector3, radius:Double)(implicit material: CT ): Mesh[CT] = {
    val s = radius.mapContrain(0,1920,4,circleGeometries.length).toInt
    val mm = addMeshInPlace(circleGeometries(s), pos, material)
    mm.scale.set(radius,radius,radius)
    mm
  }

  def circle[CT <: Material](pos:Vector3, radius:Double, segments:Int)(implicit material: CT ): Mesh[CT] = {
    val s = segments.toDouble.mapContrain(2,256,0,circleGeometries.length).toInt
    val mm = addMeshInPlace(circleGeometries(s), pos, material)
    mm.scale.set(radius,radius,radius)
    mm
  }

  //########################   Triangle   ############################

  def triangle[TT <: Material](pos1:Vector3, pos2:Vector3, pos3:Vector3)(implicit material:TT): Mesh[TT] = {
    val geometry = new Geometry()
    geometry.vertices.push(pos1)
    geometry.vertices.push(pos2)
    geometry.vertices.push(pos3)

    geometry.faces.push(new Face3(0, 1, 2))

    addMeshInPlace(geometry, center, material)
  }


  // WONT WORK !
//    implicit class RichMesh2(m: Material => Mesh[Material]){
//      def FILLL(color:Color): Mesh[MeshBasicMaterial] ={
//        m(new MeshBasicMaterial(js.Dynamic.literal(color = color))).asInstanceOf[Mesh[MeshBasicMaterial]]
//      }
//      def FILLLM(color:Color): Mesh[MeshLambertMaterial] ={
//        m(new MeshLambertMaterial(js.Dynamic.literal(color = color))).asInstanceOf[Mesh[MeshLambertMaterial]]
//      }
//    }


    implicit class RichMesh(m: Mesh[MeshBasicMaterial]){
      def fill(color:Color, side:Side = faceSide): Mesh[MeshBasicMaterial] ={
        m.material = new MeshBasicMaterial(js.Dynamic.literal(color = color, side= side))
        m.material.needsUpdate = true
        m
      }
    }

  implicit class RichColor(color: Color){
    def materialize(side:Side = faceSide)  = new MeshBasicMaterial(js.Dynamic.literal(color = color, side= side))
    def materializeL(side:Side = faceSide) = new MeshLambertMaterial(js.Dynamic.literal(color = color, side= side))
    def materializeP(side:Side = faceSide) = new MeshPhongMaterial(js.Dynamic.literal(color = color, side= side))
  }


  // IF YOU WORKED THAT WOULD BE LIKE AWESOME U KNOW...
//  implicit def ColorToMaterial(color:Color): MeshBasicMaterial = {
//    new MeshBasicMaterial(js.Dynamic.literal(color = color, side= faceSide))
//  }

  //############# STROKE AND FILL ##################

  def lineWeight(weight: Double) = {
    lineMaterial = new LineMaterial(lineMaterial.wrappedMaterial.clone().asInstanceOf[LineBasicMaterial])
    lineMaterial.wrappedMaterial.linewidth = weight
  }

  def stroke(color:Color) = {
    lineMaterial = new LineMaterial(lineMaterial.wrappedMaterial.clone().asInstanceOf[LineBasicMaterial])
    lineMaterial.wrappedMaterial.color = color
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

  val boxGeometry = new BoxGeometry(1, 1, 1)

  def cube[ST <: Material](pos:Vector3, width:Double)(implicit material:ST )={
    val m = addMeshInPlace(boxGeometry, pos, material)
    m.scale.set(width,width,width)
    m
  }

  def cube[ST <: Material](pos:Vector3, width:Double, height:Double, deep:Double)(implicit material:ST )={
    val m = addMeshInPlace(boxGeometry, pos, material)
    m.scale.set(width, height, deep)
    m
  }

  //#######################  SPHERE #############################

  def sphere[ST <: Material](pos:Vector3, radius:Double)(implicit material:ST ): Mesh[ST] ={
    val m = addMeshInPlace(SphereGeometry, pos, material)
    m.scale.set(radius,radius,radius)
    m
  }

  val SphereGeometry = new SphereGeometry(1, 16, 16)

  def sphere[ST <: Material](pos:Vector3, radius:Double, segments: Int)(implicit material:ST ): Mesh[ST] ={
    val m = addMeshInPlace(SphereGeometry, pos, material)
    m.scale.set(radius,radius,radius)
    m
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

    val c = lineMaterial.wrappedMaterial.color

    positions.foreach{ pos =>
      geometry.vertices.push( pos )
      geometry.colors.push(c)
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
