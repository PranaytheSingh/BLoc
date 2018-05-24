package com.pranay.server

import com.pranay.blockchain.{Chain, Config, Miner}
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.inject.Logging

class MinerController extends Controller with Logging{
  get("/v1/:miner/start") { request:Request =>
    val miner:String = request.params("miner")
    if (Config.registry.contains(miner) && Config.registry(miner) == "Off"){
      info("Starting minning")
      Config.registry(miner) = "On"
      Chain.executor.execute(new Thread(new Miner(request.params("miner"))))
      response.status(200).body(miner + " Has initiated Mining")
    }else {
      error("Miner doesn't exist or is already running")
      response.status(200).body("Miner doesn't exist or is already running")

    }
  }
}
