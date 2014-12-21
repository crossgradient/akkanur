package com.crossgradient.akkanur

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

class AkkanurActorSpec(_system: ActorSystem) extends TestKit(_system) with ImplicitSender
with WordSpecLike with Matchers with BeforeAndAfterAll {

  def this() = this(ActorSystem("MySpec"))

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "A NetworkBuilder actor" must {
    "read a conf" in {
      val networkBuilderActor = system.actorOf(NetworkBuilderActor.props)
//      pingActor ! PongActor.PongMessage("pong")
//      expectMsg(PingActor.PingMessage("ping"))
    }
  }
/*
  "A Pong actor" must {
    "send back a pong on a ping" in {
      val pongActor = system.actorOf(PongActor.props)
      pongActor ! PingActor.PingMessage("ping")
      expectMsg(PongActor.PongMessage("pong"))
    }
  }
*/
}

