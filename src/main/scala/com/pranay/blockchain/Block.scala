package com.pranay.blockchain

import java.util.Date
import com.twitter.inject.Logging

class Block(val name:Int, val previoushash:String) extends Logging{
  var nonce:Int = 0
  val timestamp:Long = new Date().getTime
  private var hash:String = _
  var mineOnDifficulty:Int = Config.difficulty
  private var minedBy:String = _
  private var isMined:Boolean = false

  def setminedBy(miner:String) =  {
    this.minedBy = miner
    info("block " + name + " mined by: "+miner + " HASH: " + hash)
    this
  }

  def checkisMined() = {
    this.isMined
  }

  def setIsMined() = {
    this.isMined = true
    this
  }

  def setHash(newhash:String) = {
    this.hash = newhash
    this
  }

  def getHash():String = {
    this.hash
  }

}
