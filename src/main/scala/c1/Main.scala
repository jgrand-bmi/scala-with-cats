package c1

import ShowInstances._
import cats.implicits.toShow

object Main extends App {
  val fry = Cat("Fry", 2, "Orange")
  val bender = Cat("Bender", 2, "Cappuccino")
//  Printable.print(fry)
//  Printable.print(bender)

  println(fry.show)
  println(bender.show)

//  new Date().print
}
