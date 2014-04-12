name := "eden"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "com.google.code.gson" % "gson" % "2.2",
  "org.reflections" % "reflections" % "0.9.9-RC1"
)     

play.Project.playJavaSettings
