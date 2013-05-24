package org.kata.test

import Car._

import org.scalatest.FlatSpec
import org.scalatest.matchers.{ClassicMatchers, ShouldMatchers}

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
// step 4-1
//class CarFlatSpec extends FlatSpec {
//
//  behavior of "A Car" should "be able to drive" in {}
//
//  it should "be able to break" in {}
//
//  it should "be able to change driving direction (heading)" in {}
//
//  it should "may slide when turn at high speed" in {}
//
//}

// step 4-2
//class CarFlatSpec extends FlatSpec with GivenWhenThen with MustMatchers {
//
//  "A Car" must "be able to drive" in {}
//
//  it must "be able to break" in {}
//
//  it must "be able to change driving direction (heading)" in {
//    val car = basicCar
//    var state = car.startEngine
//
//    Given("Driving car")
//    state = car.accelerate(state)
//
//    When("steering wheel is turned left")
//    state = car.turnLeft(state)
//
//    Then("the heading should change")
//    assert(state._1 === 315)
//
//    And("speed not")
//    assert(state._2 === 10)
//
//  }
//
//  it must "may slide when turn at high speed" in {}
//
//  it must "slide (throw SlideException) when turning on too high speed" in (pending)
//
//}

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

