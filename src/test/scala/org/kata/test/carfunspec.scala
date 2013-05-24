package org.kata.test

import Car._
import org.scalatest._

/**
 * @author Oskar Kapala <oskar.kapala@outbox.pl>
 *
 *         Trait that facilitates a “behavior-driven” style of development (BDD),
 *         in which tests are combined with text that specifies the behavior the tests verify.
 *
 *         Recommended Usage: For teams coming from Ruby's RSpec tool, FunSpec will feel familiar and comfortable;
 *         More generally, for any team that prefers BDD, FunSpec's nesting and gentle guide to structuring text (with describe and it)
 *         provide an excellent general-purpose choice for writing specification-style tests.
 *
 */
// step 3-4
class CarFunSpec extends FunSpec with GivenWhenThen {

  describe("A Premium Car") {
    val car = premiumCar;

    Given("Stopped car")
    val state = car.startEngine

    When("accelerate to 50")
    val stateAt50 = car.accelerateTo(state, 50)

    Then("speed should be 50")
    assert(stateAt50._2 === 50)
  }

  describe("The combinators") {
    they("should be easy to learn") {}
    they("should be efficient") {}
    they("should do something cool") {}
  }
}