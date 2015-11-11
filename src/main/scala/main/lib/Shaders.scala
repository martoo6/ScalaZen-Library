package main.lib

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSBracketAccess, JSName}

/**
 * Created by martin on 20/10/15.
 */
class Shaders {

}

@js.native
class TDiffuse extends js.Object{
  var `type` :String = js.native
  var value  :String = js.native
}

@js.native
class Resolution extends js.Object{
  var `type` :String = js.native
  var value:Vector2 = js.native
}

@js.native
class FXAAShaderUniforms extends js.Object{
  var tDiffuse:TDiffuse = js.native
  var resolution:Resolution = js.native
}

@js.native
@JSName("THREE.FXAAShader")
object FXAAShader extends Shader[FXAAShaderUniforms]{
  @JSBracketAccess
  def apply(name: String): Shader[FXAAShaderUniforms] = js.native
  @JSBracketAccess
  def update(name: String, v: Shader[FXAAShaderUniforms]): Unit = js.native
}

/*
@js.native
@JSName("THREE.FilmShader")
object FilmShader extends Shader{
  @JSBracketAccess
  def apply(name: String): Shader = js.native
  @JSBracketAccess
  def update(name: String, v: Shader): Unit = js.native
}


@js.native
@JSName("THREE.MirrorShader")
object MirrorShader extends Shader{
  @JSBracketAccess
  def apply(name: String): Shader = js.native

  @JSBracketAccess
  def update(name: String, v: Shader): Unit = js.native
}
*/