import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "computer-database"
    val appVersion      = "1.0"
    val h2 = "com.h2database" % "h2" % "1.2.127"

    val appDependencies = Seq(
        "org.squeryl" %% "squeryl" % "0.9.5"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here      
    )

}
            
