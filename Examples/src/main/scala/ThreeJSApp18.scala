import main.lib._

import scala.scalajs.js.annotation.JSExport

/**
 * Oscillators (In progress)
 */

@JSExport
class ThreeJSApp18 extends BasicCanvas with DrawingUtils with StatsDisplay with SimplexNoise with AutoClear{
  Setup._2D.asCanvas

//  val osc = pRampOsc().frequency(0.01)
//
//  val osc2 = pSinOsc()
//    .frequency(0.001)
//    .attach(x=>rect((0,0),50+x*150).fill(Rgb(rand(0.5,1),1,0)))
//    .attach(_=>println(width/2))





  //TODO: Mas tipos de osciladores. Mostrar varios en lo posible.
  //Ver porq la performance apesta.
  //Los osciladores deben de poder ser appendeados al loop asi se ejecutan siempre al final/pricipio todos los hooks que se quieran

  val material = new MeshNormalMaterial()
  val geo = new SphereGeometry(50,10,10)

  def render():Unit = {
    scene = new Scene()
    val g = new Group()

    for(i<- 0 to 500){
      val mesh = new Mesh(geo, material)
      //val r = (rand(-width/2,width/2), rand(-height/2,height/2))
      mesh.position.set(rand(-width/2,width/2), rand(-height/2,height/2), 100)
      g.add(mesh)
      //scene.add(mesh)
      //sphere(random2D, rand(10,50))
    }

    scene.add(g)

//    rect((0,0),50).fill(Rgb(1,0,0))
//    rect((width,0),50).fill(Rgb(1,0,0))
//    rect((width,height),50).fill(Rgb(1,0,0))
//    rect((0,height),50).fill(Rgb(1,0,0))

    //val step = 5
//    for(i<-0 to width/4 by step){
//      rect((i,0), step, height*osc.get(i+frameCount*10)).fill(Rgb(osc.get(i+frameCount*10), 0,rand(0.8,1)))
//    }
    //osc2.run
  }


}
