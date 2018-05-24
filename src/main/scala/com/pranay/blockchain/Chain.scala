package com.pranay.blockchain

import com.google.gson.Gson
import scala.collection.mutable.ArrayBuffer
import java.security.Security
import java.util.concurrent.{ExecutorService, Executors}


object Chain {

  /* Initialize Chain */
  var blockchain:ArrayBuffer[Block] = new ArrayBuffer[Block]()
  val difficulty:Int = 200
  var minimumTransaction:Int = 3
  var executor:ExecutorService = Executors.newFixedThreadPool(10);
  Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider())
  addBlock(0.toString, previousHash = Config.previousHash)

  def getBlockchain:ArrayBuffer[Block] = this.synchronized {
    blockchain
  }

  def addBlock(data:String, previousHash:String):String = this.synchronized {
    getBlockchain.append(new Block(data, previousHash))
    return data
  }

  def awardBlocktoClient(block: Block, Client:String):Unit = this.synchronized {
    block.setminedBy(Client)
  }

}
