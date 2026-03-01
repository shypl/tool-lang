package org.shypl.tool.lang

private val HEX_CHARS = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')

fun Byte.toHexString(): String {
	return CharArray(2).also { toHexString(it, 0) }.concatToString()
}

fun <A : Appendable> Byte.toHexString(target: A): A {
	val v = toInt().and(0xFF)
	target
		.append(HEX_CHARS[v.ushr(4).and(0x0F)])
		.append(HEX_CHARS[v.and(0x0F)])
	return target
}

fun Byte.toHexString(target: CharArray, offset: Int) {
	val v = toInt().and(0xFF)
	target[offset] = HEX_CHARS[v.ushr(4).and(0x0F)]
	target[offset + 1] = HEX_CHARS[v.and(0x0F)]
}

private fun Int.charAt(offset: Int) = HEX_CHARS[ushr(offset).and(0x0F)]

fun Int.toHexString(): String {
	return CharArray(8).also { toHexString(it, 0) }.concatToString()
}

fun <A : Appendable>Int.toHexString(target: A): A {
	target
		.append(charAt(28))
		.append(charAt(24))
		.append(charAt(20))
		.append(charAt(16))
		.append(charAt(12))
		.append(charAt(8))
		.append(charAt(4))
		.append(charAt(0))
	return target
}

fun Int.toHexString(target: CharArray, offset: Int) {
	target[offset] = charAt(28)
	target[offset + 1] = charAt(24)
	target[offset + 2] = charAt(20)
	target[offset + 3] = charAt(16)
	target[offset + 4] = charAt(12)
	target[offset + 5] = charAt(8)
	target[offset + 6] = charAt(4)
	target[offset + 7] = charAt(0)
}

private fun Long.charAt(offset: Int) = HEX_CHARS[ushr(offset).toInt().and(0x0F)]

fun Long.toHexString(): String {
	return CharArray(16).also { toHexString(it, 0) }.concatToString()
}

fun <A : Appendable> Long.toHexString(target: A): A {
	target
		.append(charAt(60))
		.append(charAt(56))
		.append(charAt(52))
		.append(charAt(48))
		.append(charAt(44))
		.append(charAt(40))
		.append(charAt(36))
		.append(charAt(32))
		.append(charAt(28))
		.append(charAt(24))
		.append(charAt(20))
		.append(charAt(16))
		.append(charAt(12))
		.append(charAt(8))
		.append(charAt(4))
		.append(charAt(0))
	return target
}

fun Long.toHexString(target: CharArray, offset: Int) {
	target[offset] = charAt(60)
	target[offset + 1] = charAt(56)
	target[offset + 2] = charAt(52)
	target[offset + 3] = charAt(48)
	target[offset + 4] = charAt(44)
	target[offset + 5] = charAt(40)
	target[offset + 6] = charAt(36)
	target[offset + 7] = charAt(32)
	target[offset + 8] = charAt(28)
	target[offset + 9] = charAt(24)
	target[offset + 10] = charAt(20)
	target[offset + 11] = charAt(16)
	target[offset + 12] = charAt(12)
	target[offset + 13] = charAt(8)
	target[offset + 14] = charAt(4)
	target[offset + 15] = charAt(0)
}


fun ByteArray.toHexString(): String {
	if (isEmpty()) return ""
	val chars = CharArray(size * 2)
	repeat(size) {
		this[it].toHexString(chars, it * 2)
	}
	return chars.concatToString()
}

fun ByteArray.toHexString(separator: Char): String {
	if (isEmpty()) return ""
	val chars = CharArray(size * 3 - 1)
	var i = 0
	repeat(size) {
		if (it != 0) chars[i++] = separator
		this[it].toHexString(chars, i)
		i += 2
	}
	return chars.concatToString()
}

fun <A : Appendable> ByteArray.toHexString(target: A): A {
	if (isEmpty()) return target
	repeat(size) {
		this[it].toHexString(target)
	}
	return target
}

fun <A : Appendable> ByteArray.toHexString(target: A, separator: Char): A {
	if (isEmpty()) return target
	repeat(size) {
		if (it != 0) target.append(separator)
		this[it].toHexString(target)
	}
	return target
}
