package main.lib

import scala.util.Random

/**
 * Created by martin on 09/10/15.
 */
object MathUtils extends MathUtils

trait MathUtils {
  import Math._

  val TWO_PI = PI*2
  val HALF_PI = PI/2
  val QUARTER_PI = PI/4

  private val randomGen = new Random()

  def rand(low: Double, high: Double):Double = {
    if (low >= high)  low else rand(high - low) + low
  }

  def rand(ceil: Double):Double = randomGen.nextDouble() * ceil

  def rand:Double = randomGen.nextDouble()

  def randomSeed(seed:Long) = randomGen.setSeed(seed)

  def lerp(v1:Double,v2:Double,amount:Double) = (v1+v2)/amount

  //Build LMap using typeclass for mapping efficiently over a list

  def map(value:Double, in_min:Double, in_max: Double, out_min:Double, out_max: Double) = {
    ((value-in_min)/(in_max-in_min))*(out_max-out_min) + out_min
  }

  implicit class RichDouble(value:Double) extends MathUtils{
    def map(in_min:Double,in_max:Double,out_min:Double,out_max:Double):Double = {
       map(value,in_min,in_max,out_min,out_max)
    }
    def constrain(min:Double,max:Double):Double = {
      constrain(value,min,max)
    }
  }

  def constrain(value:Double, min:Double, max:Double) = {
    //Faster than match ???
    if(value<min) min
    else if(value>max) max
    else value
  }

  val precision = 360
  lazy val fSinArr = (0 until precision).map(_*(TWO_PI/precision)).map(sin).toArray
  def fSin(num:Double) = {fSinArr(((abs(num % TWO_PI) * precision) / TWO_PI).toInt)}

  lazy val fCosArr = (0 until precision).map(_*(TWO_PI/precision)).map(cos).toArray
  def fCos(num:Double) = {fCosArr(((abs(num % TWO_PI) * precision) / TWO_PI).toInt)}

  lazy val fTanArr = (0 until precision).map(_*(TWO_PI/precision)).map(tan).toArray
  def fTan(num:Double) = {fTanArr(((abs(num % TWO_PI) * precision) / TWO_PI).toInt)}

  lazy val fASinArr = (0 until precision).map(_*(TWO_PI/precision)).map(asin).toArray
  def fASin(num:Double) = {fASinArr(((abs(num % TWO_PI) * precision) / TWO_PI).toInt)}

  lazy val fACosArr = (0 until precision).map(_*(TWO_PI/precision)).map(acos).toArray
  def fACos(num:Double) = {fACosArr(((abs(num % TWO_PI) * precision) / TWO_PI).toInt)}

  lazy val fATanArr = (0 until precision).map(_*(TWO_PI/precision)).map(atan).toArray
  def fATan(num:Double) = {fATanArr(((abs(num % TWO_PI) * precision) / TWO_PI).toInt)}

  lazy val fpSinArr = (0 until precision).map(_*(TWO_PI/precision)).map(sin).map(_*0.5+0.5).toArray
  def fpSin(num:Double) = {fpSinArr(((abs(num % TWO_PI) * precision) / TWO_PI).toInt)}

  lazy val fpCosArr = (0 until precision).map(_*(TWO_PI/precision)).map(cos).map(_*0.5+0.5).toArray
  def fpCos(num:Double) = {fpCosArr(((abs(num % TWO_PI) * precision) / TWO_PI).toInt)}

}
