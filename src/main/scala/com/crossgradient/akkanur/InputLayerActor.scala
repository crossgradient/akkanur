package com.crossgradient.akkanur

import akka.actor.{Actor, ActorLogging, Props}

class InputLayerActor extends Actor with ActorLogging {

  import InputLayerActor._

  def receive = {
    case Initialize =>
      log.info("In InputLayerActor - init")
  }
}

object InputLayerActor {

  val props = Props[InputLayerActor]

  case object Initialize

}

