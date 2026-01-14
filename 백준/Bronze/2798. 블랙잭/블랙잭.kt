fun main() {
    val (cardNum, target) = readln().split(" ").map { it.toInt() }
    val cards = readln().split(" ").map { it.toInt() }
    
    var answer = 0
    for(i in 0 until cardNum){
        for(j in i+1 until cardNum){
            for(k in j+1 until cardNum){
                val sum = cards[i] + cards[j] + cards[k]
                if(sum <= target && sum > answer) {
                    answer = sum
                }
            }
        }
    }
    println(answer)
}