fun main() {
    val testcase = readln().toInt()

    repeat(testcase) {
        getCombination()
    }
}

fun getCombination() {
    val clotheNum = readln().toInt()
    val clothMap = mutableMapOf<String, Int>()

    repeat(clotheNum) {
        val type = readln().split(" ")[1]
        clothMap[type] = clothMap.getOrDefault(type, 0) + 1
    }

    var result = 1
    clothMap.values.forEach { count -> result *= (count + 1) }

    println(result-1)
}