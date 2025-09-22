fun main() {
    val (n,m) = readln().split(" ").map { it.toInt() }.toIntArray()
    val result = mutableListOf<Int>()

    fun backTracking(start: Int){
        if(result.size == m){
            println(result.joinToString (" " ))
            return
        }

        for(i in start .. n){
            result.add(i)
            backTracking(i+1)
            result.removeAt(result.size - 1)
        }

    }

    backTracking(1)
}