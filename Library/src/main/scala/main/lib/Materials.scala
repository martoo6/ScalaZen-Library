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

  implicit object RGBToLineMaterial extends LineMaterialTypeClass[RGB, LineBasicMaterial]{
    override def toLineMaterial(t: RGB): LineBasicMaterial = {
      val l = new LineBasicMaterial(js.Dynamic.literal(color = t.toColor, side= faceSide, linewidth = defaultLineMaterial.linewidth))
      l.opacity = t.o
      l
    }
  }

  implicit object ColorToLineMaterial extends LineMaterialTypeClass[Color, LineBasicMaterial]{
    override def toLineMaterial(t: Color): LineBasicMaterial = new LineBasicMaterial(js.Dynamic.literal(color = t, side= faceSide, linewidth = defaultLineMaterial.linewidth))
  }

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

  implicit object Tuple4ToMeshMaterial extends MeshMaterialTypeClass[(Double,Double,Double,Double), MeshBasicMaterial]{
    override def toMeshMaterial(t: (Double,Double,Double,Double)): MeshBasicMaterial = new MeshBasicMaterial(js.Dynamic.literal(color = new Color(t._1, t._2, t._3), side= faceSide, transparent=true, opacity = t._4))
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
