package boj.y2025.sep.week3

import kotlin.math.abs

fun main() {
    val targetCh = readln().toInt()
    val brokenSize = readln().toInt()
    val nowCh = 100
    val brokenBtnStateArr = BooleanArray(10)
    var result = 0

    if (targetCh != 100) { // 목표 채널이 100이 아닐때
        val pushPlusMinus = abs(targetCh - nowCh)

        if (brokenSize > 0) { // 고장난 버튼이 있을때
            val brokenButton = readln().split(" ").map { it.toInt() }
            for (button in brokenButton) {
                brokenBtnStateArr[button] = true
            }
        }

        if (brokenSize > 0 && !canUseChannel(brokenBtnStateArr, targetCh)) {
            var minCount = pushPlusMinus
            for (ch in 0..999999) {
                if(canUseChannel(brokenBtnStateArr, ch)){
                    val digitCount = ch.toString().length
                    val moveCount = abs(targetCh - ch)
                    val totalCount = digitCount + moveCount

                    if(totalCount < minCount){
                        minCount = totalCount
                    }
                }
            }

            result = minCount

        } else { // 고장난 버튼이 없거나 모든 버튼을 사용가능할때
            val pushCh = targetCh.toString().length
            result = if (pushPlusMinus > pushCh) pushCh else pushPlusMinus
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
