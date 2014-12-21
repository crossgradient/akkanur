package com.crossgradient.akkanur

import akka.actor.{Actor, ActorLogging, Props}

class NetworkBuilderActor extends Actor with ActorLogging {

  import NetworkBuilderActor._

  def receive = {
    case Initialize =>
      log.info("In NetworkBuilderActor")
  }
}

object NetworkBuilderActor {

  val props = Props[NetworkBuilderActor]

  case object Initialize

}
