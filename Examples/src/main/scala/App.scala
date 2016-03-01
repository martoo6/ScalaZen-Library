import main.lib.Canvas

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

/**
  * Created by martin on 15/12/15.
  */

@JSExport
object App extends JSApp{

  override def main(): Unit = {

  }

  @JSExport
  def run(c:Canvas):Unit = {
    c.run()
  }
}
