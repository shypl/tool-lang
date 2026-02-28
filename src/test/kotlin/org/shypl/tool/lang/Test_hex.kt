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
	}
	
	@Test
	fun `check Int toHexString`() {
		assertEquals("00000000", 0.toHexString())
		assertEquals("0000000f", 15.toHexString())
		assertEquals("00000010", 16.toHexString())
		assertEquals("ffffffff", (-1).toHexString())
	}
	
	@Test
	fun `check Long toHexString`() {
		assertEquals("0000000000000000", 0L.toHexString())
		assertEquals("ffffffffffffffff", (-1L).toHexString())
	}
	
	@Test
	fun `check ByteArray toHexString`() {
		assertEquals("0102030405", byteArrayOf(1, 2, 3, 4, 5).toHexString())
		assertEquals("01:02:03:04:05", byteArrayOf(1, 2, 3, 4, 5).toHexString(':'))
	}
}
