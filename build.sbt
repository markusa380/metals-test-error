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
    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio"               % zioVersion,
      "dev.zio" %% "zio-test"          % zioVersion % "test",
      "dev.zio" %% "zio-test-sbt"      % zioVersion % "test",
      "dev.zio" %% "zio-test-magnolia" % zioVersion % "test"
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
