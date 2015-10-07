//package main
//
//import org.scalajs.dom.Node
//
//import scala.scalajs.js
//import scala.scalajs.js.annotation.JSName
//
//object THREE {
//
//  @js.native
//  @JSName("THREE.Vector3")
//  class Vector3(var x: Number, var y: Number, var z: Number) extends js.Object
//
//  @js.native
//  @JSName("THREE.Scene")
//  class Scene extends js.Object {
//    def add(obj: js.Object): Unit = js.native
//  }
//
//  @js.native
//  @JSName("THREE.Camera")
//  class Camera extends js.Object
//
//  @js.native
//  @JSName("THREE.PerspectiveCamera")
//  class PerspectiveCamera(a: Number, b: Number, c: Number, d: Number) extends Camera {
//    var position: Vector3 = js.native
//  }
//
//  @js.native
//  @JSName("THREE.WebGLRenderer")
//  class WebGLRenderer(params: js.Dynamic) extends js.Object {
//    var gammaInput: Boolean = js.native
//    var gammaOutput: Boolean = js.native
//
//    def render(scene: Scene, camera: Camera, renderTarget: RenderTarget = js.native, forceClear: Boolean = js.native): Unit = js.native
//
//    def setSize(width: Double, height: Double, updateStyle: Boolean = js.native): Unit = js.native
//
//    var domElement: Node = js.native
//  }
//
//  @js.native
//  @JSName("THREE.RenderTarget")
//  trait RenderTarget extends js.Object {
//  }
//
//  @js.native
//  @JSName("THREE.SimpleWebGLRenderer")
//  class SimpleWebGLRenderer() extends WebGLRenderer(null)
//
//  @js.native
//  @JSName("THREE.BoxGeometry")
//  class Geometry extends js.Object{
//    var vertices:js.Array[Vector3] = js.native
//  }
//
//  @js.native
//  @JSName("THREE.Line")
//  class Line extends js.Object{
//    def this(geometry: Geometry, material:Material) = this()
//    var geometry: Geometry = js.native
//    var material:Material = js.native
//  }
//
//  class LineBasicMaterial extends Material{
//    def this(color:Double) = this()
//    var color:Double = js.native
//  }
//
//  @js.native
//  @JSName("THREE.BoxGeometry")
//  class BoxGeometry  extends Geometry {
//    def this(width: Double, height: Double, depth: Double, widthSegments: Double = js.native, heightSegments: Double = js.native, depthSegments: Double = js.native) = this()
//    var parameters: js.Any = js.native
//    var widthSegments: Double = js.native
//    var heightSegments: Double = js.native
//    var depthSegments: Double = js.native
//  }
//
//  @js.native
//  @JSName("THREE.PolyhedronGeometry")
//  class PolyhedronGeometry(vertices: Array[Float], faces: Array[Int]) extends Geometry
//
//  @js.native
//  @JSName("THREE.Material")
//  class Material extends js.Object
//
//  @js.native
//  @JSName("THREE.MeshBasicMaterial")
//  class MeshBasicMaterial(params: js.Dynamic) extends Material
//
//  @js.native
//  @JSName("THREE.SimpleMeshBasicMaterial")
//  class SimpleMeshBasicMaterial() extends MeshBasicMaterial(null)
//
//  @js.native
//  @JSName("THREE.Mesh")
//  class Mesh(geometry: Geometry, material: Material) extends js.Object {
//    var rotation: Euler = js.native
//    var position: Vector3 = js.native
//  }
//
//  @js.native
//  @JSName("THREE.Euler")
//  class Euler  extends js.Object {
//    def this(x: Double = js.native, y: Double = js.native, z: Double = js.native, order: String = js.native) = this()
//    var x: Double = js.native
//    var y: Double = js.native
//    var z: Double = js.native
//    var order: String = js.native
//    def set(x: Double, y: Double, z: Double, order: String = js.native): Euler = js.native
//    def copy(euler: Euler): Euler = js.native
//    def reorder(newOrder: String): Euler = js.native
//    def equals(euler: Euler): Boolean = js.native
//    def fromArray(xyzo: js.Array[js.Any]): Euler = js.native
//    def toArray: js.Array[js.Any] = js.native
//    var onChange: js.Function0[Unit] = js.native
//    override def clone(): Euler = js.native
//  }
//
//  @js.native
//  @JSName("THREE.Clock")
//  class Clock extends js.Object{
//    def getDelta():Double = js.native
//  }
//
//  @js.native
//  @JSName("THREE.AmbientLight")
//  class AmbientLight(hex: Int) extends js.Object {
//
//  }
//
//}
