import Dependencies._

ThisBuild / scalaVersion     := "2.13.4"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val zioVersion = "1.0.5"

lazy val common = (project in file("common"))
  .settings(
    name := "Test123 Common"
  )

lazy val root = (project in file("."))
  .aggregate(common)
  .settings(
    name := "Test123",
    libraryDependencies += scalaTest % Test
  )
