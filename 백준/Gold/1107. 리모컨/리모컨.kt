package boj.y2025.sep.week3

import kotlin.math.abs

fun main() {
    val targetCh = readln().toInt()
    val brokenSize = readln().toInt()
    val brokenBtnStateArr = BooleanArray(10)


    if (brokenSize > 0) { // 고장난 버튼이 있을때
        val brokenButton = readln().split(" ").map { it.toInt() }
        for (button in brokenButton) {
            brokenBtnStateArr[button] = true
        }
    }
    var result = abs(targetCh - 100)
    for (ch in 0..999999) {
        if (canUseChannel(brokenBtnStateArr, ch)) {
            val digitCount = ch.toString().length
            val moveCount = abs(targetCh - ch)
            val totalCount = digitCount + moveCount

            result = minOf(result, totalCount)
        }
    }

    println(result)
}

private fun canUseChannel(brokenBtnStateArr: BooleanArray, targetCh: Int): Boolean {
    for (i in 0 until brokenBtnStateArr.size) {
        if (targetCh.toString().contains(i.toString()) && brokenBtnStateArr[i]) {
            return false
        }
    }
    return true
}
