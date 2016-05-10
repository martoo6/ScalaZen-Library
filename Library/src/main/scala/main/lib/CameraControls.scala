package main.lib

trait CameraControls extends BasicCanvas{

  lazy val controls = {
    val c = new OrbitControls(camera , renderer.domElement)
    c.center = _center
    c
  }
  //TODO: this will fail as we change center mode


  override def renderLoop(timestamp: Double) ={
    controls.update()
    super.renderLoop(timestamp)
  }
}







