package main


import scala.scalajs.js._

object ThreeJSApp extends JSApp with BasicCanvas with Helpers with PerlinNoise{
  var controls:OrbitControls = null

  def main():Unit = {
    Setup.Center

    addAmbientLight(0x404040)
    addDirectionalLight(0x40FF40, 0.9, (0,1,0))

    controls = addOrbitControls(origin)

    //Should be the last thing to be executed, else, weird things happen
    renderLoop(now)
  }

  def render():Unit = {
    stroke(Palette.pop.getRandom)

    val fc = frameCount*0.02
    val x = noise(fc,0,0)*500
    val y = noise(0,fc,0)*500
    val z = noise(0,0,fc)*500

    val dest = (x,y,z)
    line(origin,dest)


    fillLambert(Palette.blue.getRandom)

    val size = random(2,5)

    sphere(dest,size)

    //Should attach as an observable
    controls.update()
  }


}
