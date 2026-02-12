# TypeQL Plugin for JetBrains

<!-- Plugin description -->

[TypeQL](https://github.com/typedb/typeql) language support for JetBrains-based IDEs, targeting **TypeQL 3.x** and **TypeDB 3.x**.

<!-- Plugin description end -->

## Features

- **Syntax highlighting** — keywords, types, variables, annotations, literals, comments, with TypeDB-specific color schemes (Darcula, Dark, Light, Classic Light)
- **Parse error highlighting** — real-time error markers from a Grammar-Kit parser translated from the official TypeQL 3.x grammar
- **Structure view** — navigate type definitions, function definitions, and struct definitions (Alt+7)
- **Brace matching** — `()`, `{}`, `[]`
- **Code folding** — collapse brace-delimited blocks
- **Commenting** — toggle line comments with `#` (Cmd/Ctrl+/)
- **Configurable colors** — Preferences → Editor → Color Scheme → TypeQL

## Requirements

- IntelliJ IDEA 2024.3+ (or any JetBrains IDE based on platform 243+)
- Java 21+

## Installation

This plugin is published on the [JetBrains Plugin Repository](https://plugins.jetbrains.com/plugin/17912-typeql):

    Preferences → Plugins → Marketplace → Search for "TypeQL"

### From Source

Clone this repository and check out the `3.x` branch:

```bash
git clone https://github.com/flyingsilverfin/typeql-plugin-jetbrains
cd typeql-plugin-jetbrains
git checkout 3.x
```

Build the plugin zip:

```bash
./gradlew buildPlugin
```

Install from `./build/distributions/typeql-plugin-jetbrains-*.zip`:

    Preferences → Plugins → ⚙️ → Install Plugin from Disk

## Development

Run an IntelliJ IDEA sandbox with the plugin installed:

```bash
./gradlew runIde
```

Run the tests (101 tests — lexer + parser):

```bash
./gradlew test
```

Regenerate the parser and lexer from grammars:

```bash
./gradlew generateTypeQLParser generateTypeQLLexer
```

### Architecture

| Layer | Source | Generated |
|-------|--------|-----------|
| Lexer | `src/main/grammars/TypeQL.flex` (JFlex) | `TypeQLLexer.java` |
| Parser | `src/main/grammars/TypeQL.bnf` (Grammar-Kit) | `TypeQLParser.java`, `TypeQLTypes.java`, `psi/*.java` |
| Plugin | `src/main/kotlin/.../` (Kotlin) | — |

Build order: `generateTypeQLParser` → `generateTypeQLLexer` → `compileKotlin`. The parser generates token type constants that the lexer imports.

## Roadmap

- [x] Phase 1 — JFlex lexer, syntax highlighting, brace matching, commenting, folding
- [x] Phase 2 — Grammar-Kit parser, PSI tree, error highlighting, structure view
- [ ] Phase 3 — Find usages, go-to-declaration, rename refactoring, code completion
