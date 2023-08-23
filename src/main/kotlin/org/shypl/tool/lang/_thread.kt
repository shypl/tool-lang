package org.shypl.tool.lang

inline fun waitUntil(maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, condition: () -> Boolean) =
	condition().letOnFalse { waitUntilLater(maxTimeoutMillis, checkTimeoutMillis, condition) }

inline fun waitWhile(maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, condition: () -> Boolean) =
	condition().letOnTrue { waitWhileLater(maxTimeoutMillis, checkTimeoutMillis, condition) }

inline fun waitUntilLater(maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, condition: () -> Boolean) =
	waitFor(true, maxTimeoutMillis, checkTimeoutMillis, condition)

inline fun waitWhileLater(maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, condition: () -> Boolean) =
	waitFor(false, maxTimeoutMillis, checkTimeoutMillis, condition)


inline fun waitFor(expected: Boolean, maxTimeoutMillis: Int, checkTimeoutMillis: Int = 10, condition: () -> Boolean): Boolean {
	var result: Boolean
	val checkTime = checkTimeoutMillis.toLong()
	val maxTime = maxTimeoutMillis.toLong()
	val startTime = System.currentTimeMillis()
	do {
		Thread.sleep(checkTime)
		result = condition()
	}
	while (result != expected && System.currentTimeMillis() - startTime < maxTime)
	return result
}