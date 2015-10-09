package main
/**
 *  Perlin noise function.
 *
 * @author Hans Haggstrom
 */
object PerlinNoise extends MathUtils{


  //======================================================================
  // Private Constants


  // TODO: Is there some array initializer idiom in scala?
//  val permutation : Array[Int]= Array(151, 160, 137, 91, 90, 15,
//    131, 13, 201, 95, 96, 53, 194, 233, 7, 225, 140, 36, 103, 30, 69, 142, 8, 99, 37,
//    240, 21, 10, 23,
//    190, 6, 148, 247, 120, 234, 75, 0, 26, 197, 62, 94, 252, 219, 203, 117, 35, 11, 32,
//    57, 177, 33,
//    88, 237, 149, 56, 87, 174, 20, 125, 136, 171, 168, 68, 175, 74, 165, 71, 134, 139,
//    48, 27, 166,
//    77, 146, 158, 231, 83, 111, 229, 122, 60, 211, 133, 230, 220, 105, 92, 41, 55, 46,
//    245, 40, 244,
//    102, 143, 54, 65, 25, 63, 161, 1, 216, 80, 73, 209, 76, 132, 187, 208, 89, 18, 169,
//    200, 196,
//    135, 130, 116, 188, 159, 86, 164, 100, 109, 198, 173, 186, 3, 64, 52, 217, 226,
//    250, 124, 123,
//    5, 202, 38, 147, 118, 126, 255, 82, 85, 212, 207, 206, 59, 227, 47, 16, 58, 17,
//    182, 189, 28, 42,
//    223, 183, 170, 213, 119, 248, 152, 2, 44, 154, 163, 70, 221, 153, 101, 155, 167,
//    43, 172, 9,
//    129, 22, 39, 253, 19, 98, 108, 110, 79, 113, 224, 232, 178, 185, 112, 104, 218,
//    246, 97, 228,
//    251, 34, 242, 193, 238, 210, 144, 12, 191, 179, 162, 241, 81, 51, 145, 235, 249,
//    14, 239, 107,
//    49, 192, 214, 31, 181, 199, 106, 157, 184, 84, 204, 176, 115, 121, 50, 45, 127, 4,
//    150, 254,
//    138, 236, 205, 93, 222, 114, 67, 29, 24, 72, 243, 141, 128, 195, 78, 66, 215, 61,
//    156, 180)
  val permutation = Array.fill(300){ random(255).toInt }

  val p =new Array[Int](512)

  // Initialize the p array with two copies of the permutation array.
  var j = 0
  while (j < 256) {
    p(j) = permutation(j)
    p(256 + j) = p(j)
    j += 1
  }

  /**
   *  Three dimensional Perlin noise.
   *  Based on Ken Perlins reference implementation of improved noise ( http://mrl.nyu.edu/~perlin/noise/ ).
   *
   * @param x coordinate to calculate the noise value at
   * @param y coordinate to calculate the noise value at
   * @param z coordinate to calculate the noise value at
   *
   * @return the noise value at the specified point, a value between -1 and 1
   */
  def perlinNoise(x: Double, y: Double, z: Double): Double =
  {

    def fade(t: Double): Double =
    {
      // fade(t) = 6t^5 - 15t^4 + 10t^3
      t * t * t * (t * (t * 6 - 15) + 10);
    }

    def interpolate(t: Double, a: Double, b: Double) : Double =
    {
      a + t * (b - a);
    }

    def grad(hash: Int, x: Double, y: Double, z: Double): Double =
    {
      // Convert low 4 bits of hash code into 12 gradient directions
      val lowBits = hash & 15;
      val u = if (lowBits < 8) x else y
      val v = if (lowBits < 4) y else
      if (lowBits == 12 || lowBits == 14) x else z
      return (if ((lowBits & 1) == 0) u else -u) +
             (if ((lowBits & 2) == 0) v else -v)
    }



    // Calculate integer values for coordinates
    // OPTIMIZE: Math.floor seems to be somewhat slow?  Is there any faster way to get the same result?
    val roundedX = Math.floor(x).toInt
    val roundedY = Math.floor(y).toInt
    val roundedZ = Math.floor(z).toInt

    // Find unit cube that contains point
    val X: Int = roundedX & 255
    val Y: Int = roundedY & 255
    val Z: Int = roundedZ & 255

    // Find relative x,y,z of point in cube
    var x_ = x - roundedX
    var y_ = y - roundedY
    var z_ = z - roundedZ

    // Compute fade curves for each of x,y,z
    val u = fade(x_)
    val v = fade(y_)
    val w = fade(z_)

    // Hash coordinates of the 8 cube corners,
    val A = p(X) + Y
    val AA = p(A) + Z
    val AB = p(A + 1) + Z
    val B = p(X + 1) + Y
    val BA = p(B) + Z
    val BB = p(B + 1) + Z

    // and add blended results from 8 corners of cube
    return interpolate(w,
      interpolate(v,
        interpolate(u,
          grad(p(AA), x_, y_, z_),
          grad(p(BA), x_ - 1, y_, z_)),
        interpolate(u,
          grad(p(AB), x_, y_ - 1, z_),
          grad(p(BB), x_ - 1, y_ - 1, z_))),
      interpolate(v,
        interpolate(u,
          grad(p(AA + 1), x_, y_, z_ - 1),
          grad(p(BA + 1), x_ - 1, y_, z_ - 1)),
        interpolate(u,
          grad(p(AB + 1), x_ , y_ - 1, z_ - 1),
          grad(p(BB + 1), x_ - 1, y_ - 1, z_ - 1))));
  }


}