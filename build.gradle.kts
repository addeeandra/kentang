plugins {
    kotlin("jvm") version("1.3.61")
}

buildscript {

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.61")
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.14.1")
    }

}

allprojects {
    group = "dev.poteto"
    version = "1.0"

    repositories {
        mavenCentral()
        jcenter()
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":kentang-core"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}