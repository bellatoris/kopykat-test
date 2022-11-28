import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    id("com.google.devtools.ksp") version "1.7.21-1.0.8"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sourceSets {
    test {
        java {
             srcDir("build/generated/ksp/test/kotlin")
        }
    }
}

dependencies {
    ksp("at.kopyk:kopykat-ksp:1.0")
    compileOnly("at.kopyk:kopykat-annotations:1.0")
    testImplementation(kotlin("test"))
    testCompileOnly("at.kopyk:kopykat-annotations:1.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

ksp {
    arg("generate", "annotated")
}
