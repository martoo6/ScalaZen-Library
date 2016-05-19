package main.lib

/**
  * Created by martin on 08/05/16.
  */
trait VectorTypeclasses{
  trait VectorTypeclass[T]{
    def toVector(t: T): Vector3
    def x(t:T): Float
    def y(t:T): Float
    def z(t:T): Float
  }

  implicit object Vector3ToVectorTypeclass extends VectorTypeclass[Vector3]{
    def toVector(t: Vector3): Vector3 = t
    def x(t: Vector3): Float = t.x
    def y(t: Vector3): Float = t.y
    def z(t: Vector3): Float = t.z
  }

  implicit def Tuple3ToVectorTypeclasss[T1, T2, T3](implicit n1:Numeric[T1], n2:Numeric[T2], n3:Numeric[T3]): VectorTypeclass[(T1,T2,T3)] ={
    new VectorTypeclass[(T1,T2,T3)] {
      override def toVector(t: (T1, T2, T3)): Vector3 = new Vector3(n1.toFloat(t._1), n2.toFloat(t._2), n3.toFloat(t._3))
      override def z(t: (T1, T2, T3)): Float = n1.toFloat(t._1)
      override def y(t: (T1, T2, T3)): Float = n2.toFloat(t._2)
      override def x(t: (T1, T2, T3)): Float = n3.toFloat(t._3)
    }
  }

  implicit def Tuple2ToVectorTypeclasss[T1, T2](implicit n1:Numeric[T1], n2:Numeric[T2]): VectorTypeclass[(T1,T2)] ={
    new VectorTypeclass[(T1,T2)] {
      override def toVector(t: (T1, T2)): Vector3 = new Vector3(n1.toFloat(t._1), n2.toFloat(t._2), 0)
      override def z(t: (T1, T2)): Float = 0
      override def y(t: (T1, T2)): Float = n2.toFloat(t._2)
      override def x(t: (T1, T2)): Float = n1.toFloat(t._1)
    }
  }

  //This allows for heterogeneous lists !
  type StructuralVectorType = {def toVector: Vector3; def x: Float; def y: Float; def z: Float}
  implicit object StructuralVectorTypeclass extends VectorTypeclass[StructuralVectorType]{
    def toVector(t: StructuralVectorType): Vector3 = t.toVector
    def x(t: StructuralVectorType): Float = t.x
    def y(t: StructuralVectorType): Float = t.y
    def z(t: StructuralVectorType): Float = t.z
  }
}

object VectorTypeclasses extends VectorTypeclasses