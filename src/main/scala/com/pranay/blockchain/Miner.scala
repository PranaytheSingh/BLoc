package com.pranay.blockchain

import com.pranay.blockchain.Chain.{addBlock, awardBlocktoClient, getBlockchain}
import com.twitter.inject.Logging

class Miner(miner:String) extends Runnable with Logging {

  override def run(): Unit = {
      while(getBlockchain.length < Config.miningDuration) {
          if (getBlockchain.last.isMined) {
            var name: String = addBlock(data = (getBlockchain.indexOf(getBlockchain.last) + 1)
              .toString, previousHash = getBlockchain.last.hash)
          }
          var (b: Block, didIMine: Boolean) = getBlockchain.last.mineBlock(3)
          if (didIMine) {
            Tools.isBlockchainPreserved(getBlockchain)
            awardBlocktoClient(b, miner)

        }
      }
  }
}
