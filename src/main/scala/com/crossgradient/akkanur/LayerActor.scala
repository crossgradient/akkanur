package com.crossgradient.akkanur

import akka.actor.{Actor, ActorLogging, Props}
import com.crossgradient.akkanur.NeuronActor.InputsCompleteMessage

import scala.collection.mutable

class LayerActor extends Actor with ActorLogging {

  import LayerActor._

  // source neuron - weight
  val w = mutable.HashMap[String,Double]()
  val inputs = mutable.HashMap[String,Double]()
  val myNeurons = mutable.HashMap[String,Boolean]()
  var allInputCollected:Boolean = false

  def receive = {
    case Initialize =>
      log.info("In LayerActor - init")
    case NeuronActor.InputsCompleteMessage =>
      log.info("In LayerActor - received inputs complete")
      myNeurons.put(sender().path.toStringWithoutAddress,false)
      if( myNeurons.values.toList.distinct(0) ) {
        //myNeurons.foreach(context.children)
        //(InputsCompleteMessage,self)
      }
  }
}

object LayerActor {

  val props = Props[LayerActor]

  case object Initialize
  case class BroadcastMessage()

}
