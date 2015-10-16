package main

import main.ThreeJSApp._

import scala.scalajs.js._

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################
import java.lang.Math._

object ThreeJSApp11 extends JSApp with BasicCanvas with Helpers with PerlinNoise{
  var controls:OrbitControls = null



  def main():Unit = {
    Setup.Dim3.Center.asScene.noClear


    controls = addOrbitControls(origin)

    renderLoop(now)
  }


  val step = 10
  val cubes = for{
    x <- (-5 to 5)
    y <- (-5 to 5)
  }
    yield{
      //fillLambert(new Color(noise(x*0.1,y*0.1)*255,0,0))
      fill(new Color(map(noise(x*0.06+100,y*0.06),-1,1,0,1),0,0.5))
      //cube((x*step,-250,y*step-20*step-50),step)
      sphere((x*step,-250,y*step-20*step-50),step)
    }



  def render():Unit = {

    cubes.foreach(c=>c.position.set(c.position.x,map(noise(c.position.x*0.001+100,c.position.z*0.001, frameCount*0.01),-1,1,-150,0),c.position.z))

    controls.update()
    stats.update()
  }


}
