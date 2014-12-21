package com.crossgradient.akkanur

import akka.actor.{Actor, ActorLogging, Props}

class NeuronActor extends Actor with ActorLogging {
  import NeuronActor._
  var counter = 0
  val neuronActor = context.actorOf(PongActor.props, "pongActor")

  def receive = {
    case Initialize =>
      log.info("In NeuronActor - setting default weight")
      // pongActor ! PingMessage("ping")
    case NeuronActor.inputMessage(v) =>
      log.info("In NeuronActor - received message: {}", v)
      counter += 1
      if (counter == 3) context.system.shutdown()
      else sender() ! PingMessage("ping")
  }
}

object NeuronActor {

    case object Initialize
    case class outputMessage(v:Double)
    case class inputMessage(v:Double)

    def sigmoid(x:Double):Double = {
      1 / (1 + math.exp(-x))
    }

}
