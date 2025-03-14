plugins {
    java
    id("org.springframework.boot") version "3.4.3"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "roshka.diegoduarte"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    //testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // JUnit 5 (Jupiter)
    testImplementation ("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine")
    //database
    runtimeOnly ("com.h2database:h2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
