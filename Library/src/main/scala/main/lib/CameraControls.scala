package main.lib

trait CameraControls extends BasicCanvas{

  controls = new OrbitControls(camera , renderer.domElement)
  withControlsRender = true
  //TODO: this will fail as we change center mode
  controls.center = _center

  override def renderLoop(timestamp: Double) ={
    controls.update()
    super.renderLoop(timestamp)
  }
}







