enablePlugins(ScalaJSPlugin)

name := "ThreeJScalaJS"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.0"

libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.8.0"

libraryDependencies += "org.webjars" % "jquery" % "1.10.2"

libraryDependencies += "org.webjars.bower" % "three.js" % "0.73.0"

jsDependencies += "org.webjars" % "jquery" % "1.10.2" / "jquery.js"
jsDependencies += "org.webjars.bower" % "three.js" % "0.73.0" / "three.js" minified "three.min.js"
jsDependencies += ProvidedJS / "js/OrbitControls.js" dependsOn "three.js"
jsDependencies += ProvidedJS / "js/stats.min.js"
jsDependencies += ProvidedJS / "js/shaders/FXAAShader.js"
jsDependencies += ProvidedJS / "js/postprocessing/EffectComposer.js"
jsDependencies += ProvidedJS / "js/postprocessing/ShaderPass.js"
jsDependencies += ProvidedJS / "js/postprocessing/RenderPass.js"
jsDependencies += ProvidedJS / "js/postprocessing/MaskPass.js"
jsDependencies += ProvidedJS / "js/shaders/CopyShader.js"
jsDependencies += ProvidedJS / "js/shaders/FilmShader.js"
jsDependencies += ProvidedJS / "js/shaders/MirrorShader.js"
jsDependencies += ProvidedJS / "js/recorder/Whammy.js"
jsDependencies += ProvidedJS / "js/recorder/gif.js"
jsDependencies += ProvidedJS / "js/recorder/CCapture.min.js"

skip in packageJSDependencies := false

persistLauncher in Compile := true

persistLauncher in Test := false