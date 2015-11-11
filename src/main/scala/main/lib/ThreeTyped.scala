package main.lib

import org.scalajs.dom.raw._

import scala.scalajs.js
import scala.scalajs.js.annotation.{ScalaJSDefined, JSBracketAccess, JSName}
import scala.scalajs.js.typedarray.Float32Array

//package object ThreeTyped{

  //@JSName("importedjs")
  package object importedjs extends js.GlobalScope {
    var Detector: DetectorStatic = js.native
  }

  @js.native
  @JSName("THREE")
  object THREE extends js.Object {
    var CopyShader: Shader[_] = js.native
    var REVISION: String = js.native
    var CullFaceNone: CullFace = js.native
    var CullFaceBack: CullFace = js.native
    var CullFaceFront: CullFace = js.native
    var CullFaceFrontBack: CullFace = js.native
    var FrontFaceDirectionCW: FrontFaceDirection = js.native
    var FrontFaceDirectionCCW: FrontFaceDirection = js.native
    var BasicShadowMap: ShadowMapType = js.native
    var PCFShadowMap: ShadowMapType = js.native
    var PCFSoftShadowMap: ShadowMapType = js.native
    var FrontSide: Side = js.native
    var BackSide: Side = js.native
    var DoubleSide: Side = js.native
    var NoShading: Shading = js.native
    var FlatShading: Shading = js.native
    var SmoothShading: Shading = js.native
    var NoColors: Colors = js.native
    var FaceColors: Colors = js.native
    var VertexColors: Colors = js.native
    var NoBlending: Blending = js.native
    var NormalBlending: Blending = js.native
    var AdditiveBlending: Blending = js.native
    var SubtractiveBlending: Blending = js.native
    var MultiplyBlending: Blending = js.native
    var CustomBlending: Blending = js.native
    var AddEquation: BlendingEquation = js.native
    var SubtractEquation: BlendingEquation = js.native
    var ReverseSubtractEquation: BlendingEquation = js.native
    var MinEquation: BlendingEquation = js.native
    var MaxEquation: BlendingEquation = js.native
    var ZeroFactor: BlendingDstFactor = js.native
    var OneFactor: BlendingDstFactor = js.native
    var SrcColorFactor: BlendingDstFactor = js.native
    var OneMinusSrcColorFactor: BlendingDstFactor = js.native
    var SrcAlphaFactor: BlendingDstFactor = js.native
    var OneMinusSrcAlphaFactor: BlendingDstFactor = js.native
    var DstAlphaFactor: BlendingDstFactor = js.native
    var OneMinusDstAlphaFactor: BlendingDstFactor = js.native
    var DstColorFactor: BlendingSrcFactor = js.native
    var OneMinusDstColorFactor: BlendingSrcFactor = js.native
    var SrcAlphaSaturateFactor: BlendingSrcFactor = js.native
    var MultiplyOperation: Combine = js.native
    var MixOperation: Combine = js.native
    var AddOperation: Combine = js.native
    var UVMapping: Mapping = js.native
    var CubeReflectionMapping: Mapping = js.native
    var CubeRefractionMapping: Mapping = js.native
    var EquirectangularReflectionMapping: Mapping = js.native
    var EquirectangularRefractionMapping: Mapping = js.native
    var SphericalReflectionMapping: Mapping = js.native
    var RepeatWrapping: Wrapping = js.native
    var ClampToEdgeWrapping: Wrapping = js.native
    var MirroredRepeatWrapping: Wrapping = js.native
    var NearestFilter: TextureFilter = js.native
    var NearestMipMapNearestFilter: TextureFilter = js.native
    var NearestMipMapLinearFilter: TextureFilter = js.native
    var LinearFilter: TextureFilter = js.native
    var LinearMipMapNearestFilter: TextureFilter = js.native
    var LinearMipMapLinearFilter: TextureFilter = js.native
    var UnsignedByteType: TextureDataType = js.native
    var ByteType: TextureDataType = js.native
    var ShortType: TextureDataType = js.native
    var UnsignedShortType: TextureDataType = js.native
    var IntType: TextureDataType = js.native
    var UnsignedIntType: TextureDataType = js.native
    var FloatType: TextureDataType = js.native
    var HalfFloatType: TextureDataType = js.native
    var UnsignedShort4444Type: PixelType = js.native
    var UnsignedShort5551Type: PixelType = js.native
    var UnsignedShort565Type: PixelType = js.native
    var AlphaFormat: PixelFormat = js.native
    var RGBFormat: PixelFormat = js.native
    var RGBAFormat: PixelFormat = js.native
    var LuminanceFormat: PixelFormat = js.native
    var LuminanceAlphaFormat: PixelFormat = js.native
    var RGBEFormat: PixelFormat = js.native
    var RGB_S3TC_DXT1_Format: CompressedPixelFormat = js.native
    var RGBA_S3TC_DXT1_Format: CompressedPixelFormat = js.native
    var RGBA_S3TC_DXT3_Format: CompressedPixelFormat = js.native
    var RGBA_S3TC_DXT5_Format: CompressedPixelFormat = js.native
    var RGB_PVRTC_4BPPV1_Format: CompressedPixelFormat = js.native
    var RGB_PVRTC_2BPPV1_Format: CompressedPixelFormat = js.native
    var RGBA_PVRTC_4BPPV1_Format: CompressedPixelFormat = js.native
    var RGBA_PVRTC_2BPPV1_Format: CompressedPixelFormat = js.native
    //TODO: VER Q ONDA !
    //  def warn(message: js.Any = ???, optionalParams: js.Any*): Unit = js.native
    //  def error(message: js.Any = ???, optionalParams: js.Any*): Unit = js.native
    //  def log(message: js.Any = ???, optionalParams: js.Any*): Unit = js.native
    var Cache: Cache = js.native
    var Math: Math = js.native
    var LineStrip: LineMode = js.native
    var LinePieces: LineMode = js.native
    var ShaderChunk: ShaderChunk = js.native
    var WebGLState: WebGLStateStatic = js.native
    var WebGLTextures: WebGLTexturesStatic = js.native
  }

  @js.native
  trait WebGLRenderingContext extends js.Object {
  }

  @js.native
  trait DetectorStatic extends js.Object {
    var canvas: Boolean = js.native
    var webgl: Boolean = js.native
    var workers: Boolean = js.native
    var fileapi: Boolean = js.native
    def getWebGLErrorMessage(): HTMLElement = js.native
    def addGetWebGLMessage(parameters: js.Any = ???): Unit = js.native
  }

  @js.native
  @JSName("THREE.RenderPass")
  class RenderPass extends js.Object {
    def this(scene: Scene, camera: Camera, overrideMaterial: Material = ???, clearColor: Color = ???, clearAlpha: Double = ???) = this()
    var scene: Scene = js.native
    var camera: Camera = js.native
    var overrideMaterial: Material = js.native
    var clearColor: js.Any = js.native
    var clearAlpha: Double = js.native
    var oldClearColor: Color = js.native
    var oldClearAlpha: Double = js.native
    var enabled: Boolean = js.native
    var clear: Boolean = js.native
    var needsSwap: Boolean = js.native
    def render(renderer: WebGLRenderer, writeBuffer: WebGLRenderTarget, readBuffer: WebGLRenderTarget, delta: Double): Unit = js.native
  }

  @js.native
  @JSName("THREE.TransformControls")
  class TransformControls extends Object3D {
    def this(`object`: Camera, domElement: HTMLElement = ???) = this()
    var `object`: Object3D = js.native
    def update(): Unit = js.native
    def detach(`object`: Object3D): Unit = js.native
    def attach(`object`: Object3D): Unit = js.native
    def setMode(mode: String): Unit = js.native
    def setSnap(snap: js.Any): Unit = js.native
    def setSize(size: Double): Unit = js.native
    def setSpace(space: String): Unit = js.native
  }

  @js.native
  @JSName("THREE.ShaderPass")
  class ShaderPass[T] extends js.Object {
    def this(shader: Shader[T], textureID: String = ???) = this()
    var textureID: String = js.native
    var uniforms: T = js.native
    var material: ShaderMaterial = js.native
    var renderToScreen: Boolean = js.native
    var enabled: Boolean = js.native
    var needsSwap: Boolean = js.native
    var clear: Boolean = js.native
    var camera: Camera = js.native
    var scene: Scene = js.native
    var quad: Mesh[_] = js.native
    def render(renderer: WebGLRenderer, writeBuffer: WebGLRenderTarget, readBuffer: WebGLRenderTarget, delta: Double): Unit = js.native
  }

  @js.native
  @JSName("THREE.EffectComposer")
  class EffectComposer extends js.Object {
    def this(renderer: WebGLRenderer, renderTarget: WebGLRenderTarget = ???) = this()
    var renderTarget1: WebGLRenderTarget = js.native
    var renderTarget2: WebGLRenderTarget = js.native
    var writeBuffer: WebGLRenderTarget = js.native
    var readBuffer: WebGLRenderTarget = js.native
    var passes: js.Array[js.Any] = js.native
    var copyPass: ShaderPass[_] = js.native
    def swapBuffers(): Unit = js.native
    def addPass(pass: js.Any): Unit = js.native
    def insertPass(pass: js.Any, index: Double): Unit = js.native
    def render(delta: Double = ???): Unit = js.native
    def reset(renderTarget: WebGLRenderTarget = ???): Unit = js.native
    def setSize(width: Double, height: Double): Unit = js.native
  }

  @js.native
  @JSName("THREE.TrackballControls")
  class TrackballControls extends EventDispatcher {
    def this(`object`: Camera, domElement: HTMLElement = ???) = this()
    var `object`: Camera = js.native
    var domElement: HTMLElement = js.native
    var enabled: Boolean = js.native
    var screen: js.Any = js.native
    var rotateSpeed: Double = js.native
    var zoomSpeed: Double = js.native
    var panSpeed: Double = js.native
    var noRotate: Boolean = js.native
    var noZoom: Boolean = js.native
    var noPan: Boolean = js.native
    var noRoll: Boolean = js.native
    var staticMoving: Boolean = js.native
    var dynamicDampingFactor: Double = js.native
    var minDistance: Double = js.native
    var maxDistance: Double = js.native
    var keys: js.Array[Double] = js.native
    var position0: Vector3 = js.native
    var target0: Vector3 = js.native
    var up0: Vector3 = js.native
    def update(): Unit = js.native
    def reset(): Unit = js.native
    def checkDistances(): Unit = js.native
    def zoomCamera(): Unit = js.native
    def panCamera(): Unit = js.native
    def rotateCamera(): Unit = js.native
    def handleResize(): Unit = js.native
    def handleEvent(event: js.Any): Unit = js.native
  }

  @js.native
  sealed trait MOUSE extends js.Object {
  }

  @js.native
  @JSName("THREE.MOUSE")
  object MOUSE extends js.Object {
    var LEFT: MOUSE = js.native
    var MIDDLE: MOUSE = js.native
    var RIGHT: MOUSE = js.native
    @JSBracketAccess
    def apply(value: MOUSE): String = js.native
  }

  @js.native
  sealed trait CullFace extends js.Object {
  }

  @js.native
  @JSName("THREE.CullFace")
  object CullFace extends js.Object {
    @JSBracketAccess
    def apply(value: CullFace): String = js.native
  }

  @js.native
  sealed trait FrontFaceDirection extends js.Object {
  }

  @js.native
  @JSName("THREE.FrontFaceDirection")
  object FrontFaceDirection extends js.Object {
    @JSBracketAccess
    def apply(value: FrontFaceDirection): String = js.native
  }

  @js.native
  sealed trait ShadowMapType extends js.Object {
  }

  @js.native
  @JSName("THREE.ShadowMapType")
  object ShadowMapType extends js.Object {
    @JSBracketAccess
    def apply(value: ShadowMapType): String = js.native
  }

  @js.native
  sealed trait Side extends js.Object {
  }

  @js.native
  @JSName("THREE.Side")
  object Side extends js.Object {
    @JSBracketAccess
    def apply(value: Side): String = js.native
  }

  @js.native
  sealed trait Shading extends js.Object {
  }

  @js.native
  @JSName("THREE.Shading")
  object Shading extends js.Object {
    @JSBracketAccess
    def apply(value: Shading): String = js.native
  }

  @js.native
  sealed trait Colors extends js.Object {
  }

  @js.native
  @JSName("THREE.Colors")
  object Colors extends js.Object {
    @JSBracketAccess
    def apply(value: Colors): String = js.native
  }

  @js.native
  sealed trait Blending extends js.Object {
  }

  @js.native
  @JSName("THREE.Blending")
  object Blending extends js.Object {
    @JSBracketAccess
    def apply(value: Blending): String = js.native
  }

  @js.native
  sealed trait BlendingEquation extends js.Object {
  }

  @js.native
  @JSName("THREE.BlendingEquation")
  object BlendingEquation extends js.Object {
    @JSBracketAccess
    def apply(value: BlendingEquation): String = js.native
  }

  @js.native
  sealed trait BlendingDstFactor extends js.Object {
  }

  @js.native
  @JSName("THREE.BlendingDstFactor")
  object BlendingDstFactor extends js.Object {
    @JSBracketAccess
    def apply(value: BlendingDstFactor): String = js.native
  }

  @js.native
  sealed trait BlendingSrcFactor extends js.Object {
  }

  @js.native
  @JSName("THREE.BlendingSrcFactor")
  object BlendingSrcFactor extends js.Object {
    @JSBracketAccess
    def apply(value: BlendingSrcFactor): String = js.native
  }

  @js.native
  sealed trait Combine extends js.Object {
  }

  @js.native
  @JSName("THREE.Combine")
  object Combine extends js.Object {
    @JSBracketAccess
    def apply(value: Combine): String = js.native
  }

  @js.native
  sealed trait Mapping extends js.Object {
  }

  @js.native
  @JSName("THREE.Mapping")
  object Mapping extends js.Object {
    @JSBracketAccess
    def apply(value: Mapping): String = js.native
  }

  @js.native
  sealed trait Wrapping extends js.Object {
  }

  @js.native
  @JSName("THREE.Wrapping")
  object Wrapping extends js.Object {
    @JSBracketAccess
    def apply(value: Wrapping): String = js.native
  }

  @js.native
  sealed trait TextureFilter extends js.Object {
  }

  @js.native
  @JSName("THREE.TextureFilter")
  object TextureFilter extends js.Object {
    @JSBracketAccess
    def apply(value: TextureFilter): String = js.native
  }

  @js.native
  sealed trait TextureDataType extends js.Object {
  }

  @js.native
  @JSName("THREE.TextureDataType")
  object TextureDataType extends js.Object {
    @JSBracketAccess
    def apply(value: TextureDataType): String = js.native
  }

  @js.native
  sealed trait PixelType extends js.Object {
  }

  @js.native
  @JSName("THREE.PixelType")
  object PixelType extends js.Object {
    @JSBracketAccess
    def apply(value: PixelType): String = js.native
  }

  @js.native
  sealed trait PixelFormat extends js.Object {
  }

  @js.native
  @JSName("THREE.PixelFormat")
  object PixelFormat extends js.Object {
    @JSBracketAccess
    def apply(value: PixelFormat): String = js.native
  }

  @js.native
  sealed trait CompressedPixelFormat extends js.Object {
  }

  @js.native
  @JSName("THREE.CompressedPixelFormat")
  object CompressedPixelFormat extends js.Object {
    @JSBracketAccess
    def apply(value: CompressedPixelFormat): String = js.native
  }

  @js.native
  @JSName("THREE.Camera")
  trait Camera extends Object3D{
    var matrixWorldInverse: Matrix4 = js.native
    var projectionMatrix: Matrix4 = js.native
  }


  @js.native
  @JSName("THREE.CubeCamera")
  class CubeCamera extends Object3D {
    def this(near: Double = ???, far: Double = ???, cubeResolution: Double = ???) = this()
    var renderTarget: WebGLRenderTargetCube = js.native
    def updateCubeMap(renderer: Renderer, scene: Scene): Unit = js.native
  }

  @js.native
  @JSName("THREE.OrthographicCamera")
  class OrthographicCamera extends Camera {
    def this(left: Double, right: Double, top: Double, bottom: Double, near: Double = ???, far: Double = ???) = this()
    var zoom: Double = js.native
    var left: Double = js.native
    var right: Double = js.native
    var top: Double = js.native
    var bottom: Double = js.native
    var near: Double = js.native
    var far: Double = js.native
    def updateProjectionMatrix(): Unit = js.native
  }

  @js.native
  @JSName("THREE.PerspectiveCamera")
  class PerspectiveCamera extends Camera {
    def this(fov: Double = ???, aspect: Double = ???, near: Double = ???, far: Double = ???) = this()
    var zoom: Double = js.native
    var fov: Double = js.native
    var aspect: Double = js.native
    var near: Double = js.native
    var far: Double = js.native
    def setLens(focalLength: Double, frameHeight: Double = ???): Unit = js.native
    def setViewOffset(fullWidth: Double, fullHeight: Double, x: Double, y: Double, width: Double, height: Double): Unit = js.native
    def updateProjectionMatrix(): Unit = js.native
  }

  @js.native
  @JSName("THREE.BufferAttribute")
  class BufferAttribute extends js.Object {
    def this(array: js.Any, itemSize: Double) = this()
    var array: js.Array[Double] = js.native
    var itemSize: Double = js.native
    var needsUpdate: Boolean = js.native
    var length: Double = js.native
    def copyAt(index1: Double, attribute: BufferAttribute, index2: Double): Unit = js.native
    def set(value: Double, offset: Double = ???): BufferAttribute = js.native
    def setX(index: Double, x: Double): BufferAttribute = js.native
    def setY(index: Double, y: Double): BufferAttribute = js.native
    def setZ(index: Double, z: Double): BufferAttribute = js.native
    def setXY(index: Double, x: Double, y: Double): BufferAttribute = js.native
    def setXYZ(index: Double, x: Double, y: Double, z: Double): BufferAttribute = js.native
    def setXYZW(index: Double, x: Double, y: Double, z: Double, w: Double): BufferAttribute = js.native
  }

  @js.native
  @JSName("THREE.Int8Attribute")
  class Int8Attribute extends BufferAttribute {
    def this(data: js.Any, itemSize: Double) = this()
  }

  @js.native
  @JSName("THREE.Uint8Attribute")
  class Uint8Attribute extends BufferAttribute {
    def this(data: js.Any, itemSize: Double) = this()
  }

  @js.native
  @JSName("THREE.Uint8ClampedAttribute")
  class Uint8ClampedAttribute extends BufferAttribute {
    def this(data: js.Any, itemSize: Double) = this()
  }

  @js.native
  @JSName("THREE.Int16Attribute")
  class Int16Attribute extends BufferAttribute {
    def this(data: js.Any, itemSize: Double) = this()
  }

  @js.native
  @JSName("THREE.Uint16Attribute")
  class Uint16Attribute extends BufferAttribute {
    def this(data: js.Any, itemSize: Double) = this()
  }

  @js.native
  @JSName("THREE.Int32Attribute")
  class Int32Attribute extends BufferAttribute {
    def this(data: js.Any, itemSize: Double) = this()
  }

  @js.native
  @JSName("THREE.Uint32Attribute")
  class Uint32Attribute extends BufferAttribute {
    def this(data: js.Any, itemSize: Double) = this()
  }

  @js.native
  @JSName("THREE.Float32Attribute")
  class Float32Attribute extends BufferAttribute {
    def this(data: js.Any, itemSize: Double) = this()
  }

  @js.native
  @JSName("THREE.Float64Attribute")
  class Float64Attribute extends BufferAttribute {
    def this(data: js.Any, itemSize: Double) = this()
  }




  @js.native
  @JSName("THREE.BufferGeometry")
  class BufferGeometry extends Object3D {
//    var id: Double = js.native
//    var uuid: String = js.native
//    var name: String = js.native
//    var `type`: String = js.native
    var attributes: js.Array[BufferAttribute] = js.native
    var attributesKeys: js.Array[String] = js.native
    var drawcalls: js.Array[js.Any] = js.native
    var offsets: js.Array[js.Any] = js.native
    var boundingBox: Box3 = js.native
    var boundingSphere: BoundingSphere = js.native
    def addAttribute(name: String, attribute: BufferAttribute): js.Dynamic = js.native
    def addAttribute(name: String, array: js.Any, itemSize: Double): js.Dynamic = js.native
    def getAttribute(name: String): js.Dynamic = js.native
    def addDrawCall(start: Double, count: Double, index: Double): Unit = js.native
//    def applyMatrix(matrix: Matrix4): Unit = js.native
    def center(): Vector3 = js.native
    def fromGeometry(geometry: Geometry, settings: js.Any = ???): BufferGeometry = js.native
    def computeBoundingBox(): Unit = js.native
    def computeBoundingSphere(): Unit = js.native
    def computeFaceNormals(): Unit = js.native
    def computeVertexNormals(): Unit = js.native
    def computeTangents(): Unit = js.native
    def computeOffsets(size: Double): Unit = js.native
    def merge(geometry: BufferGeometry, offset: Double): BufferGeometry = js.native
    def normalizeNormals(): Unit = js.native
    def reorderBuffers(indexBuffer: Double, indexMap: js.Array[Double], vertexCount: Double): Unit = js.native
//    def toJSON(): js.Dynamic = js.native
    def dispose(): Unit = js.native
//    def addEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
//    def hasEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
//    def removeEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
//    def dispatchEvent(event: js.Any): Unit = js.native
  }

  @js.native
  @JSName("THREE.Clock")
  class Clock extends js.Object {
    def this(autoStart: Boolean = ???) = this()
    var autoStart: Boolean = js.native
    var startTime: Double = js.native
    var oldTime: Double = js.native
    var elapsedTime: Double = js.native
    var running: Boolean = js.native
    def start(): Unit = js.native
    def stop(): Unit = js.native
    def getElapsedTime(): Double = js.native
    def getDelta(): Double = js.native
  }

  @js.native
  @JSName("THREE.DynamicBufferAttribute")
  class DynamicBufferAttribute extends BufferAttribute {
    def this(array: js.Any, itemSize: Double) = this()
    var updateRange: js.Any = js.native
  }

  @js.native
  @JSName("THREE.EventDispatcher")
  class EventDispatcher extends js.Object {
    def addEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def hasEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def removeEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def dispatchEvent(event: js.Any): Unit = js.native
  }

  @js.native
  @JSName("THREE.Face3")
  class Face3 extends js.Object {
    def this(a: Double, b: Double, c: Double, normal: Vector3 = ???, color: Color = ???, materialIndex: Double = ???) = this()
    //TODO: Por ahora uno solo.
//    def this(a: Double, b: Double, c: Double, normal: Vector3 = ???, vertexColors: js.Array[Color] = ???, materialIndex: Double = ???) = this()
//    def this(a: Double, b: Double, c: Double, vertexNormals: js.Array[Vector3] = ???, color: Color = ???, materialIndex: Double = ???) = this()
//    def this(a: Double, b: Double, c: Double, vertexNormals: js.Array[Vector3] = ???, vertexColors: js.Array[Color] = ???, materialIndex: Double = ???) = this()
    var a: Double = js.native
    var b: Double = js.native
    var c: Double = js.native
    var normal: Vector3 = js.native
    var vertexNormals: js.Array[Vector3] = js.native
    var color: Color = js.native
    var vertexColors: js.Array[Color] = js.native
    var vertexTangents: js.Array[Double] = js.native
    var materialIndex: Double = js.native
  }

  @js.native
  trait MorphTarget extends js.Object {
    var name: String = js.native
    var vertices: js.Array[Vector3] = js.native
  }

  @js.native
  trait MorphColor extends js.Object {
    var name: String = js.native
    var colors: js.Array[Color] = js.native
  }

  @js.native
  trait MorphNormals extends js.Object {
    var name: String = js.native
    var normals: js.Array[Vector3] = js.native
  }

  @js.native
  trait BoundingSphere extends js.Object {
    var radius: Double = js.native
  }

  @js.native
  @JSName("THREE.Object3D")
  class Object3D extends js.Object {
    var id: Double = js.native
    var uuid: String = js.native
    var name: String = js.native
    var `type`: String = js.native
    var parent: Object3D = js.native
    var children: js.Array[Object3D] = js.native
    var up: Vector3 = js.native
    var position: Vector3 = js.native
    var rotation: Euler = js.native
    var quaternion: Quaternion = js.native
    var scale: Vector3 = js.native
    var rotationAutoUpdate: Boolean = js.native
    var matrix: Matrix4 = js.native
    var matrixWorld: Matrix4 = js.native
    var matrixAutoUpdate: Boolean = js.native
    var matrixWorldNeedsUpdate: Boolean = js.native
    var visible: Boolean = js.native
    var castShadow: Boolean = js.native
    var receiveShadow: Boolean = js.native
    var frustumCulled: Boolean = js.native
    var renderOrder: Double = js.native
    var userData: js.Any = js.native
    var eulerOrder: String = js.native
    def applyMatrix(matrix: Matrix4): Unit = js.native
    def setRotationFromAxisAngle(axis: Vector3, angle: Double): Unit = js.native
    def setRotationFromEuler(euler: Euler): Unit = js.native
    def setRotationFromMatrix(m: Matrix4): Unit = js.native
    def setRotationFromQuaternion(q: Quaternion): Unit = js.native
    def rotateOnAxis(axis: Vector3, angle: Double): Object3D = js.native
    def rotateX(angle: Double): Object3D = js.native
    def rotateY(angle: Double): Object3D = js.native
    def rotateZ(angle: Double): Object3D = js.native
    def translateOnAxis(axis: Vector3, distance: Double): Object3D = js.native
    def translate(distance: Double, axis: Vector3): Object3D = js.native
    def translateX(distance: Double): Object3D = js.native
    def translateY(distance: Double): Object3D = js.native
    def translateZ(distance: Double): Object3D = js.native
    def localToWorld(vector: Vector3): Vector3 = js.native
    def worldToLocal(vector: Vector3): Vector3 = js.native
    def lookAt(vector: Vector3): Unit = js.native
    def add(`object`: Object3D): Unit = js.native
    def remove(`object`: Object3D): Unit = js.native
    def getChildByName(name: String): Object3D = js.native
    def getObjectById(id: String): Object3D = js.native
    def getObjectByName(name: String): Object3D = js.native
    def getObjectByProperty(name: String, value: String): Object3D = js.native
    def getWorldPosition(optionalTarget: Vector3 = ???): Vector3 = js.native
    def getWorldQuaternion(optionalTarget: Quaternion = ???): Quaternion = js.native
    def getWorldRotation(optionalTarget: Euler = ???): Euler = js.native
    def getWorldScale(optionalTarget: Vector3 = ???): Vector3 = js.native
    def getWorldDirection(optionalTarget: Vector3 = ???): Vector3 = js.native
    def traverse(callback: js.Function1[Object3D, Any]): Unit = js.native
    def traverseVisible(callback: js.Function1[Object3D, Any]): Unit = js.native
    def traverseAncestors(callback: js.Function1[Object3D, Any]): Unit = js.native
    def updateMatrix(): Unit = js.native
    def updateMatrixWorld(force: Boolean): Unit = js.native
    def toJSON(): js.Dynamic = js.native
    def clone(`object`: Object3D = ???, recursive: Boolean = ???): Object3D = js.native
    def addEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def hasEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def removeEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def dispatchEvent(event: js.Any): Unit = js.native
  }

