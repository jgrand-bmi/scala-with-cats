package c1

import cats.Eq
import cats.syntax.eq._

import scala.annotation.tailrec

object EqualsIntances {
  implicit val catsEq: Eq[Cat] = Eq.instance[Cat]({ (cat1, cat2) =>
    (cat1.age === cat2.age) &&
    (cat1.name === cat2.name) &&
    (cat1.color === cat2.color)
  })
}