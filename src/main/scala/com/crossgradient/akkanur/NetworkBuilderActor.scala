package com.crossgradient.akkanur

import akka.actor.{Actor, ActorLogging, Props}

class NetworkBuilderActor extends Actor with ActorLogging {

  import NetworkBuilderActor._

  val inputLayer = context.actorOf(Props[InputLayerActor],"inputLayer")
  val hiddenLayer1 = context.actorOf(Props[HiddenLayerActor],"hiddenLayer1")
  val hiddenLayer2 = context.actorOf(Props[HiddenLayerActor],"hiddenLayer2")
  val outputLayer = context.actorOf(Props[OutputLayerActor],"outputLayer")

  def receive = {
    case Initialize =>
      log.info("In NetworkBuilderActor")
      inputLayer.tell(InputLayerActor.Initialize(5),self)
      hiddenLayer1.tell(HiddenLayerActor.Initialize(5),self)
      hiddenLayer2.tell(HiddenLayerActor.Initialize(5),self)
      outputLayer.tell(OutputLayerActor.Initialize,self)
  }
}

object NetworkBuilderActor {

  val props = Props[NetworkBuilderActor]

  case object Initialize

}
