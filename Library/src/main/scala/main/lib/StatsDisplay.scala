package main.lib

trait StatsDisplay extends BasicCanvas{

  private val stats = new Stats()
  stats.domElement.style.position = "absolute"
  stats.domElement.style.top = "0px"
  body.appendChild( stats.domElement )

  override def renderLoop(timestamp: Double) ={
    stats.update()
    super.renderLoop(timestamp)
  }
}







