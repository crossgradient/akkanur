package com.crossgradient.akkanur

import akka.actor.{Actor, ActorLogging, Props}

import scala.collection.mutable

class NeuronActor extends Actor with ActorLogging {

  import NeuronActor._

  // source neuron - weight
  val w = mutable.HashMap[String,Double]()
  val inputs = mutable.HashMap[String,Double]()
  val feedingNeurons = mutable.HashMap[String,Boolean]()
  var allInputCollected:Boolean = false

  def receive = {
    case Initialize =>
      log.info("In NeuronActor - setting default weight")
      // gaussian weight init
      // register as child to neurons in upper layer
    case NeuronActor.RegisterChildMessage =>
      feedingNeurons.put(sender().path.toStringWithoutAddress,false)
    case NeuronActor.outMessage(v) =>
      log.info("In NeuronActor - received input value: {} from {}", v, sender().path)
      inputs.put(sender().path.toStringWithoutAddress,v)
      feedingNeurons.put(sender().path.toStringWithoutAddress,true)
      if( feedingNeurons.values.toList.distinct(0) ) {
        context.parent.tell(InputsCompleteMessage,self)
      }
  }
}

object NeuronActor {

    val props = Props[NeuronActor]

    case object Initialize
    case class outMessage(v:Double)
    case class RegisterChildMessage()
    case class InputsCompleteMessage()

    def sigmoid(x:Double):Double = {
      1 / (1 + math.exp(-x))
    }

}
