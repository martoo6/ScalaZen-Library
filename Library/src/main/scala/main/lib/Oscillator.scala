package main.lib

import scala.scalajs.js.Date

/**
  * Created by martin on 04/11/15.
  */
class Oscillator(var input: Unit => Double = _ => Date.now()){
  var amplitude = 1.0
  var frequency = 1.0
  var oscOperation: Double => Double = Osc.Sin
  var scale = (-1.0, 1.0)
  val attachments = scala.collection.mutable.ListBuffer[Double => Unit]()

  def get(manualInput: Double = input()) = MathUtils.map(oscOperation(manualInput*frequency), -1, 1, scale._1, scale._2)
  def get = MathUtils.map(oscOperation(input()*frequency), -1, 1, scale._1, scale._2)
  def run = {
    val value = get
    attachments.foreach(_(value))
  }

  def amplitude(_amplitude:Double): Oscillator = {
    amplitude = _amplitude
    this
  }
  def frequency(_frequency:Double): Oscillator ={
    frequency = _frequency
    this
  }
  def scale(from:Double, to:Double): Oscillator ={
    scale = (from, to)
    this
  }
  def oscOp(_oscOperation: Double => Double): Oscillator ={
    oscOperation = _oscOperation
    this
  }
  def attach(f: Double => Unit) = {
    attachments+=f
    this
  }

}

object pSinOsc{
  def apply(input: Unit => Double = _ => Date.now()) = new Oscillator(input).scale(0,1).oscOp(Osc.Sin)
}

object sinOsc{
  def apply(input: Unit => Double = _ => Date.now()) = new Oscillator(input).oscOp(Osc.Sin)
}

object pRectOsc{
  def apply(input: Unit => Double = _ => Date.now()) = new Oscillator(input).scale(0,1).oscOp(Osc.Rect)
}

object rectOsc{
  def apply(input: Unit => Double = _ => Date.now()) = new Oscillator(input).oscOp(Osc.Rect)
}

object pRampOsc{
  def apply(input: Unit => Double = _ => Date.now()) = new Oscillator(input).scale(0,1).oscOp(Osc.Ramp)
}

object rampOsc{
  def apply(input: Unit => Double = _ => Date.now()) = new Oscillator(input).oscOp(Osc.Ramp)
}

object Osc{
  def Sin(input:Double)  = Math.sin(input)
  def Rect(input:Double) = (Math.round(input % 1)*2-1).toDouble
  def Ramp(input:Double) = (input % 1)*2-1
  def Triangle(input:Double) = (input % 1)*2-1
}