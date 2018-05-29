package com.pranay.blockchain


import com.twitter.util.Future
import java.security.Security
import scala.collection.mutable.ListBuffer

object Chain {

  /* Initialize Chain */
  var blockchain:ListBuffer[Block] = ListBuffer[Block](new Block(0,Config.firstHash))
  mineFirstBlock()
  val initizlied:Boolean = true

  Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider())

  def getBlockchain:ListBuffer[Block] = {
    this.synchronized(blockchain)
  }

  def getBlockchainLast:Block= {
    getBlockchain.last
  }

  def getBlockToMine = {
    val index =  getBlockchain.size-1
    index
  }

  def getPreviousBlockHash(name:Int):String = {
    getBlockchain(name - 1).getHash()
  }

  def CheckandAddBlock(Client:String, hash:String, name:Int):Boolean = {
    val newBlock = new Block(name,getPreviousBlockHash(name))
    if (getBlockchain.indexWhere(x => x.name == name) == -1) return false
    if (Tools.isBlockchainPreserved(blockchain :+ newBlock) && Tools.checkHashValue(hash, newBlock)){
      newBlock.setIsMined().setminedBy(Client).setHash(hash)
      blockchain = blockchain :+ newBlock
      return true
      }
    false
  }

  def mineFirstBlock() = {
    var target: String = List.fill(Config.difficulty)(0).mkString
    var nonce = 0
    var b: Block = getBlockchain(0)
    var hash:String = "random"
    while (!hash.substring(0, Config.difficulty).equals(target)) {
      nonce += 1
      hash = Tools.getHash(b.previoushash + b.name + b.timestamp.toString + nonce.toString)
    }
    b.setHash(hash).setIsMined().setminedBy("N1")
  }

  def main(args: Array[String]): Unit = {
    val ch = Chain
    ch.mineFirstBlock()
    println(ch.getBlockchain(0).getHash())
    println(ch.getBlockToMine)
    var name = 0
    println(getBlockchain.indexWhere(x => x.name == name))



  }

}

