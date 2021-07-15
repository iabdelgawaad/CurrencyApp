package com.example.paypaycodechallenge.utils

import java.util.*


fun String.isAnagramOf(str2: String): Boolean {
    //Both String Length must be Equal
    if (this.length != str2.length) {
        return false
    }

    //Convert Strings to character Array
    val strArray1 = this.toCharArray()
    val strArray2 = str2.toCharArray()

    //Sort the Arrays
    Arrays.sort(strArray1)
    Arrays.sort(strArray2)

    //Convert Arrays to String
    val sortedStr1 = String(strArray1)
    val sortedStr2 = String(strArray2)

    //Check Both String Equals or not After Sorting
    //and Return value True or False
    return sortedStr1 == sortedStr2
}

fun Int.getFibonacciIterativeApproach(): String {
    var t1 = 1
    var t2 = 1

    var result = StringBuilder()

    for (i in 1..this) {
        result?.append("$t1 ")
        val sum = t1 + t2
        t1 = t2
        t2 = sum
    }
    return result.toString()
}

fun getFibonacciRecursiveApproach(n: Int): Int {
    if (n <= 1)
        return n;
    System.out.println("n = $n")
    return getFibonacciRecursiveApproach(n - 1) + getFibonacciRecursiveApproach(n - 2);
}