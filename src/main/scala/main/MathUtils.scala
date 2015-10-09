package main

/**
 * Created by martin on 09/10/15.
 */
trait MathUtils {
  def random(Min: Double, Max: Double) = Min + (Math.random * (Max - Min + 1))

  def random(ceil: Double) = Math.random * ceil

  def lerp(v1:Double,v2:Double,amount:Double) = (v1+v2)/amount
}
