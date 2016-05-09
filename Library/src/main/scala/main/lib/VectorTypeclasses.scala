package main.lib

/**
  * Created by martin on 08/05/16.
  */
trait VectorTypeclasses{
  trait VectorTypeclass[T]{
    def toVector(t: T): Vector3
    def x(t:T): Double
    def y(t:T): Double
    def z(t:T): Double
  }

  implicit object Vector3ToVectorTypeclass extends VectorTypeclass[Vector3]{
    def toVector(t: Vector3): Vector3 = t
    def x(t: Vector3): Double = t.x
    def y(t: Vector3): Double = t.y
    def z(t: Vector3): Double = t.z
  }

  implicit def Tuple3ToVectorTypeclasss[T1, T2, T3](implicit n1:Numeric[T1], n2:Numeric[T2], n3:Numeric[T3]): VectorTypeclass[(T1,T2,T3)] ={
    new VectorTypeclass[(T1,T2,T3)] {
      override def toVector(t: (T1, T2, T3)): Vector3 = new Vector3(n1.toDouble(t._1), n2.toDouble(t._2), n3.toDouble(t._3))
      override def z(t: (T1, T2, T3)): Double = n1.toDouble(t._1)
      override def y(t: (T1, T2, T3)): Double = n2.toDouble(t._2)
      override def x(t: (T1, T2, T3)): Double = n3.toDouble(t._3)
    }
  }

  implicit def Tuple2ToVectorTypeclasss[T1, T2](implicit n1:Numeric[T1], n2:Numeric[T2]): VectorTypeclass[(T1,T2)] ={
    new VectorTypeclass[(T1,T2)] {
      override def toVector(t: (T1, T2)): Vector3 = new Vector3(n1.toDouble(t._1), n2.toDouble(t._2), 0)
      override def z(t: (T1, T2)): Double = 0
      override def y(t: (T1, T2)): Double = n2.toDouble(t._2)
      override def x(t: (T1, T2)): Double = n1.toDouble(t._1)
    }
  }

  //This allows for heterogeneous lists !
  type StructuralVectorType = {def toVector: Vector3; def x: Double; def y: Double; def z: Double}
  implicit object StructuralVectorTypeclass extends VectorTypeclass[StructuralVectorType]{
    def toVector(t: StructuralVectorType): Vector3 = t.toVector
    def x(t: StructuralVectorType): Double = t.x
    def y(t: StructuralVectorType): Double = t.y
    def z(t: StructuralVectorType): Double = t.z
  }
}

object VectorTypeclasses extends VectorTypeclasses