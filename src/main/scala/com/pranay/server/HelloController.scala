package com.pranay.server

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.inject.Logging

class HelloController extends Controller with Logging {

  get("/test") { request: Request =>
    info("Finatra Server is Up")
    response.status(200).body("BLoc is ready")
  }
}
