package org.shypl.tool.lang

inline fun waitUntil(maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, condition: () -> Boolean) =
	condition().letOnFalse { waitUntilLater(maxTimeoutMillis, checkTimeoutMillis, condition) }

inline fun waitWhile(maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, condition: () -> Boolean) =
	condition().letOnTrue { waitWhileLater(maxTimeoutMillis, checkTimeoutMillis, condition) }

inline fun waitUntilLater(maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, condition: () -> Boolean) =
	waitFor(true, maxTimeoutMillis, checkTimeoutMillis, condition)

inline fun waitWhileLater(maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, condition: () -> Boolean) =
	waitFor(false, maxTimeoutMillis, checkTimeoutMillis, condition)


@PublishedApi
internal inline fun waitFor(expected: Boolean, maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, condition: () -> Boolean): Boolean {
	var result: Boolean
	val checkTime = checkTimeoutMillis.toLong()
	val maxTime = maxTimeoutMillis * 1_000_000L
	val startTime = System.nanoTime()
	do {
		try {
			Thread.sleep(checkTime)
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