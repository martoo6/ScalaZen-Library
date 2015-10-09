package main


import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js._

object ThreeJSApp extends JSApp with BasicCanvas with Helpers{

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

//    def createCube(side: Double): Mesh = {
//      val geometry = new BoxGeometry(side, side, side)
//      val material = new MeshBasicMaterial(js.Dynamic.literal(color = 0xffffff, wireframe=true))
//      new Mesh(geometry, material)
//    }
//
//    val cube = createCube(3)
//    scene.add(cube)

//    (0 to 100 by 2).foreach{_=>
//      stroke(new Color(Math.random(),Math.random(),Math.random()))
//      val pos1 = (random(width),random(height))
//      val pos2 = (random(width),random(height))
//      line(pos1 :: pos2 :: Nil :_*)
//      stroke(new Color(Math.random(),Math.random(),Math.random()))
//      rect(pos1,random(5,10),random(5,10))
//      rect(pos2,random(5,10),random(5,10))
//    }

//    def render{
////      cube.rotation.x += delta*.5
////      cube.rotation.y += delta*.5
////      stroke(new Color(Math.random(),Math.random(),Math.random()))
////      line((0.0,0.0,0.0),(Math.random()*200-100,Math.random()*200.0-100,0.0))
//    }

    Perlin.init

    def render{
      stroke(Palette.pop.getRandom)

      val fc = frameCount*0.02
      val x = PerlinNoise.perlinNoise(fc,0,0)*500
      val y = PerlinNoise.perlinNoise(0,fc,0)*500
      val z = PerlinNoise.perlinNoise(0,0,fc)*500

      println(s"$x - $y")

      //val pos2 = (random(-width,width),random(-height,height),0.0)
      val pos2 = (x,y,z)
      line((0.0,0.0,0.0) :: pos2 :: Nil :_*)

      fill(Palette.blue.getRandom)
      val size = random(5,10)
      //rect(pos2,size,size)

      cube(pos2,size)
    }

    def renderLoop(timestamp: Double){
      delta = clock.getDelta()
      frameCount+=1
      dom.requestAnimationFrame(renderLoop _)
      render
      renderer.render(scene, camera)
    }

    renderLoop(now)
  }
}
