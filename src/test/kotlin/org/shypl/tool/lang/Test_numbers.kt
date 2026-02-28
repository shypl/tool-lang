package org.shypl.tool.lang

import kotlin.test.Test
import kotlin.test.assertEquals

class Test_numbers {
	@Test
	fun `check Int plusSafePositive`() {
		assertEquals(1, 1 plusSafePositive 0)
		assertEquals(1, 0 plusSafePositive 1)
		assertEquals(0, 0 plusSafePositive -1)
		assertEquals(Int.MAX_VALUE, Int.MAX_VALUE plusSafePositive 1)
		
		assertEquals(3, 5 plusSafePositive -2)
		assertEquals(0, 1 plusSafePositive -2)
	}
	
	@Test
	fun `check Int minusSafePositive`() {
		assertEquals(1, 1 minusSafePositive 0)
		assertEquals(0, 1 minusSafePositive 1)
		assertEquals(2, 1 minusSafePositive -1)
		assertEquals(0, 1 minusSafePositive 2)
		assertEquals(Int.MAX_VALUE, Int.MAX_VALUE minusSafePositive -1)
		
		assertEquals(Int.MAX_VALUE, (Int.MAX_VALUE - 1) minusSafePositive -2)
	}
	
	@Test
	fun `check Long plusSafePositive`() {
		assertEquals(1L, 1L plusSafePositive 0)
		assertEquals(1L, 0L plusSafePositive 1)
		assertEquals(0L, 0L plusSafePositive -1)
		assertEquals(Long.MAX_VALUE, Long.MAX_VALUE plusSafePositive 1)
		
		assertEquals(3L, 5L plusSafePositive -2)
		assertEquals(0L, 1L plusSafePositive -2L)
	}
	
	@Test
	fun `check Long minusSafePositive`() {
		assertEquals(1L, 1L minusSafePositive 0)
		assertEquals(0L, 1L minusSafePositive 1)
		assertEquals(2L, 1L minusSafePositive -1)
		assertEquals(0L, 1L minusSafePositive 2)
		assertEquals(Long.MAX_VALUE, Long.MAX_VALUE minusSafePositive -1)
		
		assertEquals(Long.MAX_VALUE, (Long.MAX_VALUE - 1) minusSafePositive -2)
	}
}