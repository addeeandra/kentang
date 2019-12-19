plugins {
    kotlin("jvm")
}

dependencies {
    val ktor_version: String by project

    implementation(kotlin("stdlib-jdk8"))

    api("io.ktor:ktor-server-core:${ktor_version}")
    api("io.ktor:ktor-server-netty:${ktor_version}")
    api("io.ktor:ktor-server-jetty:${ktor_version}")
    api("io.ktor:ktor-gson:${ktor_version}")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
