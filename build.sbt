name := "Lexpand"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0" classifier "models",
  "org.scalatest" %% "scalatest" % "3.0.0-M15"
)