package org.shypl.tool.lang

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Test_flow {
	@Test
	fun `check applyOn`() {
		var affected: Boolean
		
		affected = false
		assertEquals(1, 1.applyOn(1) {
			assertEquals(1, this)
			affected = true
		})
		assertTrue(affected)
		
		affected = false
		assertEquals(2, 2.applyOn(1) {
			affected = true
		})
		assertFalse(affected)
	}
	
	@Test
	fun `check applyEx`() {
		var affected: Boolean
		
		affected = false
		assertEquals(1, 1.applyEx(1) { affected = true })
		assertFalse(affected)
		
		affected = false
		assertEquals(2, 2.applyEx(1) {
			assertEquals(2, this)
			affected = true
		})
		assertTrue(affected)
	}
	
	@Test
	fun `check alsoOn`() {
		var affected: Boolean
		
		affected = false
		assertEquals(1, 1.alsoOn(1) {
			assertEquals(1, it)
			affected = true
		})
		assertTrue(affected)
		
		affected = false
		assertEquals(2, 2.alsoOn(1) { affected = true })
		assertFalse(affected)
	}
	
	@Test
	fun `check alsoEx`() {
		var affected: Boolean
		
		affected = false
		assertEquals(1, 1.alsoEx(1) { affected = true })
		assertFalse(affected)
		
		affected = false
		assertEquals(2, 2.alsoEx(1) {
			assertEquals(2, it)
			affected = true
		})
		assertTrue(affected)
	}
	
	@Test
	fun `check letOn`() {
		assertEquals(2, 1.letOn(1) {
			assertEquals(1, it)
			2
		})
		assertEquals(2, 2.letOn(1) { 1 })
	}
	
	@Test
	fun `check letEx`() {
		assertEquals(1, 1.letEx(1) { 2 })
		assertEquals(1, 2.letEx(1) {
			assertEquals(2, it)
			1
		})
	}
	
	@Test
	fun `check runOn`() {
		assertEquals(2, 1.runOn(1) {
			assertEquals(1, this)
			2
		})
		assertEquals(2, 2.letOn(1) { 1 })
	}
	
	@Test
	fun `check runEx`() {
		assertEquals(1, 1.runEx(1) { 2 })
		assertEquals(1, 2.runEx(1) {
			assertEquals(2, this)
			1
		})
	}
	
	@Test
	fun `check letOnTrue`() {
		assertFalse(true letOnTrue { false })
		assertFalse(false letOnTrue { true })
	}
	
	@Test
	fun `check letOnFalse`() {
		assertTrue(true letOnFalse { false })
		assertTrue(false letOnFalse { true })
	}
	
	@Test
	fun `check alsoOnTrue`() {
		var affected: Boolean
		
		affected = false
		assertTrue(true alsoOnTrue { affected = true })
		assertTrue(affected)
		
		affected = false
		assertFalse(false alsoOnTrue { affected = true })
		assertFalse(affected)
	}
	
	@Test
	fun `check alsoOnFalse`() {
		var affected: Boolean
		
		affected = false
		assertTrue(true alsoOnFalse { affected = true })
		assertFalse(affected)
		
		affected = false
		assertFalse(false alsoOnFalse { affected = true })
		assertTrue(affected)
	}
	
	@Test
	fun `check make`() {
		assertEquals(1, true.make(1, 2))
		assertEquals(2, false.make(1, 2))
		
		assertEquals(1, true.make({ 1 }, { 2 }))
		assertEquals(2, false.make({ 1 }, { 2 }))
	}
	
	@Test
	fun `check onIs`() {
		var affected: Boolean
		
		affected = false
		assertTrue("A".onIs<String> { affected = true })
		assertTrue(affected)
		
		affected = false
		assertFalse("A".onIs<Int> { affected = true })
		assertFalse(affected)
	}
}