package com.example.paypaycodechallenge

import com.example.paypaycodechallenge.utils.isAnagramOf
import org.junit.Test

import org.junit.Assert.*

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
}