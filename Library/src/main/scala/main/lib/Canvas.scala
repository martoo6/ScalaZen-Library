package main.lib

import org.scalajs.dom
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.raw.KeyboardEvent

import scala.scalajs.js

/**
 * Created by martin on 20/10/15.
 */
trait Canvas extends WorldCoordinates{
  //self: Helpers=>

  //TODO: Replace everything possible with vals !

  var faceSide: Side = THREE.FrontSide
  def _center = new Vector3(0,0,500)
  def leftBottomPosition = new Vector3(width / 2, height / 2, 1000)
  var position = _center

  var renderAction: Unit => Unit = { _ => renderer.render(scene, camera, forceClear = !canvasStyle)}
  var canvasStyle = false

  val canvasData: CanvasData

  //var lineMaterial: LineBasicMaterial
  var scene:Scene
  var camera: Camera
  var renderer: WebGLRenderer
  var clock: Clock

  val composer:EffectComposer

  var delta:Float = 0
  var frameCount:Long = 0

  var mouseX = 0.0
  var mouseY = 0.0

  def run():Unit = {
    Setup.configure()
    renderLoop(System.currentTimeMillis())
  }

  object Setup {

    case class SetupConfiguration(worldCoordinates: Coordinates,
                                  position: () => Vector3,
                                  faceSide: Side,
                                  camera: (Int, Int) => Camera,
                                  sortObjects: Boolean,
                                  ortho: Boolean,
                                  canvasStyle: Boolean,
                                  autoClear: Boolean,
                                  autoClearColor: Boolean,
                                  antialiasing: Boolean)

    var config: SetupConfiguration = SetupConfiguration(
      CenterCoordiantes,
      () => _center,
      THREE.FrontSide,
      getOrthograpicCamera,
      sortObjects = false,
      ortho = true,
      canvasStyle = false,
      autoClear = true,
      autoClearColor = true,
      antialiasing = false
    )

    //    sealed trait WorldCoordinates{
    //      def position: Vector3
    //      def coordinate: Coordinates
    //    }
    //    case object CenterCoordinate extends WorldCoordinates{
    //      def position =_center
    //      def coordinate = CenterCoordiantes
    //    }
    //    case object LeftBottomCoordinate extends WorldCoordinates{
    //      def position = leftBottomPosition
    //      def coordinate = LeftBottomCoordiantes
    //    }
    //
    //    sealed trait Dimensions{
    //      def position =
    //      def coordinate =
    //    }
    //    case object _2Dimensions extends Dimensions
    //    case object _3Dimensions extends Dimensions
    //
    //    sealed trait CameraPerspective
    //    case object Perspective extends CameraPerspective
    //    case object Orthogonal extends CameraPerspective
    //
    //    sealed trait RenderMode
    //    case object Canvas extends RenderMode
    //    case object Scene extends RenderMode
    //
    //    case class SetupConfiguration(
    //                                   worldCoordinates: WorldCoordinates,
    //                                   dimensions: Dimensions,
    //                                   cameraPerspective: CameraPerspective,
    //                                   renderMode: RenderMode,
    //                                   antialiasing: Boolean
    //                                 )
    //    var config: SetupConfiguration = SetupConfiguration(CenterCoordinate, _2Dimensions, Orthogonal, Scene, antialiasing = false)

    private def getOrthograpicCamera(width: Int, height:Int):Camera = new OrthographicCamera(width / -2, width / 2, height / 2, height / -2, -1000, 1000)
    private def getPerspectiveCamera(width: Int, height:Int):Camera = new PerspectiveCamera(45, width / height, 1, 1000)

