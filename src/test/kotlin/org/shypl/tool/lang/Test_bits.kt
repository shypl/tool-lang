package org.shypl.tool.lang

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@Suppress("ClassName")
class Test_bits {
	@Test
	fun `check Int has`() {
		assertTrue(0x00.has(0))
		assertTrue(0xFF.has(0b0000_0001))
		assertTrue(0xFF.has(0b0000_0010))
		assertTrue(0xFF.has(0b0000_0100))
		assertTrue(0xFF.has(0b0000_1000))
		
		assertTrue(0xFF.has(0b1000_1000))
		assertTrue(0xFF.has(0b1111_1111))
		assertTrue(0xFF.has(0b0101_0000))
		
		assertFalse(0x0F.has(0b0001_0000))
		assertFalse(0x0F.has(0b1000_0000))
	}
	
	@Test
	fun `check Long has`() {
		assertTrue(0x00L.has(0))
		assertTrue(0xFFL.has(0b0000_0001))
		assertTrue(0xFFL.has(0b0000_0010))
		assertTrue(0xFFL.has(0b0000_0100))
		assertTrue(0xFFL.has(0b0000_1000))
		
		assertTrue(0xFFL.has(0b1000_1000))
		assertTrue(0xFFL.has(0b1111_1111))
		assertTrue(0xFFL.has(0b0101_0000))
		
		assertFalse(0x0FL.has(0b0001_0000))
		assertFalse(0x0FL.has(0b1000_0000))
	}
}