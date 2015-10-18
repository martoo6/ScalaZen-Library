package main

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

  //Should re calculate acording to origin
  val origin      = new Vector3(0.0,0.0,0.0)
  val leftTop     = new Vector3(0.0,height,0.0)
  val rightTop    = new Vector3(width,height,0.0)
  val leftBottom  = new Vector3(0.0,0.0,0.0)
  val rightBottom = new Vector3(width,0.0,0.0)
}
