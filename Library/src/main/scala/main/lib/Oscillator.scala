package main.lib

import scala.scalajs.js.Date

/**
  * Created by martin on 04/11/15.
  */
class Oscillator(var input: Unit => Float = _ => Date.now().toFloat){
  implicit def toFloat(d:Double):Float = d.toFloat

  var amplitude = 1.0
  var frequency = 1.0
  var oscOperation: Float => Float = Osc.Sin
  var scale = (-1.0, 1.0)
  val attachments = scala.collection.mutable.ListBuffer[Float => Unit]()

  def get(manualInput: Float = input()) = MathUtils.map(oscOperation(manualInput*frequency), -1, 1, scale._1, scale._2)
  def get = MathUtils.map(oscOperation(input()*frequency), -1, 1, scale._1, scale._2)
  def run = {
    val value = get
    attachments.foreach(_(value))
  }

  def amplitude(_amplitude:Float): Oscillator = {
    amplitude = _amplitude
    this
  }
  def frequency(_frequency:Float): Oscillator ={
    frequency = _frequency
    this
  }
  def scale(from:Float, to:Float): Oscillator ={
    scale = (from, to)
    this
  }
  def oscOp(_oscOperation: Float => Float): Oscillator ={
    oscOperation = _oscOperation
    this
  }
  def attach(f: Float => Unit) = {
    attachments+=f
    this
  }

}

object pSinOsc{
  def apply(input: Unit => Float = _ => Date.now().toFloat) = new Oscillator(input).scale(0,1).oscOp(Osc.Sin)
}

object sinOsc{
  def apply(input: Unit => Float = _ => Date.now().toFloat) = new Oscillator(input).oscOp(Osc.Sin)
}

object pRectOsc{
  def apply(input: Unit => Float = _ => Date.now().toFloat) = new Oscillator(input).scale(0,1).oscOp(Osc.Rect)
}

object rectOsc{
  def apply(input: Unit => Float = _ => Date.now().toFloat) = new Oscillator(input).oscOp(Osc.Rect)
}

object pRampOsc{
  def apply(input: Unit => Float = _ => Date.now().toFloat) = new Oscillator(input).scale(0,1).oscOp(Osc.Ramp)
}

object rampOsc{
  def apply(input: Unit => Float = _ => Date.now().toFloat) = new Oscillator(input).oscOp(Osc.Ramp)
}

object Osc{
  def Sin(input:Float)  = Math.sin(input).toFloat
  def Rect(input:Float) = (Math.round(input % 1)*2-1).toFloat
  def Ramp(input:Float) = (input % 1)*2-1
  def Triangle(input:Float) = (input % 1)*2-1
}