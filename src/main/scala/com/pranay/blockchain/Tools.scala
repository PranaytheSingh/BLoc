package com.pranay.blockchain

import java.security.{Key, MessageDigest, PrivateKey, PublicKey, Signature}
import java.util.Base64
import scala.collection.mutable.ArrayBuffer

object Tools {
  def getHash(input:String):String = {
    val digest: MessageDigest = MessageDigest.getInstance("SHA-256")
    val hash: Array[Byte] = digest.digest(input.getBytes())
    var hexString: String = new String
    hexString = hash.map("%02x".format(_)).mkString
    hexString
  }

  def checkPreviousHash(previousBlock:Block, currentBlock:Block):Boolean = {
    previousBlock.hash == currentBlock.previoushash
  }

  def checkCurrentHash(currentBlock:Block):Boolean = {
    currentBlock.hash == getHash(currentBlock.previoushash + currentBlock.timestamp.toString + currentBlock.data)
  }

  def isBlockchainPreserved(blockchain:ArrayBuffer[Block]):Boolean = {
    if (blockchain.length > 1){
    for(i <- 0 to blockchain.length-1) {
      if ((checkCurrentHash(blockchain(i + 1)) && checkPreviousHash(blockchain(i), blockchain(i + 1))) == false) {
        return false
        }
      }
    }
    return true
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
