package org.shypl.tool.lang

import kotlin.test.Test
import kotlin.test.assertEquals

class Test_hex {
	@Test
	fun `check Byte toHexString`() {
		assertEquals("00", 0.toByte().toHexString())
		assertEquals("0f", 15.toByte().toHexString())
		assertEquals("10", 16.toByte().toHexString())
		assertEquals("ff", (-1).toByte().toHexString())
		
		assertEquals("0f", 15.toByte().toHexString(StringBuilder()).toString())
		
		val chars = CharArray(4)
		15.toByte().toHexString(chars, 1)
		assertEquals("\u00000f\u0000", chars.concatToString())
	}
	
	@Test
	fun `check Int toHexString`() {
		assertEquals("00000000", 0.toHexString())
		assertEquals("0000000f", 15.toHexString())
		assertEquals("00000010", 16.toHexString())
		assertEquals("80000000", Int.MIN_VALUE.toHexString())
		assertEquals("ffffffff", (-1).toHexString())
		
		assertEquals("0000000f", 15.toHexString(StringBuilder()).toString())
		
		val chars = CharArray(10)
		15.toHexString(chars, 1)
		assertEquals("\u00000000000f\u0000", chars.concatToString())
	}
	
	@Test
	fun `check Long toHexString`() {
		assertEquals("0000000000000000", 0L.toHexString())
		assertEquals("8000000000000000", Long.MIN_VALUE.toHexString())
		assertEquals("ffffffffffffffff", (-1L).toHexString())
		
		assertEquals("000000000000000f", 15L.toHexString(StringBuilder()).toString())
		
		val chars = CharArray(18)
		15L.toHexString(chars, 1)
		assertEquals("\u0000000000000000000f\u0000", chars.concatToString())
	}
	
	@Test
	fun `check ByteArray toHexString`() {
		assertEquals("0102030405", byteArrayOf(1, 2, 3, 4, 5).toHexString())
		assertEquals("01:02:03:04:05", byteArrayOf(1, 2, 3, 4, 5).toHexString(':'))
		assertEquals("0f", byteArrayOf(0x0F.toByte()).toHexString(':'))
		
		assertEquals("010203", byteArrayOf(1, 2, 3).toHexString(StringBuilder()).toString())
		assertEquals("01:02:03", byteArrayOf(1, 2, 3).toHexString(StringBuilder(), ':').toString())
		assertEquals("0f", byteArrayOf(0x0F.toByte()).toHexString(StringBuilder(), ':').toString())
		
		assertEquals("", byteArrayOf().toHexString())
		assertEquals("", byteArrayOf().toHexString(':'))
		assertEquals("", byteArrayOf().toHexString(StringBuilder()).toString())
		assertEquals("", byteArrayOf().toHexString(StringBuilder(), ':').toString())
	}
}
