package org.kata.test

import org.scalatest._
import java.lang.String

/**
 * @author Oskar Kapala <oskar.kapala@outbox.pl>
 *
 */
class SmokeFunSuite extends FunSuite {

  test("some smoke") {
    assert(1 === 1)

  }

  test("smokie teset") {
    val smokie = new Smokie()

    assert(smokie.getSmokeColor === "Grey")
  }

}

class SmokeFunSpec extends FunSpec {

  describe("A Smoke") {

    it("smells")(pending)

    it("is dark") {
      assert(1 === 1)
    }

  }

}

class SmokeSpec extends FlatSpec {
  "A Smoke" should "go up" in {
    assert(1 === 1)
  }

  it should "throw NoSuchElementException if there is no fire" in {
    val container: List[String] = Nil
    intercept[NoSuchElementException] {
      container.head
    }
  }
}


class SmokeFeatureSpec extends FeatureSpec {

  feature("User can burn sth") {

    scenario("burning produces smoke")(pending)

  }
}
