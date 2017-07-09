import sbt.Keys._

//enablePlugins(ScalaJSPlugin)
//scalaJSUseRhino in Global := false
lazy val root = project.in(file("."))
  .aggregate(boardJVM, boardJS)
  .settings(commonSetting)
lazy val commonSetting = Seq(
  version := "1.0"
)

lazy val board = crossProject.in(file(".")).
  settings(
    name := "board",
    scalaVersion := "2.11.8"
  ).jvmSettings(
    scalaVersion := "2.11.8",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http-core" % "2.4.2", // 主に低レベルのサーバーサイドおよびクライアントサイド HTTP/WebSocket API
      "com.typesafe.akka" %% "akka-http-experimental" % "2.4.2", // 高レベルのサーバーサイド API (experimental)
      "com.typesafe.akka" %% "akka-http-spray-json-experimental" % "2.4.2", // Akka で JSON を扱う場合はこれ (experimental)
      "org.scalikejdbc" %% "scalikejdbc" % "2.4.2",
      "com.h2database" % "h2" % "1.4.192",
      "mysql" % "mysql-connector-java" % "5.1.29",
      "ch.qos.logback" % "logback-classic" % "1.1.7",
      "fr.hmil" %%% "roshttp" % "2.0.0-RC1"
    )
  ).jsSettings(
    libraryDependencies += "org.scala-js" %% "scalajs-stubs" % scalaJSVersion % "provided",
    libraryDependencies += "fr.hmil" %%% "roshttp" % "2.0.0-RC1"
)


lazy val boardJVM = board.jvm
lazy val boardJS = board.js