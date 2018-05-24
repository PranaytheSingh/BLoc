package com.pranay.server

import com.google.gson.{Gson, GsonBuilder}
import com.pranay.blockchain.{Block, Chain}
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.inject.Logging
import java.util
import java.util.HashMap
import scala.collection.mutable.ArrayBuffer

class ViewController extends Controller with Logging{
  get("/v1/final") { request:Request =>
    var dataSet:HashMap[String, infoObj] = new util.HashMap[String, infoObj]()
    val blockchain:ArrayBuffer[Block] = Chain.getBlockchain
    blockchain.foreach(x => {
      dataSet.put(x.data, new infoObj(x.minedBy, x.hash))
      info("block : " + x.data + " Mined By: " + x.minedBy + " Is Mined : " + x.isMined)
    }
    )
    val gson:Gson = new GsonBuilder().create()
    val json:String = gson.toJson(dataSet)
    info(json)
    response.status(200).body(json)
  }
}

class infoObj(val MinedBy:String, val hash:String )
