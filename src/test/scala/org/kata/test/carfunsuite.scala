package org.kata.test

import Car._
import org.scalatest.{BeforeAndAfter, GivenWhenThen, FunSuite}
import org.kata.test.Car.Car

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
// step-2-2: pending
class CarFunSuite extends FunSuite {

  test("car speed should be zero at the beginning") (pending)

  test("car speed should be grater equal then zero all the time") (pending)

  test("car heading should not change on turn when car speed is zero") (pending)
}
