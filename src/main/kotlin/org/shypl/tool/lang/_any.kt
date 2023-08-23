package org.shypl.tool.lang

inline fun <A, reified T : Any> A.cast(failMessage: (A) -> String): T {
	return this as? T ?: throw IllegalStateException(failMessage(this))
}