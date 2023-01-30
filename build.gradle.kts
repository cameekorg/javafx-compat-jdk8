plugins {
    `java-library`
    `maven-publish`
}

group = "org.cameek"
version = "8.362"

java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

publishing {
    publications {
        create<MavenPublication>("myLibrary") {
            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "myRepo"
            url = uri(layout.buildDirectory.dir("repo"))
        }
    }
}

//tasks.withType<JavaCompile> {
//    val javaCompile = this
//    doFirst {
//        val task = this
//      //  if ((java.sourceCompatibility == JavaVersion.VERSION_1_8) && System.env.JDK6_HOME != null) {
//      //      javaCompile.options.bootstrapClasspath?.files?.add(File(""))
//            //options.fork = true
//          //  options.bootClasspath = "$System.env.JDK6_HOME/jre/lib/rt.jar"
//           // options.bootClasspath += "$File.pathSeparator$System.env.JDK6_HOME/jre/lib/jsse.jar"
//            // use the line above as an example to add jce.jar
//            // and other specific JDK jars
//      //  }
//    }
//}