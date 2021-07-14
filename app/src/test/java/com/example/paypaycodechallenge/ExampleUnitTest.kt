package com.example.paypaycodechallenge

import com.example.paypaycodechallenge.utils.getFibonacciIterativeApproach
import com.example.paypaycodechallenge.utils.getFibonacciRecursiveApproach
import com.example.paypaycodechallenge.utils.isAnagramOf
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun isAnagrams() {
        var s1 = "ahmed"
        var s2 = "hamed"
        assertEquals(true, s1?.isAnagramOf(s2))
    }

    @Test
    fun getFabIterative() {
        var input = 9
        assertEquals("1 1 2 3 5 8 13 21 34 ", input?.getFibonacciIterativeApproach())
    }

    @Test
    fun getFabRecursive() {
        var input = 9
        assertEquals(34, getFibonacciRecursiveApproach(input))
    }
}