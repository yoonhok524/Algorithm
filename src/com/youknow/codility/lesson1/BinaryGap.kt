package com.youknow.codility.lesson1

fun main() {
    checkResult(solution(9), 2)
    checkResult(solution(529), 4)
    checkResult(solution(20), 1)
    checkResult(solution(15), 0)
    checkResult(solution(32), 0)
    checkResult(solution(1041), 5)
}

fun checkResult(solution: Int, result: Int) {
    if (solution == result) {
        println("pass")
    } else {
        println("fail: expected: [$result] but actual: $solution")
    }
}

fun solution(n: Int): Int {
    var temp = n
    var longestCount = 0
    var tempCnt = 0
    var startCounting = false
    while(temp != 0) {
        val num = temp % 2
        if (startCounting && num == 0) {
            tempCnt++
        } else if (num == 1) {
            startCounting = true
            if (longestCount < tempCnt) {
                longestCount = tempCnt
            }

            tempCnt = 0
        }

        temp /= 2
    }

    return longestCount
}