package main

/**
 * Created by martin on 10/17/15.
 */
trait Converters {

  //############# VECTORS ###################

  type vec3Double = (Double, Double, Double)
  type vec3Int    = (Int, Int, Int)
  type vec2Double = (Double, Double)
  type vec2Int    = (Int, Int)

  type vec2DoubleInt = (Double, Int)
  type vec2IntDouble = (Int, Double)

  type vec3IntDoubleDouble = (Int, Double, Double)
  type vec3DoubleIntDouble = (Double, Int, Double)
  type vec3DoubleDoubleInt = (Double, Double, Int)
  type vec3IntIntDouble = (Int, Int, Double)
  type vec3DoubleIntInt = (Double, Int, Int)
  type vec3IntDoubleInt = (Int, Double, Int)

  implicit def Vec3IntToDouble(i: vec3Int): vec3Double = (i._1.toDouble, i._2.toDouble, i._3.toDouble)

  implicit def Vec2IntToDouble(i: vec2Int): vec2Double = (i._1.toDouble, i._2.toDouble)

  implicit def Vec3ToVector3(i: vec3Double): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec2ToVector3(i: vec2Double): Vector3 = new Vector3(i._1, i._2, 0)

  implicit def Vec3IntToVector3(i: vec3Int): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec3IntDoubleDoubleToVector3(i: vec3IntDoubleDouble): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec3DoubleIntDoubleToVector3(i: vec3DoubleIntDouble): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec3DoubleDoubleIntToVector3(i: vec3DoubleDoubleInt): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec3IntIntDoubleToVector3(i: vec3IntIntDouble): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec3DoubleIntIntToVector3(i: vec3DoubleIntInt): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec3IntDoubleIntToVector3(i: vec3IntDoubleInt): Vector3 = new Vector3(i._1, i._2, i._3)

  implicit def Vec2IntToVector3(i: vec2Int): Vector3 = new Vector3(i._1, i._2, 0)

  implicit def Vec2DoubleIntToVector3(i: vec2DoubleInt): Vector3 = new Vector3(i._1, i._2, 0)

  implicit def Vec2IntDoubleToVector3(i: vec2IntDouble): Vector3 = new Vector3(i._1, i._2, 0)

  implicit def IntToDouble(i: Int): Double = i.toDouble

  implicit def SeqVec3ToVector3(lst:Seq[vec3Double]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}

  implicit def SeqVec2ToVector3(lst:Seq[vec2Double]): Seq[Vector3] = lst.map{case(x,y)=>new Vector3(x,y,0)}


  //############# COLORS ###################


  implicit def SeqIntToColor(lst:Seq[Int]): Seq[Color] = lst.map{new Color(_)}

  implicit def IntToColor(value:Int): Color = new Color(value)
}
