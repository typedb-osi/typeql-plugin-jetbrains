# TypeQL Plugin for JetBrains

<!-- Plugin description -->

Basic support for the [TypeQL language](https://github.com/vaticle/typeql) on JetBrains-based IDEs.

<!-- Plugin description end -->

## Installation

This plugin is published on the [JetBrains Plugin Repository](https://plugins.jetbrains.com/plugin/17912-typeql):

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

## Supported features

 - Syntax highlighting and colouring (JetBrains and TypeDB color schemes) based on the official TypeQL grammar.
 - Find Usages, Go To Declaration.
 - Rename (currently excluding [references to relations in "plays" constraints](https://github.com/typedb-osi/typeql-plugin-jetbrains/issues/15)).
 - Code completion.

### Temporarily disabled features

 - Unused, Invalid and Duplicated items inspections.

## Syntax highlighting and colouring

JetBrains Color Scheme-based syntax highlighting automatically works out of the box. However, it is possible to import TypeDB-specific color schemes used in [TypeDB Studio](https://typedb.com/docs/typedb/connecting/studio) by downloading the needed color scheme files from the corresponding [resource directory](https://github.com/typedb-osi/typeql-plugin-jetbrains/tree/master/src/main/resources) and importing it in the IDE via `Preferences → Editor → Color Scheme → Import Scheme`.

## Information

For more information about how this plugin works and how to add additional functionality please see:
 - https://github.com/JetBrains/intellij-platform-plugin-template
 - https://www.jetbrains.org/intellij/sdk/docs/basics.html
 - https://www.jetbrains.org/intellij/sdk/docs/tutorials/custom_language_support_tutorial.html
