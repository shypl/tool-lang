package org.shypl.tool.lang

fun String.ensureEnd(suffix: String): String {
	return if (endsWith(suffix)) return this else this + suffix
}

fun String.ensureEnd(suffix: Char): String {
	return if (endsWith(suffix)) return this else this + suffix
}