# TypeQL Plugin for JetBrains

<!-- Plugin description -->

[TypeQL](https://github.com/typedb/typeql) language support for JetBrains-based IDEs, targeting **TypeQL 3.x** and **TypeDB 3.x**.

<!-- Plugin description end -->

## Features

### Editing
- **Syntax highlighting** — keywords, types, variables, annotations, literals, comments, with TypeDB-specific color schemes (Darcula, Dark, Light, Classic Light)
- **Parse error highlighting** — real-time error markers from a Grammar-Kit parser translated from the official TypeQL 3.x grammar
- **Brace matching** — `()`, `{}`, `[]`
- **Code folding** — collapse brace-delimited blocks
- **Commenting** — toggle line comments with `#` (Cmd/Ctrl+/)
- **Configurable colors** — Preferences → Editor → Color Scheme → TypeQL

### Navigation
- **Go to declaration** (Cmd/Ctrl+Click or Cmd/Ctrl+B) — click on a type name (`person` in `$p isa person`) to jump to its definition (`entity person sub entity`)
- **Find usages** (Alt+F7) — from a type, function, or struct definition, find all references across `.tql` files in the project
- **Structure view** (Alt+7) — navigate type definitions, function definitions, and struct definitions

### Refactoring
- **Rename** (Shift+F6) — rename a type, function, or struct definition and all references update automatically
- **In-place rename** — inline rename for local variables and member definitions

### Supported Definitions
| Definition | Declaration syntax | Resolution scope |
|---|---|---|
| Types | `entity name`, `relation name`, `attribute name` | Global (all `.tql` files) |
| Functions | `fun name(...)` | Global (all `.tql` files) |
| Structs | `struct name:` | Global (all `.tql` files) |
| Variables | `$name` | Local (containing query/function) |

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

Run the tests:

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
| Mixins | `src/main/kotlin/.../psi/impl/` (Kotlin) | Extend generated `*Impl` classes via BNF `mixin` attribute |
| References | `src/main/kotlin/.../psi/` (Kotlin) | `PsiReferenceBase` subclasses for type, function, variable resolution |
| Plugin | `src/main/kotlin/.../` (Kotlin) | — |

Build order: `generateTypeQLParser` → `generateTypeQLLexer` → `compileKotlin`. The parser generates token type constants that the lexer imports. Grammar-Kit `mixin` attributes wire generated PSI implementations to hand-written Kotlin mixin classes that provide `PsiNameIdentifierOwner` and `PsiReference` support.

### Reference Resolution

Resolution uses `PsiTreeUtil` tree walks — no stub indexes. For type and function references, the containing file is searched first (fast path), then all `.tql` files in the project via `FileTypeIndex` (cross-file path). Variable references are scoped to the nearest containing query or function definition.

## Roadmap

- [x] Phase 1 — JFlex lexer, syntax highlighting, brace matching, commenting, folding
- [x] Phase 2 — Grammar-Kit parser, PSI tree, error highlighting, structure view
- [x] Phase 3 — Go-to-declaration, find usages, rename refactoring
- [ ] Phase 4 — Code completion, semantic inspections, stub indexes for large projects
