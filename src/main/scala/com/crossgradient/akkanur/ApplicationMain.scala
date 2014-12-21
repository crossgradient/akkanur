package com.crossgradient.akkanur

import akka.actor.ActorSystem

object ApplicationMain extends App {
  val system = ActorSystem("AkkanurSystem")
  val networkBuilderActor = system.actorOf(PingActor.props, "NetworkBuilderActor")
  networkBuilderActor ! NetworkBuilderActor.Initialize
  system.awaitTermination()
}