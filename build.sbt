lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """health_care""",
    version := "2.8.x",
    scalaVersion := "2.13.1",
    libraryDependencies ++= Seq(
      guice,
      "com.typesafe.play" %% "play-slick" % "5.0.0",
      "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.3.2",
      "org.postgresql" % "postgresql" % "42.2.5",
      specs2 % Test,
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
