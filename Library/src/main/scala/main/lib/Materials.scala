package main.lib

import scala.scalajs.js

/**
  * Created by martin on 04/05/16.
  */
trait Materials {
  this:Canvas=>
  //#######################  MATERIALS #########################
  //TODO: Might include an optional service that searches for cached colors, textures, etc. ?

  var defaultLineMaterial: LineBasicMaterial = new LineBasicMaterial(js.Dynamic.literal(color = 0xFFFFFF, side= faceSide))

  trait LineMaterialTypeClass[T, W <: Material]{
    def toLineMaterial(t:T): W
  }

// Not working
//  implicit def Tuple2ToLineMaterial[T1,T2](t: (T1,T2))(implicit n1:Numeric[T1], n2:Numeric[T2]): LineMaterialTypeClass[(T1,T2), LineBasicMaterial] = {
//    new LineMaterialTypeClass[(T1,T2), LineBasicMaterial]{
//      def toLineMaterial(t: (T1,T2)): LineBasicMaterial = {
//        val l = new LineBasicMaterial(js.Dynamic.literal(color = new Color(n1.toFloat(t._1), n1.toFloat(t._1), n1.toFloat(t._1)), side= faceSide, linewidth = defaultLineMaterial.linewidth))
//        l.opacity = n2.toFloat(t._2)
//        l
//      }
//    }
//  }
//
//  implicit def Tuple3ToLineMaterial[T1,T2,T3](t: (T1,T2,T3))(implicit n1:Numeric[T1], n2:Numeric[T2], n3:Numeric[T3]): LineMaterialTypeClass[(T1,T2,T3), LineBasicMaterial] = {
//    new LineMaterialTypeClass[(T1,T2,T3), LineBasicMaterial]{
//      def toLineMaterial(t: (T1,T2,T3)): LineBasicMaterial = {
//        val l = new LineBasicMaterial(js.Dynamic.literal(color = new Color(n1.toFloat(t._1), n2.toFloat(t._2), n3.toFloat(t._3)), side= faceSide, linewidth = defaultLineMaterial.linewidth))
//        l.opacity = 1
//        l
//      }
//    }
//  }
//
//  implicit def Tuple4ToLineMaterial[T1,T2,T3,T4](t: (T1,T2,T3,T4))(implicit n1:Numeric[T1], n2:Numeric[T2], n3:Numeric[T3], n4:Numeric[T4]): LineMaterialTypeClass[(T1,T2,T3,T4), LineBasicMaterial] = {
//    new LineMaterialTypeClass[(T1,T2,T3,T4), LineBasicMaterial]{
//      def toLineMaterial(t: (T1,T2,T3,T4)): LineBasicMaterial = {
//        val l = new LineBasicMaterial(js.Dynamic.literal(color = new Color(n1.toFloat(t._1), n2.toFloat(t._2), n3.toFloat(t._3)), side= faceSide, linewidth = defaultLineMaterial.linewidth))
//        l.opacity = n4.toFloat(t._4)
//        l
//      }
//    }
//  }

//  implicit object GRYToLineMaterial extends LineMaterialTypeClass[GRY, LineBasicMaterial]{
//    override def toLineMaterial(t: GRY): LineBasicMaterial = {
//      val l = new LineBasicMaterial(js.Dynamic.literal(color = t.toColor, side= faceSide, linewidth = defaultLineMaterial.linewidth))
//      l.opacity = t.o
//      l
//    }
//  }
//
//  implicit object HSBToLineMaterial extends LineMaterialTypeClass[HSB, LineBasicMaterial]{
//    override def toLineMaterial(t: HSB): LineBasicMaterial = {
//      val l = new LineBasicMaterial(js.Dynamic.literal(color = t.toColor, side= faceSide, linewidth = defaultLineMaterial.linewidth))
//      l.opacity = t.o
//      l
//    }
//  }
//
//  implicit object RGBToLineMaterial extends LineMaterialTypeClass[RGB, LineBasicMaterial]{
//    override def toLineMaterial(t: RGB): LineBasicMaterial = {
//      val l = new LineBasicMaterial(js.Dynamic.literal(color = t.toColor, side= faceSide, linewidth = defaultLineMaterial.linewidth))
//      l.opacity = t.o
//      l
//    }
//  }
//
//  implicit object ColorToLineMaterial extends LineMaterialTypeClass[Color, LineBasicMaterial]{
//    override def toLineMaterial(t: Color): LineBasicMaterial = new LineBasicMaterial(js.Dynamic.literal(color = t, side= faceSide, linewidth = defaultLineMaterial.linewidth))
//  }
//

