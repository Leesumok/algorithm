fun main() {

    val cardNum = readln().toInt()
    val queue = ArrayDeque<Int>()
    var card = 1
    repeat(cardNum) {
        queue.add(card++)
    }

    while (queue.size > 1){
        queue.removeFirst()
        val second = queue.removeFirst()
        queue.add(second)
    }

    println(queue.joinToString(""))
}