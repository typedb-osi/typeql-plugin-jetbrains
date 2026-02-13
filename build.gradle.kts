import org.jetbrains.grammarkit.tasks.GenerateLexerTask
import org.jetbrains.grammarkit.tasks.GenerateParserTask

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

    signing {
        certificateChain = providers.environmentVariable("CERTIFICATE_CHAIN")
        privateKey = providers.environmentVariable("PRIVATE_KEY")
        password = providers.environmentVariable("PRIVATE_KEY_PASSWORD")
    }

    publishing {
        token = providers.environmentVariable("PUBLISH_TOKEN")
        channels = providers.gradleProperty("pluginVersion").map {
            listOf(it.substringAfter('-').substringBefore('.').ifBlank { "default" })
        }
    }

    pluginVerification {
        ides {
            recommended()
        }
    }
}

val generateTypeQLParser = tasks.register<GenerateParserTask>("generateTypeQLParser") {
    sourceFile.set(file("src/main/grammars/TypeQL.bnf"))
    targetRootOutputDir.set(file("src/main/gen"))
    pathToParser.set("org/typedb/typeql/plugin/jetbrains/TypeQLParser.java")
    pathToPsiRoot.set("org/typedb/typeql/plugin/jetbrains/psi")
    purgeOldFiles.set(true)
}

val generateTypeQLLexer = tasks.register<GenerateLexerTask>("generateTypeQLLexer") {
    dependsOn(generateTypeQLParser)
    sourceFile.set(file("src/main/grammars/TypeQL.flex"))
    targetOutputDir.set(file("src/main/gen/org/typedb/typeql/plugin/jetbrains"))
    purgeOldFiles.set(false)
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
