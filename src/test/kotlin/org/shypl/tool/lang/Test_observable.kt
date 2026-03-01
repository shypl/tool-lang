package org.shypl.tool.lang

import kotlin.test.Test
import kotlin.test.assertEquals

class Test_observable {
	private data class Box(val value: Int)
	
	@Test
	fun `check observable`() {
		
		var value = 0
		var count = 0
		
		class A {
			var foo by observable(1) {
				value = it
				count++
			}
		}
		
		val a = A()
		
		a.foo = 2
		assertEquals(2, a.foo)
		assertEquals(2, value)
		assertEquals(1, count)
		
		a.foo = 2
		assertEquals(2, a.foo)
		assertEquals(2, value)
		assertEquals(1, count)
	}
	
	@Test
	fun `check observable with null values`() {
		var observed: String? = "init"
		var count = 0
		
		class A {
			var foo by observable<String?>(null) {
				observed = it
				count++
			}
		}
		
		val a = A()
		a.foo = null
		assertEquals(0, count)
		assertEquals("init", observed)
		
		a.foo = "bar"
		assertEquals(1, count)
		assertEquals("bar", observed)
		
		a.foo = null
		assertEquals(2, count)
		assertEquals(null, observed)
	}
	
	@Test
	fun `check observable uses equals`() {
		var count = 0
		
		class A {
			var foo by observable(Box(1)) { count++ }
		}
		
		val a = A()
		a.foo = Box(1)
		assertEquals(0, count)
		
		a.foo = Box(2)
		assertEquals(1, count)
	}
	
}
