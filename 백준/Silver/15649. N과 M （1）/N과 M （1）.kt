fun main() {
    val (n,m) = readln().split(" ").map { it.toInt() }.toIntArray()
    val usedArr = BooleanArray(n+1)
    val result = mutableListOf<Int>()
    fun backTracking (depth: Int) {
        if(depth == m){
            println(result.joinToString(" "))
            return
        }

        for(i in 1 .. n){
            if(!usedArr[i]){
                usedArr[i] = true
                result.add(i)
                backTracking(depth + 1)

                usedArr[i] = false
                result.removeAt(result.size - 1)
            }
        }
    }
    backTracking(0)
}