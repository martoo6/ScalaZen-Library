package main.lib

import scala.scalajs.js

/**
 * Created by martin on 10/17/15.
 */
trait Converters {

  //############# VECTORS ###################


  type vec2Double = (Double, Double)
  type vec2Int    = (Int, Int)
  type vec2DoubleInt = (Double, Int)
  type vec2IntDouble = (Int, Double)

  type vec3Double = (Double, Double, Double)
  type vec3Int    = (Int, Int, Int)
  type vec3IntDoubleDouble = (Int, Double, Double)
  type vec3DoubleIntDouble = (Double, Int, Double)
  type vec3DoubleDoubleInt = (Double, Double, Int)
  type vec3IntIntDouble = (Int, Int, Double)
  type vec3DoubleIntInt = (Double, Int, Int)
  type vec3IntDoubleInt = (Int, Double, Int)

  implicit def Vec3ToVector3(i: vec3Double): Vector3 = new Vector3(i._1, i._2, i._3)
  implicit def Vec3IntToVector3(i: vec3Int): Vector3 = new Vector3(i._1, i._2, i._3)
  implicit def Vec3IntDoubleDoubleToVector3(i: vec3IntDoubleDouble): Vector3 = new Vector3(i._1, i._2, i._3)
  implicit def Vec3DoubleIntDoubleToVector3(i: vec3DoubleIntDouble): Vector3 = new Vector3(i._1, i._2, i._3)
  implicit def Vec3DoubleDoubleIntToVector3(i: vec3DoubleDoubleInt): Vector3 = new Vector3(i._1, i._2, i._3)
  implicit def Vec3IntIntDoubleToVector3(i: vec3IntIntDouble): Vector3 = new Vector3(i._1, i._2, i._3)
  implicit def Vec3DoubleIntIntToVector3(i: vec3DoubleIntInt): Vector3 = new Vector3(i._1, i._2, i._3)
  implicit def Vec3IntDoubleIntToVector3(i: vec3IntDoubleInt): Vector3 = new Vector3(i._1, i._2, i._3)
  implicit def Vec2ToVector3(i: vec2Double): Vector3 = new Vector3(i._1, i._2, 0)
  implicit def Vec2IntToVector3(i: vec2Int): Vector3 = new Vector3(i._1, i._2, 0)
  implicit def Vec2DoubleIntToVector3(i: vec2DoubleInt): Vector3 = new Vector3(i._1, i._2, 0)
  implicit def Vec2IntDoubleToVector3(i: vec2IntDouble): Vector3 = new Vector3(i._1, i._2, 0)
  implicit def IntToDouble(i: Int): Double = i.toDouble
//

//
//
//  //Heterogeneous list would need typeclasses, but those typeclasses wouldn't work with existing threejs code.
//  //actually structural typing would fix the problem, somehow...
  implicit def SeqVec3ToVector3(lst: Seq[vec3Double]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}
  implicit def SeqVec3IntToVector3(lst: Seq[vec3Int]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}
  implicit def SeqVec3IntDoubleDoubleToVector3(lst: Seq[vec3IntDoubleDouble]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}
  implicit def SeqVec3DoubleIntDoubleToVector3(lst: Seq[vec3DoubleIntDouble]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}
  implicit def SeqVec3DoubleDoubleIntToVector3(lst: Seq[vec3DoubleDoubleInt]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}
  implicit def SeqVec3IntIntDoubleToVector3(lst: Seq[vec3IntIntDouble]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}
  implicit def SeqVec3DoubleIntIntToVector3(lst: Seq[vec3DoubleIntInt]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}
  implicit def SeqVec3IntDoubleIntToVector3(lst: Seq[vec3IntDoubleInt]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}
  implicit def SeqVec2ToVector3(lst: Seq[vec2Double]): Seq[Vector3] = lst.map{case(x,y)=>new Vector3(x,y,0)}
  implicit def SeqVec2IntToVector3(lst: Seq[vec2Int]): Seq[Vector3] = lst.map{case(x,y)=>new Vector3(x,y,0)}
  implicit def SeqVec2DoubleIntToVector3(lst: Seq[vec2DoubleInt]): Seq[Vector3] = lst.map{case(x,y)=>new Vector3(x,y,0)}
  implicit def SeqVec2IntDoubleToVector3(lst: Seq[vec2IntDouble]): Seq[Vector3] = lst.map{case(x,y)=>new Vector3(x,y,0)}



//
//  implicit def SeqVec3IntDoubleIntToVector3(i: Seq[{val _1}]): Seq[Vector3] = new Vector3(i._1, i._2, i._3)

  //############# COLORS ###################


  implicit def SeqIntToColor(lst:Seq[Int]): Seq[Color] = lst.map{new Color(_)}

  implicit def IntToColor(value:Int): Color = new Color(value)

  implicit def ColorToRGB(color: Color): RGB = new RGB(color.r, color.g, color.b)

  //############# Materials ###################

  //NOT WORKING !
//  implicit def ColorToMeshBasicMaterial(color:Color): MeshBasicMaterial = {
//    val m = new MeshBasicMaterial(js.Dynamic.literal(color = color))
//    m
//  }
}
