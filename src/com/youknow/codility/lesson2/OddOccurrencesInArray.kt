package com.youknow.codility.lesson2

import kotlin.random.Random

fun main() {
    val arr = generateArray(100_000)

    val sTime = System.currentTimeMillis()
    val result = solution(arr)
    val eTime = System.currentTimeMillis()
    println("time: ${eTime - sTime} ms")

    checkResult(result, 7)
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

fun solution(arr: IntArray): Int = arr.reduce { acc, i ->
    acc xor i
}