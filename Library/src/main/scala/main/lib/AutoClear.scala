package main.lib

/**
  * Created by martin on 5/6/16.
  */
trait AutoClear extends BasicCanvas{
  override def renderLoop(timestamp: Double) = {
    super.renderLoop(timestamp)

    (0 to scene.children.length).reverse.foreach{ i=>
      val c = scene.children(i)
      c match{
        case m:Mesh[_]=>
          m.material.dispose()
          m.geometry.dispose()
        case p:Points[_,_] =>
          p.material.dispose()
          p.geometry match{
            case bg: BufferGeometry => bg.dispose();
            case g: Geometry => g.dispose();
          }
        case l:Line[_] =>
          l.material.dispose()
          l.geometry.dispose()
        case _ =>
      }
      scene.remove(c)
    }
    //scene = new Scene()
  }
}
