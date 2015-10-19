package main

import scala.scalajs.js._
import scala.scalajs.js.annotation.JSExport

//Some IDEs will autmatically delete import java.lang.Math._   , try to keep it
//########################

@JSExport
class ThreeJSApp12 extends JSApp with PerlinNoise with DrawingUtils with BasicCanvas {

  Setup.Dim2.LeftBottom.asCanvas.autoClear.withStats

  // postprocessing

  val composer = new EffectComposer( renderer )
  composer.addPass( new RenderPass( scene, camera ) )

  var effect = new ShaderPass( DotScreenShader )
  effect.uniforms("scale").value = 4
  composer.addPass( effect )

  var effect = new THREE.ShaderPass( RGBShiftShader )
  effect.uniforms("amount").value = 0.0015
  effect.renderToScreen = true
  composer.addPass( effect )

  def render():Unit = {
    val pos = random2D
    val c = pos.x.map(0,width,0,1)
    fill(new Color(random(1),0,c))
    val radio = pos.y.map(0,height, 10,50)
    circle(pos, radio)
  }


}
