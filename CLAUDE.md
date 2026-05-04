# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
./gradlew build          # compile + test
./gradlew test           # run tests only
./gradlew test --tests "org.shypl.tool.lang.Test_fun"  # single test class
./gradlew publish        # publish to Maven (requires shypl.maven.* properties)
./gradlew release        # version bump + publish via Nebula Release
```

## Architecture

Kotlin JVM utility library (`org.shypl.tool.lang`), zero runtime dependencies, JVM 21 toolchain, Kotlin 2.x.

Each source file is a top-level extension/utility module named with a leading underscore:

- `_fun.kt` / `_flow.kt` — functional helpers: `applyOn`, `letOn`, `letIf`, conditional booleans, type casting
- `_collections.kt` — `checkIndex`, `letFirstNotNull`, `clearAndEach`
- `_observable.kt` — observable property delegates
- `_thread.kt` — `waitUntil` / `waitWhile` with timeout polling
- `_hex.kt` — hex conversion for `Byte`, `Int`, `Long`, `ByteArray`
- `_bits.kt` — `has` infix operator for bitwise checks
- `_numbers.kt` — safe arithmetic (`plusSafePositive`, `minusSafePositive`)
- `_array.kt` — empty array constants
- `_string.kt` — `ensureEnd` string extension

Each module has a corresponding `Test_*.kt` in `src/test/kotlin/org/shypl/tool/lang/`.
