package com.crossgradient.akkanur

import akka.actor.{Actor, ActorLogging, Props}

class HiddenLayerActor extends Actor with ActorLogging {

  import HiddenLayerActor._

  var numUnits = 0
  
  def receive = {
    case Initialize(h:Int) =>
      log.info("In HiddenLayerActor - init")
      numUnits = h
      for( i <- 1 to h ) {
        val u = context.actorOf(Props[SigmoidUnitActor], "hid" + i)
        u.tell(SigmoidUnitActor.Initialize, self)
      }
  }
}

object HiddenLayerActor {

  val props = Props[HiddenLayerActor]

  case class Initialize(h:Int)

}