  implicit object LineBasicMaterialToLineMaterial extends LineMaterialTypeClass[LineBasicMaterial, LineBasicMaterial]{
    override def toLineMaterial(t: LineBasicMaterial): LineBasicMaterial = t
  }

  implicit object LineDashedMaterialToLineMaterial extends LineMaterialTypeClass[LineDashedMaterial, LineDashedMaterial]{
    override def toLineMaterial(t: LineDashedMaterial): LineDashedMaterial = t
  }


  var defaultMeshMaterial = new MeshBasicMaterial(js.Dynamic.literal(color = 0xFFFFFF, side = faceSide))

  trait MeshMaterialTypeClass[T, W <: Material]{
    def toMeshMaterial(t:T): W
  }

  implicit object ColorToMeshMaterial extends MeshMaterialTypeClass[Color, MeshBasicMaterial]{
    override def toMeshMaterial(t: Color): MeshBasicMaterial = new MeshBasicMaterial(js.Dynamic.literal(color = t, side= faceSide))
  }

  implicit object Tuple4ToMeshMaterial extends MeshMaterialTypeClass[(Float,Float,Float,Float), MeshBasicMaterial]{
    override def toMeshMaterial(t: (Float,Float,Float,Float)): MeshBasicMaterial = new MeshBasicMaterial(js.Dynamic.literal(color = new Color(t._1, t._2, t._3), side= faceSide, transparent=true, opacity = t._4))
  }

  implicit object RgbToMeshMaterial extends MeshMaterialTypeClass[RGB, MeshBasicMaterial]{
    override def toMeshMaterial(t: RGB): MeshBasicMaterial =  t match {
      case RGB(r, g, b, 1) => new MeshBasicMaterial(js.Dynamic.literal(color = new Color(r, g, b), side= faceSide))
      case RGB(r, g, b, o) => new MeshBasicMaterial(js.Dynamic.literal(color = new Color(r, g, b), side= faceSide, transparent=true, opacity = o))
    }
  }

  implicit object HsbToMeshMaterial extends MeshMaterialTypeClass[HSB, MeshBasicMaterial]{
    override def toMeshMaterial(t: HSB): MeshBasicMaterial =  t match {
      case HSB(h, s, b, 1) => new MeshBasicMaterial(js.Dynamic.literal(color = new Color().setHSL(h, s, b), side= faceSide))
      case HSB(h, s, b, o) => new MeshBasicMaterial(js.Dynamic.literal(color = new Color().setHSL(h, s, b), side= faceSide, transparent=true, opacity = o))
    }
  }

  implicit object GryToMeshMaterial extends MeshMaterialTypeClass[GRY, MeshBasicMaterial]{
    override def toMeshMaterial(t: GRY): MeshBasicMaterial =  t match {
      case GRY(v, 1) => new MeshBasicMaterial(js.Dynamic.literal(color = new Color(v, v, v), side= faceSide))
      case GRY(v, o) => new MeshBasicMaterial(js.Dynamic.literal(color = new Color(v, v, v), side= faceSide, transparent=true, opacity = o))
    }
  }

  implicit object MeshBasicMaterialToLineMaterial extends MeshMaterialTypeClass[MeshBasicMaterial, MeshBasicMaterial]{
    override def toMeshMaterial(t: MeshBasicMaterial): MeshBasicMaterial = t
  }

  implicit object MeshLambertMaterialToLineMaterial extends MeshMaterialTypeClass[MeshLambertMaterial, MeshLambertMaterial]{
    override def toMeshMaterial(t: MeshLambertMaterial): MeshLambertMaterial = t
  }

  implicit object MeshPhongMaterialToLineMaterial extends MeshMaterialTypeClass[MeshPhongMaterial, MeshPhongMaterial]{
    override def toMeshMaterial(t: MeshPhongMaterial): MeshPhongMaterial = t
  }
}
