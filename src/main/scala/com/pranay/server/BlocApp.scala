package com.pranay.server

import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.http.{HttpServer}


object BlocApp extends FinatraServer


class FinatraServer extends HttpServer {
  override protected def configureHttp(router: HttpRouter): Unit = {
    router.add(new HelloController)
  }
}

