package org.shypl.tool.lang

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class Test_any {
	@Test
	fun `check cast`() {
		val any: Any = "foo"
		val string: String = any.cast { "error" }
		assertEquals("foo", string)
		
		assertFailsWith<IllegalStateException> {
			(123 as Any).cast<Any, String> { "is not string" }
		}
	}
}
