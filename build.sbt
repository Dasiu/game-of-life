name := """game-of-life"""

version := "1.0"

lazy val root = (project in file("."))

scalaVersion := "2.12.6"
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")
scalacOptions += "-Yrangepos"

addCompilerPlugin(scalafixSemanticdb)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test

fork in run := true