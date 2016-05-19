package main.lib

import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.typedarray.Float32Array
import js.JSConverters._
import scala.reflect.ClassTag

/**
 * Created by martin on 07/10/15.
 */




//TODO: Get rid of Typeclasses, annoying as shit, not usefull for this use case..

trait DrawingUtils extends MathUtils with Converters with Materials with ColorsTypeclasses with VectorTypeclasses with PaletteT with WorldCoordinates{
  self:Canvas=>

  def now = System.currentTimeMillis()

  //Should re calculate acording to origin
  def random2D = new Vector3(rand(width), rand(height),0)
  def randomWidth = rand(width)
  def randomHeight = rand(height)

  def vecXYAngle(angle:Float, size:Float=1) = new Vector3(size,0,0).applyAxisAngle(zAxis, angle)

  //########################   LINE   ############################


//    TODO: BufferGeometry is supposed to have better performance, but i could not prove it.
//    def lines[V1, C](vertices: Traversable[V1], colors: Traversable[C])(implicit v1: VectorTypeclass[V1], ct: ColorTypeclass[C]) = {
//    val geometry = new BufferGeometry
//    val material = new LineBasicMaterial(js.Dynamic.literal(color = 0xFFFFFF, side= faceSide, vertexColors= THREE.VertexColors, lineWidth = defaultLineMaterial.linewidth))
//    val positions = new Float32Array(vertices.toJSArray.flatMap(v=> js.Array(v1.x(v), v1.y(v), v1.z(v))))
//    val cols = new Float32Array(colors.toJSArray.flatMap(v=> js.Array(ct.r(v), ct.g(v), ct.b(v))))
//    geometry.addAttribute( "position", new BufferAttribute( positions, 3 ) )
//    geometry.addAttribute( "color", new BufferAttribute( cols, 3 ) )
//    geometry.computeBoundingSphere()
//    val mesh = new LineSegments( geometry, material )
//    mainGroup.add(mesh)
//    mesh
//  }

  private def defaultLineMaterialCopy =
    new LineBasicMaterial(js.Dynamic.literal(color = defaultLineMaterial.color, linewidth = defaultLineMaterial.linewidth, linejoin=defaultLineMaterial.linejoin, linecap=defaultLineMaterial.linecap, fog=defaultLineMaterial.fog))

  def line[V1, V2, C](start: V1, end: V2)(implicit v1: VectorTypeclass[V1], v2: VectorTypeclass[V2]): Line[LineBasicMaterial] = {
    val geometry = new Geometry()
    geometry.vertices = js.Array(v1.toVector(start), v2.toVector(end))
    val mesh = new Line( geometry, defaultLineMaterial )
    mainGroup.add(mesh)
    mesh
  }

  def line[V1, V2, C](start: V1, end: V2, color: C)(implicit ct: ColorTypeclass[C], v1: VectorTypeclass[V1], v2: VectorTypeclass[V2]): Line[LineBasicMaterial] = {
    val geometry = new Geometry()
    geometry.vertices = js.Array(v1.toVector(start), v2.toVector(end))
    val material = defaultLineMaterialCopy
    material.color = ct.toColor(color)
    val mesh = new Line( geometry, material )
    mainGroup.add(mesh)
    mesh
  }


  //Typeclasses
//  def line[V1, V2, C](start: V1, end: V2, lmp: LineMaterialProperties)(implicit v1: VectorTypeclass[V1], v2: VectorTypeclass[V2]): Line[LineBasicMaterial] = {
//    val geometry = new BufferGeometry()
//    val material = new LineBasicMaterial(js.Dynamic.literal( color = lmp.color, linewidth = lmp.linewidth, linecap = lmp.linecap, linejoin = lmp.linejoin, fog=lmp.fog))
//    val positions = new Float32Array(js.Array(v1.x(start),v1.y(start), v1.z(start) , v2.x(end),v2.y(end), v2.z(end)) )
//    geometry.addAttribute( "position", new BufferAttribute( positions, 3 ) )
//    geometry.computeBoundingSphere()
//    val mesh = new Line( geometry, material )
//    mainGroup.add(mesh)
//    mesh
//  }


