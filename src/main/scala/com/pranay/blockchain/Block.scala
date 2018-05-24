package com.pranay.blockchain

import java.util.Date
import com.twitter.inject.Logging

class Block(val data:String, val previoushash:String) extends Logging{
  private var nonce:Int = 0
  val timestamp:Long = new Date().getTime
  var hash:String = Tools.getHash(previoushash + timestamp.toString + data + nonce.toString)
  var isMined:Boolean = false
  var minedBy:String = _


  def mineBlock(difficulty:Int):(Block,Boolean) ={
    var target:String = List.fill(difficulty)(0).mkString
    while(!hash.substring(0,difficulty).equals(target)){
      nonce += 1
      hash = Tools.getHash(previoushash + timestamp.toString + data + nonce.toString)
      if (checkisMined()){
        return (this, false)
      } //if isMined is true then false
    }
    setIsMined()
    (this, true)
  }

  def setminedBy(miner:String) =  {
    minedBy = miner
    info("block " + data + " mined by: "+miner)
  }

  def checkisMined() = {
    isMined
  }

  def setIsMined() = this.synchronized {
    isMined = true
  }


}
