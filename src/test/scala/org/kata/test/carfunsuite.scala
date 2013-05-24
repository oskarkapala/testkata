package org.kata.test

import Car._
import org.scalatest.{GivenWhenThen, BeforeAndAfter, FunSuite}

/**
 * @author Oskar Kapala <oskar.kapala@outbox.pl>
 *
 *         A suite of tests in which each test is represented as a function value. The “Fun” in FunSuite stands for “function.”
 *
 *         Recommended Usage: For teams coming from xUnit, FunSuite feels comfortable and familiar while still giving some benefits of BDD:
 *         FunSuite makes it easy to write descriptive test names, natural to write focused tests,
 *         and generates specification-like output that can facilitate communication among stakeholders.
 *
 */
//step-2-5
class CarFunSuite extends FunSuite with BeforeAndAfter with GivenWhenThen {

  val car = basicCar;
  var state: CarState = (1, 1);

  before {
    state = car.startEngine
  }

  test("car speed should be zero at the beginning") {
    assert(state._2 === 0)
  }

  test("car speed should be grater equal then zero all the time") {
    assert(state._2 >= 0)

    state = car.break(state)
    assert(state._2 >= 0)

  }

  test("car heading should not change on turn when car speed is zero") {
    state = car.turnLeft(state)
    assert(state._1 === 0)
  }

  test("A Car can turn when driving") {

    Given("Driving car")
    state = car.accelerate(state)

    When("steering wheel is turned left")
    state = car.turnLeft(state)

    Then("the heading should change")
    assert(state._1 === 315)

    And("speed not")
    assert(state._2 === 10)

    info("That's great, it works")
  }

  test("car should slide when braking at fast speed") {
    Given("Driving car")
    state = car.accelerate(state)

    When("steering wheel is turned left")
    state = car accelerate (car accelerate (car accelerate (car accelerate (car accelerate (car accelerate state)))))

    Then("the heading should change")
    intercept[SlideException] {
      car.rapidBreak(state)
    }
  }
}
