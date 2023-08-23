package org.shypl.tool.lang

infix fun Int.plusSafePositive(other: Int): Int {
	if (other == 0) return this
	val new = this + other
	return if (other < 0) {
		if (new < 0) 0 else new
	}
	else {
		if (new < this) Int.MAX_VALUE else new
	}
}

infix fun Int.minusSafePositive(other: Int): Int {
	if (other == 0) return this
	val new = this - other
	return if (other < 0) {
		if (new < this) Int.MAX_VALUE else new
	}
	else {
		if (new < 0) 0 else new
	}
}

infix fun Long.plusSafePositive(other: Long): Long {
	if (other == 0L) return this
	val new = this + other
	return if (other < 0) {
		if (new < 0) 0 else new
	}
	else {
		if (new < this) Long.MAX_VALUE else new
	}
}

infix fun Long.minusSafePositive(other: Long): Long {
	if (other == 0L) return this
	val new = this - other
	return if (other < 0) {
		if (new < this) Long.MAX_VALUE else new
	}
	else {
		if (new < 0) 0 else new
	}
}