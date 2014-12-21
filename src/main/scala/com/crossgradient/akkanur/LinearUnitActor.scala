package com.crossgradient.akkanur

import akka.actor.{Actor, ActorLogging, Props}

import scala.collection.mutable

class LinearUnitActor extends Actor with ActorLogging {

  import LinearUnitActor._

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
    case LinearUnitActor.RegisterChildMessage =>
      feedingNeurons.put(sender().path.toStringWithoutAddress,false)
    case LinearUnitActor.outMessage(v) =>
      log.info("In NeuronActor - received input value: {} from {}", v, sender().path)
      inputs.put(sender().path.toStringWithoutAddress,v)
      feedingNeurons.put(sender().path.toStringWithoutAddress,true)
      if( feedingNeurons.values.toList.distinct(0) ) {
        context.parent.tell(InputsCompleteMessage,self)
      }
  }
}

object LinearUnitActor {

  val props = Props[LinearUnitActor]

  case object Initialize
  case class outMessage(v:Double)
  case class RegisterChildMessage()
  case class InputsCompleteMessage()

  def f(x:Double):Double = {
    x
  }

}
