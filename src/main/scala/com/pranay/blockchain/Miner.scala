//package com.pranay.blockchain
//
////import com.pranay.blockchain.Chain.{addBlock, awardBlocktoClient, getBlockchain, getBlockchainLast}
//import com.twitter.inject.Logging
//import java.lang.IllegalAccessException
//
//class Miner(miner:String) extends Runnable with Logging {
//
//  override def run(): Unit = {
//    while (getBlockchain.length < Config.miningDuration) {
//      var hash: String = "a"
//      var target: String = List.fill(Config.difficulty)(0).mkString
//      var nonce = 0
//      var b: Block = getBlockchainLast
//
//      try {
//        while (!hash.substring(0, Config.difficulty).equals(target)) {
//          if (b.checkisMined()) throw new Exception("already built");
//          nonce += 1
//          hash = Tools
//            .getHash(getBlockchainLast.previoushash + getBlockchainLast.timestamp
//              .toString + getBlockchainLast.data + nonce.toString)
//        }
//
//        awardBlocktoClient(b, miner, hash)
//      } catch {
//        case e: Exception => info("Block already mined")
//      }
//    }
//  }
//  }
//
