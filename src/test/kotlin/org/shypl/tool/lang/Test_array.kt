package org.shypl.tool.lang

import kotlin.test.Test
import kotlin.test.assertEquals

class Test_array {
	@Test
	fun `check empty values`() {
		assertEquals(0, EMPTY_BOOLEAN_ARRAY.size)
		assertEquals(0, EMPTY_BYTE_ARRAY.size)
		assertEquals(0, EMPTY_INT_ARRAY.size)
		assertEquals(0, EMPTY_LONG_ARRAY.size)
		assertEquals(0, EMPTY_DOUBLE_ARRAY.size)
	}
}