package main.lib

/**
 * Created by martin on 20/10/15.
 */
trait PerlinNoise extends MathUtils{


  //======================================================================
  // Private Constants for some reason it doesnt work if they are not lazy
  //val permutation = Array.fill(300){ random(255).toInt }
  val permutation = (1 to 300).map(_=>random(255).toInt)

  // Initialize the p array with two copies of the permutation array.
  val p = permutation++permutation

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
  def noise(x: Double, y: Double = 0, z: Double = 0): Double =
  {

    def fade(t: Double): Double =
    {
      // fade(t) = 6t^5 - 15t^4 + 10t^3
      t * t * t * (t * (t * 6 - 15) + 10)
    }

    def interpolate(t: Double, a: Double, b: Double) : Double =
    {
      a + t * (b - a)
    }

    def grad(hash: Int, x: Double, y: Double, z: Double): Double =
    {
      // Convert low 4 bits of hash code into 12 gradient directions
      val lowBits = hash & 15
      val u = if (lowBits < 8) x else y
      val v = if (lowBits < 4) y else
      if (lowBits == 12 || lowBits == 14) x else z
      return (if ((lowBits & 1) == 0) u else -u) +
             (if ((lowBits & 2) == 0) v else -v)
    }



    // Calculate integer values for coordinates
    val roundedX = x.toInt
    val roundedY = y.toInt
    val roundedZ = z.toInt

    // Find unit cube that contains point
    val X: Int = roundedX & 255
    val Y: Int = roundedY & 255
    val Z: Int = roundedZ & 255

    // Find relative x,y,z of point in cube
    val x_ = x - roundedX
    val y_ = y - roundedY
    val z_ = z - roundedZ

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
    interpolate(w,
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
          grad(p(BB + 1), x_ - 1, y_ - 1, z_ - 1))))
  }


}

case class Perlin(min:Double, max: Double) extends PerlinNoise with MathUtils{
  override def noise(x: Double, y: Double = 0, z: Double = 0): Double = {
    map(super.noise(x,y,z),-1,1,min,max)
  }
}

object Perlin extends PerlinNoise{
  def apply(max: Double):Perlin = Perlin(0,max)
  def apply:Perlin = Perlin(-1,1)
}