  def line[V1, C, LM, W <: Material](vertices: Traversable[V1], colors: Traversable[C], lm: LM)(implicit lmtc: LineMaterialTypeClass[LM, W], v1: VectorTypeclass[V1], ct: ColorTypeclass[C]) = {
    val lineGeometry = new Geometry()
    lineGeometry.vertices = vertices.view.map(v1.toVector).toJSArray
    lineGeometry.colors = colors.view.map(ct.toColor).toJSArray
    val l = new LineSegments(lineGeometry, lmtc.toLineMaterial(lm))
    mainGroup.add(l)
    l
  }

  def line[V1, C](vertices: Traversable[V1], colors: Traversable[C])(implicit v1: VectorTypeclass[V1], ct: ColorTypeclass[C]) = {
    val lineGeometry = new Geometry()
    val material = defaultLineMaterialCopy
    material.vertexColors = THREE.VertexColors
    lineGeometry.vertices = vertices.view.map(v1.toVector).toJSArray
    lineGeometry.colors = colors.view.map(ct.toColor).toJSArray
    val l = new LineSegments(lineGeometry, material)
    mainGroup.add(l)
    l
  }

  def line[V1, C](vertices: Traversable[V1])(implicit v1: VectorTypeclass[V1]) = {
    val lineGeometry = new Geometry()
    lineGeometry.vertices = vertices.view.map(v1.toVector).toJSArray
    val l = new LineSegments(lineGeometry, defaultLineMaterial)
    mainGroup.add(l)
    l
  }

  def line[V1, C](vertices: Traversable[V1], colors: Traversable[C], lineWidth:Float = defaultLineMaterial.linewidth)(implicit v1: VectorTypeclass[V1], ct: ColorTypeclass[C]) = {
    val lineGeometry = new Geometry()
    vertices.foreach(v=>lineGeometry.vertices.push(v1.toVector(v)))
    colors.foreach(c=>lineGeometry.colors.push(ct.toColor(c)))

    val l = new LineSegments(lineGeometry, new LineBasicMaterial(js.Dynamic.literal(color = 0xFFFFFF, side= faceSide, vertexColors= THREE.VertexColors,lineWidth = lineWidth)))
    mainGroup.add(l)
    l
  }

  def mline[LM, W <: Material, V](vertices :Traversable[V], material: LM)(implicit lineMaterialTypeClass: LineMaterialTypeClass[LM, W], v: VectorTypeclass[V]): Line[W] = {
    val geometry = new Geometry()
    geometry.vertices = vertices.toJSArray.map(v.toVector)
    val l = new Line(geometry, lineMaterialTypeClass.toLineMaterial(material))
    mainGroup.add(l)
    l
  }

//  def mline[V:ClassTag](vertices :Seq[V])(implicit v: VectorTypeclass[V]): Line[LineBasicMaterial] = {
//    val geometry = new BufferGeometry()
//    val material = new LineBasicMaterial(js.Dynamic.literal( color = defaultLineMaterial.color))
//    val positions = new Float32Array(vertices.toJSArray.flatMap(x => js.Array(v.x(x), v.y(x), v.z(x)) ))
//    geometry.addAttribute( "position", new BufferAttribute( positions, 3 ) )
//    geometry.computeBoundingSphere()
//    val mesh = new Line( geometry, material )
//    mainGroup.add(mesh)
//    mesh
//  }

  def mline[V:ClassTag](vertices :Seq[V])(implicit v: VectorTypeclass[V]): Line[LineBasicMaterial] = {
    val geometry = new Geometry()
    geometry.vertices = vertices.toJSArray.map(v.toVector)
    val l = new Line(geometry, defaultLineMaterial)
    mainGroup.add(l)
    l
  }

  def mline[V, C](vertices :Seq[V], colors :Seq[C])(implicit v: VectorTypeclass[V], ct: ColorTypeclass[C]) = {
    val geometry = new Geometry()
    geometry.vertices = vertices.toJSArray.map(v.toVector)
    geometry.colors = colors.toJSArray.map(ct.toColor)
    val l = new Line(geometry, defaultLineMaterial)
    mainGroup.add(l)
    l
  }

