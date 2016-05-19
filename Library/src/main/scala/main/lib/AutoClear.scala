package main.lib

/**
  * Created by martin on 5/6/16.
  */
trait AutoClear extends BasicCanvas{
  override def renderLoop(timestamp: Double) = {
    super.renderLoop(timestamp)
    //TODO: Verify if disposing is necesary
    disposeChildren(scene.children)
    scene.children = scala.scalajs.js.Array[Object3D]()
  }

  def disposeChildren(children: scala.scalajs.js.Array[Object3D]): Unit = {
    if (children.nonEmpty){
        children.foreach {
          case m: Mesh[_] =>
            m.material.dispose()
            m.geometry.dispose()
          case p: Points[_, _] =>
            p.material.dispose()
            p.geometry match {
              case bg: BufferGeometry => bg.dispose();
              case g: Geometry => g.dispose();
            }
          case l: Line[_] =>
            l.material.dispose()
            l.geometry match {
              case bg: BufferGeometry => bg.dispose();
              case g: Geometry => g.dispose();
            }
          case _ =>
        }
      children.foreach(child => disposeChildren(child.children))
    }
  }
}
