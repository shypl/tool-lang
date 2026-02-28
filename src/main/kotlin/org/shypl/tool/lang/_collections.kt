package org.shypl.tool.lang

fun checkCollectionIndex(index: Int, size: Int) {
	if (index !in 0..<size) {
		throw IndexOutOfBoundsException("index: $index, size: $size")
	}
}

fun Array<*>.checkIndex(index: Int) {
	checkCollectionIndex(index, size)
}

fun Collection<*>.checkIndex(index: Int) {
	checkCollectionIndex(index, size)
}

inline fun <T, R> Array<out T>.letFirstNotNull(transform: (T) -> R?): R? {
	for (e in this) {
		val r = transform(e)
		if (r != null) return r
	}
	return null
}

inline fun <T, R> Iterable<T>.letFirstNotNull(transform: (T) -> R?): R? {
	for (e in this) {
		val r = transform(e)
		if (r != null) return r
	}
	return null
}

inline fun <reified T> MutableCollection<T>.clearAndEach(action: (T) -> Unit) {
	val array = toTypedArray()
	clear()
	array.forEach(action)
}
