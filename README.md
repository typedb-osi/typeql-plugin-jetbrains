# TypeQL Plugin for JetBrains

<!-- Plugin description -->

Basic support for the [TypeQL language](https://github.com/vaticle/typeql) on JetBrains-based IDEs

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

## Suggested Colouring

The following colours are suggested for the best experience, but are not required. 

You can add these colours to your IDE colour scheme by going to `Preferences → Editor → Color Scheme`, downloading your current scheme. Then, add the following to the `attributes` section of the downloaded scheme:

- Dark Theme

```
<option name="TYPEQL_AGGREGATE">
      <value>
        <option name="FOREGROUND" value="ff7abd" />
        <option name="FONT_TYPE" value="2" />
      </value>
    </option>
    <option name="TYPEQL_BOOLEAN">
      <value>
        <option name="FOREGROUND" value="ffa187" />
      </value>
    </option>
    <option name="TYPEQL_IDENTIFIER">
      <value>
        <option name="FOREGROUND" value="d5ccff" />
      </value>
    </option>
    <option name="TYPEQL_KEYWORD">
      <value>
        <option name="FOREGROUND" value="ff7abd" />
      </value>
    </option>
    <option name="TYPEQL_LINE_COMMENT">
      <value>
        <option name="FOREGROUND" value="4dc97c" />
      </value>
    </option>
    <option name="TYPEQL_NUMBER">
      <value>
        <option name="FOREGROUND" value="82b6ff" />
      </value>
    </option>
    <option name="TYPEQL_STRING">
      <value>
        <option name="FOREGROUND" value="ffe4a7" />
      </value>
    </option>
    <option name="TYPEQL_THING">
      <value>
        <option name="FOREGROUND" value="55eae2" />
        <option name="FONT_TYPE" value="2" />
      </value>
    </option>
    <option name="TYPEQL_TYPE">
      <value>
        <option name="FOREGROUND" value="82b6ff" />
        <option name="FONT_TYPE" value="2" />
      </value>
    </option>
    <option name="TYPEQL_VAR">
      <value>
        <option name="FOREGROUND" value="55eae2" />
      </value>
    </option>
  </attributes>
```

- Light Theme

```
<option name="TYPEQL_AGGREGATE">
      <value>
        <option name="FOREGROUND" value="fb3196" />
        <option name="FONT_TYPE" value="2" />
      </value>
    </option>
    <option name="TYPEQL_BOOLEAN">
      <value>
        <option name="FOREGROUND" value="ff6b00" />
      </value>
    </option>
    <option name="TYPEQL_IDENTIFIER">
      <value>
        <option name="FOREGROUND" value="392d67" />
      </value>
    </option>
    <option name="TYPEQL_KEYWORD">
      <value>
        <option name="FOREGROUND" value="fb3196" />
      </value>
    </option>
    <option name="TYPEQL_LINE_COMMENT">
      <value>
        <option name="FOREGROUND" value="309c59" />
      </value>
    </option>
    <option name="TYPEQL_NUMBER">
      <value>
        <option name="FOREGROUND" value="82b6ff" />
      </value>
    </option>
    <option name="TYPEQL_STRING">
      <value>
        <option name="FOREGROUND" value="f1be05" />
      </value>
    </option>
    <option name="TYPEQL_THING">
      <value>
        <option name="FOREGROUND" value="28c9c0" />
        <option name="FONT_TYPE" value="2" />
      </value>
    </option>
    <option name="TYPEQL_TYPE">
      <value>
        <option name="FOREGROUND" value="82b6ff" />
        <option name="FONT_TYPE" value="2" />
      </value>
    </option>
    <option name="TYPEQL_VAR">
      <value>
        <option name="FOREGROUND" value="28c9c0" />
      </value>
    </option>
  </attributes>
```

## Information

For more information about how this plugin works and how to add additional functionality please see:
 - https://github.com/JetBrains/intellij-platform-plugin-template
 - https://www.jetbrains.org/intellij/sdk/docs/basics.html
 - https://www.jetbrains.org/intellij/sdk/docs/tutorials/custom_language_support_tutorial.html
