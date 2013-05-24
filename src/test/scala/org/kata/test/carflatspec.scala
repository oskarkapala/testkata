package org.kata.test

import Car._

import org.scalatest.{GivenWhenThen, FlatSpec}
import org.scalatest.matchers.MustMatchers

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
// step 4-2
class CarFlatSpec extends FlatSpec with GivenWhenThen with MustMatchers {

  "A Car" must "be able to drive" in {}

  it must "be able to break" in {}

  it must "be able to change driving direction (heading)" in {
    val car = basicCar
    var state = car.startEngine

    Given("Driving car")
    state = car.accelerate(state)

    When("steering wheel is turned left")
    state = car.turnLeft(state)

    Then("the heading should change")
    assert(state._1 === 315)

    And("speed not")
    assert(state._2 === 10)

  }

  it must "may slide when turn at high speed" in {}

  it must "slide (throw SlideException) when turning on too high speed" in (pending)

}

