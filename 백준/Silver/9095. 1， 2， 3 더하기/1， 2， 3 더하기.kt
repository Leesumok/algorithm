fun main() {
    val arr = IntArray(readln().toInt()) { readln().toInt() }
    val dp = IntArray(12)
    dp[0] = 1
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for(i in 4..11){
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
    }

    for(i in 0 .. arr.size-1){
        println(dp[arr[i]])
    }
}