import sbt._

class KMinProject(info: ProjectInfo) extends DefaultProject(info)
{
    val scalacheck = "org.scala-tools.testing" %% "scalacheck" % "1.9" % "test" 
}
