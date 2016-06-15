name := "ScalaZen"

lazy val root = (project in file(".")).settings(publish := { }).aggregate(Library, Examples)

lazy val commonSettings = Seq(
  version := "1.0.0",
  scalaVersion := "2.11.8"
)

lazy val Library =  project.
enablePlugins(ScalaJSPlugin).
settings(commonSettings: _*).
settings(
  name := "ScalaZen",
  libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.0",
  libraryDependencies += "org.webjars.bower" % "three.js" % "0.73.0",
  jsDependencies += "org.webjars.bower" % "three.js" % "0.73.0" / "three.js" minified "three.min.js",
  jsDependencies += ProvidedJS / "js/OrbitControls.js" dependsOn "three.js",
  jsDependencies += ProvidedJS / "js/stats.min.js",
  jsDependencies += ProvidedJS / "js/shaders/FXAAShader.js",
  jsDependencies += ProvidedJS / "js/postprocessing/EffectComposer.js",
  jsDependencies += ProvidedJS / "js/postprocessing/ShaderPass.js",
  jsDependencies += ProvidedJS / "js/postprocessing/RenderPass.js",
  jsDependencies += ProvidedJS / "js/postprocessing/MaskPass.js",
  jsDependencies += ProvidedJS / "js/shaders/CopyShader.js",
  jsDependencies += ProvidedJS / "js/shaders/FilmShader.js",
  jsDependencies += ProvidedJS / "js/shaders/MirrorShader.js",
  jsDependencies += ProvidedJS / "js/CCapture.all.min.js",
  jsDependencies += ProvidedJS / "js/FileSaver.min.js",
  jsDependencies += ProvidedJS / "js/CanvasToBlob.js",
  jsDependencies += ProvidedJS / "js/gif.worker.js",


  test in assembly := {},
  skip in packageJSDependencies := false,
  //persistLauncher in Compile := true,
  persistLauncher in Test := false,

  assemblyMergeStrategy in assembly := {
    case "JS_DEPENDENCIES"     => MergeStrategy.first
    //case "scalajs-dom_sjs0.6_2.11-0.9.0.jar"  => MergeStrategy.first
    case x =>
      val oldStrategy = (assemblyMergeStrategy in assembly).value
      oldStrategy(x)
  },
  publishTo := {
                 val nexus = "http://nexus-fakevyral.rhcloud.com/nexus/"
                 if (version.value.trim.endsWith("SNAPSHOT"))
                   Some("snapshots" at nexus + "content/repositories/snapshots")
                 else
                   Some("releases"  at nexus + "content/repositories/releases")
               }
)

lazy val Examples = project.
enablePlugins(ScalaJSPlugin).
settings(commonSettings: _*).
settings(
  test in assembly := {},
  skip in packageJSDependencies := false,
  persistLauncher in Compile := true,
  persistLauncher in Test := false,
  publish := { }
).
aggregate(Library).
dependsOn(Library)

