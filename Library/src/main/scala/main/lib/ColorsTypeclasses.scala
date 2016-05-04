package main.lib

/**
  * Created by martin on 04/05/16.
  */
trait ColorsTypeclasses{
  trait ColorTypeclass[T]{
    def toColor(t: T): Color
    def alpha(t: T): Double
  }

  implicit object ColorToColorTypeclass extends ColorTypeclass[Color]{
    def toColor(t:Color): Color = t
    def alpha(t: Color): Double = 1
  }

  implicit object RGBToColorTypeclass extends ColorTypeclass[RGB]{
    def toColor(t:RGB): Color = t.toColor
    def alpha(t: RGB): Double = t.o
  }

  implicit object HSBToColorTypeclass extends ColorTypeclass[HSB]{
    def toColor(t:HSB): Color = t.toColor
    def alpha(t: HSB): Double = t.o
  }

  implicit object GRYToColorTypeclass extends ColorTypeclass[GRY]{
    def toColor(t:GRY): Color = t.toColor
    def alpha(t: GRY): Double = t.o
  }

  //Same as Grayscale
  implicit object Tuple2ToColorTypeclass extends ColorTypeclass[(Double, Double)]{
    def toColor(t: (Double,Double)): Color = new Color(t._1, t._1, t._1)
    def alpha(t: (Double,Double)): Double = t._2
  }

  //Same as RGB without ALPHA - Could Change with some king of color mode
  implicit object Tuple3ToColorTypeclass extends ColorTypeclass[(Double, Double, Double)]{
    def toColor(t: (Double, Double, Double)): Color = new Color(t._1, t._2, t._3)
    def alpha(t: (Double, Double, Double)): Double = 1
  }

  //Same as RGB - Could Change with some king of color mode
  implicit object Tuple4ToColorTypeclass extends ColorTypeclass[(Double, Double, Double, Double)]{
    def toColor(t: (Double, Double, Double, Double)): Color = new Color(t._1, t._2, t._3)
    def alpha(t: (Double, Double, Double, Double)): Double = t._4
  }
}
