package main

object Perlin extends MathUtils{
  var B: Int = 0x100
  var BM: Int = 0xff
  var N: Int = 0x1000
  var NP = 12
  var NM: Int = 0xfff
  var p  = Array.ofDim[Int](B + B + 2)
  var g3 = Array.ofDim[Double](B + B + 2, 3)
  var g2 = Array.ofDim[Double](B + B + 2, 2)
  var g1 = Array.ofDim[Double](B + B + 2)

  def normalize2(v: Array[Double]) {
    val s: Double = Math.sqrt(v(0) * v(0) + v(1) * v(1))
    v(0) = v(0) / s
    v(1) = v(1) / s
  }

  def normalize3(v: Array[Double]) {
    val s: Double = Math.sqrt(v(0) * v(0) + v(1) * v(1) + v(2) * v(2))
    v(0) = v(0) / s
    v(1) = v(1) / s
    v(2) = v(2) / s
  }

  def sCurve(t: Double): Double = {
    return t * t * (3.0 - 2.0 * t)
  }

  def at2(q: Array[Double], rx: Double, ry: Double): Double = {
    return rx * q(0) + ry * q(1)
  }

  def at3(q: Array[Double], rx: Double, ry: Double, rz: Double): Double = {
    return rx * q(0) + ry * q(1) + rz * q(2)
  }

  def init {
    var j = 0
    var k = 0

    for (i <- 0 until B) {
      p(i) = i
      g1(i) = (random(B + B) - B) / B

      for (j <- 0 until 2)
      g2(i)(j) = (random(B + B) - B) / B
      normalize2(g2(i))

      for (j <- 0 until  3)
      g3(i)(j) = (random(B + B) - B) / B
      normalize3(g3(i))
    }

    for(i <- B until 0) {
      k = p(i)
      j = random(B).toInt
      p(i) = p(j)
      p(j) = k
    }

    for (i <- 0 until B + 2) {
      p(B + i) = p(i)
      g1(B + i) = g1(i)
      for (j <- 0 until 2)
      g2(B + i)(j) = g2(i)(j)
      for (j <- 0 until 3)
      g3(B + i)(j) = g3(i)(j)
    }
  }

  def noise1(vec: Array[Double]): Double = {
    val t = vec(0) + N
    val bx0 = t.toInt & BM
    val bx1 = (bx0 + 1) & BM
    val rx0 = t - t.toInt
    val rx1 = rx0 - 1.0
    val sx = sCurve(rx0)
    val u = rx0 * g1(p(bx0))
    val v = rx1 * g1(p(bx1))
    lerp(u, v, sx)
  }

  def noise2(vec: Array[Double]): Double = {
    var t = vec(0) + N
    val bx0 = t.toInt & BM
    val bx1 = (bx0 + 1) & BM
    val rx0 = t - t.toInt
    val rx1 = rx0 - 1.0
    t = vec(1) + N
    val by0 = t.toInt & BM
    val by1 = (by0 + 1) & BM
    val ry0 = t - t.toInt
    val ry1 = ry0 - 1.0
    val i = p(bx0)
    val j = p(bx1)
    val b00 = p(i + by0)
    val b10 = p(j + by0)
    val b01 = p(i + by1)
    val b11 = p(j + by1)
    val sx = sCurve(rx0)
    val sy = sCurve(ry0)
    var q = g2(b00)
    var u = at2(q, rx0, ry0)
    q = g2(b10)
    var v = at2(q, rx1, ry0)
    val a = lerp(u, v, sx)
    q = g2(b01)
    u = at2(q, rx0, ry1)
    q = g2(b11)
    v = at2(q, rx1, ry1)
    val b = lerp(u, v, sx)
    lerp(a, b, sy)
  }

  def noise3(vec: Array[Double]): Double = {
    var t = vec(0) + N
    val bx0 = t.toInt & BM
    val bx1 = (bx0 + 1) & BM
    val rx0 = t - t.toInt
    val rx1 = rx0 - 1.0
    t = vec(1) + N
    val by0 = t.toInt & BM
    val by1 = (by0 + 1) & BM
    val ry0 = t - t.toInt
    val ry1 = ry0 - 1.0
    t = vec(2) + N
    val bz0 = t.toInt & BM
    val bz1 = (bz0 + 1) & BM
    val rz0 = t - t.toInt
    val rz1 = rz0 - 1.0
    val i = p(bx0)
    val j = p(bx1)
    val b00 = p(i + by0)
    val b10 = p(j + by0)
    val b01 = p(i + by1)
    val b11 = p(j + by1)
    t = sCurve(rx0)
    val sy = sCurve(ry0)
    val sz = sCurve(rz0)
    var q = g3(b00 + bz0)
    var u = at3(q, rx0, ry0, rz0)
    q = g3(b10 + bz0)
    var v = at3(q, rx1, ry0, rz0)
    var a = lerp(u, v, t)
    q = g3(b01 + bz0)
    u = at3(q, rx0, ry1, rz0)
    q = g3(b11 + bz0)
    v = at3(q, rx1, ry1, rz0)
    var b = lerp(u, v, t)
    val c = lerp(a, b, sy)
    q = g3(b00 + bz1)
    u = at3(q, rx0, ry0, rz1)
    q = g3(b10 + bz1)
    v = at3(q, rx1, ry0, rz1)
    a = lerp(u, v, t)
    q = g3(b01 + bz1)
    u = at3(q, rx0, ry1, rz1)
    q = g3(b11 + bz1)
    v = at3(q, rx1, ry1, rz1)
    b = lerp(u, v, t)
    val d = lerp(a, b, sy)
    lerp(c, d, sz)
  }

  def noise1D(x: Double, nalpha: Double, nbeta: Double, n: Int): Double = {
    var value = .0
    var sum = 0.0
    val v = Array(x)
    var nscale = 1.0
    for(i <- 0 until n){
      value = noise1(v)
      sum += value / nscale
      nscale *= nalpha
      v(0) *= nbeta
    }
    sum
  }

  def noise2D(x: Double, y: Double, nalpha: Double, nbeta: Double, n: Int): Double = {
    var value = .0
    var sum = 0.0
    val v = Array(x, y)
    var nscale = 1.0
    for(i <- 0 until n){
      value = noise2(v)
      sum += value / nscale
      nscale *= nalpha
      v(0) *= nbeta
      v(1) *= nbeta
    }
    sum
  }

  def noise3D(x: Double, y: Double, z: Double, nalpha: Double, nbeta: Double, n: Int): Double = {
    var value= .0
    var sum = 0.0
    val v = Array(x, y, z)
    var nscale = 1.0
    for(i <- 0 until n){
      value = noise3(v)
      sum += value / nscale
      nscale *= nalpha
      v(0) *= nbeta
      v(1) *= nbeta
      v(2) *= nbeta
    }
    sum
  }
}