  def mline[V, C](vertices :Seq[V], colors :Seq[C], lineWidth:Float)(implicit v: VectorTypeclass[V], ct: ColorTypeclass[C]) = {
    val geometry = new Geometry()
    geometry.vertices = vertices.toJSArray.map(v.toVector)
    geometry.colors = colors.toJSArray.map(ct.toColor)
    val material = defaultLineMaterialCopy
    material.linewidth = lineWidth
    val l = new Line(geometry, material)
    mainGroup.add(l)
    l
  }

//  def mline[V, C](vertices :Seq[V], cols :Seq[C], lineWidth:Float = defaultLineMaterial.linewidth)(implicit v: VectorTypeclass[V], ct: ColorTypeclass[C]): Line[LineBasicMaterial] = {
//    val geometry = new BufferGeometry()
//    val material = defaultLineMaterialCopy
//    material.vertexColors= THREE.VertexColors
//    material.linewidth = lineWidth
//    val positions = new Float32Array(vertices.toJSArray.flatMap(x => js.Array(v.x(x), v.y(x), v.z(x)) ))
//    val colors = new Float32Array(cols.toJSArray.flatMap(x => js.Array(ct.r(x), ct.g(x), ct.b(x)) ))
//    geometry.addAttribute( "position", new BufferAttribute( positions, 3 ) )
//    geometry.addAttribute( "color", new BufferAttribute( colors, 3 ) )
//    geometry.computeBoundingSphere()
//    val mesh = new Line( geometry, material )
//    mainGroup.add(mesh)
//    mesh
//  }

  //########################   SPLINE ############################

  def spline[V1, V2, V3, V4](first: V1, second: V2, third: V3, fourth: V4)(implicit v1: VectorTypeclass[V1], v2: VectorTypeclass[V2], v3: VectorTypeclass[V3], v4: VectorTypeclass[V4])= {
    val curve = new SplineCurve3(js.Array(v1.toVector(first), v2.toVector(second), v3.toVector(third), v4.toVector(fourth)))
    val geometry = new Geometry()
    //TODO: look at divisions, what the heck ?
    geometry.vertices = curve.getPoints(500)
    val splineObject = new Line(geometry, defaultLineMaterial)
    mainGroup.add(splineObject)
    splineObject
  }

  def spline[V1, V2, V3, V4, C](first: V1, second: V2, third: V3, fourth: V4, color: C)(implicit colorTypeclass: ColorTypeclass[C], v1: VectorTypeclass[V1], v2: VectorTypeclass[V2], v3: VectorTypeclass[V3], v4: VectorTypeclass[V4])= {
    val curve = new SplineCurve3(js.Array(v1.toVector(first), v2.toVector(second), v3.toVector(third), v4.toVector(fourth)))
    val geometry = new Geometry()
    val material = defaultLineMaterialCopy
    material.color = colorTypeclass.toColor(color)
    //TODO: look at divisions, what the heck ?
    geometry.vertices = curve.getPoints(500)
    val splineObject = new Line(geometry, material)
    mainGroup.add(splineObject)
    splineObject
  }

  def spline[LM, W <: Material, V1, V2, V3, V4](first: V1, second: V2, third: V3, fourth: V4, material: LM)(implicit lineMaterialTypeClass: LineMaterialTypeClass[LM, W], v1: VectorTypeclass[V1], v2: VectorTypeclass[V2], v3: VectorTypeclass[V3], v4: VectorTypeclass[V4]): Line[W] = {
    val curve = new SplineCurve3(js.Array(v1.toVector(first), v2.toVector(second), v3.toVector(third), v4.toVector(fourth)))
    val geometry = new Geometry()
    //TODO: look at divisions, what the heck ?
    geometry.vertices = curve.getPoints(500)
    val splineObject = new Line(geometry, lineMaterialTypeClass.toLineMaterial(material))
    mainGroup.add(splineObject)
    splineObject
  }

  def spline[V](vertices :Iterable[V])(implicit vectorTypeclass: VectorTypeclass[V]) = {
    val curve = new CatmullRomCurve3(vertices.toJSArray.map(vectorTypeclass.toVector))
    val geometry = new Geometry()
    //TODO: look at divisions, what the heck ?
    geometry.vertices = curve.getPoints(vertices.size)
    //Create the final Object3d to add to the scene
    val splineObject = new Line(geometry, defaultLineMaterial)
    mainGroup.add(splineObject)
    splineObject
  }