@js.native
@JSName("THREE.Geometry")
class Geometry extends Object3D {
//  var id: Double = js.native
//  var uuid: String = js.native
//  var name: String = js.native
//  var `type`: String = js.native
  var vertices: js.Array[Vector3] = js.native
  var colors: js.Array[Color] = js.native
  var faces: js.Array[Face3] = js.native
  var faceVertexUvs: js.Array[js.Array[js.Array[Vector2]]] = js.native
  var morphTargets: js.Array[MorphTarget] = js.native
  var morphColors: js.Array[MorphColor] = js.native
  var morphNormals: js.Array[MorphNormals] = js.native
  var skinWeights: js.Array[Double] = js.native
  var skinIndices: js.Array[Double] = js.native
  var lineDistances: js.Array[Double] = js.native
  var boundingBox: Box3 = js.native
  var boundingSphere: BoundingSphere = js.native
  var hasTangents: Boolean = js.native
  var dynamic: Boolean = js.native
  var verticesNeedUpdate: Boolean = js.native
  var elementsNeedUpdate: Boolean = js.native
  var uvsNeedUpdate: Boolean = js.native
  var normalsNeedUpdate: Boolean = js.native
  var tangentsNeedUpdate: Boolean = js.native
  var colorsNeedUpdate: Boolean = js.native
  var lineDistancesNeedUpdate: Boolean = js.native
  var groupsNeedUpdate: Boolean = js.native
//  def applyMatrix(matrix: Matrix4): Unit = js.native
  def fromBufferGeometry(geometry: BufferGeometry): Geometry = js.native
  def center(): Vector3 = js.native
  def computeFaceNormals(): Unit = js.native
  def computeVertexNormals(areaWeighted: Boolean = ???): Unit = js.native
  def computeMorphNormals(): Unit = js.native
  def computeTangents(): Unit = js.native
  def computeLineDistances(): Unit = js.native
  def computeBoundingBox(): Unit = js.native
  def computeBoundingSphere(): Unit = js.native
  def merge(geometry: Geometry, matrix: Matrix, materialIndexOffset: Double): Unit = js.native
  def mergeMesh(mesh: Mesh[_]): Unit = js.native
  def mergeVertices(): Double = js.native
//  def toJSON(): js.Dynamic = js.native
  def dispose(): Unit = js.native
  var bones: js.Array[Bone] = js.native
  var animation: AnimationData = js.native
  var animations: js.Array[AnimationData] = js.native
//  def addEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
//  def hasEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
//  def removeEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
//  def dispatchEvent(event: js.Any): Unit = js.native
}

  @js.native
  @JSName("THREE.Object3D")
  object Object3D extends js.Object {
    var DefaultUp: Vector3 = js.native
  }

  @js.native
  trait Intersection extends js.Object {
    var distance: Double = js.native
    var point: Vector3 = js.native
    var face: Face3 = js.native
    var `object`: Object3D = js.native
  }

  @js.native
  trait RaycasterParameters extends js.Object {
    var Sprite: js.Any = js.native
    var Mesh: js.Any = js.native
    var PointCloud: js.Any = js.native
    var LOD: js.Any = js.native
    var Line: js.Any = js.native
  }

  @js.native
  @JSName("THREE.Raycaster")
  class Raycaster extends js.Object {
    def this(origin: Vector3 = ???, direction: Vector3 = ???, near: Double = ???, far: Double = ???) = this()
    var ray: Ray = js.native
    var near: Double = js.native
    var far: Double = js.native
    var params: RaycasterParameters = js.native
    var precision: Double = js.native
    var linePrecision: Double = js.native
    def set(origin: Vector3, direction: Vector3): Unit = js.native
    def setFromCamera(coords: js.Any, camera: Camera): Unit = js.native
    def intersectObject(`object`: Object3D, recursive: Boolean = ???): js.Array[Intersection] = js.native
    def intersectObjects(objects: js.Array[Object3D], recursive: Boolean = ???): js.Array[Intersection] = js.native
  }

  @js.native
  @JSName("THREE.Light")
  class Light extends Object3D {
    def this(hex: Double = ???) = this()
    var color: Color = js.native
  }

  @js.native
  @JSName("THREE.AmbientLight")
  class AmbientLight extends Light {
    def this(hex: Double = ???) = this()
  }

  @js.native
  @JSName("THREE.DirectionalLight")
  class DirectionalLight extends Light {
    def this(hex: Double = ???, intensity: Double = ???) = this()
    var target: Object3D = js.native
    var intensity: Double = js.native
    var onlyShadow: Boolean = js.native
    var shadowCameraNear: Double = js.native
    var shadowCameraFar: Double = js.native
    var shadowCameraLeft: Double = js.native
    var shadowCameraRight: Double = js.native
    var shadowCameraTop: Double = js.native
    var shadowCameraBottom: Double = js.native
    var shadowCameraVisible: Boolean = js.native
    var shadowBias: Double = js.native
    var shadowDarkness: Double = js.native
    var shadowMapWidth: Double = js.native
    var shadowMapHeight: Double = js.native
    var shadowCascade: Boolean = js.native
    var shadowCascadeOffset: Vector3 = js.native
    var shadowCascadeCount: Double = js.native
    var shadowCascadeBias: js.Array[Double] = js.native
    var shadowCascadeWidth: js.Array[Double] = js.native
    var shadowCascadeHeight: js.Array[Double] = js.native
    var shadowCascadeNearZ: js.Array[Double] = js.native
    var shadowCascadeFarZ: js.Array[Double] = js.native
    var shadowCascadeArray: js.Array[DirectionalLight] = js.native
    var shadowMap: RenderTarget = js.native
    var shadowMapSize: Double = js.native
    var shadowCamera: Camera = js.native
    var shadowMatrix: Matrix4 = js.native
  }

  @js.native
  @JSName("THREE.HemisphereLight")
  class HemisphereLight extends Light {
    def this(skyColorHex: Double = ???, groundColorHex: Double = ???, intensity: Double = ???) = this()
    var groundColor: Color = js.native
    var intensity: Double = js.native
  }

  @js.native
  @JSName("THREE.PointLight")
  class PointLight extends Light {
    def this(hex: Double = ???, intensity: Double = ???, distance: Double = ???, decay: Double = ???) = this()
    var intensity: Double = js.native
    var distance: Double = js.native
    var decay: Double = js.native
  }

  @js.native
  @JSName("THREE.SpotLight")
  class SpotLight extends Light {
    def this(hex: Double = ???, intensity: Double = ???, distance: Double = ???, angle: Double = ???, exponent: Double = ???, decay: Double = ???) = this()
    var target: Object3D = js.native
    var intensity: Double = js.native
    var distance: Double = js.native
    var angle: Double = js.native
    var exponent: Double = js.native
    var decay: Double = js.native
    var onlyShadow: Boolean = js.native
    var shadowCameraNear: Double = js.native
    var shadowCameraFar: Double = js.native
    var shadowCameraFov: Double = js.native
    var shadowCameraVisible: Boolean = js.native
    var shadowBias: Double = js.native
    var shadowDarkness: Double = js.native
    var shadowMapWidth: Double = js.native
    var shadowMapHeight: Double = js.native
    var shadowMap: RenderTarget = js.native
    var shadowMapSize: Vector2 = js.native
    var shadowCamera: Camera = js.native
    var shadowMatrix: Matrix4 = js.native
  }

  @js.native
  trait Progress extends js.Object {
    var total: Double = js.native
    var loaded: Double = js.native
  }

  @js.native
  @JSName("THREE.Loader")
  class Loader extends js.Object {
    def this(showStatus: Boolean = ???) = this()
    var showStatus: Boolean = js.native
    var statusDomElement: HTMLElement = js.native
    var imageLoader: ImageLoader = js.native
    var onLoadStart: js.Function0[Unit] = js.native
    var onLoadProgress: js.Function0[Unit] = js.native
    var onLoadComplete: js.Function0[Unit] = js.native
    var crossOrigin: String = js.native
    def addStatusElement(): HTMLElement = js.native
    def updateProgress(progress: Progress): Unit = js.native
    def extractUrlBase(url: String): String = js.native
    def initMaterials(materials: js.Array[Material], texturePath: String): js.Array[Material] = js.native
    def needsTangents(materials: js.Array[Material]): Boolean = js.native
    def createMaterial(m: Material, texturePath: String): Boolean = js.native
  }

  @js.native
  @JSName("THREE.Loader")
  object Loader extends js.Object {
    var Handlers: LoaderHandler = js.native
  }

  @js.native
  trait LoaderHandler extends js.Object {
    var handlers: js.Array[js.Any] = js.native
    def add(regex: String, loader: Loader): Unit = js.native
    def get(file: String): Loader = js.native
  }

  @js.native
  @JSName("THREE.BinaryTextureLoader")
  class BinaryTextureLoader extends js.Object {
    def load(url: String, onLoad: js.Function1[DataTexture, Unit], onProgress: js.Function1[js.Any, Unit] = ???, onError: js.Function1[js.Any, Unit] = ???): Unit = js.native
  }

  @js.native
  @JSName("THREE.BufferGeometryLoader")
  class BufferGeometryLoader extends js.Object {
    def this(manager: LoadingManager = ???) = this()
    var manager: LoadingManager = js.native
    def load(url: String, onLoad: js.Function1[BufferGeometry, Unit], onProgress: js.Function1[js.Any, Unit] = ???, onError: js.Function1[js.Any, Unit] = ???): Unit = js.native
    def setCrossOrigin(crossOrigin: String): Unit = js.native
    def parse(json: js.Any): BufferGeometry = js.native
  }

  @js.native
  trait Cache extends js.Object {
    var files: js.Array[js.Any] = js.native
    def add(key: String, file: js.Any): Unit = js.native
    def get(key: String): js.Dynamic = js.native
    def remove(key: String): Unit = js.native
    def clear(): Unit = js.native
  }

  @js.native
  @JSName("THREE.CompressedTextureLoader")
  class CompressedTextureLoader extends js.Object {
    def load(url: String, onLoad: js.Function1[BufferGeometry, Unit], onError: js.Function1[js.Any, Unit] = ???): Unit = js.native
  }

  @js.native
  @JSName("THREE.DataTextureLoader")
  class DataTextureLoader extends BinaryTextureLoader {
  }

  @js.native
  @JSName("THREE.ImageLoader")
  class ImageLoader extends js.Object {
    def this(manager: LoadingManager = ???) = this()
    var cache: Cache = js.native
    var manager: LoadingManager = js.native
    var crossOrigin: String = js.native
    def load(url: String, onLoad: js.Function1[HTMLImageElement, Unit] = ???, onProgress: js.Function1[js.Any, Unit] = ???, onError: js.Function1[js.Any, Unit] = ???): HTMLImageElement = js.native
    def setCrossOrigin(crossOrigin: String): Unit = js.native
  }

  @js.native
  @JSName("THREE.JSONLoader")
  class JSONLoader extends Loader {
    def this(showStatus: Boolean = ???) = this()
    var withCredentials: Boolean = js.native
    def load(url: String, callback: js.Function2[Geometry, js.Array[Material], Unit], texturePath: String = ???): Unit = js.native
    def loadAjaxJSON(context: JSONLoader, url: String, callback: js.Function2[Geometry, js.Array[Material], Unit], texturePath: String = ???, callbackProgress: js.Function1[Progress, Unit] = ???): Unit = js.native
    def parse(json: js.Any, texturePath: String = ???): js.Any = js.native
  }

  @js.native
  @JSName("THREE.LoadingManager")
  class LoadingManager extends js.Object {
    def this(onLoad: js.Function0[Unit] = ???, onProgress: js.Function3[String, Double, Double, Unit] = ???, onError: js.Function0[Unit] = ???) = this()
    var onLoad: js.Function0[Unit] = js.native
    var onProgress: js.Function3[js.Any, Double, Double, Unit] = js.native
    var onError: js.Function0[Unit] = js.native
    def itemStart(url: String): Unit = js.native
    def itemEnd(url: String): Unit = js.native
  }

  @js.native
  @JSName("THREE.MaterialLoader")
  class MaterialLoader extends js.Object {
    def this(manager: LoadingManager = ???) = this()
    var manager: LoadingManager = js.native
    def load(url: String, onLoad: js.Function1[Material, Unit]): Unit = js.native
    def setCrossOrigin(crossOrigin: String): Unit = js.native
    def parse(json: js.Any): Material = js.native
  }

  @js.native
  @JSName("THREE.ObjectLoader")
  class ObjectLoader extends js.Object {
    def this(manager: LoadingManager = ???) = this()
    var manager: LoadingManager = js.native
    var texturePass: String = js.native
    def load(url: String, onLoad: js.Function1[Object3D, Unit] = ???): Unit = js.native
    def setTexturePath(value: String): Unit = js.native
    def setCrossOrigin(crossOrigin: String): Unit = js.native
    def parse[T <: Object3D](json: js.Any, onLoad: js.Function1[Object3D, Unit] = ???): T = js.native
    def parseGeometries(json: js.Any): js.Array[js.Any] = js.native
    def parseMaterials(json: js.Any, textures: js.Array[Texture]): js.Array[Material] = js.native
    def parseImages(json: js.Any, onLoad: js.Function0[Unit]): js.Array[js.Any] = js.native
    def parseTextures(json: js.Any, images: js.Any): js.Array[Texture] = js.native
    def parseObject[T <: Object3D](data: js.Any, geometries: js.Array[js.Any], materials: js.Array[Material]): T = js.native
  }

  @js.native
  @JSName("THREE.TextureLoader")
  class TextureLoader extends js.Object {
    def this(manager: LoadingManager = ???) = this()
    var manager: LoadingManager = js.native
    var crossOrigin: String = js.native
    def load(url: String, onLoad: js.Function1[Texture, Unit]): Unit = js.native
    def setCrossOrigin(crossOrigin: String): Unit = js.native
  }

  @js.native
  @JSName("THREE.XHRLoader")
  class XHRLoader extends js.Object {
    def this(manager: LoadingManager = ???) = this()
    var cache: Cache = js.native
    var manager: LoadingManager = js.native
    var responseType: String = js.native
    var crossOrigin: String = js.native
    def load(url: String, onLoad: js.Function1[String, Unit] = ???, onProgress: js.Function1[js.Any, Unit] = ???, onError: js.Function1[js.Any, Unit] = ???): Unit = js.native
    def setResponseType(responseType: String): Unit = js.native
    def setCrossOrigin(crossOrigin: String): Unit = js.native
  }

  @js.native
  trait MaterialParameters extends js.Object {
    var name: String = js.native
    var side: Side = js.native
    var opacity: Double = js.native
    var transparent: Boolean = js.native
    var blending: Blending = js.native
    var blendSrc: BlendingDstFactor = js.native
    var blendDst: BlendingSrcFactor = js.native
    var blendEquation: BlendingEquation = js.native
    var depthTest: Boolean = js.native
    var depthWrite: Boolean = js.native
    var polygonOffset: Boolean = js.native
    var polygonOffsetFactor: Double = js.native
    var polygonOffsetUnits: Double = js.native
    var alphaTest: Double = js.native
    var overdraw: Double = js.native
    var visible: Boolean = js.native
    var needsUpdate: Boolean = js.native
  }

  @js.native
  @JSName("THREE.Material")
  class Material extends js.Object {
    var id: Double = js.native
    var uuid: String = js.native
    var name: String = js.native
    var `type`: String = js.native
    var side: Side = js.native
    var opacity: Double = js.native
    var transparent: Boolean = js.native
    var blending: Blending = js.native
    var blendSrc: BlendingDstFactor = js.native
    var blendDst: BlendingSrcFactor = js.native
    var blendEquation: BlendingEquation = js.native
    var blendSrcAlpha: Double = js.native
    var blendDstAlpha: Double = js.native
    var blendEquationAlpha: Double = js.native
    var depthTest: Boolean = js.native
    var depthWrite: Boolean = js.native
    var colorWrite: Boolean = js.native
    var polygonOffset: Boolean = js.native
    var polygonOffsetFactor: Double = js.native
    var polygonOffsetUnits: Double = js.native
    var alphaTest: Double = js.native
    var overdraw: Double = js.native
    var visible: Boolean = js.native
    var needsUpdate: Boolean = js.native
    def setValues(values: Object): Unit = js.native
    def toJSON(): js.Dynamic = js.native
    def clone(material: Material = ???): Material = js.native
    def update(): Unit = js.native
    def dispose(): Unit = js.native
    def addEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def hasEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def removeEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def dispatchEvent(event: js.Any): Unit = js.native
  }


  @js.native
  trait LineBasicMaterialParameters extends MaterialParameters {
    var color: Double = js.native
    var linewidth: Double = js.native
    var linecap: String = js.native
    var linejoin: String = js.native
    var vertexColors: Colors = js.native
    var fog: Boolean = js.native
  }

  @js.native
  @JSName("THREE.LineBasicMaterial")
  class LineBasicMaterial extends Material {
    //def this(parameters: LineBasicMaterialParameters = ???) = this()
    def this(parameters: js.Dynamic = ???) = this()
    var color: Color = js.native
    var linewidth: Double = js.native
    var linecap: String = js.native
    var linejoin: String = js.native
    var vertexColors: Colors = js.native
    var fog: Boolean = js.native
  }

  @js.native
  trait LineDashedMaterialParameters extends MaterialParameters {
    var color: Double = js.native
    var linewidth: Double = js.native
    var scale: Double = js.native
    var dashSize: Double = js.native
    var gapSize: Double = js.native
    var vertexColors: Colors = js.native
    var fog: Boolean = js.native
  }

  @js.native
  @JSName("THREE.LineDashedMaterial")
  class LineDashedMaterial extends Material {
    //def this(parameters: LineDashedMaterialParameters = ???) = this()
    def this(parameters: js.Dynamic = ???) = this()
    var color: Color = js.native
    var linewidth: Double = js.native
    var scale: Double = js.native
    var dashSize: Double = js.native
    var gapSize: Double = js.native
    var vertexColors: Colors = js.native
    var fog: Boolean = js.native
  }

  @js.native
  trait MeshBasicMaterialParameters extends MaterialParameters {
    var color: Double = js.native
    var map: Texture = js.native
    var lightMap: Texture = js.native
    var specularMap: Texture = js.native
    var alphaMap: Texture = js.native
    var envMap: Texture = js.native
    var combine: Combine = js.native
    var reflectivity: Double = js.native
    var refractionRatio: Double = js.native
    var fog: Boolean = js.native
    var shading: Shading = js.native
    var wireframe: Boolean = js.native
    var wireframeLinewidth: Double = js.native
    var wireframeLinecap: String = js.native
    var wireframeLinejoin: String = js.native
    var vertexColors: Colors = js.native
    var skinning: Boolean = js.native
    var morphTargets: Boolean = js.native
  }

  @js.native
  @JSName("THREE.MeshBasicMaterial")
  class MeshBasicMaterial(parameters: js.Dynamic = ???) extends Material {
    //def this(parameters: MeshBasicMaterialParameters = ???) = this()
    //def this(parameters: js.Dynamic = ???) = this()
    var color: Color = js.native
    var map: Texture = js.native
    var lightMap: Texture = js.native
    var specularMap: Texture = js.native
    var alphaMap: Texture = js.native
    var envMap: Texture = js.native
    var combine: Combine = js.native
    var reflectivity: Double = js.native
    var refractionRatio: Double = js.native
    var fog: Boolean = js.native
    var shading: Shading = js.native
    var wireframe: Boolean = js.native
    var wireframeLinewidth: Double = js.native
    var wireframeLinecap: String = js.native
    var wireframeLinejoin: String = js.native
    var vertexColors: Colors = js.native
    var skinning: Boolean = js.native
    var morphTargets: Boolean = js.native
  }

  @js.native
  trait MeshDepthMaterialParameters extends MaterialParameters {
    var wireframe: Boolean = js.native
    var wireframeLinewidth: Double = js.native
  }

  @js.native
  @JSName("THREE.MeshDepthMaterial")
  class MeshDepthMaterial extends Material {
    def this(parameters: MeshDepthMaterialParameters = ???) = this()
    var wireframe: Boolean = js.native
    var wireframeLinewidth: Double = js.native
  }

  @js.native
  @JSName("THREE.MeshFaceMaterial")
  class MeshFaceMaterial extends Material {
    def this(materials: js.Array[Material] = ???) = this()
    var materials: js.Array[Material] = js.native
  }

  @js.native
  trait MeshLambertMaterialParameters extends MaterialParameters {
    var color: Double = js.native
    var emissive: Double = js.native
    var wrapAround: Boolean = js.native
    var wrapRGB: Vector3 = js.native
    var map: Texture = js.native
    var lightMap: Texture = js.native
    var specularMap: Texture = js.native
    var alphaMap: Texture = js.native
    var envMap: Texture = js.native
    var combine: Combine = js.native
    var reflectivity: Double = js.native
    var refractionRatio: Double = js.native
    var fog: Boolean = js.native
    var shading: Shading = js.native
    var wireframe: Boolean = js.native
    var wireframeLinewidth: Double = js.native
    var wireframeLinecap: String = js.native
    var wireframeLinejoin: String = js.native
    var vertexColors: Colors = js.native
    var skinning: Boolean = js.native
    var morphTargets: Boolean = js.native
    var morphNormals: Boolean = js.native
  }

  @js.native
  @JSName("THREE.MeshLambertMaterial")
  class MeshLambertMaterial extends Material {
    //def this(parameters: MeshLambertMaterialParameters = ???) = this()
    def this(parameters: js.Dynamic = ???) = this()
    var color: Color = js.native
    var emissive: Color = js.native
    var wrapAround: Boolean = js.native
    var wrapRGB: Vector3 = js.native
    var map: Texture = js.native
    var lightMap: Texture = js.native
    var specularMap: Texture = js.native
    var alphaMap: Texture = js.native
    var envMap: Texture = js.native
    var combine: Combine = js.native
    var reflectivity: Double = js.native
    var refractionRatio: Double = js.native
    var fog: Boolean = js.native
    var shading: Shading = js.native
    var wireframe: Boolean = js.native
    var wireframeLinewidth: Double = js.native
    var wireframeLinecap: String = js.native
    var wireframeLinejoin: String = js.native
    var vertexColors: Colors = js.native
    var skinning: Boolean = js.native
    var morphTargets: Boolean = js.native
    var morphNormals: Boolean = js.native
  }

  @js.native
  trait MeshNormalMaterialParameters extends MaterialParameters {
    var color: Double = js.native
    var map: Texture = js.native
    var lightMap: Texture = js.native
    var specularMap: Texture = js.native
    var alphaMap: Texture = js.native
    var envMap: Texture = js.native
    var fog: Boolean = js.native
    var shading: Shading = js.native
    var wireframe: Boolean = js.native
    var wireframeLinewidth: Double = js.native
    var wireframeLinecap: String = js.native
    var wireframeLinejoin: String = js.native
    var vertexColors: Colors = js.native
    var skinning: Boolean = js.native
    var morphTargets: Boolean = js.native
  }

  @js.native
  @JSName("THREE.MeshNormalMaterial")
  class MeshNormalMaterial extends Material {
    //def this(parameters: MeshNormalMaterialParameters = ???) = this()
    def this(parameters: js.Dynamic = ???) = this()
    var wireframe: Boolean = js.native
    var wireframeLinewidth: Double = js.native
    var morphTargets: Boolean = js.native
  }

  @js.native
  trait MeshPhongMaterialParameters extends MaterialParameters {
    var color: Double = js.native
    var map: Texture = js.native
    var lightMap: Texture = js.native
    var specularMap: Texture = js.native
    var alphaMap: Texture = js.native
    var envMap: Texture = js.native
    var fog: Boolean = js.native
    var shading: Shading = js.native
    var wireframe: String = js.native
    var wireframeLinewidth: Double = js.native
    var wireframeLinecap: String = js.native
    var wireframeLinejoin: String = js.native
    var vertexColors: Colors = js.native
    var skinning: Boolean = js.native
    var morphTargets: Boolean = js.native
    var emissive: Double = js.native
    var specular: Double = js.native
    var shininess: Double = js.native
    var metal: Boolean = js.native
    var wrapAround: Boolean = js.native
    var wrapRGB: Vector3 = js.native
    var bumpMap: Texture = js.native
    var bumpScale: Double = js.native
    var normalMap: Texture = js.native
    var normalScale: Vector2 = js.native
    var combine: Combine = js.native
    var reflectivity: Double = js.native
    var refractionRatio: Double = js.native
    var morphNormals: Boolean = js.native
  }

  @js.native
  @JSName("THREE.MeshPhongMaterial")
  class MeshPhongMaterial extends Material {
    //def this(parameters: MeshPhongMaterialParameters = ???) = this()
    def this(parameters: js.Dynamic = ???) = this()
    var color: Color = js.native
    var emissive: Color = js.native
    var specular: Color = js.native
    var shininess: Double = js.native
    var metal: Boolean = js.native
    var wrapAround: Boolean = js.native
    var wrapRGB: Vector3 = js.native
    var map: Texture = js.native
    var lightMap: Texture = js.native
    var bumpMap: Texture = js.native
    var bumpScale: Double = js.native
    var normalMap: Texture = js.native
    var normalScale: Vector2 = js.native
    var specularMap: Texture = js.native
    var alphaMap: Texture = js.native
    var envMap: Texture = js.native
    var combine: Combine = js.native
    var reflectivity: Double = js.native
    var refractionRatio: Double = js.native
    var fog: Boolean = js.native
    var shading: Shading = js.native
    var wireframe: Boolean = js.native
    var wireframeLinewidth: Double = js.native
    var wireframeLinecap: String = js.native
    var wireframeLinejoin: String = js.native
    var vertexColors: Colors = js.native
    var skinning: Boolean = js.native
    var morphTargets: Boolean = js.native
    var morphNormals: Boolean = js.native
  }

  @js.native
  trait PointCloudMaterialParameters extends MaterialParameters {
    var color: Double = js.native
    var map: Texture = js.native
    var size: Double = js.native
    var sizeAttenuation: Boolean = js.native
    var vertexColors: Colors = js.native
    var fog: Boolean = js.native
  }

  @js.native
  @JSName("THREE.RawShaderMaterial")
  class RawShaderMaterial extends ShaderMaterial {
    def this(parameters: ShaderMaterialParameters = ???) = this()
  }

  @js.native
  trait ShaderMaterialParameters extends MaterialParameters {
    var defines: js.Any = js.native
    var uniforms: js.Any = js.native
    var attributes: js.Any = js.native
    var vertexShader: String = js.native
    var fragmentShader: String = js.native
    var shading: Shading = js.native
    var linewidth: Double = js.native
    var wireframe: Boolean = js.native
    var wireframeLinewidth: Double = js.native
    var fog: Boolean = js.native
    var lights: Boolean = js.native
    var vertexColors: Colors = js.native
    var skinning: Boolean = js.native
    var morphTargets: Boolean = js.native
    var morphNormals: Boolean = js.native
  }

  @js.native
  @JSName("THREE.ShaderMaterial")
  class ShaderMaterial extends Material {
    def this(parameters: ShaderMaterialParameters = ???) = this()
    var defines: js.Any = js.native
    var uniforms: js.Any = js.native
    var attributes: js.Any = js.native
    var vertexShader: String = js.native
    var fragmentShader: String = js.native
    var shading: Shading = js.native
    var linewidth: Double = js.native
    var wireframe: Boolean = js.native
    var wireframeLinewidth: Double = js.native
    var fog: Boolean = js.native
    var lights: Boolean = js.native
    var vertexColors: Colors = js.native
    var skinning: Boolean = js.native
    var morphTargets: Boolean = js.native
    var morphNormals: Boolean = js.native
  }

  @js.native
  trait SpriteMaterialParameters extends MaterialParameters {
    var color: Double = js.native
    var map: Texture = js.native
    var rotation: Double = js.native
    var fog: Boolean = js.native
  }

  @js.native
  @JSName("THREE.SpriteMaterial")
  class SpriteMaterial extends Material {
    def this(parameters: SpriteMaterialParameters = ???) = this()
    var color: Color = js.native
    var map: Texture = js.native
    var rotation: Double = js.native
    var fog: Boolean = js.native
  }

  @js.native
  @JSName("THREE.Box2")
  class Box2 extends js.Object {
    def this(min: Vector2 = ???, max: Vector2 = ???) = this()
    var max: Vector2 = js.native
    var min: Vector2 = js.native
    def set(min: Vector2, max: Vector2): Box2 = js.native
    def setFromPoints(points: js.Array[Vector2]): Box2 = js.native
    def setFromCenterAndSize(center: Vector2, size: Vector2): Box2 = js.native
    def copy(box: Box2): Box2 = js.native
    def makeEmpty(): Box2 = js.native
    def empty(): Boolean = js.native
    def center(optionalTarget: Vector2 = ???): Vector2 = js.native
    def size(optionalTarget: Vector2 = ???): Vector2 = js.native
    def expandByPoint(point: Vector2): Box2 = js.native
    def expandByVector(vector: Vector2): Box2 = js.native
    def expandByScalar(scalar: Double): Box2 = js.native
    def containsPoint(point: Vector2): Boolean = js.native
    def containsBox(box: Box2): Boolean = js.native
    def getParameter(point: Vector2): Vector2 = js.native
    def isIntersectionBox(box: Box2): Boolean = js.native
    def clampPoint(point: Vector2, optionalTarget: Vector2 = ???): Vector2 = js.native
    def distanceToPoint(point: Vector2): Double = js.native
    def intersect(box: Box2): Box2 = js.native
    def union(box: Box2): Box2 = js.native
    def translate(offset: Vector2): Box2 = js.native
    def equals(box: Box2): Boolean = js.native
  }

  @js.native
  @JSName("THREE.Box3")
  class Box3 extends js.Object {
    def this(min: Vector3 = ???, max: Vector3 = ???) = this()
    var max: Vector3 = js.native
    var min: Vector3 = js.native
    def set(min: Vector3, max: Vector3): Box3 = js.native
    def setFromPoints(points: js.Array[Vector3]): Box3 = js.native
    def setFromCenterAndSize(center: Vector3, size: Vector3): Box3 = js.native
    def setFromObject(`object`: Object3D): Box3 = js.native
    def copy(box: Box3): Box3 = js.native
    def makeEmpty(): Box3 = js.native
    def empty(): Boolean = js.native
    def center(optionalTarget: Vector3 = ???): Vector3 = js.native
    def size(optionalTarget: Vector3 = ???): Vector3 = js.native
    def expandByPoint(point: Vector3): Box3 = js.native
    def expandByVector(vector: Vector3): Box3 = js.native
    def expandByScalar(scalar: Double): Box3 = js.native
    def containsPoint(point: Vector3): Boolean = js.native
    def containsBox(box: Box3): Boolean = js.native
    def getParameter(point: Vector3): Vector3 = js.native
    def isIntersectionBox(box: Box3): Boolean = js.native
    def clampPoint(point: Vector3, optionalTarget: Vector3 = ???): Vector3 = js.native
    def distanceToPoint(point: Vector3): Double = js.native
    def getBoundingSphere(optionalTarget: Sphere = ???): Sphere = js.native
    def intersect(box: Box3): Box3 = js.native
    def union(box: Box3): Box3 = js.native
    def applyMatrix4(matrix: Matrix4): Box3 = js.native
    def translate(offset: Vector3): Box3 = js.native
    def equals(box: Box3): Boolean = js.native
  }

  @js.native
  trait HSL extends js.Object {
    var h: Double = js.native
    var s: Double = js.native
    var l: Double = js.native
  }

  object Gray{
    def apply(v:Double) = new Color(v,v,v)
  }

  object Rgb{
    def apply(r:Double, g:Double, b:Double) = new Color(r,g,b)
  }

  object Hsl{
    def apply(h:Double = 0, s:Double = 1, l:Double = 1) = new Color().setHSL(h,s,l)
  }

  object Hex{
    def apply(hex:Int) = new Color().setHex(hex)
  }

  @js.native
  @JSName("THREE.Color")
  class Color(var r: Double = js.native, var g: Double = js.native, var b: Double = js.native) extends js.Object {
    //TODO: ver constructores
    //def this(color: Color = ???) = this()
    //def this(r: Double, g: Double, b: Double) = this()
    def set(color: Color): Color = js.native
    def setHex(hex: Double): Color = js.native
    def setRGB(r: Double, g: Double, b: Double): Color = js.native
    def setHSL(h: Double, s: Double, l: Double): Color = js.native
    def setStyle(style: String): Color = js.native
    def copy(color: Color): Color = js.native
    def copyGammaToLinear(color: Color, gammaFactor: Double = ???): Color = js.native
    def copyLinearToGamma(color: Color, gammaFactor: Double = ???): Color = js.native
    def convertGammaToLinear(): Color = js.native
    def convertLinearToGamma(): Color = js.native
    def getHex(): Double = js.native
    def getHexString(): String = js.native
    def getHSL(): HSL = js.native
    def getStyle(): String = js.native
    def offsetHSL(h: Double, s: Double, l: Double): Color = js.native
    def add(color: Color): Color = js.native
    def addColors(color1: Color, color2: Color): Color = js.native
    def addScalar(s: Double): Color = js.native
    def multiply(color: Color): Color = js.native
    def multiplyScalar(s: Double): Color = js.native
    def lerp(color: Color, alpha: Double): Color = js.native
    def equals(color: Color): Boolean = js.native
    def fromArray(rgb: js.Array[Double]): Color = js.native
    def toArray(array: js.Array[Double] = ???, offset: Double = ???): js.Array[Double] = js.native
  }

  @js.native
  @JSName("THREE.ColorKeywords")
  class ColorKeywords extends js.Object {
  }

  @js.native
  @JSName("THREE.ColorKeywords")
  object ColorKeywords extends js.Object {
    var aliceblue: Double = js.native
    var antiquewhite: Double = js.native
    var aqua: Double = js.native
    var aquamarine: Double = js.native
    var azure: Double = js.native
    var beige: Double = js.native
    var bisque: Double = js.native
    var black: Double = js.native
    var blanchedalmond: Double = js.native
    var blue: Double = js.native
    var blueviolet: Double = js.native
    var brown: Double = js.native
    var burlywood: Double = js.native
    var cadetblue: Double = js.native
    var chartreuse: Double = js.native
    var chocolate: Double = js.native
    var coral: Double = js.native
    var cornflowerblue: Double = js.native
    var cornsilk: Double = js.native
    var crimson: Double = js.native
    var cyan: Double = js.native
    var darkblue: Double = js.native
    var darkcyan: Double = js.native
    var darkgoldenrod: Double = js.native
    var darkgray: Double = js.native
    var darkgreen: Double = js.native
    var darkgrey: Double = js.native
    var darkkhaki: Double = js.native
    var darkmagenta: Double = js.native
    var darkolivegreen: Double = js.native
    var darkorange: Double = js.native
    var darkorchid: Double = js.native
    var darkred: Double = js.native
    var darksalmon: Double = js.native
    var darkseagreen: Double = js.native
    var darkslateblue: Double = js.native
    var darkslategray: Double = js.native
    var darkslategrey: Double = js.native
    var darkturquoise: Double = js.native
    var darkviolet: Double = js.native
    var deeppink: Double = js.native
    var deepskyblue: Double = js.native
    var dimgray: Double = js.native
    var dimgrey: Double = js.native
    var dodgerblue: Double = js.native
    var firebrick: Double = js.native
    var floralwhite: Double = js.native
    var forestgreen: Double = js.native
    var fuchsia: Double = js.native
    var gainsboro: Double = js.native
    var ghostwhite: Double = js.native
    var gold: Double = js.native
    var goldenrod: Double = js.native
    var gray: Double = js.native
    var green: Double = js.native
    var greenyellow: Double = js.native
    var grey: Double = js.native
    var honeydew: Double = js.native
    var hotpink: Double = js.native
    var indianred: Double = js.native
    var indigo: Double = js.native
    var ivory: Double = js.native
    var khaki: Double = js.native
    var lavender: Double = js.native
    var lavenderblush: Double = js.native
    var lawngreen: Double = js.native
    var lemonchiffon: Double = js.native
    var lightblue: Double = js.native
    var lightcoral: Double = js.native
    var lightcyan: Double = js.native
    var lightgoldenrodyellow: Double = js.native
    var lightgray: Double = js.native
    var lightgreen: Double = js.native
    var lightgrey: Double = js.native
    var lightpink: Double = js.native
    var lightsalmon: Double = js.native
    var lightseagreen: Double = js.native
    var lightskyblue: Double = js.native
    var lightslategray: Double = js.native
    var lightslategrey: Double = js.native
    var lightsteelblue: Double = js.native
    var lightyellow: Double = js.native
    var lime: Double = js.native
    var limegreen: Double = js.native
    var linen: Double = js.native
    var magenta: Double = js.native
    var maroon: Double = js.native
    var mediumaquamarine: Double = js.native
    var mediumblue: Double = js.native
    var mediumorchid: Double = js.native
    var mediumpurple: Double = js.native
    var mediumseagreen: Double = js.native
    var mediumslateblue: Double = js.native
    var mediumspringgreen: Double = js.native
    var mediumturquoise: Double = js.native
    var mediumvioletred: Double = js.native
    var midnightblue: Double = js.native
    var mintcream: Double = js.native
    var mistyrose: Double = js.native
    var moccasin: Double = js.native
    var navajowhite: Double = js.native
    var navy: Double = js.native
    var oldlace: Double = js.native
    var olive: Double = js.native
    var olivedrab: Double = js.native
    var orange: Double = js.native
    var orangered: Double = js.native
    var orchid: Double = js.native
    var palegoldenrod: Double = js.native
    var palegreen: Double = js.native
    var paleturquoise: Double = js.native
    var palevioletred: Double = js.native
    var papayawhip: Double = js.native
    var peachpuff: Double = js.native
    var peru: Double = js.native
    var pink: Double = js.native
    var plum: Double = js.native
    var powderblue: Double = js.native
    var purple: Double = js.native
    var red: Double = js.native
    var rosybrown: Double = js.native
    var royalblue: Double = js.native
    var saddlebrown: Double = js.native
    var salmon: Double = js.native
    var sandybrown: Double = js.native
    var seagreen: Double = js.native
    var seashell: Double = js.native
    var sienna: Double = js.native
    var silver: Double = js.native
    var skyblue: Double = js.native
    var slateblue: Double = js.native
    var slategray: Double = js.native
    var slategrey: Double = js.native
    var snow: Double = js.native
    var springgreen: Double = js.native
    var steelblue: Double = js.native
    var tan: Double = js.native
    var teal: Double = js.native
    var thistle: Double = js.native
    var tomato: Double = js.native
    var turquoise: Double = js.native
    var violet: Double = js.native
    var wheat: Double = js.native
    var white: Double = js.native
    var whitesmoke: Double = js.native
    var yellow: Double = js.native
    var yellowgreen: Double = js.native
  }

  @js.native
  @JSName("THREE.Euler")
  class Euler extends js.Object {
    def this(x: Double = ???, y: Double = ???, z: Double = ???, order: String = ???) = this()
    var x: Double = js.native
    var y: Double = js.native
    var z: Double = js.native
    var order: String = js.native
    def set(x: Double, y: Double, z: Double, order: String = ???): Euler = js.native
    def copy(euler: Euler): Euler = js.native
    def setFromRotationMatrix(m: Matrix4, order: String = ???, update: Boolean = ???): Euler = js.native
    def setFromQuaternion(q: Quaternion, order: String = ???, update: Boolean = ???): Euler = js.native
    def setFromVector3(v: Vector3, order: String = ???): Euler = js.native
    def reorder(newOrder: String): Euler = js.native
    def equals(euler: Euler): Boolean = js.native
    def fromArray(xyzo: js.Array[js.Any]): Euler = js.native
    def toArray(array: js.Array[Double] = ???, offset: Double = ???): js.Array[Double] = js.native
    def toVector3(optionalResult: Vector3 = ???): Vector3 = js.native
    var onChange: js.Function0[Unit] = js.native
  }

  @js.native
  @JSName("THREE.Frustum")
  class Frustum extends js.Object {
    def this(p0: Plane = ???, p1: Plane = ???, p2: Plane = ???, p3: Plane = ???, p4: Plane = ???, p5: Plane = ???) = this()
    var planes: js.Array[Plane] = js.native
    def set(p0: Double = ???, p1: Double = ???, p2: Double = ???, p3: Double = ???, p4: Double = ???, p5: Double = ???): Frustum = js.native
    def copy(frustum: Frustum): Frustum = js.native
    def setFromMatrix(m: Matrix4): Frustum = js.native
    def intersectsObject(`object`: Object3D): Boolean = js.native
    def intersectsSphere(sphere: Sphere): Boolean = js.native
    def intersectsBox(box: Box3): Boolean = js.native
    def containsPoint(point: Vector3): Boolean = js.native
  }

  @js.native
  @JSName("THREE.Line3")
  class Line3 extends js.Object {
    def this(start: Vector3 = ???, end: Vector3 = ???) = this()
    var start: Vector3 = js.native
    var end: Vector3 = js.native
    def set(start: Vector3 = ???, end: Vector3 = ???): Line3 = js.native
    def copy(line: Line3): Line3 = js.native
    def center(optionalTarget: Vector3 = ???): Vector3 = js.native
    def delta(optionalTarget: Vector3 = ???): Vector3 = js.native
    def distanceSq(): Double = js.native
    def distance(): Double = js.native
    def at(t: Double, optionalTarget: Vector3 = ???): Vector3 = js.native
    def closestPointToPointParameter(point: Vector3, clampToLine: Boolean = ???): Double = js.native
    def closestPointToPoint(point: Vector3, clampToLine: Boolean = ???, optionalTarget: Vector3 = ???): Vector3 = js.native
    def applyMatrix4(matrix: Matrix4): Line3 = js.native
    def equals(line: Line3): Boolean = js.native
  }

  @js.native
  trait Math extends js.Object {
    def generateUUID(): String = js.native
    def clamp(x: Double, a: Double, b: Double): Double = js.native
    def clampBottom(x: Double, a: Double): Double = js.native
    def mapLinear(x: Double, a1: Double, a2: Double, b1: Double, b2: Double): Double = js.native
    def smoothstep(x: Double, min: Double, max: Double): Double = js.native
    def smootherstep(x: Double, min: Double, max: Double): Double = js.native
    def random16(): Double = js.native
    def randInt(low: Double, high: Double): Double = js.native
    def randFloat(low: Double, high: Double): Double = js.native
    def randFloatSpread(range: Double): Double = js.native
    def degToRad(degrees: Double): Double = js.native
    def radToDeg(radians: Double): Double = js.native
    def isPowerOfTwo(value: Double): Boolean = js.native
    def nextPowerOfTwo(value: Double): Double = js.native
  }

  @js.native
  trait Matrix extends js.Object {
    var elements: Float32Array = js.native
    def identity(): Matrix = js.native
    def copy(m: Matrix): Matrix = js.native
    def multiplyScalar(s: Double): Matrix = js.native
    def determinant(): Double = js.native
    def getInverse(matrix: Matrix, throwOnInvertible: Boolean = ???): Matrix = js.native
    def transpose(): Matrix = js.native
  }

  @js.native
  @JSName("THREE.Matrix3")
  class Matrix3 extends Matrix {
    def this(n11: Double, n12: Double, n13: Double, n21: Double, n22: Double, n23: Double, n31: Double, n32: Double, n33: Double) = this()
    def set(n11: Double, n12: Double, n13: Double, n21: Double, n22: Double, n23: Double, n31: Double, n32: Double, n33: Double): Matrix3 = js.native
    def copy(m: Matrix3): Matrix3 = js.native
    def applyToVector3Array(array: js.Array[Double], offset: Double = ???, length: Double = ???): js.Array[Double] = js.native
    //TODO: Ver q onda
    //def getInverse(matrix: Matrix3, throwOnInvertible: Boolean = ???): Matrix3 = js.native
    def flattenToArrayOffset(array: js.Array[Double], offset: Double): js.Array[Double] = js.native
    def getNormalMatrix(m: Matrix4): Matrix3 = js.native
    def transposeIntoArray(r: js.Array[Double]): js.Array[Double] = js.native
    def fromArray(array: js.Array[Double]): Matrix3 = js.native
    def toArray(): js.Array[Double] = js.native
  }

  @js.native
  @JSName("THREE.Matrix4")
  class Matrix4 extends Matrix {
    def this(n11: Double = ???, n12: Double = ???, n13: Double = ???, n14: Double = ???, n21: Double = ???, n22: Double = ???, n23: Double = ???, n24: Double = ???, n31: Double = ???, n32: Double = ???, n33: Double = ???, n34: Double = ???, n41: Double = ???, n42: Double = ???, n43: Double = ???, n44: Double = ???) = this()
    def set(n11: Double, n12: Double, n13: Double, n14: Double, n21: Double, n22: Double, n23: Double, n24: Double, n31: Double, n32: Double, n33: Double, n34: Double, n41: Double, n42: Double, n43: Double, n44: Double): Matrix4 = js.native
    def copy(m: Matrix4): Matrix4 = js.native
    def copyPosition(m: Matrix4): Matrix4 = js.native
    def extractBasis(xAxis: Vector3, yAxis: Vector3, zAxis: Vector3): Matrix4 = js.native
    def makeBasis(xAxis: Vector3, yAxis: Vector3, zAxis: Vector3): Matrix4 = js.native
    def extractRotation(m: Matrix4): Matrix4 = js.native
    def makeRotationFromEuler(euler: Euler): Matrix4 = js.native
    def makeRotationFromQuaternion(q: Quaternion): Matrix4 = js.native
    def lookAt(eye: Vector3, target: Vector3, up: Vector3): Matrix4 = js.native
    def multiply(m: Matrix4): Matrix4 = js.native
    def multiplyMatrices(a: Matrix4, b: Matrix4): Matrix4 = js.native
    def multiplyToArray(a: Matrix4, b: Matrix4, r: js.Array[Double]): Matrix4 = js.native
    def applyToVector3Array(array: js.Array[Double], offset: Double = ???, length: Double = ???): js.Array[Double] = js.native
    def flattenToArrayOffset(array: js.Array[Double], offset: Double): js.Array[Double] = js.native
    def setPosition(v: Vector3): Vector3 = js.native
    //TODO: ver q onda
    //def getInverse(m: Matrix4, throwOnInvertible: Boolean = ???): Matrix4 = js.native
    def scale(v: Vector3): Matrix4 = js.native
    def getMaxScaleOnAxis(): Double = js.native
    def makeTranslation(x: Double, y: Double, z: Double): Matrix4 = js.native
    def makeRotationX(theta: Double): Matrix4 = js.native
    def makeRotationY(theta: Double): Matrix4 = js.native
    def makeRotationZ(theta: Double): Matrix4 = js.native
    def makeRotationAxis(axis: Vector3, angle: Double): Matrix4 = js.native
    def makeScale(x: Double, y: Double, z: Double): Matrix4 = js.native
    def compose(translation: Vector3, rotation: Quaternion, scale: Vector3): Matrix4 = js.native
    def decompose(translation: Vector3 = ???, rotation: Quaternion = ???, scale: Vector3 = ???): js.Array[Object] = js.native
    def makeFrustum(left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Matrix4 = js.native
    def makePerspective(fov: Double, aspect: Double, near: Double, far: Double): Matrix4 = js.native
    def makeOrthographic(left: Double, right: Double, top: Double, bottom: Double, near: Double, far: Double): Matrix4 = js.native
    def fromArray(array: js.Array[Double]): Matrix4 = js.native
    def toArray(): js.Array[Double] = js.native
  }

  @js.native
  @JSName("THREE.Plane")
  class Plane(var normal: Vector3 = ???,var constant: Double = ???) extends js.Object {
    def set(normal: Vector3, constant: Double): Plane = js.native
    def setComponents(x: Double, y: Double, z: Double, w: Double): Plane = js.native
    def setFromNormalAndCoplanarPoint(normal: Vector3, point: Vector3): Plane = js.native
    def setFromCoplanarPoints(a: Vector3, b: Vector3, c: Vector3): Plane = js.native
    def copy(plane: Plane): Plane = js.native
    def normalize(): Plane = js.native
    def negate(): Plane = js.native
    def distanceToPoint(point: Vector3): Double = js.native
    def distanceToSphere(sphere: Sphere): Double = js.native
    def projectPoint(point: Vector3, optionalTarget: Vector3 = ???): Vector3 = js.native
    def orthoPoint(point: Vector3, optionalTarget: Vector3 = ???): Vector3 = js.native
    def isIntersectionLine(line: Line3): Boolean = js.native
    def intersectLine(line: Line3, optionalTarget: Vector3 = ???): Vector3 = js.native
    def coplanarPoint(optionalTarget: Boolean = ???): Vector3 = js.native
    def applyMatrix4(matrix: Matrix4, optionalNormalMatrix: Matrix3 = ???): Plane = js.native
    def translate(offset: Vector3): Plane = js.native
    def equals(plane: Plane): Boolean = js.native
  }

  @js.native
  @JSName("THREE.Quaternion")
  class Quaternion extends js.Object {
    def this(x: Double = ???, y: Double = ???, z: Double = ???, w: Double = ???) = this()
    var x: Double = js.native
    var y: Double = js.native
    var z: Double = js.native
    var w: Double = js.native
    def set(x: Double, y: Double, z: Double, w: Double): Quaternion = js.native
    def copy(q: Quaternion): Quaternion = js.native
    def setFromEuler(euler: Euler, update: Boolean = ???): Quaternion = js.native
    def setFromAxisAngle(axis: Vector3, angle: Double): Quaternion = js.native
    def setFromRotationMatrix(m: Matrix4): Quaternion = js.native
    def setFromUnitVectors(vFrom: Vector3, vTo: Vector3): Quaternion = js.native
    def inverse(): Quaternion = js.native
    def conjugate(): Quaternion = js.native
    def dot(v: Vector3): Double = js.native
    def lengthSq(): Double = js.native
    def length(): Double = js.native
    def normalize(): Quaternion = js.native
    def multiply(q: Quaternion): Quaternion = js.native
    def multiplyQuaternions(a: Quaternion, b: Quaternion): Quaternion = js.native
    def multiplyVector3(vector: Vector3): Vector3 = js.native
    def slerp(qb: Quaternion, t: Double): Quaternion = js.native
    def equals(v: Quaternion): Boolean = js.native
    def fromArray(n: js.Array[Double]): Quaternion = js.native
    def toArray(): js.Array[Double] = js.native
    def fromArray(xyzw: js.Array[Double], offset: Double = ???): Quaternion = js.native
    def toArray(xyzw: js.Array[Double] = ???, offset: Double = ???): js.Array[Double] = js.native
    var onChange: js.Function0[Unit] = js.native
  }

  @js.native
  @JSName("THREE.Quaternion")
  object Quaternion extends js.Object {
    def slerp(qa: Quaternion, qb: Quaternion, qm: Quaternion, t: Double): Quaternion = js.native
  }

  @js.native
  @JSName("THREE.Ray")
  class Ray extends js.Object {
    def this(origin: Vector3 = ???, direction: Vector3 = ???) = this()
    var origin: Vector3 = js.native
    var direction: Vector3 = js.native
    def set(origin: Vector3, direction: Vector3): Ray = js.native
    def copy(ray: Ray): Ray = js.native
    def at(t: Double, optionalTarget: Vector3 = ???): Vector3 = js.native
    def recast(t: Double): Ray = js.native
    def closestPointToPoint(point: Vector3, optionalTarget: Vector3 = ???): Vector3 = js.native
    def distanceToPoint(point: Vector3): Double = js.native
    def distanceSqToSegment(v0: Vector3, v1: Vector3, optionalPointOnRay: Vector3 = ???, optionalPointOnSegment: Vector3 = ???): Double = js.native
    def isIntersectionSphere(sphere: Sphere): Boolean = js.native
    def intersectSphere(sphere: Sphere, optionalTarget: Vector3 = ???): Vector3 = js.native
    def isIntersectionPlane(plane: Plane): Boolean = js.native
    def distanceToPlane(plane: Plane): Double = js.native
    def intersectPlane(plane: Plane, optionalTarget: Vector3 = ???): Vector3 = js.native
    def isIntersectionBox(box: Box3): Boolean = js.native
    def intersectBox(box: Box3, optionalTarget: Vector3 = ???): Vector3 = js.native
    def intersectTriangle(a: Vector3, b: Vector3, c: Vector3, backfaceCulling: Boolean, optionalTarget: Vector3 = ???): Vector3 = js.native
    def applyMatrix4(matrix4: Matrix4): Ray = js.native
    def equals(ray: Ray): Boolean = js.native
  }

  @js.native
  @JSName("THREE.Sphere")
  class Sphere extends js.Object {
    def this(center: Vector3 = ???, radius: Double = ???) = this()
    var center: Vector3 = js.native
    var radius: Double = js.native
    def set(center: Vector3, radius: Double): Sphere = js.native
    def setFromPoints(points: js.Array[Vector3], optionalCenter: Vector3 = ???): Sphere = js.native
    def copy(sphere: Sphere): Sphere = js.native
    def empty(): Boolean = js.native
    def containsPoint(point: Vector3): Boolean = js.native
    def distanceToPoint(point: Vector3): Double = js.native
    def intersectsSphere(sphere: Sphere): Boolean = js.native
    def clampPoint(point: Vector3, optionalTarget: Vector3 = ???): Vector3 = js.native
    def getBoundingBox(optionalTarget: Box3 = ???): Box3 = js.native
    def applyMatrix4(matrix: Matrix4): Sphere = js.native
    def translate(offset: Vector3): Sphere = js.native
    def equals(sphere: Sphere): Boolean = js.native
  }

  @js.native
  trait SplineControlPoint extends js.Object {
    var x: Double = js.native
    var y: Double = js.native
    var z: Double = js.native
  }

  @js.native
  @JSName("THREE.Spline")
  class Spline extends js.Object {
    def this(points: js.Array[SplineControlPoint]) = this()
    var points: js.Array[SplineControlPoint] = js.native
    def initFromArray(a: js.Array[js.Array[Double]]): Unit = js.native
    def getPoint(k: Double): SplineControlPoint = js.native
    def getControlPointsArray(): js.Array[js.Array[Double]] = js.native
    def getLength(nSubDivisions: Double = ???): js.Any = js.native
    def reparametrizeByArcLength(samplingCoef: Double): Unit = js.native
  }

  @js.native
  @JSName("THREE.Triangle")
  class Triangle(var a: Vector3 = js.native, var b: Vector3 = js.native, var c: Vector3 = js.native) extends js.Object {
    def set(a: Vector3, b: Vector3, c: Vector3): Triangle = js.native
    def setFromPointsAndIndices(points: js.Array[Vector3], i0: Double, i1: Double, i2: Double): Triangle = js.native
    def copy(triangle: Triangle): Triangle = js.native
    def area(): Double = js.native
    def midpoint(optionalTarget: Vector3 = ???): Vector3 = js.native
    def normal(optionalTarget: Vector3 = ???): Vector3 = js.native
    def plane(optionalTarget: Vector3 = ???): Plane = js.native
    def barycoordFromPoint(point: Vector3, optionalTarget: Vector3 = ???): Vector3 = js.native
    def containsPoint(point: Vector3): Boolean = js.native
    def equals(triangle: Triangle): Boolean = js.native
  }

  @js.native
  @JSName("THREE.Triangle")
  object Triangle extends js.Object {
    def normal(a: Vector3, b: Vector3, c: Vector3, optionalTarget: Vector3 = ???): Vector3 = js.native
    def barycoordFromPoint(point: Vector3, a: Vector3, b: Vector3, c: Vector3, optionalTarget: Vector3): Vector3 = js.native
    def containsPoint(point: Vector3, a: Vector3, b: Vector3, c: Vector3): Boolean = js.native
  }

  @js.native
  trait Vector extends js.Object {
    def setComponent(index: Double, value: Double): Unit = js.native
    def getComponent(index: Double): Double = js.native
    def copy(v: Vector): Vector = js.native
    def add(v: Vector): Vector = js.native
    def addVectors(a: Vector, b: Vector): Vector = js.native
    def sub(v: Vector): Vector = js.native
    def subVectors(a: Vector, b: Vector): Vector = js.native
    def multiplyScalar(s: Double): Vector = js.native
    def divideScalar(s: Double): Vector = js.native
    def negate(): Vector = js.native
    def dot(v: Vector): Double = js.native
    def lengthSq(): Double = js.native
    def length(): Double = js.native
    def normalize(): Vector = js.native
    def distanceTo(v: Vector): Double = js.native
    def distanceToSquared(v: Vector): Double = js.native
    def setLength(l: Double): Vector = js.native
    def lerp(v: Vector, alpha: Double): Vector = js.native
    def equals(v: Vector): Boolean = js.native
  }

  @js.native
  @JSName("THREE.Vector2")
  class Vector2 extends Vector {
    def this(x: Double = ???, y: Double = ???) = this()
    var x: Double = js.native
    var y: Double = js.native
    def set(x: Double, y: Double): Vector2 = js.native
    def setX(x: Double): Vector2 = js.native
    def setY(y: Double): Vector2 = js.native
    def copy(v: Vector2): Vector2 = js.native
    def add(v: Vector2): Vector2 = js.native
    def addScalar(s: Double): Vector2 = js.native
    def addVectors(a: Vector2, b: Vector2): Vector2 = js.native
    def sub(v: Vector2): Vector2 = js.native
    def subVectors(a: Vector2, b: Vector2): Vector2 = js.native
    def multiply(v: Vector2): Vector2 = js.native
    def divide(v: Vector2): Vector2 = js.native
    def min(v: Vector2): Vector2 = js.native
    def max(v: Vector2): Vector2 = js.native
    def clamp(min: Vector2, max: Vector2): Vector2 = js.native
    def clampScalar(min: Double, max: Double): Vector2 = js.native
    def floor(): Vector2 = js.native
    def ceil(): Vector2 = js.native
    def round(): Vector2 = js.native
    def roundToZero(): Vector2 = js.native
    def dot(v: Vector2): Double = js.native
    def distanceTo(v: Vector2): Double = js.native
    def distanceToSquared(v: Vector2): Double = js.native
    def lerp(v: Vector2, alpha: Double): Vector2 = js.native
    def lerpVectors(v1: Vector2, v2: Vector2, alpha: Double): Vector2 = js.native
    def equals(v: Vector2): Boolean = js.native
    def fromArray(xy: js.Array[Double], offset: Double = ???): Vector2 = js.native
    def toArray(xy: js.Array[Double] = ???, offset: Double = ???): js.Array[Double] = js.native
    def fromAttribute(attribute: BufferAttribute, index: Double, offset: Double = ???): Vector2 = js.native
  }

  @js.native
  @JSName("THREE.Vector3")
  class Vector3(var x: Double = js.native, var y: Double = js.native, var z: Double = js.native) extends Vector {
    def set(x: Double, y: Double, z: Double): Vector3 = js.native
    def setX(x: Double): Vector3 = js.native
    def setY(y: Double): Vector3 = js.native
    def setZ(z: Double): Vector3 = js.native
    def copy(v: Vector3): Vector3 = js.native
    def add(a: Vector3): Vector3 = js.native
    def addScalar(s: Double): Vector3 = js.native
    def addVectors(a: Vector3, b: Vector3): Vector3 = js.native
    def sub(a: Vector3): Vector3 = js.native
    def subScalar(s: Double): Vector3 = js.native
    def subVectors(a: Vector3, b: Vector3): Vector3 = js.native
    def multiply(v: Vector3): Vector3 = js.native
    def multiplyVectors(a: Vector3, b: Vector3): Vector3 = js.native
    def applyEuler(euler: Euler): Vector3 = js.native
    def applyAxisAngle(axis: Vector3, angle: Double): Vector3 = js.native
    def applyMatrix3(m: Matrix3): Vector3 = js.native
    def applyMatrix4(m: Matrix4): Vector3 = js.native
    def applyProjection(m: Matrix4): Vector3 = js.native
    def applyQuaternion(q: Quaternion): Vector3 = js.native
    def project(camrea: Camera): Vector3 = js.native
    def unproject(camera: Camera): Vector3 = js.native
    def transformDirection(m: Matrix4): Vector3 = js.native
    def divide(v: Vector3): Vector3 = js.native
    def min(v: Vector3): Vector3 = js.native
    def max(v: Vector3): Vector3 = js.native
    def clamp(min: Vector3, max: Vector3): Vector3 = js.native
    def clampScalar(min: Double, max: Double): Vector3 = js.native
    def floor(): Vector3 = js.native
    def ceil(): Vector3 = js.native
    def round(): Vector3 = js.native
    def roundToZero(): Vector3 = js.native
    def dot(v: Vector3): Double = js.native
    def lengthManhattan(): Double = js.native
    def lerp(v: Vector3, alpha: Double): Vector3 = js.native
    def lerpVectors(v1: Vector3, v2: Vector3, alpha: Double): Vector3 = js.native
    def cross(a: Vector3): Vector3 = js.native
    def crossVectors(a: Vector3, b: Vector3): Vector3 = js.native
    def projectOnVector(v: Vector3): Vector3 = js.native
    def projectOnPlane(planeNormal: Vector3): Vector3 = js.native
    def reflect(vector: Vector3): Vector3 = js.native
    def angleTo(v: Vector3): Double = js.native
    def distanceTo(v: Vector3): Double = js.native
    def distanceToSquared(v: Vector3): Double = js.native
    def setFromMatrixPosition(m: Matrix4): Vector3 = js.native
    def setFromMatrixScale(m: Matrix4): Vector3 = js.native
    def setFromMatrixColumn(index: Double, matrix: Matrix4): Vector3 = js.native
    def equals(v: Vector3): Boolean = js.native
    def fromArray(xyz: js.Array[Double], offset: Double = ???): Vector3 = js.native
    def toArray(xyz: js.Array[Double] = ???, offset: Double = ???): js.Array[Double] = js.native
    def fromAttribute(attribute: BufferAttribute, index: Double, offset: Double = ???): Vector3 = js.native
  }

  @js.native
  @JSName("THREE.Vector4")
  class Vector4(var x: Double, var y: Double, var z: Double, var w: Double) extends Vector {
    def set(x: Double, y: Double, z: Double, w: Double): Vector4 = js.native
    def setX(x: Double): Vector4 = js.native
    def setY(y: Double): Vector4 = js.native
    def setZ(z: Double): Vector4 = js.native
    def setW(w: Double): Vector4 = js.native
    def copy(v: Vector4): Vector4 = js.native
    def add(v: Vector4): Vector4 = js.native
    def addScalar(s: Double): Vector4 = js.native
    def addVectors(a: Vector4, b: Vector4): Vector4 = js.native
    def sub(v: Vector4): Vector4 = js.native
    def subScalar(s: Double): Vector4 = js.native
    def subVectors(a: Vector4, b: Vector4): Vector4 = js.native
    def applyMatrix4(m: Matrix4): Vector4 = js.native
    def setAxisAngleFromQuaternion(q: Quaternion): Vector4 = js.native
    def setAxisAngleFromRotationMatrix(m: Matrix3): Vector4 = js.native
    def min(v: Vector4): Vector4 = js.native
    def max(v: Vector4): Vector4 = js.native
    def clamp(min: Vector4, max: Vector4): Vector4 = js.native
    def clampScalar(min: Double, max: Double): Vector4 = js.native
    def floor(): Vector4 = js.native
    def ceil(): Vector4 = js.native
    def round(): Vector4 = js.native
    def roundToZero(): Vector4 = js.native
    def dot(v: Vector4): Double = js.native
    def lengthManhattan(): Double = js.native
    def lerp(v: Vector4, alpha: Double): Vector4 = js.native
    def lerpVectors(v1: Vector4, v2: Vector4, alpha: Double): Vector4 = js.native
    def equals(v: Vector4): Boolean = js.native
    def fromArray(xyzw: js.Array[Double], offset: Double = ???): Vector4 = js.native
    def toArray(xyzw: js.Array[Double] = ???, offset: Double = ???): js.Array[Double] = js.native
    def fromAttribute(attribute: BufferAttribute, index: Double, offset: Double = ???): Vector4 = js.native
  }

  @js.native
  @JSName("THREE.Bone")
  class Bone extends Object3D {
    def this(skin: SkinnedMesh) = this()
    var skin: SkinnedMesh = js.native
  }

  @js.native
  @JSName("THREE.Group")
  class Group extends Object3D {
  }

  @js.native
  trait LensFlareProperty extends js.Object {
    var texture: Texture = js.native
    var size: Double = js.native
    var distance: Double = js.native
    var x: Double = js.native
    var y: Double = js.native
    var z: Double = js.native
    var scale: Double = js.native
    var rotation: Double = js.native
    var opacity: Double = js.native
    var color: Color = js.native
    var blending: Blending = js.native
  }

  @js.native
  @JSName("THREE.LensFlare")
  class LensFlare(var texture: Texture = ???,var size: Double = ???,var distance: Double = ???,var blending: Blending = ???,var color: Color = ???) extends Object3D {
    var lensFlares: js.Array[LensFlareProperty] = js.native
    var positionScreen: Vector3 = js.native
    var customUpdateCallback: js.Function1[LensFlare, Unit] = js.native
    def add(texture: Texture, size: Double = ???, distance: Double = ???, blending: Blending = ???, color: Color = ???): Unit = js.native
    def updateLensFlares(): Unit = js.native
  }

  @js.native
  @JSName("THREE.Line")
  class Line[LM <: Material](geometry: Geometry = ???, material: LM = ???, mode: Double = ???) extends Object3D {
    //def this(geometry: Geometry = ???, material: LineDashedMaterial = ???, mode: Double = ???) = this()
    //def this(geometry: Geometry = ???, material: Material = ???, mode: Double = ???) = this()
//    var geometry: js.Any = js.native
//    var material: Material = js.native
//    var mode: LineMode = js.native
    def raycast(raycaster: Raycaster, intersects: js.Any): Unit = js.native
  }

  @js.native
  sealed trait LineMode extends js.Object {
  }

  @js.native
  @JSName("THREE.LineMode")
  object LineMode extends js.Object {
    @JSBracketAccess
    def apply(value: LineMode): String = js.native
  }

  @js.native
  @JSName("THREE.LOD")
  class LOD extends Object3D {
    var objects: js.Array[js.Any] = js.native
    def addLevel(`object`: Object3D, distance: Double = ???): Unit = js.native
    def getObjectForDistance(distance: Double): Object3D = js.native
    def raycast(raycaster: Raycaster, intersects: js.Any): Unit = js.native
    def update(camera: Camera): Unit = js.native
  }

  @js.native
  @JSName("THREE.Mesh")
  class Mesh[MT <: Material](var geometry: Geometry = ???,var material: MT = ???) extends Object3D {
//    def this(geometry: Geometry = ???, material: Material = ???) = this()
//    var geometry: Geometry = js.native
//    var material: Material = js.native
    def updateMorphTargets(): Unit = js.native
    def getMorphTargetIndexByName(name: String): Double = js.native
    def raycast(raycaster: Raycaster, intersects: js.Any): Unit = js.native
  }

  @js.native
  @JSName("THREE.MorphAnimMesh")
  class MorphAnimMesh extends Mesh {
    def this(geometry: Geometry = ???, material: MeshBasicMaterial = ???) = this()
    var duration: Double = js.native
    var mirroredLoop: Boolean = js.native
    var time: Double = js.native
    var lastKeyframe: Double = js.native
    var currentKeyframe: Double = js.native
    var direction: Double = js.native
    var directionBackwards: Boolean = js.native
    var startKeyframe: Double = js.native
    var endKeyframe: Double = js.native
    var length: Double = js.native
    def setFrameRange(start: Double, end: Double): Unit = js.native
    def setDirectionForward(): Unit = js.native
    def setDirectionBackward(): Unit = js.native
    def parseAnimations(): Unit = js.native
    def setAnimationLabel(label: String, start: Double, end: Double): Unit = js.native
    def playAnimation(label: String, fps: Double): Unit = js.native
    def updateAnimation(delta: Double): Unit = js.native
    def interpolateTargets(a: Double, b: Double, t: Double): Unit = js.native
  }

  @js.native
  @JSName("THREE.Skeleton")
  class Skeleton extends js.Object {
    def this(bones: js.Array[Bone], boneInverses: js.Array[Matrix4] = ???, useVertexTexture: Boolean = ???) = this()
    var useVertexTexture: Boolean = js.native
    var identityMatrix: Matrix4 = js.native
    var bones: js.Array[Bone] = js.native
    var boneTextureWidth: Double = js.native
    var boneTextureHeight: Double = js.native
    var boneMatrices: Float32Array = js.native
    var boneTexture: DataTexture = js.native
    var boneInverses: js.Array[Matrix4] = js.native
    def calculateInverses(bone: Bone): Unit = js.native
    def pose(): Unit = js.native
    def update(): Unit = js.native
  }

  @js.native
  @JSName("THREE.SkinnedMesh")
  class SkinnedMesh extends Mesh {
    //TODO: ver q onda
    //def this(geometry: Geometry | BufferGeometry = ???, material: MeshBasicMaterial = ???, useVertexTexture: Boolean = ???) = this()
//    def this(geometry: Geometry , material: MeshBasicMaterial = ???, useVertexTexture: Boolean = ???) = this()
    def this(geometry: BufferGeometry = ???, material: MeshBasicMaterial = ???, useVertexTexture: Boolean = ???) = this()

    var bindMode: String = js.native
    var bindMatrix: Matrix4 = js.native
    var bindMatrixInverse: Matrix4 = js.native
    def bind(skeleton: Skeleton, bindMatrix: Matrix4 = ???): Unit = js.native
    def pose(): Unit = js.native
    def normalizeSkinWeights(): Unit = js.native
    var skeleton: Skeleton = js.native
  }

  @js.native
  @JSName("THREE.Sprite")
  class Sprite extends Object3D {
    def this(material: Material = ???) = this()
    var geometry: BufferGeometry = js.native
    var material: SpriteMaterial = js.native
    def raycast(raycaster: Raycaster, intersects: js.Any): Unit = js.native
  }

  @js.native
  trait Renderer extends js.Object {
    def render(scene: Scene, camera: Camera): Unit = js.native
    def setSize(width: Double, height: Double, updateStyle: Boolean = ???): Unit = js.native
    var domElement: HTMLCanvasElement = js.native
  }

  @js.native
  trait WebGLRendererParameters extends js.Object {
    var canvas: HTMLCanvasElement = js.native
    var precision: String = js.native
    var alpha: Boolean = js.native
    var premultipliedAlpha: Boolean = js.native
    var antialias: Boolean = js.native
    var stencil: Boolean = js.native
    var preserveDrawingBuffer: Boolean = js.native
    var clearColor: Double = js.native
    var clearAlpha: Double = js.native
    var devicePixelRatio: Double = js.native
  }

  @js.native
  @JSName("THREE.WebGLRenderer")
  class WebGLRenderer extends Renderer {
    //def this(parameters: WebGLRendererParameters = ???) = this()
    def this(parameters: js.Dynamic = ???) = this()
    var context: js.Any = js.native
    var autoClear: Boolean = js.native
    var autoClearColor: Boolean = js.native
    var autoClearDepth: Boolean = js.native
    var autoClearStencil: Boolean = js.native
    var sortObjects: Boolean = js.native
    var gammaFactor: Double = js.native
    var gammaInput: Boolean = js.native
    var gammaOutput: Boolean = js.native
    var shadowMapEnabled: Boolean = js.native
    var shadowMapType: ShadowMapType = js.native
    var shadowMapCullFace: CullFace = js.native
    var shadowMapDebug: Boolean = js.native
    var shadowMapCascade: Boolean = js.native
    var maxMorphTargets: Double = js.native
    var maxMorphNormals: Double = js.native
    var autoScaleCubemaps: Boolean = js.native
    var info: js.Any = js.native
    var shadowMapPlugin: ShadowMapPlugin = js.native
    def getContext(): WebGLRenderingContext = js.native
    def forceContextLoss(): Unit = js.native
    def supportsVertexTextures(): Boolean = js.native
    def supportsFloatTextures(): Boolean = js.native
    def supportsStandardDerivatives(): Boolean = js.native
    def supportsCompressedTextureS3TC(): Boolean = js.native
    def supportsCompressedTexturePVRTC(): Boolean = js.native
    def supportsBlendMinMax(): Boolean = js.native
    def getMaxAnisotropy(): Double = js.native
    def getPrecision(): String = js.native
    def getPixelRatio(): Double = js.native
    def setPixelRatio(value: Double): Unit = js.native
    def setViewport(x: Double = ???, y: Double = ???, width: Double = ???, height: Double = ???): Unit = js.native
    def setScissor(x: Double, y: Double, width: Double, height: Double): Unit = js.native
    def enableScissorTest(enable: Boolean): Unit = js.native
    def setClearColor(color: Color, alpha: Double = ???): Unit = js.native
    def setClearAlpha(alpha: Double): Unit = js.native
    def setClearColorHex(hex: Double, alpha: Double): Unit = js.native
    def getClearColor(): Color = js.native
    def getClearAlpha(): Double = js.native
    def clear(color: Boolean = ???, depth: Boolean = ???, stencil: Boolean = ???): Unit = js.native
    def clearColor(): Unit = js.native
    def clearDepth(): Unit = js.native
    def clearStencil(): Unit = js.native
    def clearTarget(renderTarget: WebGLRenderTarget, color: Boolean, depth: Boolean, stencil: Boolean): Unit = js.native
    def resetGLState(): Unit = js.native
    def updateShadowMap(scene: Scene, camera: Camera): Unit = js.native
    def renderBufferImmediate(`object`: Object3D, program: Object, material: Material): Unit = js.native
    def renderBufferDirect(camera: Camera, lights: js.Array[Light], fog: Fog, material: Material, geometryGroup: js.Any, `object`: Object3D): Unit = js.native
    def renderBuffer(camera: Camera, lights: js.Array[Light], fog: Fog, material: Material, geometryGroup: js.Any, `object`: Object3D): Unit = js.native
    def render(scene: Scene, camera: Camera, renderTarget: RenderTarget = ???, forceClear: Boolean = ???): Unit = js.native
    def renderImmediateObject(camera: Camera, lights: js.Array[Light], fog: Fog, material: Material, `object`: Object3D): Unit = js.native
    def setFaceCulling(cullFace: CullFace = ???, frontFace: FrontFaceDirection = ???): Unit = js.native
    def setMaterialFaces(material: Material): Unit = js.native
    def setDepthTest(depthTest: Boolean): Unit = js.native
    def setDepthWrite(depthWrite: Boolean): Unit = js.native
    def setBlending(blending: Blending, blendEquation: BlendingEquation, blendSrc: BlendingSrcFactor, blendDst: BlendingDstFactor): Unit = js.native
    def uploadTexture(texture: Texture): Unit = js.native
    def setTexture(texture: Texture, slot: Double): Unit = js.native
    def setRenderTarget(renderTarget: RenderTarget): Unit = js.native
    def readRenderTargetPixels(renderTarget: RenderTarget, x: Double, y: Double, width: Double, height: Double, buffer: js.Any): Unit = js.native
  }

  @js.native
  trait RenderTarget extends js.Object {
  }

  @js.native
  trait WebGLRenderTargetOptions extends js.Object {
    var wrapS: Wrapping = js.native
    var wrapT: Wrapping = js.native
    var magFilter: TextureFilter = js.native
    var minFilter: TextureFilter = js.native
    var anisotropy: Double = js.native
    var format: Double = js.native
    var `type`: TextureDataType = js.native
    var depthBuffer: Boolean = js.native
    var stencilBuffer: Boolean = js.native
  }

  @js.native
  @JSName("THREE.WebGLRenderTarget")
  class WebGLRenderTarget extends RenderTarget {
    def this(width: Double, height: Double, options: WebGLRenderTargetOptions = ???) = this()
    var width: Double = js.native
    var height: Double = js.native
    var wrapS: Wrapping = js.native
    var wrapT: Wrapping = js.native
    var magFilter: TextureFilter = js.native
    var minFilter: TextureFilter = js.native
    var anisotropy: Double = js.native
    var offset: Vector2 = js.native
    var repeat: Vector2 = js.native
    var format: Double = js.native
    var `type`: Double = js.native
    var depthBuffer: Boolean = js.native
    var stencilBuffer: Boolean = js.native
    var generateMipmaps: Boolean = js.native
    var shareDepthFrom: js.Any = js.native
    def setSize(width: Double, height: Double): Unit = js.native
    def dispose(): Unit = js.native
    def addEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def hasEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def removeEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def dispatchEvent(event: js.Any): Unit = js.native
  }

  @js.native
  @JSName("THREE.WebGLRenderTargetCube")
  class WebGLRenderTargetCube extends WebGLRenderTarget {
    def this(width: Double, height: Double, options: WebGLRenderTargetOptions = ???) = this()
    var activeCubeFace: Double = js.native
  }

  @js.native
  trait ShaderChunk extends js.Object {
    @JSBracketAccess
    def apply(name: String): String = js.native
    @JSBracketAccess
    def update(name: String, v: String): Unit = js.native
    var common: String = js.native
    var alphamap_fragment: String = js.native
    var alphamap_pars_fragment: String = js.native
    var alphatest_fragment: String = js.native
    var bumpmap_pars_fragment: String = js.native
    var color_fragment: String = js.native
    var color_pars_fragment: String = js.native
    var color_pars_vertex: String = js.native
    var color_vertex: String = js.native
    var default_vertex: String = js.native
    var defaultnormal_vertex: String = js.native
    var envmap_fragment: String = js.native
    var envmap_pars_fragment: String = js.native
    var envmap_pars_vertex: String = js.native
    var envmap_vertex: String = js.native
    var fog_fragment: String = js.native
    var fog_pars_fragment: String = js.native
    var lightmap_fragment: String = js.native
    var lightmap_pars_fragment: String = js.native
    var lightmap_pars_vertex: String = js.native
    var lightmap_vertex: String = js.native
    var lights_lambert_pars_vertex: String = js.native
    var lights_lambert_vertex: String = js.native
    var lights_phong_fragment: String = js.native
    var lights_phong_pars_fragment: String = js.native
    var lights_phong_pars_vertex: String = js.native
    var lights_phong_vertex: String = js.native
    var linear_to_gamma_fragment: String = js.native
    var logdepthbuf_fragment: String = js.native
    var logdepthbuf_pars_fragment: String = js.native
    var logdepthbuf_pars_vertex: String = js.native
    var logdepthbuf_vertex: String = js.native
    var map_fragment: String = js.native
    var map_pars_fragment: String = js.native
    var map_pars_vertex: String = js.native
    var map_particle_fragment: String = js.native
    var map_particle_pars_fragment: String = js.native
    var map_vertex: String = js.native
    var morphnormal_vertex: String = js.native
    var morphtarget_pars_vertex: String = js.native
    var morphtarget_vertex: String = js.native
    var normalmap_pars_fragment: String = js.native
    var shadowmap_fragment: String = js.native
    var shadowmap_pars_fragment: String = js.native
    var shadowmap_pars_vertex: String = js.native
    var shadowmap_vertex: String = js.native
    var skinbase_vertex: String = js.native
    var skinning_pars_vertex: String = js.native
    var skinning_vertex: String = js.native
    var skinnormal_vertex: String = js.native
    var specularmap_fragment: String = js.native
    var specularmap_pars_fragment: String = js.native
    var worldpos_vertex: String = js.native
  }

  @js.native
  trait Shader[T] extends js.Object {
    var uniforms: T = js.native
    var vertexShader: String = js.native
    var fragmentShader: String = js.native
  }

  @js.native
  @JSName("THREE.ShaderLib")
  object ShaderLib extends js.Object {
    @JSBracketAccess
    def apply(name: String): Shader[_] = js.native
    @JSBracketAccess
    def update(name: String, v: Shader[_]): Unit = js.native
    var basic: Shader[_] = js.native
    var lambert: Shader[_] = js.native
    var phong: Shader[_] = js.native
    var particle_basic: Shader[_] = js.native
    var dashed: Shader[_] = js.native
    var depth: Shader[_] = js.native
    var normal: Shader[_] = js.native
    var normalmap: Shader[_] = js.native
    var cube: Shader[_] = js.native
    var equirect: Shader[_] = js.native
    var depthRGBA: Shader[_] = js.native
  }

  @js.native
  @JSName("THREE.UniformsLib")
  object UniformsLib extends js.Object {
    var common: js.Any = js.native
    var bump: js.Any = js.native
    var normalmap: js.Any = js.native
    var fog: js.Any = js.native
    var lights: js.Any = js.native
    var particle: js.Any = js.native
    var shadowmap: js.Any = js.native
  }

  @js.native
  @JSName("THREE.UniformsUtils")
  object UniformsUtils extends js.Object {
    def merge(uniforms: js.Array[js.Any]): js.Dynamic = js.native
  }

  @js.native
  @JSName("THREE.WebGLExtensions")
  class WebGLExtensions extends js.Object {
    def this(gl: js.Any) = this()
    def get(name: String): js.Dynamic = js.native
  }

  @js.native
  @JSName("THREE.WebGLProgram")
  class WebGLProgram extends js.Object {
    def this(renderer: WebGLRenderer, code: String, material: ShaderMaterial, parameters: WebGLRendererParameters) = this()
    var attributes: js.Any = js.native
    var attributesKeys: js.Array[String] = js.native
    var id: Double = js.native
    var code: String = js.native
    var usedTimes: Double = js.native
    var program: js.Any = js.native
    var vertexShader: WebGLShader = js.native
    var fragmentShader: WebGLShader = js.native
  }

  @js.native
  @JSName("THREE.WebGLShader")
  class WebGLShader extends js.Object {
    def this(gl: js.Any, `type`: String, string: String) = this()
  }

  @js.native
  trait WebGLStateInstance extends js.Object {
    /* ??? ConstructorMember(FunSignature(List(),List(FunParam(Ident(gl),false,Some(TypeRef(CoreType(any),List()))), FunParam(Ident(paramThreeToGL),false,Some(TypeRef(TypeName(Function),List())))),Some(TypeRef(CoreType(void),List())))) */
    def initAttributes(): Unit = js.native
    def enableAttribute(attribute: String): Unit = js.native
    def disableUnusedAttributes(): Unit = js.native
    def setBlending(blending: Double, blendEquation: Double, blendSrc: Double, blendDst: Double, blendEquationAlpha: Double, blendSrcAlpha: Double, blendDstAlpha: Double): Unit = js.native
    def setDepthTest(depthTest: Double): Unit = js.native
    def setDepthWrite(depthWrite: Double): Unit = js.native
    def setColorWrite(colorWrite: Double): Unit = js.native
    def setDoubleSided(doubleSided: Double): Unit = js.native
    def setFlipSided(flipSided: Double): Unit = js.native
    def setLineWidth(width: Double): Unit = js.native
    def setPolygonOffset(polygonoffset: Double, factor: Double, units: Double): Unit = js.native
    def reset(): Unit = js.native
  }

  @js.native
  trait WebGLStateStatic extends js.Object {
    def apply(gl: js.Any, paramThreeToGL: js.Function): WebGLStateInstance = js.native
  }

  @js.native
  trait WebGLTexturesInstance extends js.Object {
    /* ??? ConstructorMember(FunSignature(List(),List(FunParam(Ident(webgglcontext),false,Some(TypeRef(CoreType(any),List())))),Some(TypeRef(TypeName(WebGLTexturesInstance),List())))) */
    def get(texture: Texture): js.Dynamic = js.native
    def create(texture: Texture): js.Dynamic = js.native
    def delete(texture: Texture): Unit = js.native
  }

  @js.native
  trait WebGLTexturesStatic extends js.Object {
    def apply(webgglcontext: js.Any): WebGLTexturesInstance = js.native
  }

  @js.native
  trait RendererPlugin extends js.Object {
    def init(renderer: WebGLRenderer): Unit = js.native
    def render(scene: Scene, camera: Camera, currentWidth: Double, currentHeight: Double): Unit = js.native
  }

  @js.native
  @JSName("THREE.LensFlarePlugin")
  class LensFlarePlugin extends RendererPlugin {
    def init(renderer: Renderer): Unit = js.native
  }

  @js.native
  @JSName("THREE.ShadowMapPlugin")
  class ShadowMapPlugin extends RendererPlugin {
    def init(renderer: Renderer): Unit = js.native
    def render(scene: Scene, camera: Camera): Unit = js.native
    def update(scene: Scene, camera: Camera): Unit = js.native
  }

  @js.native
  @JSName("THREE.SpritePlugin")
  class SpritePlugin extends RendererPlugin {
    def init(renderer: Renderer): Unit = js.native
  }

  @js.native
  trait IFog extends js.Object {
    var name: String = js.native
    var color: Color = js.native
  }

  @js.native
  @JSName("THREE.Fog")
  class Fog extends IFog {
    def this(hex: Double, near: Double = ???, far: Double = ???) = this()
    var near: Double = js.native
    var far: Double = js.native
  }

  @js.native
  @JSName("THREE.FogExp2")
  class FogExp2 extends IFog {
    def this(hex: Double, density: Double = ???) = this()
    var density: Double = js.native
  }

  @js.native
  @JSName("THREE.Scene")
  class Scene extends Object3D {
    var fog: IFog = js.native
    var overrideMaterial: Material = js.native
    var autoUpdate: Boolean = js.native
  }

  @js.native
  @JSName("THREE.CompressedTexture")
  class CompressedTexture extends Texture {
    def this(mipmaps: js.Array[ImageData], width: Double, height: Double, format: PixelFormat = ???, `type`: TextureDataType = ???, mapping: Mapping = ???, wrapS: Wrapping = ???, wrapT: Wrapping = ???, magFilter: TextureFilter = ???, minFilter: TextureFilter = ???, anisotropy: Double = ???) = this()
  }

  @js.native
  @JSName("THREE.CubeTexture")
  class CubeTexture extends Texture {
    def this(images: js.Array[js.Any], mapping: Mapping = ???, wrapS: Wrapping = ???, wrapT: Wrapping = ???, magFilter: TextureFilter = ???, minFilter: TextureFilter = ???, format: PixelFormat = ???, `type`: TextureDataType = ???, anisotropy: Double = ???) = this()
    var images: js.Array[js.Any] = js.native
  }

  @js.native
  @JSName("THREE.DataTexture")
  class DataTexture extends Texture {
    def this(data: ImageData, width: Double, height: Double, format: PixelFormat, `type`: TextureDataType, mapping: Mapping, wrapS: Wrapping, wrapT: Wrapping, magFilter: TextureFilter, minFilter: TextureFilter, anisotropy: Double = ???) = this()
  }

  @js.native
  @JSName("THREE.Texture")
  class Texture extends js.Object {
    //TODO: ver q onda
    def this(image: HTMLImageElement , mapping: Mapping = ???, wrapS: Wrapping = ???, wrapT: Wrapping = ???, magFilter: TextureFilter = ???, minFilter: TextureFilter = ???, format: PixelFormat = ???, `type`: TextureDataType = ???, anisotropy: Double = ???) = this()
//    def this(image: HTMLCanvasElement, mapping: Mapping = ???, wrapS: Wrapping = ???, wrapT: Wrapping = ???, magFilter: TextureFilter = ???, minFilter: TextureFilter = ???, format: PixelFormat = ???, `type`: TextureDataType = ???, anisotropy: Double = ???) = this()
//    def this(image: HTMLVideoElement, mapping: Mapping = ???, wrapS: Wrapping = ???, wrapT: Wrapping = ???, magFilter: TextureFilter = ???, minFilter: TextureFilter = ???, format: PixelFormat = ???, `type`: TextureDataType = ???, anisotropy: Double = ???) = this()

    var id: Double = js.native
    var uuid: String = js.native
    var name: String = js.native
    var sourceFile: String = js.native
    var image: js.Any = js.native
    var mipmaps: js.Array[ImageData] = js.native
    var mapping: Mapping = js.native
    var wrapS: Wrapping = js.native
    var wrapT: Wrapping = js.native
    var magFilter: TextureFilter = js.native
    var minFilter: TextureFilter = js.native
    var anisotropy: Double = js.native
    var format: PixelFormat = js.native
    var `type`: TextureDataType = js.native
    var offset: Vector2 = js.native
    var repeat: Vector2 = js.native
    var generateMipmaps: Boolean = js.native
    var premultiplyAlpha: Boolean = js.native
    var flipY: Boolean = js.native
    var unpackAlignment: Double = js.native
    var needsUpdate: Boolean = js.native
    var onUpdate: js.Function0[Unit] = js.native
    def update(): Unit = js.native
    def dispose(): Unit = js.native
    def addEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def hasEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def removeEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def dispatchEvent(event: js.Any): Unit = js.native
  }

  @js.native
  @JSName("THREE.Texture")
  object Texture extends js.Object {
    var DEFAULT_IMAGE: js.Any = js.native
    var DEFAULT_MAPPING: js.Any = js.native
  }

  @js.native
  @JSName("THREE.VideoTexture")
  class VideoTexture extends Texture {
    def this(video: HTMLVideoElement, mapping: Mapping = ???, wrapS: Wrapping = ???, wrapT: Wrapping = ???, magFilter: TextureFilter = ???, minFilter: TextureFilter = ???, format: PixelFormat = ???, `type`: TextureDataType = ???, anisotropy: Double = ???) = this()
  }

  @js.native
  trait TypefaceData extends js.Object {
    var familyName: String = js.native
    var cssFontWeight: String = js.native
    var cssFontStyle: String = js.native
  }

  @js.native
  @JSName("THREE.FontUtils")
  object FontUtils extends js.Object {
    var faces: js.Dictionary[js.Dictionary[Face3]] = js.native
    var face: String = js.native
    var weight: String = js.native
    var style: String = js.native
    var size: Double = js.native
    var divisions: Double = js.native
    def getFace(): Face3 = js.native
    def loadFace(data: TypefaceData): TypefaceData = js.native
    def drawText(text: String): js.Any = js.native
    def extractGlyphPoints(c: String, face: Face3, scale: Double, offset: Double, path: Path): js.Any = js.native
    def generateShapes(text: String, parameters: js.Any = ???): js.Array[Shape] = js.native
    var Triangulate: js.Any = js.native
  }

  @js.native
  @JSName("THREE.GeometryUtils")
  object GeometryUtils extends js.Object {
    def merge(geometry1: Geometry, object2: Mesh[_], materialIndexOffset: Double = ???): Unit = js.native
    def center(geometry: Geometry): Vector3 = js.native
  }

  @js.native
  @JSName("THREE.ImageUtils")
  object ImageUtils extends js.Object {
    var crossOrigin: String = js.native
    def loadTexture(url: String, mapping: Mapping = ???, onLoad: js.Function1[Texture, Unit] = ???, onError: js.Function1[String, Unit] = ???): Texture = js.native
    def loadTextureCube(array: js.Array[String], mapping: Mapping = ???, onLoad: js.Function1[Texture, Unit] = ???, onError: js.Function1[String, Unit] = ???): Texture = js.native
    def getNormalMap(image: HTMLImageElement, depth: Double = ???): HTMLCanvasElement = js.native
    def generateDataTexture(width: Double, height: Double, color: Color): DataTexture = js.native
  }

  @js.native
  @JSName("THREE.SceneUtils")
  object SceneUtils extends js.Object {
    def createMultiMaterialObject(geometry: Geometry, materials: js.Array[Material]): Object3D = js.native
    def detach(child: Object3D, parent: Object3D, scene: Scene): Unit = js.native
    def attach(child: Object3D, scene: Scene, parent: Object3D): Unit = js.native
  }

  @js.native
  trait KeyFrame extends js.Object {
    var pos: js.Array[Double] = js.native
    var rot: js.Array[Double] = js.native
    var scl: js.Array[Double] = js.native
    var time: Double = js.native
  }

  @js.native
  trait KeyFrames extends js.Object {
    var keys: js.Array[KeyFrame] = js.native
    var parent: Double = js.native
  }

  @js.native
  trait AnimationData extends js.Object {
    var JIT: Double = js.native
    var fps: Double = js.native
    var hierarchy: js.Array[KeyFrames] = js.native
    var length: Double = js.native
    var name: String = js.native
  }

  @js.native
  @JSName("THREE.Animation")
  class Animation extends js.Object {
    def this(root: Mesh[_], data: AnimationData) = this()
    var root: Mesh[_] = js.native
    var data: AnimationData = js.native
    var hierarchy: js.Array[Bone] = js.native
    var currentTime: Double = js.native
    var timeScale: Double = js.native
    var isPlaying: Boolean = js.native
    var loop: Boolean = js.native
    var weight: Double = js.native
    var interpolationType: Double = js.native
    def play(startTime: Double = ???, weight: Double = ???): Unit = js.native
    def stop(): Unit = js.native
    def reset(): Unit = js.native
    def resetBlendWeights(): Unit = js.native
    def update(delta: Double): Unit = js.native
    def getNextKeyWith(`type`: String, h: Double, key: Double): KeyFrame = js.native
    def getPrevKeyWith(`type`: String, h: Double, key: Double): KeyFrame = js.native
  }

  @js.native
  @JSName("THREE.AnimationHandler")
  object AnimationHandler extends js.Object {
    var LINEAR: Double = js.native
    var CATMULLROM: Double = js.native
    var CATMULLROM_FORWARD: Double = js.native
    var animations: js.Array[js.Any] = js.native
    def init(data: AnimationData): AnimationData = js.native
    def parse(root: Mesh[_]): js.Array[Object3D] = js.native
    def play(animation: Animation): Unit = js.native
    def stop(animation: Animation): Unit = js.native
    def update(deltaTimeMS: Double): Unit = js.native
  }

  @js.native
  @JSName("THREE.KeyFrameAnimation")
  class KeyFrameAnimation extends js.Object {
    def this(data: js.Any) = this()
    var root: Mesh[_] = js.native
    var data: AnimationData = js.native
    var hierarchy: js.Array[KeyFrames] = js.native
    var currentTime: Double = js.native
    var timeScale: Double = js.native
    var isPlaying: Boolean = js.native
    var isPaused: Boolean = js.native
    var loop: Boolean = js.native
    def play(startTime: Double = ???): Unit = js.native
    def stop(): Unit = js.native
    def update(delta: Double): Unit = js.native
    def getNextKeyWith(`type`: String, h: Double, key: Double): KeyFrame = js.native
    def getPrevKeyWith(`type`: String, h: Double, key: Double): KeyFrame = js.native
  }

  @js.native
  @JSName("THREE.MorphAnimation")
  class MorphAnimation extends js.Object {
    def this(mesh: Mesh[_]) = this()
    var mesh: Mesh[_] = js.native
    var frames: Double = js.native
    var currentTime: Double = js.native
    var duration: Double = js.native
    var loop: Boolean = js.native
    var lastFrame: Double = js.native
    var currentFrame: Double = js.native
    var isPlaying: Boolean = js.native
    def play(): Unit = js.native
    def pause(): Unit = js.native
    def update(delta: Double): Unit = js.native
  }

  @js.native
  @JSName("THREE.Audio")
  class Audio extends Object3D {
    def this(listener: AudioListener) = this()
    //TODO: VER Q ONDA !
    //  var context: AudioContext = js.native
    //  var source: AudioBufferSourceNode = js.native
    //  var gain: GainNode = js.native
    //  var panner: PannerNode = js.native
    var autoplay: Boolean = js.native
    var startTime: Double = js.native
    var isPlaying: Boolean = js.native
    def load(file: String): Audio = js.native
    def play(): Unit = js.native
    def pause(): Unit = js.native
    def stop(): Unit = js.native
    def setLoop(value: Boolean): Unit = js.native
    def setRefDistance(value: Double): Unit = js.native
    def setRolloffFactor(value: Double): Unit = js.native
    def setVolume(value: Double): Unit = js.native
  }

  @js.native
  @JSName("THREE.AudioListener")
  class AudioListener extends Object3D {
    //TODO: VER Q ONDA !
    //var context: AudioContext = js.native
  }

  @js.native
  @JSName("THREE.Curve")
  class Curve[T <: Vector] extends js.Object {
    def getPoint(t: Double): T = js.native
    def getPointAt(u: Double): T = js.native
    def getPoints(divisions: Double = ???): js.Array[T] = js.native
    def getSpacedPoints(divisions: Double = ???): js.Array[T] = js.native
    def getLength(): Double = js.native
    def getLengths(divisions: Double = ???): js.Array[Double] = js.native
    def updateArcLengths(): Unit = js.native
    def getUtoTmapping(u: Double, distance: Double): Double = js.native
    def getTangent(t: Double): T = js.native
    def getTangentAt(u: Double): T = js.native
  }

  @js.native
  @JSName("THREE.Curve")
  object Curve extends js.Object {
    var Utils: js.Any = js.native
    def create(constructorFunc: js.Function, getPointFunc: js.Function): js.Function = js.native
  }

  @js.native
  trait BoundingBox extends js.Object {
    var minX: Double = js.native
    var minY: Double = js.native
    var minZ: Double = js.native
    var maxX: Double = js.native
    var maxY: Double = js.native
    var maxZ: Double = js.native
  }

  @js.native
  @JSName("THREE.CurvePath")
  class CurvePath[T <: Vector] extends Curve[T] {
    var curves: js.Array[Curve[T]] = js.native
    var bends: js.Array[Path] = js.native
    var autoClose: Boolean = js.native
    def add(curve: Curve[T]): Unit = js.native
    def checkConnection(): Boolean = js.native
    def closePath(): Unit = js.native
    def getCurveLengths(): js.Array[Double] = js.native
    def getBoundingBox(): BoundingBox = js.native
    def createPointsGeometry(divisions: Double): Geometry = js.native
    def createSpacedPointsGeometry(divisions: Double): Geometry = js.native
    def createGeometry(points: js.Array[T]): Geometry = js.native
    def addWrapPath(bendpath: Path): Unit = js.native
    def getTransformedPoints(segments: Double, bends: js.Array[Path] = ???): js.Array[T] = js.native
    def getTransformedSpacedPoints(segments: Double, bends: js.Array[Path] = ???): js.Array[T] = js.native
    def getWrapPoints(oldPts: js.Array[T], path: Path): js.Array[T] = js.native
  }

  @js.native
  @JSName("THREE.Gyroscope")
  class Gyroscope extends Object3D {
  }

  @js.native
  sealed trait PathActions extends js.Object {
  }

  @js.native
  @JSName("THREE.PathActions")
  object PathActions extends js.Object {
    var MOVE_TO: PathActions = js.native
    var LINE_TO: PathActions = js.native
    var QUADRATIC_CURVE_TO: PathActions = js.native
    var BEZIER_CURVE_TO: PathActions = js.native
    var CSPLINE_THRU: PathActions = js.native
    var ARC: PathActions = js.native
    var ELLIPSE: PathActions = js.native
    @JSBracketAccess
    def apply(value: PathActions): String = js.native
  }

  @js.native
  trait PathAction extends js.Object {
    var action: PathActions = js.native
    var args: js.Any = js.native
  }

  @js.native
  @JSName("THREE.Path")
  class Path extends CurvePath[Vector2] {
    def this(points: js.Array[Vector2] = ???) = this()
    var actions: js.Array[PathAction] = js.native
    def fromPoints(vectors: js.Array[Vector2]): Unit = js.native
    def moveTo(x: Double, y: Double): Unit = js.native
    def lineTo(x: Double, y: Double): Unit = js.native
    def quadraticCurveTo(aCPx: Double, aCPy: Double, aX: Double, aY: Double): Unit = js.native
    def bezierCurveTo(aCP1x: Double, aCP1y: Double, aCP2x: Double, aCP2y: Double, aX: Double, aY: Double): Unit = js.native
    def splineThru(pts: js.Array[Vector2]): Unit = js.native
    def arc(aX: Double, aY: Double, aRadius: Double, aStartAngle: Double, aEndAngle: Double, aClockwise: Boolean): Unit = js.native
    def absarc(aX: Double, aY: Double, aRadius: Double, aStartAngle: Double, aEndAngle: Double, aClockwise: Boolean): Unit = js.native
    def ellipse(aX: Double, aY: Double, xRadius: Double, yRadius: Double, aStartAngle: Double, aEndAngle: Double, aClockwise: Boolean): Unit = js.native
    def absellipse(aX: Double, aY: Double, xRadius: Double, yRadius: Double, aStartAngle: Double, aEndAngle: Double, aClockwise: Boolean): Unit = js.native
    //TODO: ver q onda
    //def getSpacedPoints(divisions: Double = ???, closedPath: Boolean = ???): js.Array[Vector2] = js.native
    //TODO: ver q onda
    //def getPoints(divisions: Double = ???, closedPath: Boolean = ???): js.Array[Vector2] = js.native
    def toShapes(): js.Array[Shape] = js.native
  }

  @js.native
  @JSName("THREE.Shape")
  class Shape(points: js.Array[Vector2] = ???) extends Path {
    //def this(points: js.Array[Vector2] = ???) = this()
    var holes: js.Array[Path] = js.native
    def extrude(options: js.Any = ???): ExtrudeGeometry = js.native
    def makeGeometry(options: js.Any = ???): ShapeGeometry = js.native
    def getPointsHoles(divisions: Double): js.Array[js.Array[Vector2]] = js.native
    //TODO: ver q onda
    //def getSpacedPointsHoles(divisions: Double): js.Array[js.Array[Vector2]] = js.native
    def extractAllPoints(divisions: Double): js.Any = js.native
    def extractPoints(divisions: Double): js.Array[Vector2] = js.native
    def extractAllSpacedPoints(divisions: Vector2): js.Any = js.native
  }

  @js.native
  @JSName("THREE.ArcCurve")
  class ArcCurve extends EllipseCurve {
    def this(aX: Double, aY: Double, aRadius: Double, aStartAngle: Double, aEndAngle: Double, aClockwise: Boolean) = this()
  }

  @js.native
  @JSName("THREE.ClosedSplineCurve3")
  class ClosedSplineCurve3 extends Curve[Vector3] {
    def this(points: js.Array[Vector3] = ???) = this()
    var points: js.Array[Vector3] = js.native
  }

  @js.native
  @JSName("THREE.CubicBezierCurve")
  class CubicBezierCurve extends Curve[Vector2] {
    def this(v0: Vector2, v1: Vector2, v2: Vector2, v3: Vector2) = this()
    var v0: Vector2 = js.native
    var v1: Vector2 = js.native
    var v2: Vector2 = js.native
    var v3: Vector2 = js.native
  }

  @js.native
  @JSName("THREE.CubicBezierCurve3")
  class CubicBezierCurve3 extends Curve[Vector3] {
    def this(v0: Vector3, v1: Vector3, v2: Vector3, v3: Vector3) = this()
    var v0: Vector3 = js.native
    var v1: Vector3 = js.native
    var v2: Vector3 = js.native
    var v3: Vector3 = js.native
  }

  @js.native
  @JSName("THREE.EllipseCurve")
  class EllipseCurve extends Curve[Vector2] {
    def this(aX: Double, aY: Double, xRadius: Double, yRadius: Double, aStartAngle: Double, aEndAngle: Double, aClockwise: Boolean) = this()
    var aX: Double = js.native
    var aY: Double = js.native
    var xRadius: Double = js.native
    var yRadius: Double = js.native
    var aStartAngle: Double = js.native
    var aEndAngle: Double = js.native
    var aClockwise: Boolean = js.native
  }

  @js.native
  @JSName("THREE.LineCurve")
  class LineCurve extends Curve[Vector2] {
    def this(v1: Vector2, v2: Vector2) = this()
    var v1: Vector2 = js.native
    var v2: Vector2 = js.native
  }

  @js.native
  @JSName("THREE.LineCurve3")
  class LineCurve3 extends Curve[Vector3] {
    def this(v1: Vector3, v2: Vector3) = this()
    var v1: Vector3 = js.native
    var v2: Vector3 = js.native
  }

  @js.native
  @JSName("THREE.QuadraticBezierCurve")
  class QuadraticBezierCurve extends Curve[Vector2] {
    def this(v0: Vector2, v1: Vector2, v2: Vector2) = this()
    var v0: Vector2 = js.native
    var v1: Vector2 = js.native
    var v2: Vector2 = js.native
  }

  @js.native
  @JSName("THREE.QuadraticBezierCurve3")
  class QuadraticBezierCurve3 extends Curve[Vector3] {
    def this(v0: Vector3, v1: Vector3, v2: Vector3) = this()
    var v0: Vector3 = js.native
    var v1: Vector3 = js.native
    var v2: Vector3 = js.native
  }

  @js.native
  @JSName("THREE.SplineCurve")
  class SplineCurve extends Curve[Vector2] {
    def this(points: js.Array[Vector2] = ???) = this()
    var points: js.Array[Vector2] = js.native
  }

  @js.native
  @JSName("THREE.SplineCurve3")
  class SplineCurve3(points: js.Array[Vector3] = ???) extends Curve[Vector3] {
    //var points: js.Array[Vector3] = js.native
  }

  @js.native
  @JSName("THREE.BoxGeometry")
  class BoxGeometry extends Geometry {
    def this(width: Double, height: Double, depth: Double, widthSegments: Double = ???, heightSegments: Double = ???, depthSegments: Double = ???) = this()
    var parameters: js.Any = js.native
  }

  @js.native
  @JSName("THREE.CircleGeometry")
  class CircleGeometry extends Geometry {
    def this(radius: Double = ???, segments: Double = ???, thetaStart: Double = ???, thetaLength: Double = ???) = this()
    var parameters: js.Any = js.native
  }

  @js.native
  @JSName("THREE.CubeGeometry")
  class CubeGeometry extends BoxGeometry {
  }

  @js.native
  @JSName("THREE.CylinderGeometry")
  class CylinderGeometry extends Geometry {
    def this(radiusTop: Double = ???, radiusBottom: Double = ???, height: Double = ???, radiusSegments: Double = ???, heightSegments: Double = ???, openEnded: Boolean = ???, thetaStart: Double = ???, thetaLength: Double = ???) = this()
    var parameters: js.Any = js.native
  }

  @js.native
  @JSName("THREE.DodecahedronGeometry")
  class DodecahedronGeometry extends Geometry {
    def this(radius: Double, detail: Double) = this()
    var parameters: js.Any = js.native
  }

  @js.native
  @JSName("THREE.ExtrudeGeometry")
  class ExtrudeGeometry extends Geometry {
    //TODO: ver q onda
    def this(shape: Shape = ???, options: js.Any = ???) = this()
    //def this(shapes: js.Array[Shape] = ???, options: js.Any = ???) = this()
    var WorldUVGenerator: js.Any = js.native
    def addShapeList(shapes: js.Array[Shape], options: js.Any = ???): Unit = js.native
    def addShape(shape: Shape, options: js.Any = ???): Unit = js.native
  }

  @js.native
  @JSName("THREE.IcosahedronGeometry")
  class IcosahedronGeometry extends PolyhedronGeometry {
    def this(radius: Double, detail: Double) = this()
  }

  @js.native
  @JSName("THREE.LatheGeometry")
  class LatheGeometry extends Geometry {
    def this(points: js.Array[Vector3], segments: Double = ???, phiStart: Double = ???, phiLength: Double = ???) = this()
    var parameters: js.Any = js.native
  }

  @js.native
  @JSName("THREE.OctahedronGeometry")
  class OctahedronGeometry extends PolyhedronGeometry {
    def this(radius: Double, detail: Double) = this()
  }

  @js.native
  @JSName("THREE.ParametricGeometry")
  class ParametricGeometry extends Geometry {
    def this(func: js.Function2[Double, Double, Vector3], slices: Double, stacks: Double) = this()
    var parameters: js.Any = js.native
  }

  @js.native
  @JSName("THREE.PlaneBufferGeometry")
  class PlaneBufferGeometry extends BufferGeometry {
    def this(width: Double, height: Double, widthSegments: Double = ???, heightSegments: Double = ???) = this()
    var parameters: js.Any = js.native
  }

  @js.native
  @JSName("THREE.PlaneGeometry")
  class PlaneGeometry extends Geometry {
    def this(width: Double,height: Double,widthSegments: Double = ???,heightSegments: Double = ???) = this()
    var parameters: js.Any = js.native
  }

  @js.native
  @JSName("THREE.PolyhedronGeometry")
  class PolyhedronGeometry extends Geometry {
    def this(vertices: js.Array[Vector3], faces: js.Array[Face3], radius: Double = ???, detail: Double = ???) = this()
    var parameters: js.Any = js.native
  }

  @js.native
  @JSName("THREE.RingGeometry")
  class RingGeometry extends Geometry {
    def this(innerRadius: Double = ???, outerRadius: Double = ???, thetaSegments: Double = ???, phiSegments: Double = ???, thetaStart: Double = ???, thetaLength: Double = ???) = this()
    var parameters: js.Any = js.native
  }

  @js.native
  @JSName("THREE.ShapeGeometry")
  class ShapeGeometry extends Geometry {
    //TODO: ver q onda
    def this(shape: Shape, options: js.Any = ???) = this()
    //def this(shapes: js.Array[Shape], options: js.Any = ???) = this()
    def addShapeList(shapes: js.Array[Shape], options: js.Any): ShapeGeometry = js.native
    def addShape(shape: Shape, options: js.Any = ???): Unit = js.native
  }

  @js.native
  @JSName("THREE.SphereGeometry")
  class SphereGeometry extends Geometry {
    def this(radius: Double, widthSegments: Double = ???, heightSegments: Double = ???, phiStart: Double = ???, phiLength: Double = ???, thetaStart: Double = ???, thetaLength: Double = ???) = this()
    var parameters: js.Any = js.native
  }

  @js.native
  @JSName("THREE.TetrahedronGeometry")
  class TetrahedronGeometry extends PolyhedronGeometry {
    def this(radius: Double = ???, detail: Double = ???) = this()
  }

  @js.native
  trait TextGeometryParameters extends js.Object {
    var size: Double = js.native
    var height: Double = js.native
    var curveSegments: Double = js.native
    var font: String = js.native
    var weight: String = js.native
    var style: String = js.native
    var bevelEnabled: Boolean = js.native
    var bevelThickness: Double = js.native
    var bevelSize: Double = js.native
  }

  @js.native
  @JSName("THREE.TextGeometry")
  class TextGeometry extends ExtrudeGeometry {
    def this(text: String, TextGeometryParameters: TextGeometryParameters = ???) = this()
  }

  @js.native
  @JSName("THREE.TorusGeometry")
  class TorusGeometry extends Geometry {
    def this(radius: Double = ???, tube: Double = ???, radialSegments: Double = ???, tubularSegments: Double = ???, arc: Double = ???) = this()
    var parameters: js.Any = js.native
  }

  @js.native
  @JSName("THREE.TorusKnotGeometry")
  class TorusKnotGeometry extends Geometry {
    def this(radius: Double = ???, tube: Double = ???, radialSegments: Double = ???, tubularSegments: Double = ???, p: Double = ???, q: Double = ???, heightScale: Double = ???) = this()
    var parameters: js.Any = js.native
  }

  @js.native
  @JSName("THREE.TubeGeometry")
  class TubeGeometry extends Geometry {
    def this(path: Path, segments: Double = ???, radius: Double = ???, radiusSegments: Double = ???, closed: Boolean = ???, taper: js.Function1[Double, Double] = ???) = this()
    var parameters: js.Any = js.native
    var tangents: js.Array[Vector3] = js.native
    var normals: js.Array[Vector3] = js.native
    var binormals: js.Array[Vector3] = js.native
  }

  @js.native
  @JSName("THREE.TubeGeometry")
  object TubeGeometry extends js.Object {
    def NoTaper(u: Double = ???): Double = js.native
    def SinusoidalTaper(u: Double): Double = js.native
    def FrenetFrames(path: Path, segments: Double, closed: Boolean): Unit = js.native
  }

  @js.native
  @JSName("THREE.ArrowHelper")
  class ArrowHelper extends Object3D {
    def this(dir: Vector3, origin: Vector3 = ???, length: Double = ???, hex: Double = ???, headLength: Double = ???, headWidth: Double = ???) = this()
    var line: Line[_] = js.native
    var cone: Mesh[_] = js.native
    def setDirection(dir: Vector3): Unit = js.native
    def setLength(length: Double, headLength: Double = ???, headWidth: Double = ???): Unit = js.native
    def setColor(hex: Double): Unit = js.native
  }

  @js.native
  @JSName("THREE.AxisHelper")
  class AxisHelper extends Line {
    def this(size: Double = ???) = this()
  }

  @js.native
  @JSName("THREE.BoundingBoxHelper")
  class BoundingBoxHelper extends Mesh {
    def this(`object`: Object3D = ???, hex: Double = ???) = this()
    var `object`: Object3D = js.native
    var box: Box3 = js.native
    def update(): Unit = js.native
  }

  @js.native
  @JSName("THREE.BoxHelper")
  class BoxHelper extends Line {
    def this(`object`: Object3D = ???) = this()
    def update(`object`: Object3D = ???): Unit = js.native
  }

  @js.native
  @JSName("THREE.CameraHelper")
  class CameraHelper extends Line {
    def this(camera: Camera) = this()
    var camera: Camera = js.native
    var pointMap: js.Dictionary[js.Array[Double]] = js.native
    def update(): Unit = js.native
  }

  @js.native
  @JSName("THREE.DirectionalLightHelper")
  class DirectionalLightHelper extends Object3D {
    def this(light: Light, size: Double = ???) = this()
    var light: Light = js.native
    var lightPlane: Line[_] = js.native
    var targetLine: Line[_] = js.native
    def dispose(): Unit = js.native
    def update(): Unit = js.native
  }

  @js.native
  @JSName("THREE.EdgesHelper")
  class EdgesHelper extends Line {
    def this(`object`: Object3D, hex: Double = ???, thresholdAngle: Double = ???) = this()
  }

  @js.native
  @JSName("THREE.FaceNormalsHelper")
  class FaceNormalsHelper extends Line {
    def this(`object`: Object3D, size: Double = ???, hex: Double = ???, linewidth: Double = ???) = this()
    var `object`: Object3D = js.native
    var size: Double = js.native
    var normalMatrix: Matrix3 = js.native
    def update(`object`: Object3D = ???): Unit = js.native
  }

  @js.native
  @JSName("THREE.GridHelper")
  class GridHelper extends Line {
    def this(size: Double, step: Double) = this()
    var color1: Color = js.native
    var color2: Color = js.native
    def setColors(colorCenterLine: Double, colorGrid: Double): Unit = js.native
  }

  @js.native
  @JSName("THREE.HemisphereLightHelper")
  class HemisphereLightHelper extends Object3D {
    def this(light: Light, sphereSize: Double) = this()
    var light: Light = js.native
    var colors: js.Array[Color] = js.native
    var lightSphere: Mesh[_] = js.native
    def dispose(): Unit = js.native
    def update(): Unit = js.native
  }

  @js.native
  @JSName("THREE.PointLightHelper")
  class PointLightHelper extends Object3D {
    def this(light: Light, sphereSize: Double) = this()
    var light: Light = js.native
    def dispose(): Unit = js.native
    def update(): Unit = js.native
  }

  @js.native
  @JSName("THREE.SkeletonHelper")
  class SkeletonHelper extends Line {
    def this(bone: Object3D) = this()
    var bones: js.Array[Bone] = js.native
    var root: Object3D = js.native
    def getBoneList(`object`: Object3D): js.Array[Bone] = js.native
    def update(): Unit = js.native
  }

  @js.native
  @JSName("THREE.SpotLightHelper")
  class SpotLightHelper extends Object3D {
    def this(light: Light, sphereSize: Double, arrowLength: Double) = this()
    var light: Light = js.native
    var cone: Mesh[_] = js.native
    def dispose(): Unit = js.native
    def update(): Unit = js.native
  }

  @js.native
  @JSName("THREE.VertexNormalsHelper")
  class VertexNormalsHelper extends Line {
    def this(`object`: Object3D, size: Double = ???, hex: Double = ???, linewidth: Double = ???) = this()
    var `object`: Object3D = js.native
    var size: Double = js.native
    var normalMatrix: Matrix3 = js.native
    def update(`object`: Object3D = ???): Unit = js.native
  }

  @js.native
  @JSName("THREE.VertexTangentsHelper")
  class VertexTangentsHelper extends Line {
    def this(`object`: Object3D, size: Double = ???, hex: Double = ???, linewidth: Double = ???) = this()
    var `object`: Object3D = js.native
    var size: Double = js.native
    def update(`object`: Object3D = ???): Unit = js.native
  }

  @js.native
  @JSName("THREE.WireframeHelper")
  class WireframeHelper extends Line {
    def this(`object`: Object3D, hex: Double = ???) = this()
  }

  @js.native
  @JSName("THREE.ImmediateRenderObject")
  class ImmediateRenderObject extends Object3D {
    def render(renderCallback: js.Function): Unit = js.native
  }

  @js.native
  trait MorphBlendMeshAnimation extends js.Object {
    var startFrame: Double = js.native
    var endFrame: Double = js.native
    var length: Double = js.native
    var fps: Double = js.native
    var duration: Double = js.native
    var lastFrame: Double = js.native
    var currentFrame: Double = js.native
    var active: Boolean = js.native
    var time: Double = js.native
    var direction: Double = js.native
    var weight: Double = js.native
    var directionBackwards: Boolean = js.native
    var mirroredLoop: Boolean = js.native
  }

  @js.native
  @JSName("THREE.MorphBlendMesh")
  class MorphBlendMesh extends Mesh {
    def this(geometry: Geometry, material: Material) = this()
    var animationsMap: js.Dictionary[MorphBlendMeshAnimation] = js.native
    var animationsList: js.Array[MorphBlendMeshAnimation] = js.native
    def createAnimation(name: String, start: Double, end: Double, fps: Double): Unit = js.native
    def autoCreateAnimations(fps: Double): Unit = js.native
    def setAnimationDirectionForward(name: String): Unit = js.native
    def setAnimationDirectionBackward(name: String): Unit = js.native
    def setAnimationFPS(name: String, fps: Double): Unit = js.native
    def setAnimationDuration(name: String, duration: Double): Unit = js.native
    def setAnimationWeight(name: String, weight: Double): Unit = js.native
    def setAnimationTime(name: String, time: Double): Unit = js.native
    def getAnimationTime(name: String): Double = js.native
    def getAnimationDuration(name: String): Double = js.native
    def playAnimation(name: String): Unit = js.native
    def stopAnimation(name: String): Unit = js.native
    def update(delta: Double): Unit = js.native
  }

  @js.native
  @JSName("THREE.RenderableObject")
  class RenderableObject extends js.Object {
    var id: Double = js.native
    var `object`: Object = js.native
    var z: Double = js.native
  }

  @js.native
  @JSName("THREE.RenderableFace")
  class RenderableFace extends js.Object {
    var id: Double = js.native
    var v1: RenderableVertex = js.native
    var v2: RenderableVertex = js.native
    var v3: RenderableVertex = js.native
    var normalModel: Vector3 = js.native
    var vertexNormalsModel: js.Array[Vector3] = js.native
    var vertexNormalsLength: Double = js.native
    var color: Color = js.native
    var material: Material = js.native
    var uvs: js.Array[js.Array[Vector2]] = js.native
    var z: Double = js.native
  }

  @js.native
  @JSName("THREE.RenderableVertex")
  class RenderableVertex extends js.Object {
    var position: Vector3 = js.native
    var positionWorld: Vector3 = js.native
    var positionScreen: Vector4 = js.native
    var visible: Boolean = js.native
    def copy(vertex: RenderableVertex): Unit = js.native
  }

  @js.native
  @JSName("THREE.RenderableLine")
  class RenderableLine extends js.Object {
    var id: Double = js.native
    var v1: RenderableVertex = js.native
    var v2: RenderableVertex = js.native
    var vertexColors: js.Array[Color] = js.native
    var material: Material = js.native
    var z: Double = js.native
  }

  @js.native
  @JSName("THREE.RenderableSprite")
  class RenderableSprite extends js.Object {
    var id: Double = js.native
    var `object`: Object = js.native
    var x: Double = js.native
    var y: Double = js.native
    var z: Double = js.native
    var rotation: Double = js.native
    var scale: Vector2 = js.native
    var material: Material = js.native
  }

  @js.native
  @JSName("THREE.Projector")
  class Projector extends js.Object {
    def projectVector(vector: Vector3, camera: Camera): Vector3 = js.native
    def unprojectVector(vector: Vector3, camera: Camera): Vector3 = js.native
    def projectScene(scene: Scene, camera: Camera, sortObjects: Boolean, sortElements: Boolean = ???): js.Any = js.native
  }

  @js.native
  @JSName("THREE.OrbitControls")
//  class OrbitControls extends js.Object {
  class OrbitControls(var `object`: Camera,var domElement: HTMLElement = ???) extends js.Object {
    //def this(`object`: Camera, domElement: HTMLElement = ???) = this()
    //def this(parameters: js.Dynamic = ???) = this()
//    var `object`: Camera = js.native
//    var domElement: HTMLElement = js.native
    var enabled: Boolean = js.native
    var target: Vector3 = js.native
    var center: Vector3 = js.native
    var noZoom: Boolean = js.native
    var zoomSpeed: Double = js.native
    var minDistance: Double = js.native
    var maxDistance: Double = js.native
    var noRotate: Boolean = js.native
    var rotateSpeed: Double = js.native
    var noPan: Boolean = js.native
    var keyPanSpeed: Double = js.native
    var autoRotate: Boolean = js.native
    var autoRotateSpeed: Double = js.native
    var minPolarAngle: Double = js.native
    var maxPolarAngle: Double = js.native
    var minAzimuthAngle: Double = js.native
    var maxAzimuthAngle: Double = js.native
    var noKeys: Boolean = js.native
    var keys: js.Any = js.native
    var mouseButtons: js.Any = js.native
    def rotateLeft(angle: Double = ???): Unit = js.native
    def rotateUp(angle: Double = ???): Unit = js.native
    def panLeft(distance: Double = ???): Unit = js.native
    def panUp(distance: Double = ???): Unit = js.native
    def pan(deltaX: Double, deltaY: Double): Unit = js.native
    def dollyIn(dollyScale: Double): Unit = js.native
    def dollyOut(dollyScale: Double): Unit = js.native
    def update(): Unit = js.native
    def reset(): Unit = js.native
    def getPolarAngle(): Double = js.native
    def getAzimuthalAngle(): Double = js.native
    def addEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def hasEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def removeEventListener(`type`: String, listener: js.Function1[js.Any, Unit]): Unit = js.native
    def dispatchEvent(event: js.Any): Unit = js.native
  }

  @js.native
  @JSName("THREE.VREffect")
  class VREffect extends js.Object {
    def this(renderer: Renderer, callback: js.Function1[String, Unit] = ???) = this()
    def render(scene: Scene, camera: Camera): Unit = js.native
    def setSize(width: Double, height: Double): Unit = js.native
    def setFullScreen(flag: Boolean): Unit = js.native
    def startFullscreen(): Unit = js.native
    def FovToNDCScaleOffset(fov: VRFov): VREffectOffset = js.native
    def FovPortToProjection(fov: VRFov, rightHanded: Boolean, zNear: Double, zFar: Double): Matrix4 = js.native
    def FovToProjection(fov: VRFov, rightHanded: Boolean, zNear: Double, zFar: Double): Matrix4 = js.native
  }

  @js.native
  trait VRFov extends js.Object {
    var leftTan: Double = js.native
    var rightTan: Double = js.native
    var upTan: Double = js.native
    var downTan: Double = js.native
  }

  @js.native
  trait VREffectOffset extends js.Object {
    var scale: Double = js.native
    var offset: Double = js.native
  }

  @js.native
  @JSName("THREE.VRControls")
  class VRControls extends js.Object {
    def this(camera: Camera, callback: js.Function1[String, Unit] = ???) = this()
    def update(): Unit = js.native
    def zeroSensor(): Unit = js.native
    var scale: Double = js.native
  }

  @js.native
  @JSName("THREE.MaskPass")
  class MaskPass extends js.Object {
    def this(scene: Scene, camera: Camera) = this()
    var scene: Scene = js.native
    var camera: Camera = js.native
    var enabled: Boolean = js.native
    var clear: Boolean = js.native
    var needsSwap: Boolean = js.native
    var inverse: Boolean = js.native
    def render(renderer: WebGLRenderer, writeBuffer: WebGLRenderTarget, readBuffer: WebGLRenderTarget, delta: Double): Unit = js.native
  }

  @js.native
  @JSName("THREE.ClearMaskPass")
  class ClearMaskPass extends js.Object {
    var enabled: Boolean = js.native
    def render(renderer: WebGLRenderer, writeBuffer: WebGLRenderTarget, readBuffer: WebGLRenderTarget, delta: Double): Unit = js.native
  }

  @js.native
  @JSName("THREE.CSS3DObject")
  class CSS3DObject extends Object3D {
    def this(element: js.Any) = this()
    var element: js.Any = js.native
  }

  @js.native
  @JSName("THREE.CSS3DSprite")
  class CSS3DSprite extends CSS3DObject {
    def this(element: js.Any) = this()
  }

  @js.native
  @JSName("THREE.CSS3DRenderer")
  class CSS3DRenderer extends js.Object {
    var domElement: HTMLElement = js.native
    def setSize(width: Double, height: Double): Unit = js.native
    def render(scene: Scene, camera: Camera): Unit = js.native
  }

  @JSName("THREE")
  @js.native
  trait SpriteCanvasMaterialParameters extends MaterialParameters {
    var color: Double = js.native
    var program: js.Function2[js.Any, Color, Unit] = js.native
  }

  @js.native
  @JSName("THREE.SpriteCanvasMaterial")
  class SpriteCanvasMaterial extends Material {
    def this(parameters: SpriteCanvasMaterialParameters = ???) = this()
    var color: Color = js.native
    def program(context: js.Any, color: Color): Unit = js.native
  }

  @js.native
  trait CanvasRendererParameters extends js.Object {
    var canvas: HTMLCanvasElement = js.native
    var devicePixelRatio: Double = js.native
  }

  @js.native
  @JSName("THREE.CanvasRenderer")
  class CanvasRenderer() extends Renderer {
    def this(parameters: js.Dynamic = ???) = this()
    //def this(parameters: CanvasRendererParameters = ???) = this()
    var autoClear: Boolean = js.native
    var sortObjects: Boolean = js.native
    var sortElements: Boolean = js.native
    var info: js.Any = js.native
    def supportsVertexTextures(): Unit = js.native
    def setFaceCulling(): Unit = js.native
    def getPixelRatio(): Double = js.native
    def setPixelRatio(value: Double): Unit = js.native
    def setViewport(x: Double, y: Double, width: Double, height: Double): Unit = js.native
    def setScissor(): Unit = js.native
    def enableScissorTest(): Unit = js.native
    def setClearColor(color: Color, opacity: Double = ???): Unit = js.native
    def setClearColorHex(hex: Double, alpha: Double = ???): Unit = js.native
    def getClearColor(): Color = js.native
    def getClearAlpha(): Double = js.native
    def getMaxAnisotropy(): Double = js.native
    def clear(): Unit = js.native
    def clearColor(): Unit = js.native
    def clearDepth(): Unit = js.native
    def clearStencil(): Unit = js.native
  //}

}

@js.native
@JSName("THREE.PointsMaterial")
class PointsMaterial extends js.Object{
  def this(parameters: js.Dynamic = ???) = this()
  var color: Color = js.native
  var map: Texture = js.native
  var size: Double = js.native
  var sizeAttenuation: Boolean = js.native
  var vertexColors: Colors = js.native
  var fog: Boolean = js.native
}

@js.native
@JSName("THREE.Points")
class Points[T <: Object3D](var geometry: T, var material:PointsMaterial) extends Object3D{
}