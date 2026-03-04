package org.shypl.tool.lang

inline fun waitUntil(maxTimeoutMillis: Long, checkTimeoutMillis: Long = 10, condition: () -> Boolean): Boolean {
	return condition().letOnFalse { waitUntilLater(maxTimeoutMillis, checkTimeoutMillis, condition) }
}

inline fun waitWhile(maxTimeoutMillis: Long, checkTimeoutMillis: Long = 10, condition: () -> Boolean): Boolean {
	return condition().letOnTrue { waitWhileLater(maxTimeoutMillis, checkTimeoutMillis, condition) }
}

inline fun waitUntilLater(maxTimeoutMillis: Long, checkTimeoutMillis: Long = 10, condition: () -> Boolean): Boolean {
	return waitFor(true, maxTimeoutMillis, checkTimeoutMillis, condition)
}

inline fun waitWhileLater(maxTimeoutMillis: Long, checkTimeoutMillis: Long = 10, condition: () -> Boolean): Boolean {
	return waitFor(false, maxTimeoutMillis, checkTimeoutMillis, condition)
}

@PublishedApi
internal inline fun waitFor(expected: Boolean, maxTimeoutMillis: Long, checkTimeoutMillis: Long, condition: () -> Boolean): Boolean {
	var result: Boolean
	val maxTime = maxTimeoutMillis * 1_000_000
	val startTime = System.nanoTime()
	do {
		try {
			Thread.sleep(checkTimeoutMillis)
		}
		catch (_: InterruptedException) {
			Thread.currentThread().interrupt()
			return condition()
		}
		result = condition()
	}
	while (result != expected && System.nanoTime() - startTime < maxTime)
	return result
}