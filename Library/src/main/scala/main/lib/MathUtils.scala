package main.lib

import scala.util.Random

/**
 * Created by martin on 09/10/15.
 */
object MathUtils extends MathUtils

trait MathUtils {
  import Math._

  implicit def makefloat(d:Double): Float = d.toFloat

  val PI = Math.PI.toFloat
  val TWO_PI = PI*2
  val HALF_PI = PI/2
  val QUARTER_PI = PI/4


  //########## RANDOM #############

  private val randomGen = new Random()

  def rand(low: Float, high: Float):Float = {
    if (low >= high) low else rand(high - low) + low
  }

  def rand(ceil: Float):Float = randomGen.nextFloat() * ceil

  def rand:Float = randomGen.nextFloat()

  def randomSeed(seed:Long) = randomGen.setSeed(seed)

  def randInt(low: Int, high: Int):Float = {
    if (low >= high)  low else randInt(high - low) + low
  }

  def randInt(ceil: Int):Int = randomGen.nextInt(ceil)

  def lerp[T1, T2](v1: T1, v2: T2, amount: Float)(implicit n1:Numeric[T1], n2:Numeric[T2]): Float = (n1.toFloat(v1)+n2.toFloat(v2))/amount

  def map(value: Float, in_min: Float, in_max: Float, out_min: Float, out_max: Float): Float ={
    ((value-in_min)/(in_max-in_min))*(out_max-out_min) + out_min
  }

  //By using Numeric Typeclass we have these method for any numeric type, yey !
  implicit class RichNumeric[T](value: T)(implicit n:Numeric[T]) extends MathUtils{
    def map(in_min: Float,in_max: Float,out_min: Float,out_max: Float): Float = {
      map(n.toFloat(value),in_min,in_max,out_min,out_max)
    }
    def constrain(min: Float,max: Float): Float = {
      constrain(n.toFloat(value), min, max)
    }
    def mapContrain(in_min: Float,in_max: Float,out_min: Float,out_max: Float): Float = {
      mapContrain(n.toFloat(value),in_min,in_max,out_min,out_max)
    }
    def constrainLoop(min: Float, max: Float): Float = {
      constrainLoop(n.toFloat(value), min, max)
    }
  }


  def mapContrain(value:Float, in_min:Float,in_max:Float,out_min:Float,out_max:Float): Float ={
    constrain(map(value, in_min, in_max, out_min, out_max), out_min, out_max)
  }

  def constrain(value:Float, min:Float, max:Float): Float = {
    //Faster than match ???
    if(value<min) min
    else if(value>max) max
    else value
  }

  def constrainLoop(value:Float, min:Float, max:Float) :Float= {
    //Faster than match ???
    if(value<min) max - (value % min)
    else if(value>max) value % max
    else value
  }

  //Half degree precision
  //TODO: make a builder for custom precision
  val precision = 360 * 2
  lazy val fSinArr = (0 until precision).map(_*(TWO_PI/precision)).map(sin).toArray
  def fSin(num:Float) = {fSinArr(((abs(num % TWO_PI) * precision) / TWO_PI).toInt)}

  lazy val fCosArr = (0 until precision).map(_*(TWO_PI/precision)).map(cos).toArray
  def fCos(num:Float) = {fCosArr(((abs(num % TWO_PI) * precision) / TWO_PI).toInt)}

  lazy val fTanArr = (0 until precision).map(_*(TWO_PI/precision)).map(tan).toArray
  def fTan(num:Float) = {fTanArr(((abs(num % TWO_PI) * precision) / TWO_PI).toInt)}

  lazy val fASinArr = (0 until precision).map(_*(TWO_PI/precision)).map(asin).toArray
  def fASin(num:Float) = {fASinArr(((abs(num % TWO_PI) * precision) / TWO_PI).toInt)}

  lazy val fACosArr = (0 until precision).map(_*(TWO_PI/precision)).map(acos).toArray
  def fACos(num:Float) = {fACosArr(((abs(num % TWO_PI) * precision) / TWO_PI).toInt)}

  lazy val fATanArr = (0 until precision).map(_*(TWO_PI/precision)).map(atan).toArray
  def fATan(num:Float) = {fATanArr(((abs(num % TWO_PI) * precision) / TWO_PI).toInt)}

  lazy val fpSinArr = (0 until precision).map(_*(TWO_PI/precision)).map(sin).map(_*0.5+0.5).toArray
  def fpSin(num:Float) = {fpSinArr(((abs(num % TWO_PI) * precision) / TWO_PI).toInt)}

  lazy val fpCosArr = (0 until precision).map(_*(TWO_PI/precision)).map(cos).map(_*0.5+0.5).toArray
  def fpCos(num:Float) = {fpCosArr(((abs(num % TWO_PI) * precision) / TWO_PI).toInt)}


  //So you don't have to import java.Math._

  def sin(num: Float) = Math.sin(num).toFloat
  def asin(num: Float) = Math.asin(num).toFloat
  def sinh(num: Float) = Math.sinh(num).toFloat

  def cos(num: Float)  = Math.cos(num).toFloat
  def acos(num: Float) = Math.acos(num).toFloat
  def cosh(num: Float) = Math.cosh(num).toFloat

  def tan(num: Float)  = Math.tan(num).toFloat
  def atan(num: Float) = Math.atan(num).toFloat
  def atan2(num: Float, num2: Float) = Math.atan2(num, num2).toFloat
  def tanh(num: Float) = Math.tanh(num).toFloat

  def abs(num: Float) = Math.abs(num)
  def abs(num: Int) = Math.abs(num)
  def abs(num: Long) = Math.abs(num)

  def pow(a: Float,b: Float): Float = Math.pow(a,b).toFloat

  //Another known functions

  def sinc(num: Float) = if(num==0) 1.0f else (Math.sin(num)/num).toFloat
  def cycloid(num:Float) = abs(sin(num))
  def weierstrass(num: Float, identity:Float = 7, octaves:Int = 10) = (1 to octaves).map(x=>(pow(((1+1.5*PI)/identity).toFloat, x)*cos(pow(identity,x)*num)).toFloat).sum
}
