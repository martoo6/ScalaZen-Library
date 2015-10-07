//package main
//
//import java.lang.Math._
//
//import main.THREE._
//import org.scalajs.dom._
//
///**
// * Created by martin on 09/10/14.
// */
//object MyApp{
////  val scene = new Scene()
////  val camera = new PerspectiveCamera(750, window.innerWidth/ window.innerHeight, 0.1, 1000)
////
////  def getMesh: Mesh={
////    val material = new MeshLambertMaterial()
////    material.color = new Color(random,random,random)
////    val mesh = new Mesh(new BoxGeometry(1+random,1+random,1+random), material)
////    mesh.position.set(-100+random*200, -100+random*200, 0)
////    mesh
////  }
////
////  val meshes = Seq.fill(1000)(getMesh)
////
////  meshes.foreach(scene.add(_))
////
////
////  def setup(): Unit ={
////    camera.position.z = 300
////
////    val light = new PointLight(0xFFFFFF)
////    light.position.set(0, 0, 100)
////    scene.add(light)
////  }
////
////  def render(): Unit ={
////    meshes.foreach(_.rotation.x +=0.01)
////    meshes.foreach(_.rotation.y +=0.01)
////    ScalaThreeApp.getRenderer.render(scene, camera)
////  }
//}
