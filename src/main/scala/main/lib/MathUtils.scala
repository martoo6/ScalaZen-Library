package main.lib

import scala.util.Random

/**
 * Created by martin on 09/10/15.
 */
object MathUtils extends MathUtils

trait MathUtils {
  import Math._

  val PI = Math.PI/2
  val TWO_PI = PI*2
  val HALF_PI = PI/2
  val QUARTER_PI = PI/4


  //########## RANDOM #############

  private val randomGen = new Random()

  def rand(low: Double, high: Double):Double = {
    if (low >= high)  low else rand(high - low) + low
  }

  def rand(ceil: Double):Double = randomGen.nextDouble() * ceil

  def rand:Double = randomGen.nextDouble()

  def randomSeed(seed:Long) = randomGen.setSeed(seed)

  def randInt(low: Int, high: Int):Double = {
    if (low >= high)  low else randInt(high - low) + low
  }

  def randInt(ceil: Int):Int = randomGen.nextInt(ceil)

  def lerp(v1:Double,v2:Double,amount:Double) = (v1+v2)/amount

  //Build LMap using typeclass for mapping efficiently over a list

  def map(value:Double, in_min:Double, in_max: Double, out_min:Double, out_max: Double) = {
    ((value-in_min)/(in_max-in_min))*(out_max-out_min) + out_min
  }


  //Change to typeclasses
  implicit class RichInt(value:Int) extends MathUtils{
    def map(in_min:Double,in_max:Double,out_min:Double,out_max:Double):Double = {
      map(value,in_min,in_max,out_min,out_max)
    }
    def constrain(min:Double,max:Double):Double = {
      constrain(value,min,max)
    }
    def mapContrain(in_min:Double,in_max:Double,out_min:Double,out_max:Double):Double = {
      mapContrain(value,in_min,in_max,out_min,out_max)
    }
  }

  implicit class RichDouble(value:Double) extends MathUtils{
    def map(in_min:Double,in_max:Double,out_min:Double,out_max:Double):Double = {
       map(value,in_min,in_max,out_min,out_max)
    }
    def constrain(min:Double,max:Double):Double = {
      constrain(value,min,max)
    }
    def mapContrain(in_min:Double,in_max:Double,out_min:Double,out_max:Double):Double = {
      mapContrain(value,in_min,in_max,out_min,out_max)
    }
  }

  def mapContrain(value:Double, in_min:Double,in_max:Double,out_min:Double,out_max:Double): Double ={
    constrain(map(value, in_min, in_max, out_min, out_max), out_min, out_max)
  }

  def constrain(value:Double, min:Double, max:Double) = {
    //Faster than match ???
    if(value<min) min
    else if(value>max) max
    else value
  }

  def constrainLoop(value:Double, min:Double, max:Double) = {
    //Faster than match ???
    if(value<min) max - (value % min)
    else if(value>max) value % max
    else value
  }

  //Half degree precision
  //TODO: make a builder for custom precision
  val precision = 360 * 2
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


  //So you don't have to import java.Math._

  def sin(num: Double) = Math.sin(num)
  def asin(num: Double) = Math.asin(num)
  def sinh(num: Double) = Math.sinh(num)

  def cos(num: Double)  = Math.cos(num)
  def acos(num: Double) = Math.acos(num)
  def cosh(num: Double) = Math.cosh(num)

  def tan(num: Double)  = Math.tan(num)
  def atan(num: Double) = Math.atan(num)
  def atan2(num: Double, num2: Double) = Math.atan2(num, num2)
  def tanh(num: Double) = Math.tanh(num)

  def abs(num: Double) = Math.abs(num)
  def abs(num: Int) = Math.abs(num)
  def abs(num: Long) = Math.abs(num)

  //Another known functions

  def sinc(num: Double) = if(num==0) 1.0 else Math.sin(num)/num
  def cycloid(num:Double) = abs(sin(num))
  def weierstrass(num: Double, identity:Double = 7, octaves:Int = 10) = (1 to octaves).map(x=>pow((1+1.5*PI)/identity,x)*cos(pow(identity,x)*num)).sum
}
