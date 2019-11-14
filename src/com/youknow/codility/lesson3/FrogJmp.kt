package com.youknow.codility.lesson3

fun main() {
    val sTime = System.currentTimeMillis()
    val result = solution(1, 5, 1)
    val eTime = System.currentTimeMillis()
    println("time: ${eTime - sTime} ms")

    checkResult(result, 3)
}

fun checkResult(solution: Int, result: Int) {
    if (solution == result) {
        println("pass")
    } else {
        println("fail: expected: [$result] but actual: $solution")
    }
}

fun solution(x: Int, y: Int, d: Int): Int {
    val diff = y - x
    val result = diff / d
    return if (diff % d == 0) {
        result
    } else {
        result + 1
    }
}