package com.crossgradient.akkanur

import akka.actor.{Actor, ActorLogging, Props}
import com.crossgradient.akkanur.InputLayerActor.Initialize

class InputLayerActor extends Actor with ActorLogging {

  import InputLayerActor._
  
  var numInputs = 0
//  var i = 0
  
  def receive = {
    case Initialize(d:Int) =>
      log.info("In InputLayerActor - init")
      numInputs = d
      for( i <- 1 to d ) {
        val u = context.actorOf(Props[LinearUnitActor], "in" + i)
        u.tell(LinearUnitActor.Initialize, self)
      }
  }
}

object InputLayerActor {

  val props = Props[InputLayerActor]

  case class Initialize(numInputs:Int)

}

