package com.crossgradient.akkanur

import akka.actor.{Actor, ActorLogging, Props}

class HiddenLayerActor extends Actor with ActorLogging {

  import HiddenLayerActor._

  def receive = {
    case Initialize =>
      log.info("In HiddenLayerActor - init")
  }
}

object HiddenLayerActor {

  val props = Props[HiddenLayerActor]

  case object Initialize

}

