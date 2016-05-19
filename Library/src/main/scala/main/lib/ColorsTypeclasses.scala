package main.lib

/**
  * Created by martin on 04/05/16.
  */
object ColorsTypeclasses extends ColorsTypeclasses

trait ColorsTypeclasses{
  trait ColorTypeclass[T]{
    def toColor(t: T): Color
    def alpha(t: T): Float
    def r(t: T):Float
    def g(t: T):Float
    def b(t: T):Float
  }

  implicit object IntToColorTypeclass extends ColorTypeclass[Int]{
    def toColor(t:Int): Color = new Color(t)
    def alpha(t: Int): Float = 1
    def r(t: Int):Float = new Color(t).r
    def g(t: Int):Float = new Color(t).g
    def b(t: Int):Float = new Color(t).b
  }

  implicit object ColorToColorTypeclass extends ColorTypeclass[Color]{
    def toColor(t:Color): Color = t
    def alpha(t: Color): Float = 1
    def r(t: Color):Float = t.r
    def g(t: Color):Float = t.g
    def b(t: Color):Float = t.b
  }

  implicit object RGBToColorTypeclass extends ColorTypeclass[RGB]{
    def toColor(t:RGB): Color = t.toColor
    def alpha(t: RGB): Float = t.o
    def r(t: RGB):Float = t.r
    def g(t: RGB):Float = t.g
    def b(t: RGB):Float = t.b
  }

  implicit object HSBToColorTypeclass extends ColorTypeclass[HSB]{
    def toColor(t:HSB): Color = t.toColor
    def alpha(t: HSB): Float = t.o
    //TODO: Improve !
    def r(t: HSB):Float = t.toColor.r
    def g(t: HSB):Float = t.toColor.g
    def b(t: HSB):Float = t.toColor.b
  }

  implicit object GRYToColorTypeclass extends ColorTypeclass[GRY]{
    def toColor(t:GRY): Color = t.toColor
    def alpha(t: GRY): Float = t.o
    def r(t: GRY):Float = t.v
    def g(t: GRY):Float = t.v
    def b(t: GRY):Float = t.v
  }



  //  //Same as Grayscale
  implicit def Tuple2ToColorTypeclass[T1, T2](implicit n1:Numeric[T1], n2:Numeric[T2]): ColorTypeclass[(T1,T2)] ={
    new ColorTypeclass[(T1, T2)] {
      def toColor(t: (T1, T2)): Color = new Color(n1.toFloat(t._1), n1.toFloat(t._1), n1.toFloat(t._1))
      def alpha(t: (T1, T2)): Float = n2.toFloat(t._2)
      def r(t: (T1, T2)): Float = n1.toFloat(t._1)
      def g(t: (T1, T2)): Float = n1.toFloat(t._1)
      def b(t: (T1, T2)): Float = n1.toFloat(t._1)
    }
  }

  //  //Same as RGB without ALPHA - Could Change with some king of color mode
  implicit def Tuple3ToColorTypeclass[T1, T2, T3](implicit n1:Numeric[T1], n2:Numeric[T2], n3:Numeric[T3]): ColorTypeclass[(T1,T2,T3)] ={
    new ColorTypeclass[(T1,T2,T3)] {
      def toColor(t: (T1, T2, T3)): Color = new Color(n1.toFloat(t._1), n2.toFloat(t._2), n3.toFloat(t._3))
      def alpha(t: (T1, T2, T3)): Float = 1
      def r(t: (T1, T2, T3)): Float = n1.toFloat(t._1)
      def g(t: (T1, T2, T3)): Float = n2.toFloat(t._2)
      def b(t: (T1, T2, T3)): Float = n3.toFloat(t._3)
    }
  }

  //Same as RGB - Could Change with some king of color mode
  implicit def Tuple4ToColorTypeclass[T1, T2, T3, T4](implicit n1:Numeric[T1], n2:Numeric[T2], n3:Numeric[T3], n4:Numeric[T4]): ColorTypeclass[(T1,T2,T3, T4)] ={
    new ColorTypeclass[(T1,T2,T3,T4)] {
      def toColor(t: (T1, T2, T3,T4)): Color = new Color(n1.toFloat(t._1), n2.toFloat(t._2), n3.toFloat(t._3))
      def alpha(t: (T1, T2, T3,T4)): Float = n4.toFloat(t._4)
      def r(t: (T1, T2, T3,T4)): Float = n1.toFloat(t._1)
      def g(t: (T1, T2, T3,T4)): Float = n2.toFloat(t._2)
      def b(t: (T1, T2, T3,T4)): Float = n3.toFloat(t._3)
    }
  }

  //This allows for heterogeneous lists !
  type StructuralColorType = {def toColor: Color; def alpha:Float; def r:Float; def g:Float; def b:Float}
  implicit object StructuralColorTypeclass extends ColorTypeclass[StructuralColorType]{
    def toColor(t: StructuralColorType): Color = t.toColor
    def alpha(t: StructuralColorType): Float = t.alpha
    def r(t: StructuralColorType): Float = t.r
    def b(t: StructuralColorType): Float = t.g
    def g(t: StructuralColorType): Float = t.b
  }
}
