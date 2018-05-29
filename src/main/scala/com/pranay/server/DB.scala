package com.pranay.server

import scala.collection.mutable.Map
//import scala.concurrent.{Future}
import com.twitter.util.Future
import scala.concurrent.ExecutionContext.Implicits.global


object DB {
  private var registry:Map[String,String] = Map()

  def addToRegistry(node:String):Future[String] = Future {
    this.registry.update(node,"Ok")
    node
  }
}
