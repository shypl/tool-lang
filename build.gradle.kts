plugins {
	kotlin("jvm") version "2.3.0"
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
	repositories.maven("https://maven.pkg.github.com/shypl/packages").credentials {
		username = project.property("shypl.gpr.user") as String
		password = project.property("shypl.gpr.key") as String
	}
}

tasks.release {
	finalizedBy(tasks.publish)
}