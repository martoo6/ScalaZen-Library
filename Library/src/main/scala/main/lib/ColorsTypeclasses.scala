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

  implicit object IntToColorTypeclass extends ColorTypeclass[Int]{
    def toColor(t:Int): Color = new Color(t)
    def alpha(t: Int): Double = 1
    def r(t: Int):Double = new Color(t).r
    def g(t: Int):Double = new Color(t).g
    def b(t: Int):Double = new Color(t).b
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



  //  //Same as Grayscale
  implicit def Tuple2ToColorTypeclass[T1, T2](implicit n1:Numeric[T1], n2:Numeric[T2]): ColorTypeclass[(T1,T2)] ={
    new ColorTypeclass[(T1, T2)] {
      def toColor(t: (T1, T2)): Color = new Color(n1.toDouble(t._1), n1.toDouble(t._1), n1.toDouble(t._1))
      def alpha(t: (T1, T2)): Double = n2.toDouble(t._2)
      def r(t: (T1, T2)): Double = n1.toDouble(t._1)
      def g(t: (T1, T2)): Double = n1.toDouble(t._1)
      def b(t: (T1, T2)): Double = n1.toDouble(t._1)
    }
  }

  //  //Same as RGB without ALPHA - Could Change with some king of color mode
  implicit def Tuple3ToColorTypeclass[T1, T2, T3](implicit n1:Numeric[T1], n2:Numeric[T2], n3:Numeric[T3]): ColorTypeclass[(T1,T2,T3)] ={
    new ColorTypeclass[(T1,T2,T3)] {
      def toColor(t: (T1, T2, T3)): Color = new Color(n1.toDouble(t._1), n2.toDouble(t._2), n3.toDouble(t._3))
      def alpha(t: (T1, T2, T3)): Double = 1
      def r(t: (T1, T2, T3)): Double = n1.toDouble(t._1)
      def g(t: (T1, T2, T3)): Double = n2.toDouble(t._2)
      def b(t: (T1, T2, T3)): Double = n3.toDouble(t._3)
    }
  }

  //Same as RGB - Could Change with some king of color mode
  implicit def Tuple4ToColorTypeclass[T1, T2, T3, T4](implicit n1:Numeric[T1], n2:Numeric[T2], n3:Numeric[T3], n4:Numeric[T4]): ColorTypeclass[(T1,T2,T3, T4)] ={
    new ColorTypeclass[(T1,T2,T3,T4)] {
      def toColor(t: (T1, T2, T3,T4)): Color = new Color(n1.toDouble(t._1), n2.toDouble(t._2), n3.toDouble(t._3))
      def alpha(t: (T1, T2, T3,T4)): Double = n4.toDouble(t._4)
      def r(t: (T1, T2, T3,T4)): Double = n1.toDouble(t._1)
      def g(t: (T1, T2, T3,T4)): Double = n2.toDouble(t._2)
      def b(t: (T1, T2, T3,T4)): Double = n3.toDouble(t._3)
    }
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
