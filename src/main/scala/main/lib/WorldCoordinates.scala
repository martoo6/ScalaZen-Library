package main.lib

import org.scalajs.dom

/**
 * Created by martin on 10/17/15.
 */
trait WorldCoordinates {
  val xAxis = new Vector3(1,0,0)
  val yAxis = new Vector3(0,1,0)
  val zAxis = new Vector3(0,0,1)

  def width = dom.window.innerWidth
  def height = dom.window.innerHeight

  var worldCoordinates: Coordinates = CenterCoordiantes

  def center      = worldCoordinates.center
  def leftTop     = worldCoordinates.leftTop
  def rightTop    = worldCoordinates.rightTop
  def leftBottom  = worldCoordinates.leftBottom
  def rightBottom = worldCoordinates.rightBottom

  trait Coordinates{
    val center:      Vector3
    val leftTop:     Vector3
    val rightTop:    Vector3
    val leftBottom:  Vector3
    val rightBottom: Vector3
  }

  //Should re calculate acording to origin
  object CenterCoordiantes extends Coordinates{
    val center      = new Vector3(0.0,0.0,0.0)
    val leftTop     = new Vector3(0.0,height,0.0)
    val rightTop    = new Vector3(width,height,0.0)
    val leftBottom  = new Vector3(0.0,0.0,0.0)
    val rightBottom = new Vector3(width,0.0,0.0)
  }

  object LeftBottomCoordiantes extends Coordinates{
    val center      = new Vector3(width/2,height/2,0.0)
    val leftTop     = new Vector3(0.0,height,0.0)
    val rightTop    = new Vector3(width,height,0.0)
    val leftBottom  = new Vector3(0.0,0.0,0.0)
    val rightBottom = new Vector3(width,0.0,0.0)
  }

}