  def spline[V](vertices :Iterable[V], divisions:Int)(implicit vectorTypeclass: VectorTypeclass[V]) = {
    val curve = new CatmullRomCurve3(vertices.toJSArray.map(vectorTypeclass.toVector))
    val geometry = new Geometry()
    //TODO: look at divisions, what the heck ?
    geometry.vertices = curve.getPoints(if(divisions<=0) vertices.size else divisions)
    //Create the final Object3d to add to the scene
    val splineObject = new Line(geometry, defaultLineMaterial)
    mainGroup.add(splineObject)
    splineObject
  }

  def spline[LM, W <: Material, V](vertices :Iterable[V], material: LM)(implicit lineMaterialTypeClass: LineMaterialTypeClass[LM, W], vectorTypeclass: VectorTypeclass[V]): Line[W] = {
    val curve = new CatmullRomCurve3(vertices.toJSArray.map(vectorTypeclass.toVector))
    val geometry = new Geometry()
    //TODO: look at divisions, what the heck ?
    geometry.vertices = curve.getPoints(vertices.size)
    //Create the final Object3d to add to the scene
    val splineObject = new Line(geometry, lineMaterialTypeClass.toLineMaterial(material))
    mainGroup.add(splineObject)
    splineObject
  }

  def spline[V, C](vertices :Iterable[V], divisions:Int, color: C)(implicit colorTypeclass: ColorTypeclass[C], vectorTypeclass: VectorTypeclass[V]) = {
    val curve = new CatmullRomCurve3(vertices.toJSArray.map(vectorTypeclass.toVector))
    val geometry = new Geometry()
    //TODO: look at divisions, what the heck ?
    geometry.vertices = curve.getPoints(if(divisions<=0) vertices.size else divisions)
    //Create the final Object3d to add to the scene
    val material = defaultLineMaterialCopy
    material.color = colorTypeclass.toColor(color)
    val splineObject = new Line(geometry, material)
    mainGroup.add(splineObject)
    splineObject
  }

  def spline[V](vertices :Iterable[V], divisions:Int, material: LineBasicMaterial)(implicit vectorTypeclass: VectorTypeclass[V]): Line[LineBasicMaterial] = {
    val curve = new CatmullRomCurve3(vertices.toJSArray.map(vectorTypeclass.toVector))
    val geometry = new Geometry()
    //TODO: look at divisions, what the heck ?
    geometry.vertices = curve.getPoints(if(divisions<=0) vertices.size else divisions)
    //Create the final Object3d to add to the scene
    val splineObject = new Line(geometry, material)
    mainGroup.add(splineObject)
    splineObject
  }

  def spline[V](vertices :Iterable[V], divisions:Int, material: LineDashedMaterial)(implicit vectorTypeclass: VectorTypeclass[V]): Line[LineDashedMaterial] = {
    val curve = new CatmullRomCurve3(vertices.toJSArray.map(vectorTypeclass.toVector))
    val geometry = new Geometry()
    //TODO: look at divisions, what the heck ?
    geometry.vertices = curve.getPoints(if(divisions<=0) vertices.size else divisions)
    //Create the final Object3d to add to the scene
    val splineObject = new Line(geometry, material)
    mainGroup.add(splineObject)
    splineObject
  }

  //########################   RECT   ############################

  private val planeGeometry =   new PlaneGeometry(1, 1)

  def rect[MM, W <: Material, V](pos: V, _width:Float, _height:Float, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val mesh = addMeshInPlace(planeGeometry, RectMode.rectMode(vectorTypeclass.toVector(pos), (_width, _height)), meshMaterialTypeClass.toMeshMaterial(material))
    mesh.scale.set(_width, _height, 1)
    mesh
  }

  def square[MM, W <: Material, V](pos: V, _width:Float, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val mesh = addMeshInPlace(planeGeometry, RectMode.rectMode(vectorTypeclass.toVector(pos), (_width, _width)), meshMaterialTypeClass.toMeshMaterial(material))
    mesh.scale.set(_width, _width, 1)
    mesh
  }

