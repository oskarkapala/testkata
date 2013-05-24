package org.kata.test

import Car._

import org.scalatest.FlatSpec
import org.scalatest.matchers.{ShouldMatchers, ClassicMatchers}

/**
 * @author Oskar Kapala <oskar.kapala@outbox.pl>
 *
 *         Trait that facilitates a “behavior-driven” style of development (BDD),
 *         in which tests are combined with text that specifies the behavior the tests verify.
 *
 *         Recommended Usage: Trait FlatSpec is a good first step for teams wishing to move from xUnit to BDD,
 *         because its structure is flat like xUnit, so simple and familiar, but the test names must be written
 *         in a specification style: “X should Y,” “A must B,” etc.
 *
 */
// step 4-3
class CarFlatSpec extends FlatSpec with ShouldMatchers with ClassicMatchers {

  "A Car" must "be able to do everything ;)" in {

    val car = basicCar
    val state = car.startEngine

    state._2 should equal(0)


    val s: String = "Hello seven world"
    val emptySet = Set.empty
    val map = Map("x" -> 24, "y" -> 25)


    s should startWith("Hello")
    s should endWith("world")
    s should include("seven")


    s should startWith regex ("Hel*o")
    s should endWith regex ("wo.ld")
    s should include regex ("wo.ld")


    "-123.2" should fullyMatch regex ("""(-)?(\d+)(\.\d*)?""")

    emptySet should be('empty)

    map should have size (2)

    //    assert(Array(1, 2) == (Array(1, 2)))
    Array(1, 2) should equal(Array(1, 2))


    //"yellow" should (equal ("blue") and equal { println("hello, world!"); "green" })

  }

}

