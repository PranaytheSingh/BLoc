name := "Bloc"

version := "0.1"

scalaVersion := "2.11.7"

mainClass := Some("com.pranay.server.BlocApp")

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Twitter Maven" at "https://maven.twttr.com"
)

libraryDependencies ++= Seq(
  "com.google.guava" % "guava" % "17.0",
  "com.github.sergeygrigorev" %% "gson-object-scala-syntax" % "0.3.2",
  "com.google.code.gson" % "gson" % "2.2.4",
  "org.bouncycastle" % "bcpkix-jdk15on" % "1.58",
  "com.twitter.finatra" % "finatra-http_2.11" % "2.1.2",
  "com.twitter.finatra" % "finatra-slf4j_2.11" % "2.1.2",
  "ch.qos.logback" % "logback-classic" % "1.1.3"
)
