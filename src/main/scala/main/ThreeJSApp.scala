package main


import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js._

object ThreeJSApp extends JSApp with BasicCanvas with Helpers with PerlinNoise{

  def now = System.currentTimeMillis()

  var clock = new Clock()

  var delta:Double = 0
  var frameCount:Long = 0

  def main():Unit = {


    Setup.Center



    val renderer = new WebGLRenderer(js.Dynamic.literal())
    renderer.setSize(dom.window.innerWidth, dom.window.innerHeight)
    val e =renderer.domElement
    val b: dom.Node = dom.document.body
    b.appendChild(e)

    val controls = new OrbitControls(camera , renderer.domElement)

    //val controls = new OrbitControls( js.Dynamic.literal(`object`=camera , domElement=renderer.domElement))
    controls.center=(0,0,-500)
    //controls.addEventListener("change", render _)

    def render{
      stroke(Palette.pop.getRandom)

      val fc = frameCount*0.02
      val x = noise(fc,0,0)*500
      val y = noise(0,fc,0)*500
      val z = noise(0,0,fc)*500-500

      println(s"$x - $y")

      //val pos2 = (random(-width,width),random(-height,height),0.0)
      val dest = (x,y,z)
      line((0,0,-500),dest)

      fill(Palette.blue.getRandom)
      val size = random(2,5)
      //rect(pos2,size,size)

      sphere(dest,size)

      controls.update()
    }

    def renderLoop(timestamp: Double){
      delta = clock.getDelta()
      frameCount+=1
      dom.requestAnimationFrame(renderLoop _)
      render
      renderer.render(scene, camera)
      camera.updateMatrix()
    }

    renderLoop(now)
  }
}
