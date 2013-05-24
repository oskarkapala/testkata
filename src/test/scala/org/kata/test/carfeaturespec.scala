package org.kata.test

import org.scalatest.{GivenWhenThen, FeatureSpec}

/**
 * @author Oskar Kapala <oskar.kapala@outbox.pl>
 *
 *         A suite of tests in which each test represents one scenario of a feature. FeatureSpec is intended for
 *         writing tests that are "higher level" than unit tests, for example, integration tests, functional tests,
 *         and acceptance tests. You can use FeatureSpec for unit testing if you prefer, however.
 *
 *         Recommended Usage: Trait FeatureSpec is primarily intended for acceptance testing, including facilitating
 *         the process of programmers working alongside non-programmers to define the acceptance requirements.
 *
 */
// step 5-1
class CarFeatureSpec extends FeatureSpec with GivenWhenThen {

  info("As Car user")
  info("I want to be drive car")
  info("With any direction I want")
  info("And drive safely depending on car I choose")

  feature("accelerating") {
    scenario("User presses accelerate paddle when car is stopped") {
      Given("a Car is stopped")
      When("accelerate paddle is pressed")
      Then("the car should increase the speed")
      pending
    }

    scenario("User presses accelerate paddle when car is already driving") {
      Given("a Car is driving with speed lower then top speed")
      When("accelerate paddle is pressed")
      Then("the car should increase the speed")
      pending
    }

    scenario("User presses accelerate paddle when car is already driving at top speed") {
      Given("a Car is driving with top speed")
      When("accelerate paddle is pressed")
      Then("the car should not increase the speed")
      pending
    }


  }
}
