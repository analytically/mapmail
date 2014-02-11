name := "mapmailer"

version := "1.0-SNAPSHOT"

resolvers += "Open Source Geospatial Foundation Repository" at "http://download.osgeo.org/webdav/geotools/"

libraryDependencies ++= Seq(
  javaCore,
  filters
)

libraryDependencies += "com.google.guava" % "guava" % "16.0.1"

libraryDependencies +=  "com.google.code.findbugs" % "jsr305" % "2.0.3" // see http://stackoverflow.com/questions/10007994/why-do-i-need-jsr305-to-use-guava-in-scala

libraryDependencies += "org.reactivemongo" % "play2-reactivemongo_2.10" % "0.10.2" excludeAll ExclusionRule(organization = "org.apache.logging.log4j")

libraryDependencies += "org.apache.logging.log4j" % "log4j-to-slf4j" % "2.0-beta9"

libraryDependencies += "uk.co.coen" % "capsulecrm-java" % "1.2.2" excludeAll ExclusionRule(organization = "xmlpull")

libraryDependencies += "org.apache.camel" % "camel-core" % "2.11.3"

libraryDependencies += "org.apache.camel" % "camel-csv" % "2.11.3"

libraryDependencies += "org.apache.camel" % "camel-bindy" % "2.11.3"

libraryDependencies += "org.geotools" % "gt-main" % "10.4" excludeAll ExclusionRule(organization = "javax.media")

libraryDependencies += "org.geotools" % "gt-epsg-hsql" % "10.4" excludeAll ExclusionRule(organization = "javax.media")

play.Project.playScalaSettings

libraryDependencies ~= { _ map {
  case m if m.organization == "org.apache.httpcomponents" =>
    m.exclude("commons-logging", "commons-logging")
  case m if m.organization == "com.typesafe.play" =>
    m.exclude("commons-logging", "commons-logging").exclude("org.springframework", "spring-context").exclude("org.springframework", "spring-beans")
  case m => m
}}
