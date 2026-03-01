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
		
		val array = arrayOf(1, 2, 3)
		array.checkIndex(0)
		array.checkIndex(1)
		array.checkIndex(2)
		assertFailsWith<IndexOutOfBoundsException> { array.checkIndex(-1) }
		assertFailsWith<IndexOutOfBoundsException> { array.checkIndex(3) }
	}
	
	@Test
	fun `check letFirstNotNull`() {
		val list = listOf(null, "foo", "bar")
		assertEquals("FOO", list.letFirstNotNull { it?.uppercase() })
		assertEquals(null, listOf<String?>(null, null).letFirstNotNull { it })
		
		val array = arrayOf(null, "foo", "bar")
		assertEquals("FOO", array.letFirstNotNull { it?.uppercase() })
		assertEquals(null, arrayOf<String?>(null, null).letFirstNotNull { it })
	}
	
	@Test
	fun `check letFirstNotNull short circuit`() {
		var listCalls = 0
		val listResult = listOf(1, 2, 3, 4).letFirstNotNull {
			listCalls++
			if (it == 3) "ok" else null
		}
		assertEquals("ok", listResult)
		assertEquals(3, listCalls)
		
		var arrayCalls = 0
		val arrayResult = arrayOf(1, 2, 3, 4).letFirstNotNull {
			arrayCalls++
			if (it == 2) "ok" else null
		}
		assertEquals("ok", arrayResult)
		assertEquals(2, arrayCalls)
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
