package com.youknow.codility.lesson3

fun main() {
    val sTime = System.currentTimeMillis()
    val result = solution(intArrayOf(-10, -20, -30, -40, 100))
    val eTime = System.currentTimeMillis()
    println("time: ${eTime - sTime} ms")

    checkResult(result, 1)
}

private fun checkResult(solution: Int, result: Int) {
    if (solution == result) {
        println("pass")
    } else {
        println("fail: expected: [$result] but actual: $solution")
    }
}

private fun solution(a: IntArray): Int {
    var left = a[0]
    var right = a.sum() - a[0]
    var minimum = abs(left - right)

    if (a.size == 2) {
        return minimum
    }

    for (p in 1 until a.size - 1) {
        left += a[p]
        right -= a[p]

        minimum = min(minimum, abs(left - right))
    }

    return minimum
}

private fun abs(num: Int): Int = when {
    num < 0 -> num * -1
    else -> num
}

private fun min(a: Int, b: Int): Int = when {
    a < b -> a
    else -> b
}