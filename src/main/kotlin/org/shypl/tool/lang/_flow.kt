package org.shypl.tool.lang

inline fun <T> T.applyOn(value: T, block: T.() -> Unit): T {
	if (this == value) block()
	return this
}

inline fun <T> T.applyEx(value: T, block: T.() -> Unit): T {
	if (this != value) block()
	return this
}


inline fun <T> T.alsoOn(value: T, block: (T) -> Unit): T {
	if (this == value) block(this)
	return this
}

inline fun <T> T.alsoEx(value: T, block: (T) -> Unit): T {
	if (this != value) block(this)
	return this
}


inline fun <T> T.letOn(value: T, block: (T) -> T): T {
	return if (this == value) block(this) else this
}

inline fun <T> T.letEx(value: T, block: (T) -> T): T {
	return if (this != value) block(this) else this
}


inline fun <T> T.runOn(value: T, block: T.() -> T): T {
	return if (this == value) block() else this
}

inline fun <T> T.runEx(value: T, block: T.() -> T): T {
	return if (this != value) block() else this
}


inline fun letOnTrue(predicate: Boolean, block: () -> Boolean): Boolean {
	return if (predicate) block() else false
}

inline fun letOnFalse(predicate: Boolean, block: () -> Boolean): Boolean {
	return if (predicate) true else block()
}

@JvmName("letTrueExt")
inline infix fun Boolean.letOnTrue(block: () -> Boolean) = letOnTrue(this, block)

@JvmName("letFalseExt")
inline infix fun Boolean.letOnFalse(block: () -> Boolean) = letOnFalse(this, block)


inline fun alsoOnTrue(predicate: Boolean, block: () -> Unit): Boolean {
	if (predicate) block()
	return predicate
}

inline fun alsoOnFalse(predicate: Boolean, block: () -> Unit): Boolean {
	if (!predicate) block()
	return predicate
}

@JvmName("alsoTrueExt")
inline infix fun Boolean.alsoOnTrue(block: () -> Unit) = alsoOnTrue(this, block)

@JvmName("alsoFalseExt")
inline infix fun Boolean.alsoOnFalse(block: () -> Unit) = alsoOnFalse(this, block)


@Suppress("NOTHING_TO_INLINE")
inline fun <T> Boolean.make(onTrue: T, onFalse: T) = if (this) onTrue else onFalse

inline fun <T> Boolean.make(onTrue: () -> T, onFalse: () -> T) = if (this) onTrue() else onFalse()

inline fun <reified T : Any> Any?.onIs(action: (T) -> Unit): Boolean {
	return if (this is T) {
		action(this)
		true
	}
	else false
}