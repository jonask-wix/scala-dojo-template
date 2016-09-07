lazy val scalaDojo = (project in file("."))
  .settings(
     name := "scala-dojo",
     scalaVersion := "2.11.8",
     version := "1.0.0"
  )

scalacOptions += "-target:jvm-1.8"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.8.4" % "test",
  "org.specs2" %% "specs2-scalacheck" % "3.8.4" % "test"
)

