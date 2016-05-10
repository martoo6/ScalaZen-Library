package main.lib

import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.typedarray.Float32Array
import js.JSConverters._

/**
 * Created by martin on 07/10/15.
 */
trait DrawingUtils extends MathUtils with Converters with Materials with ColorsTypeclasses with VectorTypeclasses with PaletteT with WorldCoordinates{
  self:Canvas=>

  def now = System.currentTimeMillis()

  //Should re calculate acording to origin
  def random2D = new Vector3(rand(width), rand(height),0)
  def randomWidth = rand(width)
  def randomHeight = rand(height)

  def vecXYAngle(angle:Double, size:Double=1) = new Vector3(size,0,0).applyAxisAngle(zAxis, angle)

  //########################   LINE   ############################

  def line[LM, W <: Material, V1, V2](start: V1, end: V2, material: LM = defaultLineMaterial)(implicit lineMaterialTypeClass: LineMaterialTypeClass[LM, W], v1: VectorTypeclass[V1], v2: VectorTypeclass[V2]): Line[W] = {
    val geometry = new Geometry()
    geometry.vertices.push(v1.toVector(start))
    geometry.vertices.push(v2.toVector(end))
    val l = new Line(geometry, lineMaterialTypeClass.toLineMaterial(material))
    scene.add(l)
    l
  }

  def mline[LM, W <: Material, V](vertexes :Iterable[V], material: LM = defaultLineMaterial)(implicit lineMaterialTypeClass: LineMaterialTypeClass[LM, W], v: VectorTypeclass[V]): Line[W] = {
    val geometry = new Geometry()
    geometry.vertices = vertexes.toJSArray.map(v.toVector)
    val l = new Line(geometry, lineMaterialTypeClass.toLineMaterial(material))
    scene.add(l)
    l
  }

  //########################   SPLINE ############################

  def spline[LM, W <: Material, V1, V2, V3, V4](first: V1, second: V2, third: V3, fourth: V4, material: LM = defaultLineMaterial)(implicit lineMaterialTypeClass: LineMaterialTypeClass[LM, W], v1: VectorTypeclass[V1], v2: VectorTypeclass[V2], v3: VectorTypeclass[V3], v4: VectorTypeclass[V4]): Line[W] = {
    val curve = new SplineCurve3(js.Array(v1.toVector(first), v2.toVector(second), v3.toVector(third), v4.toVector(fourth)))
    val geometry = new Geometry()
    //TODO: look at divisions, what the heck ?
    geometry.vertices = curve.getPoints(500)
    //Create the final Object3d to add to the scene
    val splineObject = new Line(geometry, lineMaterialTypeClass.toLineMaterial(material))
    scene.add(splineObject)
    splineObject
  }

  def mspline[LM, W <: Material, V](vertexes :Iterable[V], divisions:Int = 0, material: LM = defaultLineMaterial)(implicit lineMaterialTypeClass: LineMaterialTypeClass[LM, W], vectorTypeclass: VectorTypeclass[V]): Line[W] = {
    val curve = new SplineCurve3(vertexes.toJSArray.map(vectorTypeclass.toVector))
    val geometry = new Geometry()
    //TODO: look at divisions, what the heck ?
    geometry.vertices = curve.getPoints(if(divisions<=0) vertexes.size else divisions)
    //Create the final Object3d to add to the scene
    val splineObject = new Line(geometry, lineMaterialTypeClass.toLineMaterial(material))
    scene.add(splineObject)
    splineObject
  }
  //########################   RECT   ############################

  private val planeGeometry =   new PlaneGeometry(1, 1)

  def rect[MM, W <: Material, V](pos: V, _width:Double, _height:Double, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val mesh = addMeshInPlace(planeGeometry, RectMode.rectMode(vectorTypeclass.toVector(pos), (_width, _height)), meshMaterialTypeClass.toMeshMaterial(material))
    mesh.scale.set(_width, _height, 1)
    mesh
  }

  def square[MM, W <: Material, V](pos: V, _width:Double, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val mesh = addMeshInPlace(planeGeometry, RectMode.rectMode(vectorTypeclass.toVector(pos), (_width, _width)), meshMaterialTypeClass.toMeshMaterial(material))
    mesh.scale.set(_width, _width, 1)
    mesh
  }

  def rectXZ[MM, W <: Material, V](pos: V, _width:Double, _height:Double, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val mesh = addMeshInPlace(planeGeometry, RectMode.rectMode(vectorTypeclass.toVector(pos), (_width, _height)), meshMaterialTypeClass.toMeshMaterial(material))
    mesh.scale.set(_width, _height, 1)
    mesh.rotateX(HALF_PI)
    mesh
  }

  def squareXZ[MM, W <: Material, V](pos: V, _width:Double, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
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

  def circle[MM, W <: Material, V](pos:V, radius:Double, material: MM)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val s = radius.mapContrain(0,1920,4,circleGeometries.length).toInt
    val mm = addMeshInPlace(circleGeometries(s), vectorTypeclass.toVector(pos), meshMaterialTypeClass.toMeshMaterial(material))
    mm.scale.set(radius,radius,radius)
    mm
  }

