package com.youknow.codility.lesson3

fun main() {
    val arr = (1..100_000).toList().toIntArray()

    val sTime = System.currentTimeMillis()
    val result = solution(arr)
    val eTime = System.currentTimeMillis()
    println("time: ${eTime - sTime} ms")

    checkResult(result, 4)
}

private fun checkResult(solution: Int, result: Int) {
    if (solution == result) {
        println("pass")
    } else {
        println("fail: expected: [$result] but actual: $solution")
    }
}

fun solution(a: IntArray): Int {
    a.sort()

    var count = 1
    for (idx in 0 until a.size) {
        if (count != a[idx]) {
            return count
        }

        count++
    }

    return count
}