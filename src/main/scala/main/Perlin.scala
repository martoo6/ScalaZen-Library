//package main
//
//object Perlin extends Helpers{
//  var B: Int = 0x100
//  var BM: Int = 0xff
//  var N: Int = 0x1000
//  var NP: Int = 12
//  var NM: Int = 0xfff
//  var p: Array[Int] = null
//  var g3: Array[Array[Double]] = null
//  var g2: Array[Array[Double]] = null
//  var g1: Array[Double] = null
//
//  def normalize2(v: Array[Double]) {
//    val s: Double = Math.sqrt(v(0) * v(0) + v(1) * v(1))
//    v(0) = v(0) / s
//    v(1) = v(1) / s
//  }
//
//  def normalize3(v: Array[Double]) {
//    val s: Double = Math.sqrt(v(0) * v(0) + v(1) * v(1) + v(2) * v(2))
//    v(0) = v(0) / s
//    v(1) = v(1) / s
//    v(2) = v(2) / s
//  }
//
//  def sCurve(t: Double): Double = {
//    return t * t * (3.0 - 2.0 * t)
//  }
//
//  def at2(q: Array[Double], rx: Double, ry: Double): Double = {
//    return rx * q(0) + ry * q(1)
//  }
//
//  def at3(q: Array[Double], rx: Double, ry: Double, rz: Double): Double = {
//    return rx * q(0) + ry * q(1) + rz * q(2)
//  }
//
//  def this() {
//    this()
//    p = new Array[Int](B + B + 2)
//    g3 = new Array[Array[Double]](B + B + 2, 3)
//    g2 = new Array[Array[Double]](B + B + 2, 2)
//    g1 = new Array[Double](B + B + 2)
//    init
//  }
//
//  def init {
//    var i: Int = 0
//    var j: Int = 0
//    var k: Int = 0
//    {
//      i = 0
//      while (i < B) {
//        {
//          p(i) = i
//          g1(i) = (random(B + B) - B) / B
//          {
//            j = 0
//            while (j < 2) {
//              g2(i)(j) = (random(B + B) - B) / B
//              ({
//                j += 1; j - 1
//              })
//            }
//          }
//          normalize2(g2(i))
//          {
//            j = 0
//            while (j < 3) {
//              g3(i)(j) = (random(B + B) - B) / B
//              ({
//                j += 1; j - 1
//              })
//            }
//          }
//          normalize3(g3(i))
//        }
//        ({
//          i += 1; i - 1
//        })
//      }
//    }
//    while (0 < ({
//      i -= 1; i
//    })) {
//      k = p(i)
//      p(i) = p(({
//        j =; j
//      }))
//      (random(B))
//
//      p(j) = k
//    }
//    {
//      i = 0
//      while (i < B + 2) {
//        {
//          p(B + i) = p(i)
//          g1(B + i) = g1(i)
//          {
//            j = 0
//            while (j < 2) {
//              g2(B + i)(j) = g2(i)(j)
//              ({
//                j += 1; j - 1
//              })
//            }
//          }
//          {
//            j = 0
//            while (j < 3) {
//              g3(B + i)(j) = g3(i)(j)
//              ({
//                j += 1; j - 1
//              })
//            }
//          }
//        }
//        ({
//          i += 1; i - 1
//        })
//      }
//    }
//  }
//
//  def noise1(vec: Array[Double]): Double = {
//    var bx0: Int = 0
//    var bx1: Int = 0
//    var rx0: Double = .0
//    var rx1: Double = .0
//    var sx: Double = .0
//    var t: Double = .0
//    var u: Double = .0
//    var v: Double = .0
//    t = vec(0) + N
//    bx0 =
//    (t) & BM
//    bx1 = (bx0 + 1) & BM
//    rx0 = t -
//          (t)
//    rx1 = rx0 - 1.0
//    sx = sCurve(rx0)
//    u = rx0 * g1(p(bx0))
//    v = rx1 * g1(p(bx1))
//    return lerp(u, v, sx)
//  }
//
//  def noise2(vec: Array[Double]): Double = {
//    var bx0: Int = 0
//    var bx1: Int = 0
//    var by0: Int = 0
//    var by1: Int = 0
//    var b00: Int = 0
//    var b10: Int = 0
//    var b01: Int = 0
//    var b11: Int = 0
//    var rx0: Double = .0
//    var rx1: Double = .0
//    var ry0: Double = .0
//    var ry1: Double = .0
//    var sx: Double = .0
//    var sy: Double = .0
//    var a: Double = .0
//    var b: Double = .0
//    var t: Double = .0
//    var u: Double = .0
//    var v: Double = .0
//    var q: Array[Double] = null
//    var i: Int = 0
//    var j: Int = 0
//    t = vec(0) + N
//    bx0 =
//    (t) & BM
//    bx1 = (bx0 + 1) & BM
//    rx0 = t -
//          (t)
//    rx1 = rx0 - 1.0
//    t = vec(1) + N
//    by0 =
//    (t) & BM
//    by1 = (by0 + 1) & BM
//    ry0 = t -
//          (t)
//    ry1 = ry0 - 1.0
//    i = p(bx0)
//    j = p(bx1)
//    b00 = p(i + by0)
//    b10 = p(j + by0)
//    b01 = p(i + by1)
//    b11 = p(j + by1)
//    sx = sCurve(rx0)
//    sy = sCurve(ry0)
//    q = g2(b00)
//    u = at2(q, rx0, ry0)
//    q = g2(b10)
//    v = at2(q, rx1, ry0)
//    a = lerp(u, v, sx)
//    q = g2(b01)
//    u = at2(q, rx0, ry1)
//    q = g2(b11)
//    v = at2(q, rx1, ry1)
//    b = lerp(u, v, sx)
//    return lerp(a, b, sy)
//  }
//
//  def noise3(vec: Array[Double]): Double = {
//    var bx0: Int = 0
//    var bx1: Int = 0
//    var by0: Int = 0
//    var by1: Int = 0
//    var bz0: Int = 0
//    var bz1: Int = 0
//    var b00: Int = 0
//    var b10: Int = 0
//    var b01: Int = 0
//    var b11: Int = 0
//    var rx0: Double = .0
//    var rx1: Double = .0
//    var ry0: Double = .0
//    var ry1: Double = .0
//    var rz0: Double = .0
//    var rz1: Double = .0
//    var sy: Double = .0
//    var sz: Double = .0
//    var a: Double = .0
//    var b: Double = .0
//    var c: Double = .0
//    var d: Double = .0
//    var t: Double = .0
//    var u: Double = .0
//    var v: Double = .0
//    var q: Array[Double] = null
//    var i: Int = 0
//    var j: Int = 0
//    t = vec(0) + N
//    bx0 =
//    (t) & BM
//    bx1 = (bx0 + 1) & BM
//    rx0 = t -
//          (t)
//    rx1 = rx0 - 1.0
//    t = vec(1) + N
//    by0 =
//    (t) & BM
//    by1 = (by0 + 1) & BM
//    ry0 = t -
//          (t)
//    ry1 = ry0 - 1.0
//    t = vec(2) + N
//    bz0 =
//    (t) & BM
//    bz1 = (bz0 + 1) & BM
//    rz0 = t -
//          (t)
//    rz1 = rz0 - 1.0
//    i = p(bx0)
//    j = p(bx1)
//    b00 = p(i + by0)
//    b10 = p(j + by0)
//    b01 = p(i + by1)
//    b11 = p(j + by1)
//    t = sCurve(rx0)
//    sy = sCurve(ry0)
//    sz = sCurve(rz0)
//    q = g3(b00 + bz0)
//    u = at3(q, rx0, ry0, rz0)
//    q = g3(b10 + bz0)
//    v = at3(q, rx1, ry0, rz0)
//    a = lerp(u, v, t)
//    q = g3(b01 + bz0)
//    u = at3(q, rx0, ry1, rz0)
//    q = g3(b11 + bz0)
//    v = at3(q, rx1, ry1, rz0)
//    b = lerp(u, v, t)
//    c = lerp(a, b, sy)
//    q = g3(b00 + bz1)
//    u = at3(q, rx0, ry0, rz1)
//    q = g3(b10 + bz1)
//    v = at3(q, rx1, ry0, rz1)
//    a = lerp(u, v, t)
//    q = g3(b01 + bz1)
//    u = at3(q, rx0, ry1, rz1)
//    q = g3(b11 + bz1)
//    v = at3(q, rx1, ry1, rz1)
//    b = lerp(u, v, t)
//    d = lerp(a, b, sy)
//    return lerp(c, d, sz)
//  }
//
//  def noise1D(x: Double, nalpha: Double, nbeta: Double, n: Int): Double = {
//    var `val`: Double = .0
//    var sum: Double = 0
//    val v: Double = Array(x)
//    var nscale: Double = 1
//    {
//      var i: Int = 0
//      while (i < n) {
//        {
//          `val` = noise1(v)
//          sum += `val` / nscale
//          nscale *= nalpha
//          v(0) *= nbeta
//        }
//        ({
//          i += 1; i - 1
//        })
//      }
//    }
//    return sum
//  }
//
//  def noise2D(x: Double, y: Double, nalpha: Double, nbeta: Double, n: Int): Double = {
//    var value: Double = .0
//    var sum: Double = 0
//    val v = Array(x, y)
//    var nscale: Double = 1
//    for(i <- 0 to n){
//      value = noise2(v)
//      sum += value / nscale
//      nscale *= nalpha
//      v(0) *= nbeta
//      v(1) *= nbeta
//    }
//    return sum
//  }
//
//  def noise3D(x: Double, y: Double, z: Double, nalpha: Double, nbeta: Double, n: Int): Double = {
//    var value: Double = .0
//    var sum: Double = 0
//    val v = Array(x, y, z)
//    var nscale: Double = 1
//    for(i <- 0 to n){
//      value = noise3(v)
//      sum += value / nscale
//      nscale *= nalpha
//      v(0) *= nbeta
//      v(1) *= nbeta
//      v(2) *= nbeta
//    }
//    return sum
//  }
//}
