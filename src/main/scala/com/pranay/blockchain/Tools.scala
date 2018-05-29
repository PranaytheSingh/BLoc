package com.pranay.blockchain

import java.security.{Key, MessageDigest, PrivateKey, PublicKey, Signature}
import java.util.Base64
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object Tools {
  def getHash(input:String):String = {
    val digest: MessageDigest = MessageDigest.getInstance("SHA-256")
    val hash: Array[Byte] = digest.digest(input.getBytes())
    var hexString: String = new String
    hexString = hash.map("%02x".format(_)).mkString
    hexString
  }

  def checkPreviousHash(previousBlock:Block, currentBlock:Block):Boolean = {
    previousBlock.getHash == currentBlock.previoushash
  }

  def checkCurrentHash(currentBlock:Block):Boolean = {
    currentBlock.getHash() == getHash(currentBlock.previoushash + currentBlock.timestamp.toString + currentBlock.name)
  }

  def isBlockchainPreserved(blockchain:ListBuffer[Block]):Boolean = {
      for (i <- 1 to blockchain.length-1) {
        if (!(checkPreviousHash(blockchain(i - 1), blockchain(i)) && checkCurrentHash(blockchain(i)))) return false
      }
    true
  }

  def checkHashValue(hash:String, block:Block):Boolean = {
    val target: String = List.fill(block.mineOnDifficulty)(0).mkString
    hash.substring(0,block.mineOnDifficulty).equals(target)
  }

  def applyECDSASig(privateKey: PrivateKey, input:String):Array[Byte] = {
    try {
      var dsa: Signature = Signature.getInstance("ECDSA","BC")
      dsa.initSign(privateKey)
      var strByte:Array[Byte] = input.getBytes()
      dsa.update(strByte)
      var realSig:Array[Byte] = dsa.sign()
      realSig
    } catch {
      case e:Exception => throw new RuntimeException(e)
    }
  }

  def verifyECDSASig(publicKey: PublicKey, Sig:Array[Byte], input:String):Boolean = {
    try {
      var ecdsaVerify = Signature.getInstance("ECDSA", "BC")
      ecdsaVerify.initVerify(publicKey)
      ecdsaVerify.update(input.getBytes())
      return ecdsaVerify.verify(Sig)
    } catch {
      case e:Exception => throw new RuntimeException(e)
    }
  }

  def getStringFromKey(key:Key):String = {
    return Base64.getEncoder().encodeToString(key.getEncoded)
  }

}
