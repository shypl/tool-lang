package org.shypl.tool.lang

import kotlin.test.Test
import kotlin.test.assertNotNull

class Test_fun {
	@Test
	fun testEmptyFunctions() {
		assertNotNull(EMPTY_FUNCTION_1)
		
		// Should not throw anything
		EMPTY_FUNCTION_1(null)
	}
}
