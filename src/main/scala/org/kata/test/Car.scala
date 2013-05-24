package org.kata.test

/**
 * @author Oskar Kapala <oskar.kapala@outbox.pl>
 *
 */

object Car {

  type Heading = Int
  type Speed = Int
  type CarState = (Heading, Speed)

  val stopState: CarState = (0, 0)

  val topSpeed = 100
  val accStep = 10
  val breakStep = -20

  trait Car {

    def startEngine = stopState

    def accelerate(cs: CarState): CarState = {
      (cs._1, Math.min(cs._2 + accStep, topSpeed))
    }

    def break(cs: CarState): CarState = {
      (cs._1, Math.max(cs._2 + breakStep, 0))
    } ensuring(0 <= _._2, "Speed must be between 0 and top speed")

    def rapidBreak(cs: CarState): CarState = {
      slideOnRapidBreak(cs)
      (cs._1, Math.max(cs._2 + 2 * breakStep, 0))
    } ensuring(csOut => 0 <= csOut._2 && csOut._2 <= topSpeed, "Speed must be grater equal then 0")

    def turnLeftGentle(cs: CarState): CarState = {
      if (cs._2 > 0) ((cs._1 - 30 + 360) % 360, cs._2)
      else cs
    } ensuring(csOut => 0 <= csOut._2 && csOut._2 <= topSpeed, "Speed must be grater equal then 0")

    def turnLeft(cs: CarState): CarState = {
      slideOnTurn(cs)
      if (cs._2 > 0) ((cs._1 - 45 + 360) % 360, cs._2)
      else cs
    } ensuring(csOut => 0 <= csOut._1 && csOut._1 < 360, "Heading must be between 0 and 360 deg")

    def turnRightGentle(cs: CarState): CarState = {
      if (cs._2 > 0) ((cs._1 + 30) % 360, cs._2)
      else cs
    } ensuring(csOut => 0 <= csOut._1 && csOut._1 < 360, "Heading must be between 0 and 360 deg")

    def turnRight(cs: CarState): CarState = {
      slideOnTurn(cs)
      if (cs._2 > 0) ((cs._1 + 45) % 360, cs._2)
      else cs
    } ensuring(csOut => 0 <= csOut._1 && csOut._1 < 360, "Heading must be between 0 and 360 deg")

    private def slideOnTurn(cs: CarState) {
      if (cs._2 >= fatalSlideOnTurnAtSpeed) throw new FatalSlideException
      if (cs._2 >= slideOnTurnAtSpeed) throw new SlideException
    }

    private def slideOnRapidBreak(cs: Car.CarState) {
      if (cs._2 >= fatalSideOnRapidBreakAtSpeed) throw new FatalSlideException
      if (cs._2 >= sideOnRapidBreakAtSpeed) throw new SlideException
    }

    def sideOnRapidBreakAtSpeed: Int
    def fatalSideOnRapidBreakAtSpeed: Int

    def slideOnTurnAtSpeed: Int
    def fatalSlideOnTurnAtSpeed: Int
  }


  trait CruiseControl {
    def accelerateTo(cs: CarState, speed: Int): CarState = {
      (cs._1, Math.min(speed, topSpeed))
    }
  }

  trait noABS {
    def sideOnRapidBreakAtSpeed = 60
    def fatalSideOnRapidBreakAtSpeed = 80
  }

  trait ABS {
    def sideOnRapidBreakAtSpeed = 80
    def fatalSideOnRapidBreakAtSpeed = 100
  }

  trait noESP {
    def slideOnTurnAtSpeed = 30
    def fatalSlideOnTurnAtSpeed = 50
  }

  trait ESP {
    def slideOnTurnAtSpeed = 50
    def fatalSlideOnTurnAtSpeed = 70
  }

  class BasicCar extends Car with noABS with noESP
  class SafeCar extends Car with ABS with noESP
  class SuperSafeCar extends Car with ABS with ESP
  class PremiumCar extends SuperSafeCar with CruiseControl

  class SlideException extends Exception
  class FatalSlideException extends SlideException

  def basicCar = new BasicCar
  def safeCar = new SafeCar
  def superSafeCar = new SuperSafeCar
  def premiumCar = new PremiumCar

}