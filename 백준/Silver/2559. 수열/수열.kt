fun main() {
    val (day, window) = readln().split(" ").map { it.toInt() }
    val tempArr = readln().split(" ").map { it.toInt() }

    var max = 0
    var beforeMax = 0
    // max값 초기화
    for(i in tempArr.indices) {
        max += tempArr[i]
        if(i == (window - 1))break;
    }

    beforeMax = max;

    for(t in 1 until tempArr.size - window + 1) {
        val newMax = beforeMax - tempArr[t-1] + tempArr[t+window-1]
        max = maxOf(max, newMax)
        beforeMax = newMax
    }

    println(max)
}