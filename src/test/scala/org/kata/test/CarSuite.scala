package org.kata.test

import org.scalatest.Suite
import Car._

/**
 * @author Oskar Kapala <oskar.kapala@outbox.pl>
 *
 *         A suite of tests. A Suite instance encapsulates a conceptual suite (i.e., a collection) of tests.
 *
 */
// step-1-2
class CarSuite extends Suite {

  def testStartSpeed() {

    val car = basicCar

    val state: Car.CarState = car.startEngine
    assert(state._2 == 0)

    val fakeState = (0, 0)
    //    val fakeState = (0,43)
    assert(fakeState._2 == 0, "Speed must be zero but is " + fakeState._2)

    assert(fakeState._2 === 0)
  }
}