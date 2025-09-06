fun main() {
    val n = readln().toInt()
    val pArr = intArrayOf(0) + readln().split(" ").map { it.toInt() }.toIntArray()
    val dp = IntArray(n+1) { 10001 }
    dp[0] = 0
    dp[1] = pArr[1]


    for(i in 2 .. n){
        for( j in 1 .. i){
            dp[i] = minOf(dp[i], dp[i-j]+pArr[j])
        }
    }

    println(dp[n])
}