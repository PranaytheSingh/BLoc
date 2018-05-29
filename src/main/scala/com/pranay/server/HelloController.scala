package com.pranay.server

import com.pranay.blockchain
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.inject.Logging
import scala.concurrent.ExecutionContext.Implicits.global
import com.twitter.util.Future


class HelloController extends Controller with Logging {

  get("/test") { request: Request =>
    info("Finatra Server is Up")
    response.status(200).body("BLoc is ready")
  }

  get("/v1/node/:node") { request: Request =>
    val node = request.params("node")
    var cal:Future[String] = DB.addToRegistry(node)
    cal.onSuccess{
      case re => response
                      .ok
                      .json(""""
                             {
                               "Registered":re
                               "Block_to_Mine":Chain.getBlockToMine
                             }
                            """)
    }
  }

  get("v1/:node/mine") { request: Request =>
    val node = request.params("node")

  }
}
