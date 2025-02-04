plugins {
	kotlin("jvm") version "2.1.10"
	id("java-library")
	id("maven-publish")
	id("nebula.release") version "19.0.10"
}

group = "org.shypl.tool"

kotlin {
	jvmToolchain(21)
}

repositories {
	mavenCentral()
}

dependencies {
	testImplementation(kotlin("test"))
}

java {
	withSourcesJar()
}

publishing {
	publications.create<MavenPublication>("Library") {
		from(components["java"])
	}
	
	repositories {
		maven {
			url = uri("https://maven.pkg.github.com/shypl/maven")
			credentials {
				username = project.property("gpr.user") as String
				password = project.property("gpr.key") as String
			}
		}
	}
}