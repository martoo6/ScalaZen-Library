package main.lib

import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.typedarray.Float32Array
import js.JSConverters._

/**
 * Created by martin on 07/10/15.
 */
trait DrawingUtils extends MathUtils with Converters with Materials with ColorsTypeclasses with PaletteT with WorldCoordinates{
  self:Canvas=>

  def now = System.currentTimeMillis()

  //Should re calculate acording to origin
  def random2D = new Vector3(rand(width), rand(height),0)
  def randomWidth = rand(width)
  def randomHeight = rand(height)

  def vecXYAngle(angle:Double, size:Double=1) = new Vector3(size,0,0).applyAxisAngle(zAxis, angle)

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

  def mspline[LM, W <: Material](vertexes :Iterable[Vector3], divisions:Int = 0, material: LM = defaultLineMaterial)(implicit lineMaterialTypeClass: LineMaterialTypeClass[LM, W]): Line[W] = {
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

  def circle[MM, W <: Material](pos:Vector3, radius:Double, material: MM)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W]): Mesh[W] = {
    val s = radius.mapContrain(0,1920,4,circleGeometries.length).toInt
    val mm = addMeshInPlace(circleGeometries(s), pos, meshMaterialTypeClass.toMeshMaterial(material))
    mm.scale.set(radius,radius,radius)
    mm
  }

  def circle[MM, W <: Material](pos:Vector3, radius:Double, segments:Int, material: MM)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W]): Mesh[W] = {
    //TODO: segments should be the amount. Period. Maybe we should make some system for geometry caching.
    val s = segments.toDouble.mapContrain(2,256,0,circleGeometries.length).toInt
    val mm = addMeshInPlace(circleGeometries(s), pos, meshMaterialTypeClass.toMeshMaterial(material))
    mm.scale.set(radius,radius,radius)
    mm
  }

  //Scala doesn't allow overloading and default parameters yet.
  def circle(pos:Vector3, radius:Double): Mesh[MeshBasicMaterial] = {
    circle(pos, radius, defaultMeshMaterial)
  }

  def circle(pos:Vector3, radius:Double, segments:Int): Mesh[MeshBasicMaterial] = {
    circle(pos, radius, segments, defaultMeshMaterial)
  }

  //########################   Triangle   ############################

  def triangle[MM, W <: Material](pos1:Vector3, pos2:Vector3, pos3:Vector3, material: MM = defaultMeshMaterial)(implicit meshMaterialTypeClass: MeshMaterialTypeClass[MM, W]): Mesh[W] = {
    val geometry = new Geometry()
    geometry.vertices.push(pos1)
    geometry.vertices.push(pos2)
    geometry.vertices.push(pos3)

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

  implicit class RichColor(color: Color){
    def materialize(side:Side = faceSide)  = new MeshBasicMaterial(js.Dynamic.literal(color = color, side= side))
    def materializeL(side:Side = faceSide) = new MeshLambertMaterial(js.Dynamic.literal(color = color, side= side))
    def materializeP(side:Side = faceSide) = new MeshPhongMaterial(js.Dynamic.literal(color = color, side= side))
    def opacity(amount :Double):RGB = RGB(color.r, color.g, color.b, amount)
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
    val material =
      if(defaultLineMaterial.opacity >= 1)
        new PointsMaterial(js.Dynamic.literal(size= 1.0, vertexColors= THREE.VertexColors, depthTest= false, opacity= defaultLineMaterial.opacity, sizeAttenuation= false, transparent= false))
      else
        new PointsMaterial(js.Dynamic.literal(size= 1.0, vertexColors= THREE.VertexColors, depthTest= false, opacity= defaultLineMaterial.opacity, sizeAttenuation= false))

    val mesh = new Points( geometry, material )
    scene.add( mesh )
  }

  //Check for options
  val pMaterial = new PointsMaterial(js.Dynamic.literal(size= 1.0, vertexColors= THREE.VertexColors, depthTest= false, opacity= defaultLineMaterial.opacity, sizeAttenuation= false, transparent= false))

  //TODO: Check if we can replace RGB by some kinf of Color Typeclass, yey !
  def point[T](data: (Vector3,T)*)(implicit n :ColorTypeclass[T]) ={
    val geometry = new Geometry()

    data.foreach{ case (pos,col) =>
      geometry.vertices.push(pos)
      geometry.colors.push(n.toColor(col))
    }

    val mesh = new Points( geometry, pMaterial)
    scene.add( mesh )
    mesh
  }

  case class MetaPoints[T <: Object3D, G <: Material, C](points: Points[T,G], data: (Vector3,C)*)(implicit n :ColorTypeclass[C])

  val pointsShader =
    """
      |varying vec3 vColor;
      |varying float vAlpha;
      |
      |void main() {
      | gl_FragColor = vec4( vColor, vAlpha );
      |}
    """.stripMargin

  val pointsVertexShader =
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

  val sm = new ShaderMaterial(js.Dynamic.literal(fragmentShader=pointsShader, vertexShader=pointsVertexShader, transparent=true))

  def pointShader[T](data: (Vector3,T)*)(implicit n :ColorTypeclass[T]) = {
    //TODO: Need to dispose geometries !!!!
    val geometry = new BufferGeometry()

    geometry.addAttribute("alpha", new BufferAttribute( new Float32Array(data.map(x=> n.alpha(x._2)).toJSArray), 1 ) )
    //toColor isn't optimal, change with new r, g, b methods in ColorTypeclass
    geometry.addAttribute("color", new BufferAttribute( new Float32Array(data.flatMap{x=> val xx= n.toColor(x._2); xx.r :: xx.g :: xx.b :: Nil}.toJSArray), 3 ) )
    geometry.addAttribute("position", new BufferAttribute(new Float32Array(data.flatMap{ case (v,_) => v.x :: v.y :: v.z :: Nil}.toJSArray) , 3 ))
    //geometry.addAttribute( "size", new BufferAttribute( size, 1 ) )

    val mesh = new Points( geometry, sm)

    scene.add( mesh )
    //mesh
    MetaPoints(mesh, data:_*)
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
