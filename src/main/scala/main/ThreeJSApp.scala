package main


import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.JSApp

object ThreeJSApp extends JSApp with Helpers{

  def now = System.currentTimeMillis()

  var clock = new Clock()

  var delta:Double = 0
  var frameCount:Long = 0

  def main():Unit = {

    implicit var material = new LineBasicMaterial(js.Dynamic.literal(color = 0xffffff))
    implicit val scene = new Scene()

    implicit var camera = new OrthographicCamera( width / - 2, width / 2, height / 2, height / - 2, 1, 1000 )


    val renderer = new WebGLRenderer(js.Dynamic.literal())
    renderer.setSize(dom.window.innerWidth, dom.window.innerHeight)
    val e =renderer.domElement
    val b: dom.Node = dom.document.body
    b.appendChild(e)
    camera.position.z = 5

//    def createCube(side: Double): Mesh = {
//      val geometry = new BoxGeometry(side, side, side)
//      val material = new MeshBasicMaterial(js.Dynamic.literal(color = 0xffffff, wireframe=true))
//      new Mesh(geometry, material)
//    }
//
//    val cube = createCube(3)
//    scene.add(cube)

    stroke(new Color(Math.random(),Math.random(),Math.random()))
    val v = (1 to 100).map(_=>(Math.random()*200,Math.random()*200.0,0.0))
    line(v:_*)



    //line((1,2,0),(100,1000,0),(500,300,0),(500,0,0), (0,300,0))

    //YEAHP
    line(-1000,-1000,-1000,1000,1000,1000)


    //rect(1,1,0,0)

    stroke(new Color(Math.random(),Math.random(),Math.random()))

    rect(10,10,0,0)

    rect(10,10,width/2,0)

    rect(10,10,0,height/2)

    rect(10,10,width/2,height/2)

    (0 to 100).foreach{_=>
      stroke(new Color(Math.random(),Math.random(),Math.random()))
      rect(random(20,50),random(20,50),random(width/2),random(height/2))
    }

    def render{
//      cube.rotation.x += delta*.5
//      cube.rotation.y += delta*.5
//      stroke(new Color(Math.random(),Math.random(),Math.random()))
//      line((0.0,0.0,0.0),(Math.random()*200-100,Math.random()*200.0-100,0.0))
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
