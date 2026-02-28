package org.shypl.tool.lang

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class Test_collections {
	@Test
	fun `check index`() {
		val list = listOf(1, 2, 3)
		list.checkIndex(0)
		list.checkIndex(1)
		list.checkIndex(2)
		assertFailsWith<IndexOutOfBoundsException> { list.checkIndex(-1) }
		assertFailsWith<IndexOutOfBoundsException> { list.checkIndex(3) }
	}
	
	@Test
	fun `check letFirstNotNull`() {
		val list = listOf(null, "foo", "bar")
		assertEquals("FOO", list.letFirstNotNull { it?.uppercase() })
		assertEquals(null, listOf<String?>(null, null).letFirstNotNull { it })
	}
	
	@Test
	fun `check clearAndEach`() {
		val list = mutableListOf(1, 2, 3)
		val result = mutableListOf<Int>()
		list.clearAndEach { result.add(it) }
		assertEquals(0, list.size)
		assertEquals(3, result.size)
		assertEquals(listOf(1, 2, 3), result)
	}
}
