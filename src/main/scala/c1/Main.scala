package c1

import ShowInstances._
import EqualsIntances._
import cats.syntax.eq._

object Main extends App {
  val fry = Cat("Fry", 2, "Orange")
  val bender = Cat("Bender", 2, "Cappuccino")
//  Printable.print(fry)
//  Printable.print(bender)

  val cat1 = Cat("Garfield", 38, "orange and black")
  val cat2 = Cat("Heathcliff", 33, "orange and black")

  val optionCat1 = Option(cat1)
  val optionCat2 = Option.empty[Cat]

  println(cat1)
  println(cat2)
  println(optionCat1 === optionCat2)

//  new Date().print
}
