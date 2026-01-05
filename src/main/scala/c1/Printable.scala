package c1

import cats.Show
import cats.syntax.show._
import cats.instances.int._
import cats.instances.string._

/*

1.3 Exercise: Printable Library

Scala provides a toString method to let us convert any value to a String.

However, this method comes with a few disadvantages: it is implemented for
every type in the language, many implementations are of limited use, and we
can’t opt‐in to specific implementations for specific types.

Let’s define a Printable type class to work around these problems:

1. Define a type class Printable[A] containing a single method format.
format should accept a value of type A and return a String.

2. Create an object PrintableInstances containing instances of
Printable for String and Int.

3. Define an object Printable with two generic interface methods:
format accepts a value of type A and a Printable of the correspond‐
ing type. It uses the relevant Printable to convert the A to a String.
print accepts the same parameters as format and returns Unit. It
prints the formatted A value to the console using println.

 */

/*
 * Let’s make our printing library easier to use by defining some extension meth‐
 * ods to provide better syntax:
 *
 * 1. Create an object called PrintableSyntax.
 * 2. Inside PrintableSyntax define an implicit class
 *    PrintableOps[A] to wrap up a value of type A.
 * 3. In PrintableOps define the following methods:
 *    • format accepts an implicit Printable[A] and returns a String
 *      representation of the wrapped A;
 *    • print accepts an implicit Printable[A] and returns Unit. It
 *      prints the wrapped A to the console.
 * 4. Use the extension methods to print the example Cat you created in the
 *    previous exercise.
 */

//application logic
final case class Cat(name: String, age: Int, color: String)


// begin type class
trait Printable[A] {
  def format(value: A): String
}

object PrintableInstances {
  implicit val stringWriter: Printable[String] = {
    new Printable[String] {
      def format(value: String): String = {
        value
      }
    }
  }

  implicit val intWriter: Printable[Int] = {
    new Printable[Int] {
      def format(value: Int): String =
        value.toString
    }
  }

  implicit val catWriter: Printable[Cat] = {
    new Printable[Cat] {
      override def format(value: Cat): String =
        s"${Printable.format(value.name)} is a ${Printable.format(value.age)} year-old ${Printable.format(value.color)} cat"
    }
  }
}

object ShowInstances {
  implicit val catShow: Show[Cat] = Show.show[Cat] {cat =>
    val name = cat.name.show
    val age = cat.age.show
    val color = cat.color.show
    s"$name is a $age year-old $color cat"
  }
}

object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def format(implicit p: Printable[A]): String = {
      p.format(value)
    }
    def print(implicit p: Printable[A]): Unit = {
      println(format(p))
    }
  }
}

object Printable {
  def format[A](value: A)(implicit w: Printable[A]): String = {
    w.format(value)
  }

  def print[A](value: A)(implicit w: Printable[A]): Unit = {
    println(format(value))
  }
}


