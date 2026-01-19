fun main() {

    val input = readln().uppercase().toCharArray()

    val alphaMap = mutableMapOf<Char, Int>()

    for(a in input.indices){
        alphaMap[input[a]] = alphaMap.getOrDefault(input[a], 0) + 1
    }

    val maxVal = alphaMap.values.max()
    val keys = alphaMap.filterValues { it == maxVal }.keys

    if(keys.size > 1) println("?") else println(keys.first())

}