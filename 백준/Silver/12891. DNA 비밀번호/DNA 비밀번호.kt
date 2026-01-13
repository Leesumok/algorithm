var newACount = 0
var newCCount = 0
var newGCount = 0
var newTCount = 0

fun main() {
    val (dnaSize, window) = readln().split(" ").map { it.toInt() }
    val dnaArr = readln().toCharArray()
    val (aCount, cCount, gCount, tCount) = readln().split(" ").map { it.toInt() }

    var answer = 0
    for(i in 0 until window) {
        plusCount(dnaArr[i])
    }

    if(newACount >= aCount && newCCount >= cCount && newGCount >= gCount && newTCount >= tCount) {
        answer++
    }

    for (i in 1..(dnaSize-window)){
        // 이전거 카운트 빼기
        minusCount(dnaArr[i-1])
        // 다음꺼 카운트 더하기
        plusCount(dnaArr[i+window-1])
        // 비교해서 answer 값 갱신
        if(newACount >= aCount && newCCount >= cCount && newGCount >= gCount && newTCount >= tCount) {
            answer++
        }
    }

    println(answer)

}

fun plusCount(c: Char){
    when (c) {
        'A' -> {
            newACount++
        }
        'C' -> {
            newCCount++
        }
        'G' -> {
            newGCount++
        }
        'T' -> {
            newTCount++
        }
    }
}


fun minusCount(c: Char){
    when (c) {
        'A' -> {
            newACount--
        }
        'C' -> {
            newCCount--
        }
        'G' -> {
            newGCount--
        }
        'T' -> {
            newTCount--
        }
    }
}