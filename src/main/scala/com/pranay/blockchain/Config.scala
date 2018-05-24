package com.pranay.blockchain

import scala.collection.mutable.Map

object Config {
  var registry:Map[String,String] = Map(  //How many miners to simulate
    "Client1" -> "Off",
    "Client2" -> "Off",
    "Client3" -> "Off",
    "Client4" -> "Off")
  val difficulty = 3  //Difficulty of solving the hash
  val miningDuration = 100  //Clients will mine until blockchain is 100 items long
  val previousHash = "d51f7a62f377d78dda695e0af7f2b22a347f53228d5065270599e5eee0f93f46" //Pseudo Random Hash for prev hash for fist block
}
