/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java project to get you started.
 * For more details take a look at the Java Quickstart chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.1/userguide/tutorial_java_projects.html
 */

plugins {
    // Apply the java plugin to add support for Java
    java

    // Apply the application plugin to add support for building a CLI application.
    application

    // Apply the groovy plugin to also add support for Groovy (needed for Spock)
    groovy
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    // This dependency is used by the application.
    implementation("com.google.guava:guava:28.1-jre")

    // Use the latest Groovy version for Spock testing
    testImplementation("org.codehaus.groovy:groovy-all:2.5.8")

    // Use the awesome Spock testing and specification framework even with Java
    testImplementation("org.spockframework:spock-core:1.3-groovy-2.5")
    testImplementation("junit:junit:4.12")
}

application {
    // Define the main class for the application.
    mainClassName = "EndOfZWorld.App"
}

sourceSets {                                
    main {                                  
        java.srcDir("src/main/java")
    }
}
