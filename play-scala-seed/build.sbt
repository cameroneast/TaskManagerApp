name := """play-scala-seed"""
organization := "The Scalars"

version := "1.0-SNAPSHOT"


lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.12"

resolvers += "jitpack" at "https://jitpack.io"
libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.0" % Test
libraryDependencies += "com.github.bane73" % "firebase4j" % "master"


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "The Scalars.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "The Scalars.binders._"
