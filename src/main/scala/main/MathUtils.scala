package main

/**
 * Created by martin on 09/10/15.
 */
trait MathUtils {
  import Math._

  val TWO_PI = PI*2
  val HALF_PI = PI/2
  val QUARTER_PI = PI/4

  def random(Min: Double, Max: Double) = Min + (Math.random * (Max - Min + 1))

  def random(ceil: Double) = Math.random * ceil

  def lerp(v1:Double,v2:Double,amount:Double) = (v1+v2)/amount

  //Build LMap using typeclass for mapping efficiently over a list

  def map(value:Double, in_min:Double, in_max: Double, out_min:Double, out_max: Double) = {

//    val in_range = (in_max-in_min)
    //    val out_range = (out_max-out_min)
    //    val a = (value-in_min)/in_range
    //    a*out_range + out_min
    ((value-in_min)/(in_max-in_min))*(out_max-out_min) + out_min
  }

  implicit class RichDouble(value:Double) extends MathUtils{
    def map(in_min:Double,in_max:Double,out_min:Double,out_max:Double):Double = {
       map(value,in_min,in_max,out_min,out_max)
    }
  }

  def constrain(value:Double, min:Double, max:Double) = {
    //Faster than match ???
    if(value<min) min
    else if(value>max) max
    else value
  }

}
