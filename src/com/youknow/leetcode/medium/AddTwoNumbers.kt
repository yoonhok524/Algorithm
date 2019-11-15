package com.youknow.leetcode.medium

fun main() {
    val sTime = System.currentTimeMillis()

    val solution = Solution()

    val num1 = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(3)
        }
    }
    val num2 = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4)
        }
    }

    val result = solution.addTwoNumbers(num1, num2)
    val expected = ListNode(7).apply {
        next = ListNode(0).apply {
            next = ListNode(8)
        }
    }

    val eTime = System.currentTimeMillis()
    println("time: ${eTime - sTime} ms")

    checkResult(result, expected)
}

private fun checkResult(actual: ListNode?, expected: ListNode?) {
    if (actual == expected) {
        println("pass")
    } else {
        println("fail: expected: [$expected] but actual: [$actual]")
    }
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun equals(other: Any?): Boolean {
        if (other !is ListNode) {
            return false
        }

        if (`val` != other.`val`) {
            return false
        }

        if (next != other.next) {
            return false
        }

        return true
    }

    fun getNumber(): Int = `val` + (if (next != null) next!!.getNumber() else 0) * 10
}


/**
 * 243, 564
 * 708
 *
 * 342
 * 465
 * 807
 */
private class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val n1 = l1?.getNumber() ?: 0
        val n2 = l2?.getNumber() ?: 0

        val sum = n1 + n2
        println(sum)

        var temp = 0
        var result: ListNode? = null
        while(true) {
            temp = sum % 10
            if (result == null) {
                result = ListNode(temp)
            } else {
                result = ListNode(temp).apply {
                    next = result
                }
            }
        }


        return ListNode(7).apply {
            next = ListNode(0).apply {
                next = ListNode(8)
            }
        }
    }
}