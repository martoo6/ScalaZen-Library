package main.lib

import main.lib.Color

import scala.util.Random

/**
 * Created by martin on 20/10/15.
 */
object Palette extends PaletteT

case class Palette(colors:Color*){
  def apply(pos:Int) = colors(pos)
  def getRandom: Color = colors(Random.nextInt(colors.size))
  //Mayble use math to set it in range would be faster
  def getRandom(amount: Int): Color = colors(Random.nextInt(if (amount>colors.size) colors.size else amount))
}

/**
 * Should make a library out of this, get values out of a json
 * Get Palettes sorted by categories such as mood, etc.
 * Generate palettes from images, etc.
 */

trait PaletteT extends Converters{
  val white = 0xffffff
  val black = 0x000000
  val red = 0xFF0000
  val green = 0x00FF00
  val blue = 0x0000FF

  val blueSaddness = Palette(0xEAEAEA :: 0xCBC5EA :: 0x73628A :: 0x313D5A :: 0x183642 :: Nil: _*)
  val pop = Palette(0xC1ABA6 :: 0x533B4D :: 0xF564A9 :: 0xFAA4BD :: 0xFAE3C6 :: Nil :_*)

  //From http://www.colourlovers.com/
  val giantGoldfish       = Palette(0x69D2E7 :: 0xA7DBD8 :: 0xE0E4CC :: 0xF38630 :: 0xFA6900 :: Nil :_*)
  val sugar01             = Palette(0xFE4365 :: 0xFC9D9A :: 0xF9CDAD :: 0xC8C8A9 :: 0x83AF9B :: Nil :_*)
  val thoughtProvoking    = Palette(0xECD078 :: 0xD95B43 :: 0xC02942 :: 0x542437 :: 0x53777A :: Nil :_*)
  val adriftInDreams      = Palette(0xCFF09E :: 0xA8DBA8 :: 0x79BD9A :: 0x3B8686 :: 0x0B486B :: Nil :_*)
  val cheerUpEmoKid       = Palette(0x556270 :: 0x4ECDC4 :: 0xC7F464 :: 0xFF6B6B :: 0xC44D58 :: Nil :_*)
  val letThemEatCake      = Palette(0x774F38 :: 0xE08E79 :: 0xF1D4AF :: 0xECE5CE :: 0xC5E0DC :: Nil :_*)
  val mellonBallSurprise  = Palette(0xD1F2A5 :: 0xEFFAB4 :: 0xFFC48C :: 0xFF9F80 :: 0xF56991 :: Nil :_*)
  val oceanFive           = Palette(0x00A0B0 :: 0x6A4A3C :: 0xCC333F :: 0xEB6841 :: 0xEDC951 :: Nil :_*)
  val iDemandPancake      = Palette(0x594F4F :: 0x547980 :: 0x45ADA8 :: 0x9DE0AD :: 0xE5FCC2 :: Nil :_*)

}