    def Center = {
      config = config.copy(position = _center _)
      config = config.copy(worldCoordinates = CenterCoordiantes)
      this
    }
    def LeftBottom = {
      config = config.copy(position = leftBottomPosition _)
      config = config.copy(worldCoordinates = LeftBottomCoordiantes)
      this
    }
    def _3D = {
      //new MeshBasicMaterial(js.Dynamic.literal(color= 0xffff00, side= THREE.FloatSide))
      config = config.copy(camera = getOrthograpicCamera)
      config = config.copy(faceSide = THREE.FloatSide)
      this
    }
    def _2D = {
      //new MeshBasicMaterial(js.Dynamic.literal(color= 0xffff00))
      config = config.copy(camera = getOrthograpicCamera, faceSide = THREE.FrontSide, sortObjects = false)
      this
    }
    def ortho = {
      config = config.copy(camera = getOrthograpicCamera)
      this
    }
    def perspective = {
      config = config.copy(camera = getPerspectiveCamera)
      this
    }
    def asCanvas = {
      config = config.copy(canvasStyle = true, autoClear = false, autoClearColor = false)
      this
    }
    def asScene = {
      config = config.copy(canvasStyle = false, autoClear = true, autoClearColor = true)
      this
    }
    def antialiasing = {
      config = config.copy(antialiasing = true)
      this
    }
    def size(_width: Int, _height: Int) = {
      width = _width
      height = _height
      this
    }

    def configure() = {
      config match {
        case SetupConfiguration(_worldCoordinates, _position, _faceSide, _camera, _sortObjects, _ortho, _canvasStyle, _autoClear, _autoClearColor, _antialiasing) =>
          worldCoordinates = _worldCoordinates
          position = _position()
          faceSide = _faceSide
          camera = _camera(width, height)
          renderer.sortObjects = _sortObjects
          canvasStyle = _canvasStyle
          renderer.autoClear = _autoClear
          renderer.autoClearColor = _autoClearColor
          if (_antialiasing) {
            composer.addPass(new RenderPass(scene, camera))
            val effect = new ShaderPass(FXAAShader)
            effect.uniforms.resolution.value.set(1.0 / width, 1.0 / height)

            //TODO: render to screen should be the last one, check on that later
            effect.renderToScreen = true
            composer.addPass(effect)
            renderAction = _ => composer.render(1)
          } else {
            renderAction = { _ => renderer.render(scene, camera, forceClear = !canvasStyle)}
          }
          camera.position.set(position.x, position.y, position.z)
          canvasData.renderer.setSize(width, height)
      }
    }
  }

  dom.window.onmousemove = {
    event:MouseEvent =>
      mouseX = event.clientX
      mouseY = dom.window.innerHeight - event.clientY
  }

  def render():Unit

  val minFrameRate = 1
  var times = 0

  var mainGroup:Group = new Group()

  def renderLoop(timestamp: Double){

    if(!isPaused) {
      delta = clock.getDelta() //seconds
      frameCount += 1

      //Should replace for function/s that execute whats needed instead of ugly ifs
      if (delta > 1 / minFrameRate && frameCount > 60) {
        times += 1
        if (times > 15) throw new Error(s"Im preventing your machine from exploding, optimize your code! Last delta was: $delta")
      } else {
        times = 0
      }
    }

      dom.window.requestAnimationFrame(renderLoop _)

    if(!isPaused) {
      render
      //scene.add(scene)
      //TODO: Could try to merge geometries and meshes in order to improve perfomance
      scene.add(mainGroup)
      renderAction()


      camera.updateMatrix()
      mainGroup = new Group()
    }


  }

  var isPaused = false

  def pause = isPaused = true

  def resume = isPaused = false

  def toogle = isPaused = !isPaused


  def onKeyPress(f: String => Any): Unit ={
    dom.window.addEventListener("keypress", {e:KeyboardEvent => f(fromCharCode(e.charCode))})
  }

  def onKeyPressEvent(f: KeyboardEvent => Any): Unit ={
    dom.window.addEventListener("keypress", f)
  }

  private def fromCharCode(charCodes: Int*): String = {
    js.Dynamic.global.String.applyDynamic("fromCharCode")(charCodes.asInstanceOf[Seq[js.Any]]: _*).asInstanceOf[String]
  }
}
