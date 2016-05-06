package main.lib

/**
  * Created by martin on 04/05/16.
  */
trait ColorsTypeclasses{
  trait ColorTypeclass[T]{
    def toColor(t: T): Color
    def alpha(t: T): Double
    def r(t: T):Double
    def g(t: T):Double
    def b(t: T):Double
  }

  implicit object ColorToColorTypeclass extends ColorTypeclass[Color]{
    def toColor(t:Color): Color = t
    def alpha(t: Color): Double = 1
    def r(t: Color):Double = t.r
    def g(t: Color):Double = t.g
    def b(t: Color):Double = t.b
  }

  implicit object RGBToColorTypeclass extends ColorTypeclass[RGB]{
    def toColor(t:RGB): Color = t.toColor
    def alpha(t: RGB): Double = t.o
    def r(t: RGB):Double = t.r
    def g(t: RGB):Double = t.g
    def b(t: RGB):Double = t.b
  }

  implicit object HSBToColorTypeclass extends ColorTypeclass[HSB]{
    def toColor(t:HSB): Color = t.toColor
    def alpha(t: HSB): Double = t.o
    //TODO: Improve !
    def r(t: HSB):Double = t.toColor.r
    def g(t: HSB):Double = t.toColor.g
    def b(t: HSB):Double = t.toColor.b
  }

  implicit object GRYToColorTypeclass extends ColorTypeclass[GRY]{
    def toColor(t:GRY): Color = t.toColor
    def alpha(t: GRY): Double = t.o
    def r(t: GRY):Double = t.v
    def g(t: GRY):Double = t.v
    def b(t: GRY):Double = t.v
  }

  //Same as Grayscale
  implicit object Tuple2ToColorTypeclass extends ColorTypeclass[(Double, Double)]{
    def toColor(t: (Double,Double)): Color = new Color(t._1, t._1, t._1)
    def alpha(t: (Double,Double)): Double = t._2
    def r(t: (Double,Double)):Double = t._1
    def g(t: (Double,Double)):Double = t._1
    def b(t: (Double,Double)):Double = t._1
  }

  //Same as RGB without ALPHA - Could Change with some king of color mode
  implicit object Tuple3ToColorTypeclass extends ColorTypeclass[(Double, Double, Double)]{
    def toColor(t: (Double, Double, Double)): Color = new Color(t._1, t._2, t._3)
    def alpha(t: (Double, Double, Double)): Double = 1
    def r(t: (Double, Double, Double)):Double = t._1
    def g(t: (Double, Double, Double)):Double = t._2
    def b(t: (Double, Double, Double)):Double = t._3
  }

  //Same as RGB - Could Change with some king of color mode
  implicit object Tuple4ToColorTypeclass extends ColorTypeclass[(Double, Double, Double, Double)]{
    def toColor(t: (Double, Double, Double, Double)): Color = new Color(t._1, t._2, t._3)
    def alpha(t: (Double, Double, Double, Double)): Double = t._4
    def r(t: (Double, Double, Double, Double)):Double = t._1
    def g(t: (Double, Double, Double, Double)):Double = t._2
    def b(t: (Double, Double, Double, Double)):Double = t._3
  }

  //This allows for heterogeneous lists !
  type StructuralColorType = {def toColor: Color; def alpha:Double; def r:Double; def g:Double; def b:Double}
  implicit object StructuralColorTypeclass extends ColorTypeclass[StructuralColorType]{
    def toColor(t: StructuralColorType): Color = t.toColor
    def alpha(t: StructuralColorType): Double = t.alpha
    def r(t: StructuralColorType): Double = t.r
    def b(t: StructuralColorType): Double = t.g
    def g(t: StructuralColorType): Double = t.b
  }
}
