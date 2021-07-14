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