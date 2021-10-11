# JetBrains-TypeQL-Plugin

<!-- Plugin description -->

Basic support for the TypeQL language (https://vaticle.com) on JetBrains-based IDEs

<!-- Plugin description end -->

## Installation

This plugin is published on the [JetBrains Plugin Repository](#todo):

    Preferences → Plugins → Browse Repositories → Search for "TypeQL"

### From Source

Clone this repository:
```bash
$ git clone https://github.com/typedb-osi/typeql-plugin-jetbrains
$ cd typeql-plugin-jetbrains
```

Build the plugin zip file:

```bash
$ ./gradlew buildPlugin
```

Install the plugin from `./build/distributions/typeql-plugin-jetbrains-*.zip`:

    Preferences → Plugins → Install plugin from disk

## Development

Execute an IntelliJ IDEA instance with the plugin you're developing installed:

```bash
$ ./gradlew runIde
```

Run the tests:

```bash
$ ./gradlew test
```

## Information

For more information about how this plugin works and how to add additional functionality please see:
 - https://www.jetbrains.org/intellij/sdk/docs/basics.html
 - https://www.jetbrains.org/intellij/sdk/docs/tutorials/custom_language_support_tutorial.html
