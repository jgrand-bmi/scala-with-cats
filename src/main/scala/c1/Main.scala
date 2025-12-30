package c1

import PrintableInstances._
import PrintableSyntax._

//import java.util.Date

object Main extends App {
  val fry = Cat("Fry", 2, "Orange")
  val bender = Cat("Bender", 2, "Cappuccino")
//  Printable.print(fry)
//  Printable.print(bender)

  fry.print
  bender.print

//  new Date().print
}
