package main.examples

import main.lib._

import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
//########################

@JSExport
class ThreeJSApp extends BasicCanvas with DrawingUtils with PerlinNoise{
  Setup._3D.Center.asScene.noClear.withStats.withControls

  addAmbientLight(0xFFFFFF)
  addDirectionalLight(0xFFFFFF, 0.9, (0,1,0))

  val n1 = Perlin(-500,500)
  val n2 = Perlin(-500,500)
  val n3 = Perlin(-500,500)

  var i = 0

  def render():Unit = {
    stroke(Palette.iDemandPancake.getRandom)

    val size = rand(2,5)
    lineWeight(size*2)

    val fc = frameCount*0.02
    val x = n1.noise(fc)
    val y = n2.noise(fc)
    val z = n3.noise(fc)

    val dest = (x,y,z)
    line(center,dest)
    if(i<40) {
      segSphere(dest,size, 5, Palette.iDemandPancake.getRandom.materializeL())
      i+=1
    }
  }
}
