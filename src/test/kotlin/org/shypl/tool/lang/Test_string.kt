package org.shypl.tool.lang

import kotlin.test.Test
import kotlin.test.assertEquals

class Test_string {
	@Test
	fun `check ensureEnd`() {
		assertEquals("abc", "abc".ensureEnd("bc"))
		assertEquals("abc", "abc".ensureEnd('c'))
		
		assertEquals("abc", "a".ensureEnd("bc"))
		assertEquals("abc", "ab".ensureEnd('c'))
		
		assertEquals("abc", "abc".ensureEnd(""))
		assertEquals("", "".ensureEnd(""))
	}
	
}
