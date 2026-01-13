fun main() {
    val (day, window) = readln().split(" ").map { it.toInt() }
    val visitNum = readln().split(" ").map { it.toInt() }

    // 초기값 세팅
    var max = 0
    for (i in 0 until window) {
        max += visitNum[i];
    }

    // max 값 갱신 및 비교 그리고 count
    var currentSum = max
    var sameCount = 1
    for (i in window until day) {
        currentSum = currentSum - visitNum[i - window] + visitNum[i]

        if(currentSum > max){
            max = currentSum
            sameCount = 1
        }else if (currentSum == max){
            sameCount++
        }
    }

    if (max == 0) {
        println("SAD")
    } else {
        println(max)
        println(sameCount)
    }
}