# TypeQL Plugin for JetBrains

<!-- Plugin description -->

[TypeQL](https://github.com/typedb/typeql) support for JetBrains-based IDEs, targeting **TypeQL 3.x** and **TypeDB 3.x**.

<!-- Plugin description end -->

## Features

### Editing
- **Syntax highlighting** -- keywords, types, variables, annotations, literals, comments, with TypeDB-specific color schemes (Darcula, Dark, Light, Classic Light)
- **Parse error highlighting** -- real-time error markers from a Grammar-Kit parser translated from the official TypeQL 3.x grammar
- **Brace matching** -- `()`, `{}`, `[]`
- **Code folding** -- collapse brace-delimited blocks
- **Commenting** -- toggle line comments with `#` (Ctrl+/)
- **Configurable colors** -- Preferences > Editor > Color Scheme > TypeQL

### Navigation
- **Go to declaration** (Ctrl+Click / Ctrl+B) -- click on a type/variable/function to jump to its definition entity
- **Find usages** (Alt+F7) -- from a type, function, or struct definition, find all references across `.tql` files in the project
- **Structure view** (Alt+7) -- navigate type definitions, function definitions, and struct definitions

### Refactoring
- **Rename** (Shift+F6) -- rename a type, function, or struct definition and all references update automatically
- **In-place rename** -- rename for variables and member definitions

### Supported Definitions
| Construct | Declaration syntax | Resolution scope |
|---|---|---|
| Types | `entity`, `relation`, `attribute` | All `.tql` files |
| Functions | `fun(...)` | All `.tql` files |
| Structs | `struct { ... }` | All `.tql` files |
| Variables | `$...` | Containing query/function |

## Requirements

- IntelliJ IDEA 2024.3+ (or any JetBrains IDE based on platform 243+)
- Java 21+

## Installation

This plugin is published on the [JetBrains Plugin Repository](https://plugins.jetbrains.com/plugin/17912-typeql)

  IDEA > Plugins > Marketplace > Search for "TypeQL"

### From Source

Clone this repository, check out the `3.9` branch:

```bash
git clone https://github.com/flyingsilverfin/typeql-plugin-jetbrains
cd typeql-plugin-jetbrains
git checkout 3.9
```

Build the plugin zip:

```bash
./gradlew buildPlugin
```

Install from `./build/distributions/typeql-plugin-jetbrains-*.zip`:

  Preferences > Plugins > Gear > Install Plugin from Disk

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
|---|---|---|
| Lexer | `src/main/grammars/TypeQL.flex` (JFlex) | `TypeQLLexer.java` |
| Parser | `src/main/grammars/TypeQL.bnf` (Grammar-Kit) | `TypeQLParser.java`, `TypeQLTypes.java`, `psi/*.java` |
| Mixins | `src/main/kotlin/.../psi/impl/` (Kotlin) | Extend generated `*Impl` classes via BNF `mixin` attribute |
| References | `src/main/kotlin/.../psi/` (Kotlin) | `PsiReferenceBase` subclasses for type, function, variable resolution |
| Plugin | `src/main/kotlin/.../` (Kotlin) | -- |

Build order: `generateTypeQLParser` > `generateTypeQLLexer` > `compileKotlin`. The parser generates token type constants that the lexer imports. Grammar-Kit `mixin` attributes wire generated PSI implementations to hand-written Kotlin mixin classes that provide `PsiNamedElement` and `PsiReference` support.

### Reference Resolution

Resolution uses `PsiTreeUtil` tree walks -- no stub indexes. For type and function references, the containing file is searched first (fast path), then all `.tql` files in the project via `FileTypeIndex` (cross-file path). Variable references are scoped to the nearest containing query or function definition.

## CI/CD

Two GitHub Actions workflows automate validation and release:

| Workflow | Trigger | Purpose |
|---|---|---|
| `build.yml` | Push to `master`/`main`, PRs | Validate (test, verify, build), draft-release |
| `release.yml` | Pre-release, release published | Sign plugin, publish to JetBrains Marketplace, upload release asset |

**Build workflow** (`build.yml`):
1. Runs `./gradlew test` (lexer + parser + reference tests)
2. Runs `./gradlew verifyPluginStructure verifyPlugin` (IntelliJ plugin checks)
3. Runs `./gradlew buildPlugin` (produces distributable ZIP)
4. Exports the built version and artifact path as workflow outputs
5. Creates a draft GitHub release tagged with the built version

**Release workflow** (`release.yml`):
1. Checks out the tagged commit
2. Builds the plugin
3. Signs it with a PEM certificate chain and private key (from repository secrets)
4. Publishes to JetBrains Marketplace using a Marketplace upload token (from repository secrets)
5. Uploads the signed ZIP as a GitHub release asset

**Repository secrets required:**

| Secret | Description |
|---|---|
| `PUBLISH_TOKEN` | JetBrains Marketplace upload token ([obtain here](https://plugins.jetbrains.com/author/me/tokens)) |
| `CERTIFICATE_CHAIN` | PEM certificate chain for plugin signing |
| `PRIVATE_KEY` | PEM private key for plugin signing |
| `PRIVATE_KEY_PASSWORD` | Passphrase for the private key |

`GITHUB_TOKEN` is provided automatically; no configuration needed.

## Publishing

The plugin is published to the [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/17912-typeql).

**Release process:**
1. **Draft creation** -- every push to `master`/`main` that passes CI creates a draft release tagged with the version. Old drafts are deleted first to avoid accumulation.
2. **Publishing a release** -- navigate to GitHub > Releases > find the draft > edit title/description > click "Publish release" (or "Publish as pre-release" for alpha/beta). This triggers the `release.yml` workflow.
3. **What happens on publish** -- the workflow checks out the tagged commit, builds the plugin, signs it with the PEM certificate, publishes it to JetBrains Marketplace, and uploads the ZIP as a release asset.
4. **Channel routing** -- the Marketplace channel is derived from the version string: `3.0.9-alpha.1` publishes to the `alpha` channel, `3.0.9-beta.1` to `beta`, and `3.0.9` to the default (stable) channel.
5. **Version bumps** -- to prepare a new release, update `pluginVersion` in `gradle.properties` and push. The next CI run creates a new draft with the updated version.

## Roadmap

- [x] Phase 1 -- JFlex lexer, syntax highlighting, brace matching, commenting, folding
- [x] Phase 2 -- Grammar-Kit parser, PSI tree, error highlighting, structure view
- [x] Phase 3 -- Go-to-declaration, find usages, rename refactoring
- [ ] Phase 4 -- Code completion, semantic inspections, stub indexes for large projects
