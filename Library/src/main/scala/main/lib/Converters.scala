package main.lib

import scala.scalajs.js

/**
 * Created by martin on 10/17/15.
 */
trait Converters {

  //############# VECTORS ###################


  type vec2Float = (Float, Float)
  type vec2Int    = (Int, Int)
  type vec2FloatInt = (Float, Int)
  type vec2IntFloat = (Int, Float)

  type vec3Float = (Float, Float, Float)
  type vec3Int    = (Int, Int, Int)
  type vec3IntFloatFloat = (Int, Float, Float)
  type vec3FloatIntFloat = (Float, Int, Float)
  type vec3FloatFloatInt = (Float, Float, Int)
  type vec3IntIntFloat = (Int, Int, Float)
  type vec3FloatIntInt = (Float, Int, Int)
  type vec3IntFloatInt = (Int, Float, Int)

  implicit def Vec3ToVector3(i: vec3Float): Vector3 = new Vector3(i._1, i._2, i._3)
  implicit def Vec3IntToVector3(i: vec3Int): Vector3 = new Vector3(i._1, i._2, i._3)
  implicit def Vec3IntFloatFloatToVector3(i: vec3IntFloatFloat): Vector3 = new Vector3(i._1, i._2, i._3)
  implicit def Vec3FloatIntFloatToVector3(i: vec3FloatIntFloat): Vector3 = new Vector3(i._1, i._2, i._3)
  implicit def Vec3FloatFloatIntToVector3(i: vec3FloatFloatInt): Vector3 = new Vector3(i._1, i._2, i._3)
  implicit def Vec3IntIntFloatToVector3(i: vec3IntIntFloat): Vector3 = new Vector3(i._1, i._2, i._3)
  implicit def Vec3FloatIntIntToVector3(i: vec3FloatIntInt): Vector3 = new Vector3(i._1, i._2, i._3)
  implicit def Vec3IntFloatIntToVector3(i: vec3IntFloatInt): Vector3 = new Vector3(i._1, i._2, i._3)
  implicit def Vec2ToVector3(i: vec2Float): Vector3 = new Vector3(i._1, i._2, 0)
  implicit def Vec2IntToVector3(i: vec2Int): Vector3 = new Vector3(i._1, i._2, 0)
  implicit def Vec2FloatIntToVector3(i: vec2FloatInt): Vector3 = new Vector3(i._1, i._2, 0)
  implicit def Vec2IntFloatToVector3(i: vec2IntFloat): Vector3 = new Vector3(i._1, i._2, 0)
  //implicit def IntToFloat(i: Int): Float = i.toFloat
//

//
//
//  //Heterogeneous list would need typeclasses, but those typeclasses wouldn't work with existing threejs code.
//  //actually structural typing would fix the problem, somehow...
  implicit def SeqVec3ToVector3(lst: Seq[vec3Float]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}
  implicit def SeqVec3IntToVector3(lst: Seq[vec3Int]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}
  implicit def SeqVec3IntFloatFloatToVector3(lst: Seq[vec3IntFloatFloat]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}
  implicit def SeqVec3FloatIntFloatToVector3(lst: Seq[vec3FloatIntFloat]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}
  implicit def SeqVec3FloatFloatIntToVector3(lst: Seq[vec3FloatFloatInt]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}
  implicit def SeqVec3IntIntFloatToVector3(lst: Seq[vec3IntIntFloat]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}
  implicit def SeqVec3FloatIntIntToVector3(lst: Seq[vec3FloatIntInt]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}
  implicit def SeqVec3IntFloatIntToVector3(lst: Seq[vec3IntFloatInt]): Seq[Vector3] = lst.map{case(x,y,z)=>new Vector3(x,y,z)}
  implicit def SeqVec2ToVector3(lst: Seq[vec2Float]): Seq[Vector3] = lst.map{case(x,y)=>new Vector3(x,y,0)}
  implicit def SeqVec2IntToVector3(lst: Seq[vec2Int]): Seq[Vector3] = lst.map{case(x,y)=>new Vector3(x,y,0)}
  implicit def SeqVec2FloatIntToVector3(lst: Seq[vec2FloatInt]): Seq[Vector3] = lst.map{case(x,y)=>new Vector3(x,y,0)}
  implicit def SeqVec2IntFloatToVector3(lst: Seq[vec2IntFloat]): Seq[Vector3] = lst.map{case(x,y)=>new Vector3(x,y,0)}
//
//  implicit def SeqVec3IntFloatIntToVector3(i: Seq[{val _1}]): Seq[Vector3] = new Vector3(i._1, i._2, i._3)

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
