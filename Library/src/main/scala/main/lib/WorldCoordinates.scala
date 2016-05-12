package main.lib

import org.scalajs.dom

/**
 * Created by martin on 10/17/15.
 */
trait WorldCoordinates {
  val xAxis = new Vector3(1,0,0)
  val yAxis = new Vector3(0,1,0)
  val zAxis = new Vector3(0,0,1)

  var width = dom.window.innerWidth
  var height = dom.window.innerHeight

  var worldCoordinates: Coordinates = CenterCoordiantes

  def center      = worldCoordinates.center
  def leftTop     = worldCoordinates.leftTop
  def rightTop    = worldCoordinates.rightTop
  def leftBottom  = worldCoordinates.leftBottom
  def rightBottom = worldCoordinates.rightBottom
  def topLeft     = worldCoordinates.leftTop
  def topRight    = worldCoordinates.rightTop
  def bottomLeft  = worldCoordinates.leftBottom
  def bottomRight = worldCoordinates.rightBottom

  trait Coordinates{
    def center:      Vector3
    def leftTop:     Vector3
    def rightTop:    Vector3
    def leftBottom:  Vector3
    def rightBottom: Vector3
  }

  //Should re calculate acording to origin
  object CenterCoordiantes extends Coordinates{
    def center      = new Vector3(0.0,0.0,0.0)
    def leftTop     = new Vector3(-width/2,height/2,0.0)
    def rightTop    = new Vector3(width/2,height/2,0.0)
    def leftBottom  = new Vector3(-width/2,-height/2,0.0)
    def rightBottom = new Vector3(width/2,-height/2,0.0)
  }

  object LeftBottomCoordiantes extends Coordinates{
    def center      = new Vector3(width/2,height/2,0.0)
    def leftTop     = new Vector3(0.0,height,0.0)
    def rightTop    = new Vector3(width,height,0.0)
    def leftBottom  = new Vector3(0.0,0.0,0.0)
    def rightBottom = new Vector3(width,0.0,0.0)
  }

}
