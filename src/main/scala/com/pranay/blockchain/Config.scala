package com.pranay.blockchain

import scala.collection.mutable.Map

object Config {
  val difficulty = 1  //Difficulty of solving the hash
  val miningDuration = 100  //Clients will mine until blockchain is 100 items long
  //val prevHash = "000f47869182399a22a93e5307e62a38ed1ec1159cad1d05a31d519981c5cd0b" //Pseudo Random Hash for prev hash for fist block
  val firstHash = "0002a41f6874e2983f52b9871ba026a898cb534991b597c70a646cd0a6bc6fd2"
}
