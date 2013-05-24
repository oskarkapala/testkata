package org.kata.test

import Car._

/**
 * @author ${user.name}
 */
object CarDrive extends App {

  val car = basicCar

  var state = car.startEngine

  state =  car.accelerate(state)
  println(state)
  state = car.accelerate(state)
  println(state)
  state = car.accelerate(state)
  println(state)
//  state = car.turnLeft(state)

  state = car.accelerate(state)
  println(state)
  state = car.turnRightGentle(state)
  println(state)

  state = car.break(state)
  println(state)

  state = car.accelerate(state)
  println(state)

  state = car.accelerate(state)
//  state = car.accelerate(state)
//  state = car.accelerate(state)
  println(state)

  state = car.rapidBreak(state)
  println(state)


  val pCar = premiumCar
  var premiumState = pCar.startEngine
  println("premium " + premiumState)

  premiumState = pCar.accelerateTo(premiumState, 40)
  println(premiumState)
  premiumState = pCar.turnLeft(premiumState);
  println(premiumState)
  

}
