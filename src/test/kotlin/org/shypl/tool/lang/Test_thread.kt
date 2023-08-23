package org.shypl.tool.lang

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@Suppress("ClassName")
class Test_thread {
	@Test
	fun `check waitUntil`() {
		var i = 0
		val result = waitUntil(1000, 1) { ++i >= 10 }
		assertTrue(result)
		assertEquals(10, i)
	}
	
	@Test
	fun `check waitWhile`() {
		var i = 0
		val result = waitWhile(1000, 1) { ++i < 10 }
		assertFalse(result)
		assertEquals(10, i)
	}
	
	@Test
	fun `check waitUntil timeout`() {
		val result = waitUntil(10, 1) { false }
		assertFalse(result)
	}
	
	@Test
	fun `check waitWhile timeout`() {
		val result = waitUntil(10, 1) { true }
		assertTrue(result)
	}
	
	@Test
	fun `cover default parameters`() {
		waitUntil(1) { true }
		waitWhile(1) { false }
		waitUntilLater(1) { true }
		waitWhileLater(1) { false }
		
		waitFor(true, 1) { true }
	}
}