  def rectXZ[MM, W <: Material, V](pos: V, _width:Float, _height:Float, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val mesh = addMeshInPlace(planeGeometry, RectMode.rectMode(vectorTypeclass.toVector(pos), (_width, _height)), meshMaterialTypeClass.toMeshMaterial(material))
    mesh.scale.set(_width, _height, 1)
    mesh.rotateX(HALF_PI)
    mesh
  }

  def squareXZ[MM, W <: Material, V](pos: V, _width:Float, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val mesh = addMeshInPlace(planeGeometry, RectMode.rectMode(vectorTypeclass.toVector(pos), (_width, _width)), meshMaterialTypeClass.toMeshMaterial(material))
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
  private val circleGeometries =  (1 to 8).map(x=> new CircleGeometry(1, Math.pow(2,x))).toArray

  def circle[MM, W <: Material, V](pos:V, radius:Float, material: MM)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val s = radius.mapContrain(0,1920,4,circleGeometries.length).toInt
    val mm = addMeshInPlace(circleGeometries(s), vectorTypeclass.toVector(pos), meshMaterialTypeClass.toMeshMaterial(material))
    mm.scale.set(radius,radius,radius)
    mm
  }

  def circle[MM, W <: Material, V](pos:V, radius:Float, segments:Int, material: MM)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    //TODO: segments should be the amount. Period. Maybe we should make some system for geometry caching.
    val s = segments.toFloat.mapContrain(2,256,0,circleGeometries.length).toInt
    val mm = addMeshInPlace(circleGeometries(s), vectorTypeclass.toVector(pos), meshMaterialTypeClass.toMeshMaterial(material))
    mm.scale.set(radius,radius,radius)
    mm
  }

  //Scala doesn't allow overloading and default parameters yet.
  def circle[V](pos:V, radius:Float)(implicit vectorTypeclass: VectorTypeclass[V]): Mesh[MeshBasicMaterial] = {
    circle(vectorTypeclass.toVector(pos), radius, defaultMeshMaterial)
  }

  def circle[V](pos:V, radius:Float, segments:Int)(implicit vectorTypeclass: VectorTypeclass[V]): Mesh[MeshBasicMaterial] = {
    circle(vectorTypeclass.toVector(pos), radius, segments, defaultMeshMaterial)
  }

  //########################   Triangle   ############################

  def triangle[MM, W <: Material, V1, V2, V3](pos1: V1, pos2: V2, pos3: V3, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], v1: VectorTypeclass[V1], v2: VectorTypeclass[V2], v3: VectorTypeclass[V3]): Mesh[W] = {
    val geometry = new Geometry()
    geometry.vertices.push(v1.toVector(pos1))
    geometry.vertices.push(v2.toVector(pos2))
    geometry.vertices.push(v3.toVector(pos3))

    geometry.faces.push(new Face3(0, 1, 2))

    addMeshInPlace(geometry, new Vector3(0.0,0.0,0.0), meshMaterialTypeClass.toMeshMaterial(material))
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

  implicit class RichColor[T](color: T)(implicit n: ColorTypeclass[T]){
    def toMeshBasicMaterial(side:Side = faceSide)  = new MeshBasicMaterial(js.Dynamic.literal(color = n.toColor(color), side= side))
    def toMeshLambertMaterial(side:Side = faceSide) = new MeshLambertMaterial(js.Dynamic.literal(color = n.toColor(color), side= side))
    def toMeshPhongMaterial(side:Side = faceSide) = new MeshPhongMaterial(js.Dynamic.literal(color = n.toColor(color), side= side))
    def alpha(amount :Float):RGB = RGB(n.r(color), n.g(color), n.b(color), amount)
  }


  // IF YOU WORKED THAT WOULD BE LIKE AWESOME U KNOW...
//  implicit def ColorToMaterial(color:Color): MeshBasicMaterial = {
//    new MeshBasicMaterial(js.Dynamic.literal(color = color, side= faceSide))
//  }

  //############# STROKE AND FILL ##################

  def lineWeight(weight: Float) =
    defaultLineMaterial = new LineBasicMaterial(js.Dynamic.literal(color = defaultLineMaterial.color, linewidth = weight, linejoin=defaultLineMaterial.linejoin, linecap=defaultLineMaterial.linecap, fog=defaultLineMaterial.fog))

  def lineWidth(width: Float) = lineWeight(width)

  def stroke[T](color: T)(implicit n: ColorTypeclass[T]) =
    defaultLineMaterial = new LineBasicMaterial(js.Dynamic.literal(color = n.toColor(color), linewidth = defaultLineMaterial.linewidth, linejoin=defaultLineMaterial.linejoin, linecap=defaultLineMaterial.linecap, fog=defaultLineMaterial.fog))

  //Should check default attributes for world (3D, 2D)

  //#######################  CUBE #############################

  private val boxGeometry = new BoxGeometry(1, 1, 1)

  def cube[V](pos: V, width:Float)(implicit vectorTypeclass: VectorTypeclass[V]) = {
    val m = addMeshInPlace(boxGeometry, vectorTypeclass.toVector(pos), defaultMeshMaterial)
    m.scale.set(width,width,width)
    m
  }

  def cube[MM, W <: Material, V](pos: V, width:Float, material: MM)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val m = addMeshInPlace(boxGeometry, vectorTypeclass.toVector(pos), meshMaterialTypeClass.toMeshMaterial(material))
    m.scale.set(width,width,width)
    m
  }

  def hyperrectangle[MM, W <: Material, V](pos: V, width:Float, height:Float, deep:Float, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val m = addMeshInPlace(boxGeometry, vectorTypeclass.toVector(pos), meshMaterialTypeClass.toMeshMaterial(material))
    m.scale.set(width, height, deep)
    m
  }

  //#######################  SPHERE #############################

  //Create several geometries depending on size of sphere or create on demand
  private val sphereGeometries =  (1 to 8).map(x=> new SphereGeometry(1, Math.pow(2,x), Math.pow(2,x))).toArray

  def sphere[MM, W <: Material, V](pos: V, radius:Float, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val s = radius.mapContrain(0,1920,4,sphereGeometries.length).toInt
    val m = addMeshInPlace(sphereGeometries(s), vectorTypeclass.toVector(pos), meshMaterialTypeClass.toMeshMaterial(material))
    m.scale.set(radius,radius,radius)
    m
  }

  def segSphere[MM, W <: Material, V](pos: V, radius:Float, segments: Int, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val s = segments.toFloat.mapContrain(2,256,0,sphereGeometries.length).toInt
    val m = addMeshInPlace(sphereGeometries(s), vectorTypeclass.toVector(pos), meshMaterialTypeClass.toMeshMaterial(material))
    m.scale.set(radius,radius,radius)
    m
  }

  def addMeshInPlace[MT <: Material, G <: Geometry](geometry: G, pos:Vector3, material:MT): Mesh[MT] = {
    val mesh = new Mesh(geometry, material)
    mesh.position.add(pos)
    mainGroup.add(mesh)
    mesh
  }


  private val tPointMaterial = new PointsMaterial(js.Dynamic.literal(size= 1.0, vertexColors= THREE.VertexColors, depthTest= false, opacity= defaultLineMaterial.opacity, sizeAttenuation= false, transparent= false))
  private val nPointMaterial = new PointsMaterial(js.Dynamic.literal(size= 1.0, vertexColors= THREE.VertexColors, depthTest= false, sizeAttenuation= false))

  def point[V](positions:V*)(implicit vectorTypeclass: VectorTypeclass[V]): Unit ={
    val geometry = new Geometry()

    val c = defaultLineMaterial.color

    positions.foreach{ pos =>
      geometry.vertices.push(vectorTypeclass.toVector(pos))
      geometry.colors.push(c)
    }

    //Check for options
    val material = if(defaultLineMaterial.opacity >= 1) tPointMaterial else nPointMaterial
    val mesh = new Points( geometry, material )
    mainGroup.add( mesh )
  }

  //Check for options
  private val pMaterial = new PointsMaterial(js.Dynamic.literal(size= 1.0, vertexColors= THREE.VertexColors, depthTest= false, opacity= defaultLineMaterial.opacity, sizeAttenuation= false, transparent= false))

  def point[T, V](data: (V,T)*)(implicit vectorTypeclass: VectorTypeclass[V], n :ColorTypeclass[T]) ={
    val geometry = new Geometry()

    data.foreach{ case (pos,col) =>
      geometry.vertices.push(vectorTypeclass.toVector(pos))
      geometry.colors.push(n.toColor(col))
    }

    val mesh = new Points( geometry, pMaterial)
    mainGroup.add( mesh )
    mesh
  }

  case class MetaPoints[T <: Object3D, G <: Material, C, V](points: Points[T,G], data: (V,C)*)(implicit vectorTypeclass: VectorTypeclass[V], n :ColorTypeclass[C])

  private val pointsShader =
    """
      |varying vec3 vColor;
      |varying float vAlpha;
      |
      |void main() {
      | gl_FragColor = vec4( vColor, vAlpha );
      |}
    """.stripMargin

  private val pointsVertexShader =
    """
      |attribute float alpha;
      |attribute vec3 color;
      |varying float vAlpha;
      |varying vec3 vColor;
      |
      |
      |void main() {
      |    vAlpha = alpha;
      |    vColor = color;
      |    vec4 mvPosition = modelViewMatrix * vec4( position, 1.0 );
      |    gl_PointSize = 1.0;
      |    gl_Position = projectionMatrix * mvPosition;
      |}
    """.stripMargin

  private val sm = new ShaderMaterial(js.Dynamic.literal(fragmentShader=pointsShader, vertexShader=pointsVertexShader, transparent=true))

  def pointShader[V,T](data: (V,T)*)(implicit vectorTypeclass: VectorTypeclass[V], n :ColorTypeclass[T]) = {
    //TODO: Need to dispose geometries !!!!
    val geometry = new BufferGeometry()

    val parData = data.toJSArray

    geometry.addAttribute("alpha", new BufferAttribute( new Float32Array(parData.map(x=> n.alpha(x._2))), 1 ) )
    //toColor isn't optimal, change with new r, g, b methods in ColorTypeclass
    geometry.addAttribute("color", new BufferAttribute( new Float32Array(parData.flatMap{ case (_,c) => val xx= n.toColor(c); xx.r :: xx.g :: xx.b :: Nil}), 3 ) )
    geometry.addAttribute("position", new BufferAttribute(new Float32Array(parData.flatMap{ case (v,_) => vectorTypeclass.x(v) :: vectorTypeclass.y(v) :: vectorTypeclass.z(v) :: Nil}) , 3 ))
    //geometry.addAttribute( "size", new BufferAttribute( size, 1 ) )

    val mesh = new Points( geometry, sm)

    mainGroup.add( mesh )
    //mesh
    MetaPoints(mesh, data:_*)
  }
  //#######################  LIGHTS #############################

  def addHemisphereLight[C1, C2](skyColorHex: C1, groundColorHex: C2, intensity: Float)(implicit c1: ColorTypeclass[C1], c2: ColorTypeclass[C2]) = {
    val light = new HemisphereLight(c1.toColor(skyColorHex).getHex(), c2.toColor(groundColorHex).getHex(), intensity)
    mainGroup.add( light )
    light
  }

  def addAmbientLight[C](color: C)(implicit colorTypeclass: ColorTypeclass[C]) = {
    val light = new AmbientLight(colorTypeclass.toColor(color).getHex())
    mainGroup.add( light )
    light
  }

  def addDirectionalLight[V, C](color: C, intensity: Float, position: V)(implicit vectorTypeclass: VectorTypeclass[V], colorTypeclass: ColorTypeclass[C])= {
    val directionalLight = new DirectionalLight(colorTypeclass.toColor(color).getHex(), intensity)
    directionalLight.position.add(vectorTypeclass.toVector(position))
    mainGroup.add(directionalLight)
    directionalLight
  }

  //########################   GROUPING     ########################

  def group(lst: Iterable[Object3D]): Group = {
    val g = new Group()
    //Must be added one by one in order to work, should check JS to understand behaviour
    lst.foreach(g.add)
    //g.children = lst.toJSArray
    mainGroup.add(g)
    g
  }
}
