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
class CarFlatSpec extends FlatSpec {

  "A Car" should "be able to drive" in {}

  it should "be able to break" in {}

  it should "be able to change driving direction (heading)" in {}

  it should "may slide when turn at high speed" in {}

}

