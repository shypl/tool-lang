package org.shypl.tool.lang

import kotlin.test.Test
import kotlin.test.assertEquals

@Suppress("ClassName")
class Test_observable {
	@Test
	fun `check observable`() {
		
		var value = 0
		
		class A {
			var foo by observable(1) { value = it }
		}
		
		val a = A()
		
		a.foo = 2
		assertEquals(2, a.foo)
		assertEquals(2, value)
	}
	
}