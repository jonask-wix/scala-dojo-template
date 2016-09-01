lazy val scalaDojo = (project in file("."))
  .settings(
     name := "scala-dojo",
     scalaVersion := "2.11.8",
     version := "1.0.0"
  )

scalacOptions += "-target:jvm-1.8"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.5" % "test"
)
