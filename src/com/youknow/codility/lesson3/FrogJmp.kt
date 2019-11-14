package com.youknow.codility.lesson3

import kotlin.random.Random

fun main() {
    val arr = generateArray(100_000)

    val sTime = System.currentTimeMillis()
//    val result = solution(1, 5, 1)
    val result = solution(10, 1000000000, 1) // 999999991
    val eTime = System.currentTimeMillis()
    println("time: ${eTime - sTime} ms")

    checkResult(result, 999999990)
//    checkResult(result, 3)
}

fun generateArray(n: Int): IntArray {
    val list = mutableListOf<Int>()
    for (i in 0 until n step 2) {
        val randomNum = Random.nextInt(1, 1_000_000_001)
        list.add(randomNum)

        if (i != n - 1) list.add(randomNum)
    }

    return list.toIntArray()
}

fun checkResult(solution: Int, result: Int) {
    if (solution == result) {
        println("pass")
    } else {
        println("fail: expected: [$result] but actual: $solution")
    }
}

//fun solution(x: Int, y: Int, d: Int): Int {
//    var count = 0
//    var result = x
//
//    while (result < y) {
//        result += d
//        count++
//    }
//
//    return count
//}

fun solution(x: Int, y: Int, d: Int): Int {
    val diff = y - x
    val result = diff / d
    return if (diff % d == 0) {
        result
    } else {
        result + 1
    }
}