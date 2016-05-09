package main.lib

/**
  * Created by martin on 08/05/16.
  */

trait RichTuples{
  implicit class RichTuple4[T1, T2, T3, T4](t: (T1, T2, T3, T4))(implicit n1:Numeric[T1], n2: Numeric[T2], n3: Numeric[T3], n4: Numeric[T4]){
    def toColor: Color = new Color(n1.toDouble(t._1), n2.toDouble(t._2), n3.toDouble(t._3))
    def alpha: Double = n4.toDouble(t._4)
    def r: Double = n1.toDouble(t._1)
    def g: Double = n2.toDouble(t._2)
    def b: Double = n3.toDouble(t._3)
  }

  implicit class RichTuple3[T1, T2, T3](t: (T1, T2, T3))(implicit n1:Numeric[T1], n2: Numeric[T2], n3: Numeric[T3]){
    def toVector: Vector3 = {
      new Vector3(n1.toDouble(t._1), n2.toDouble(t._2), n3.toDouble(t._3))
    }
    def x: T1 = t._1
    def y: T2 = t._2
    def z: T3 = t._3

    def toColor: Color = new Color(n1.toDouble(t._1), n2.toDouble(t._2), n3.toDouble(t._3))
    def alpha: Double = 1
    def r: Double = n1.toDouble(t._1)
    def g: Double = n2.toDouble(t._2)
    def b: Double = n3.toDouble(t._3)
  }

  implicit class RichTuple2[T1, T2](t: (T1, T2))(implicit n1:Numeric[T1], n2: Numeric[T2]){
    def toVector(t: (T1, T2)): Vector3 = {
      new Vector3(n1.toDouble(t._1), n2.toDouble(t._2), 0)
    }
    def x: T1 = t._1
    def y: T2 = t._2
    def z: Double = 0

    def toColor: Color = new Color(n1.toDouble(t._1), n1.toDouble(t._1), n1.toDouble(t._1))
    def alpha: Double = n2.toDouble(t._2)
    def r: Double = n1.toDouble(t._1)
    def g: Double = n1.toDouble(t._1)
    def b: Double = n1.toDouble(t._1)
  }
}

object RichTuples extends RichTuples