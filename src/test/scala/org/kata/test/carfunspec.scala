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
// step 3-2
class CarFunSpec extends FunSpec {

  describe("A Car") {

    val car: Car = basicCar;

    describe("when standing") {

      val state = car.startEngine;

      it("should have speed 0") {
        assert(state._2 === 0)
      }

      it("can't change heading") {
        assert(car.turnLeft(state)._1 === 0)
      }
    }
  }
}