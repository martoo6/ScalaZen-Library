package main.lib

import org.scalajs.dom

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


  //#######################  MATERIALS #########################
  //TODO: Might include an optional service that searches for cached colors, textures, etc. ?


  var defaultLineMaterial: LineBasicMaterial = new LineBasicMaterial(js.Dynamic.literal(color = 0xFFFFFF, side= faceSide))

  trait LineMaterialTypeClass[T, W <: Material]{
    def toLineMaterial(t:T): W
  }

  implicit object ColorToLineMaterial extends LineMaterialTypeClass[Color, LineBasicMaterial]{
    override def toLineMaterial(t: Color): LineBasicMaterial = new LineBasicMaterial(js.Dynamic.literal(color = t, side= faceSide))
  }

  implicit object LineBasicMaterialToLineMaterial extends LineMaterialTypeClass[LineBasicMaterial, LineBasicMaterial]{
    override def toLineMaterial(t: LineBasicMaterial): LineBasicMaterial = t
  }

  implicit object LineDashedMaterialToLineMaterial extends LineMaterialTypeClass[LineDashedMaterial, LineDashedMaterial]{
    override def toLineMaterial(t: LineDashedMaterial): LineDashedMaterial = t
  }


  var defaultMeshMaterial = new MeshBasicMaterial(js.Dynamic.literal(color = 0xFFFFFF, side = faceSide))

  trait MeshMaterialTypeClass[T, W <: Material]{
    def toMeshMaterial(t:T): W
  }

  implicit object ColorToMeshMaterial extends MeshMaterialTypeClass[Color, MeshBasicMaterial]{
    override def toMeshMaterial(t: Color): MeshBasicMaterial = new MeshBasicMaterial(js.Dynamic.literal(color = t, side= faceSide))
  }

  implicit object MeshBasicMaterialToLineMaterial extends MeshMaterialTypeClass[MeshBasicMaterial, MeshBasicMaterial]{
    override def toMeshMaterial(t: MeshBasicMaterial): MeshBasicMaterial = t
  }

  implicit object MeshLambertMaterialToLineMaterial extends MeshMaterialTypeClass[MeshLambertMaterial, MeshLambertMaterial]{
    override def toMeshMaterial(t: MeshLambertMaterial): MeshLambertMaterial = t
  }

  implicit object MeshPhongMaterialToLineMaterial extends MeshMaterialTypeClass[MeshPhongMaterial, MeshPhongMaterial]{
    override def toMeshMaterial(t: MeshPhongMaterial): MeshPhongMaterial = t
  }

  //########################   LINE   ############################

  def line[LM, W <: Material](start: Vector3, end: Vector3, material: LM = defaultLineMaterial)(implicit lineMaterialTypeClass: LineMaterialTypeClass[LM, W]): Line[W] = {
    val geometry = new Geometry()
    geometry.vertices.push(start)
    geometry.vertices.push(end)
    val l = new Line(geometry, lineMaterialTypeClass.toLineMaterial(material))
    scene.add(l)
    l
  }

  def mline[LM, W <: Material](vertexes :Iterable[Vector3], material: LM = defaultLineMaterial)(implicit lineMaterialTypeClass: LineMaterialTypeClass[LM, W]): Line[W] = {
    val geometry = new Geometry()
    geometry.vertices = vertexes.toJSArray
    val l = new Line(geometry, lineMaterialTypeClass.toLineMaterial(material))
    scene.add(l)
    l
  }

  //########################   SPLINE ############################

  def spline[LM, W <: Material](first: Vector3, second: Vector3, third: Vector3, fourth: Vector3, material: LM = defaultLineMaterial)(implicit lineMaterialTypeClass: LineMaterialTypeClass[LM, W]): Line[W] = {
    val curve = new SplineCurve3(List(first, second, third, fourth).toJSArray)
    val geometry = new Geometry()
    //TODO: look at divisions, what the heck ?
    geometry.vertices = curve.getPoints(500)
    //Create the final Object3d to add to the scene
    val splineObject = new Line(geometry, lineMaterialTypeClass.toLineMaterial(material))
    scene.add(splineObject)
    splineObject
  }

  def
  mspline[LM, W <: Material](vertexes :Iterable[Vector3], divisions:Int = 0, material: LM = defaultLineMaterial)(implicit lineMaterialTypeClass: LineMaterialTypeClass[LM, W]): Line[W] = {
    val curve = new SplineCurve3(vertexes.toJSArray)
    val geometry = new Geometry()
    //TODO: look at divisions, what the heck ?
    geometry.vertices = curve.getPoints(if(divisions<=0) vertexes.size else divisions)
    //Create the final Object3d to add to the scene
    val splineObject = new Line(geometry, lineMaterialTypeClass.toLineMaterial(material))
    scene.add(splineObject)
    splineObject
  }
  //########################   RECT   ############################

  val planeGeometry =   new PlaneGeometry(1, 1)

  def rect[MM, W <: Material](pos:Vector3, _width:Double, _height:Double, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W]): Mesh[W] = {
    val mesh = addMeshInPlace(planeGeometry, RectMode.rectMode(pos, (_width, _height)), meshMaterialTypeClass.toMeshMaterial(material))
    mesh.scale.set(_width, _height, 1)
    mesh
  }

  def square[MM, W <: Material](pos:Vector3, _width:Double, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W]): Mesh[W] = {
    val mesh = addMeshInPlace(planeGeometry, RectMode.rectMode(pos, (_width, _width)), meshMaterialTypeClass.toMeshMaterial(material))
    mesh.scale.set(_width, _width, 1)
    mesh
  }

  def rectXZ[MM, W <: Material](pos:Vector3, _width:Double, _height:Double, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W]): Mesh[W] = {
    val mesh = addMeshInPlace(planeGeometry, RectMode.rectMode(pos, (_width, _height)), meshMaterialTypeClass.toMeshMaterial(material))
    mesh.scale.set(_width, _height, 1)
    mesh.rotateX(HALF_PI)
    mesh
  }

  def squareXZ[MM, W <: Material](pos:Vector3, _width:Double, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W]): Mesh[W] = {
    val mesh = addMeshInPlace(planeGeometry, RectMode.rectMode(pos, (_width, _width)), meshMaterialTypeClass.toMeshMaterial(material))
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

  
  def circle[MM, W <: Material](pos:Vector3, radius:Double, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W]): Mesh[W] = {
    val s = radius.mapContrain(0,1920,4,circleGeometries.length).toInt
    val mm = addMeshInPlace(circleGeometries(s), pos, meshMaterialTypeClass.toMeshMaterial(material))
    mm.scale.set(radius,radius,radius)
    mm
  }

  def segCircle[MM, W <: Material](pos:Vector3, radius:Double, segments:Int, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W]): Mesh[W] = {
    val s = segments.toDouble.mapContrain(2,256,0,circleGeometries.length).toInt
    val mm = addMeshInPlace(circleGeometries(s), pos, meshMaterialTypeClass.toMeshMaterial(material))
    mm.scale.set(radius,radius,radius)
    mm
  }

  //########################   Triangle   ############################

  def triangle[MM, W <: Material](pos1:Vector3, pos2:Vector3, pos3:Vector3, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W]): Mesh[W] = {
    val geometry = new Geometry()
    geometry.vertices.push(pos1)
    geometry.vertices.push(pos2)
    geometry.vertices.push(pos3)

    geometry.faces.push(new Face3(0, 1, 2))

    addMeshInPlace(geometry, center, meshMaterialTypeClass.toMeshMaterial(material))
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
    //Cannot assure it's LineBasicMaterial
    //lm = lm.clone().asInstanceOf[LineBasicMaterial]
    defaultLineMaterial.linewidth = weight
  }

  def stroke(color:Color, lineWidth:Double = 1) = {
    defaultLineMaterial = new LineBasicMaterial(js.Dynamic.literal(color = color, side= faceSide, linewidth = lineWidth))
  }

  //Should check default attributes for world (3D, 2D)

  //#######################  CUBE #############################

  val boxGeometry = new BoxGeometry(1, 1, 1)

  def cube[MM, W <: Material](pos:Vector3, width:Double, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W]): Mesh[W] = {
    val m = addMeshInPlace(boxGeometry, pos, meshMaterialTypeClass.toMeshMaterial(material))
    m.scale.set(width,width,width)
    m
  }

  def hyperrectangle[MM, W <: Material](pos:Vector3, width:Double, height:Double, deep:Double, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W]): Mesh[W] = {
    val m = addMeshInPlace(boxGeometry, pos, meshMaterialTypeClass.toMeshMaterial(material))
    m.scale.set(width, height, deep)
    m
  }

  //#######################  SPHERE #############################

  //Create several geometries depending on size of sphere or create on demand
  val sphereGeometries =  (1 to 8).map(x=> new SphereGeometry(1, Math.pow(2,x), Math.pow(2,x))).toArray

  def sphere[MM, W <: Material](pos:Vector3, radius:Double, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W]): Mesh[W] = {
    val s = radius.mapContrain(0,1920,4,sphereGeometries.length).toInt
    val m = addMeshInPlace(sphereGeometries(s), pos, meshMaterialTypeClass.toMeshMaterial(material))
    m.scale.set(radius,radius,radius)
    m
  }

  def segSphere[MM, W <: Material](pos:Vector3, radius:Double, segments: Int, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W]): Mesh[W] = {
    val s = segments.toDouble.mapContrain(2,256,0,sphereGeometries.length).toInt
    val m = addMeshInPlace(sphereGeometries(s), pos, meshMaterialTypeClass.toMeshMaterial(material))
    m.scale.set(radius,radius,radius)
    m
  }

  def addMeshInPlace[MT <: Material, G <: Geometry](geometry: G, pos:Vector3, material:MT): Mesh[MT] = {
    val mesh = new Mesh(geometry, material)
    mesh.position.add(pos)
    scene.add(mesh)
    mesh
  }

  //

  def point(positions:Vector3*): Unit ={
    val geometry = new Geometry()

    val c = defaultLineMaterial.color

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

  //########################   SAVE     ########################

  def saveImg = dom.window.open(renderer.domElement.toDataURL("image/png"))

  //########################   GROUPING     ########################

  def grouped(lst: Seq[Object3D]) = {
    val g = new Group()
    //Must be added one by one in order to work, should check JS to understand behaviour
    lst.foreach(g.add)
    //g.children = lst.toJSArray
    scene.add(g)
    g
  }
}
