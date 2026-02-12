import org.jetbrains.grammarkit.tasks.GenerateLexerTask

fun properties(key: String) = project.findProperty(key).toString()

plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.21"
    id("org.jetbrains.intellij.platform")
    id("org.jetbrains.grammarkit") version "2022.3.2.2"
}

group = properties("pluginGroup")
version = properties("pluginVersion")

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity(properties("platformVersion"))
        testFramework(org.jetbrains.intellij.platform.gradle.TestFrameworkType.Platform)
    }
    testImplementation("junit:junit:4.13.2")
}

intellijPlatform {
    pluginConfiguration {
        name = properties("pluginName")
        ideaVersion {
            sinceBuild = properties("pluginSinceBuild")
        }
    }
}

val generateTypeQLLexer = tasks.register<GenerateLexerTask>("generateTypeQLLexer") {
    sourceFile.set(file("src/main/grammars/TypeQL.flex"))
    targetOutputDir.set(file("src/main/gen/org/typedb/typeql/plugin/jetbrains"))
    purgeOldFiles.set(true)
}

sourceSets {
    main {
        java {
            srcDir("src/main/gen")
        }
    }
}

tasks.named("compileKotlin") { dependsOn(generateTypeQLLexer) }
tasks.named("compileJava") { dependsOn(generateTypeQLLexer) }

tasks {
    properties("javaVersion").let {
        withType<JavaCompile> {
            sourceCompatibility = it
            targetCompatibility = it
        }
    }
}

kotlin {
    jvmToolchain(properties("javaVersion").toInt())
}
