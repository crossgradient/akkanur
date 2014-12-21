package com.crossgradient.akkanur

import akka.actor.{Actor, ActorLogging, Props}

class OutputLayerActor extends Actor with ActorLogging {

  import OutputLayerActor._

  def receive = {
    case Initialize =>
      log.info("In OutputLayerActor - init")
      
  }
}

object OutputLayerActor {

  val props = Props[OutputLayerActor]

  case object Initialize

}