  def circle[MM, W <: Material, V](pos:V, radius:Double, segments:Int, material: MM)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    //TODO: segments should be the amount. Period. Maybe we should make some system for geometry caching.
    val s = segments.toDouble.mapContrain(2,256,0,circleGeometries.length).toInt
    val mm = addMeshInPlace(circleGeometries(s), vectorTypeclass.toVector(pos), meshMaterialTypeClass.toMeshMaterial(material))
    mm.scale.set(radius,radius,radius)
    mm
  }

  //Scala doesn't allow overloading and default parameters yet.
  def circle[V](pos:V, radius:Double)(implicit vectorTypeclass: VectorTypeclass[V]): Mesh[MeshBasicMaterial] = {
    circle(vectorTypeclass.toVector(pos), radius, defaultMeshMaterial)
  }

  def circle[V](pos:V, radius:Double, segments:Int)(implicit vectorTypeclass: VectorTypeclass[V]): Mesh[MeshBasicMaterial] = {
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
    def materialize(side:Side = faceSide)  = new MeshBasicMaterial(js.Dynamic.literal(color = n.toColor(color), side= side))
    def materializeL(side:Side = faceSide) = new MeshLambertMaterial(js.Dynamic.literal(color = n.toColor(color), side= side))
    def materializeP(side:Side = faceSide) = new MeshPhongMaterial(js.Dynamic.literal(color = n.toColor(color), side= side))
    def alpha(amount :Double):RGB = RGB(n.r(color), n.g(color), n.b(color), amount)
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

  def stroke[T](color: T, lineWidth:Double = 1)(implicit n: ColorTypeclass[T]) = {
    defaultLineMaterial = new LineBasicMaterial(js.Dynamic.literal(color = n.toColor(color), side= faceSide, linewidth = lineWidth))
  }

  //Should check default attributes for world (3D, 2D)

  //#######################  CUBE #############################

  private val boxGeometry = new BoxGeometry(1, 1, 1)

  def cube[MM, W <: Material, V](pos: V, width:Double, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val m = addMeshInPlace(boxGeometry, vectorTypeclass.toVector(pos), meshMaterialTypeClass.toMeshMaterial(material))
    m.scale.set(width,width,width)
    m
  }

  def hyperrectangle[MM, W <: Material, V](pos: V, width:Double, height:Double, deep:Double, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val m = addMeshInPlace(boxGeometry, vectorTypeclass.toVector(pos), meshMaterialTypeClass.toMeshMaterial(material))
    m.scale.set(width, height, deep)
    m
  }

  //#######################  SPHERE #############################

  //Create several geometries depending on size of sphere or create on demand
  private val sphereGeometries =  (1 to 8).map(x=> new SphereGeometry(1, Math.pow(2,x), Math.pow(2,x))).toArray

  def sphere[MM, W <: Material, V](pos: V, radius:Double, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val s = radius.mapContrain(0,1920,4,sphereGeometries.length).toInt
    val m = addMeshInPlace(sphereGeometries(s), vectorTypeclass.toVector(pos), meshMaterialTypeClass.toMeshMaterial(material))
    m.scale.set(radius,radius,radius)
    m
  }

  def segSphere[MM, W <: Material, V](pos: V, radius:Double, segments: Int, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W], vectorTypeclass: VectorTypeclass[V]): Mesh[W] = {
    val s = segments.toDouble.mapContrain(2,256,0,sphereGeometries.length).toInt
    val m = addMeshInPlace(sphereGeometries(s), vectorTypeclass.toVector(pos), meshMaterialTypeClass.toMeshMaterial(material))
    m.scale.set(radius,radius,radius)
    m
  }

  def addMeshInPlace[MT <: Material, G <: Geometry](geometry: G, pos:Vector3, material:MT): Mesh[MT] = {
    val mesh = new Mesh(geometry, material)
    mesh.position.add(pos)
    scene.add(mesh)
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
    scene.add( mesh )
  }

  //Check for options
  private val pMaterial = new PointsMaterial(js.Dynamic.literal(size= 1.0, vertexColors= THREE.VertexColors, depthTest= false, opacity= defaultLineMaterial.opacity, sizeAttenuation= false, transparent= false))

  //TODO: Check if we can replace RGB by some kinf of Color Typeclass, yey !
  def point[T, V](data: (V,T)*)(implicit vectorTypeclass: VectorTypeclass[V], n :ColorTypeclass[T]) ={
    val geometry = new Geometry()

    data.foreach{ case (pos,col) =>
      geometry.vertices.push(vectorTypeclass.toVector(pos))
      geometry.colors.push(n.toColor(col))
    }

    val mesh = new Points( geometry, pMaterial)
    scene.add( mesh )
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

    scene.add( mesh )
    //mesh
    MetaPoints(mesh, data:_*)
  }
  //#######################  LIGHTS #############################

  def addHemisphereLight[C1, C2](skyColorHex: C1, groundColorHex: C2, intensity: Double)(implicit c1: ColorTypeclass[C1], c2: ColorTypeclass[C2]) = {
    val light = new HemisphereLight(c1.toColor(skyColorHex).getHex(), c2.toColor(groundColorHex).getHex(), intensity)
    scene.add( light )
    light
  }

  def addAmbientLight[C](color: C)(implicit colorTypeclass: ColorTypeclass[C]) = {
    val light = new AmbientLight(colorTypeclass.toColor(color).getHex())
    scene.add( light )
    light
  }

  def addDirectionalLight[V, C](color: C, intensity: Double, position: V)(implicit vectorTypeclass: VectorTypeclass[V], colorTypeclass: ColorTypeclass[C])= {
    val directionalLight = new DirectionalLight(colorTypeclass.toColor(color).getHex(), intensity)
    directionalLight.position.add(vectorTypeclass.toVector(position))
    scene.add(directionalLight)
    directionalLight
  }

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
