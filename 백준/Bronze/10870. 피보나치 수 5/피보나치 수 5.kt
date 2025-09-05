fun main() {
    val n = readln().toInt()

    if(n >= 2){
        val dp = IntArray(n+1)
        dp[0] = 0
        dp[1] = 1
        for(i in 2..n){
            dp[i] = dp[i-1] + dp[i-2]
        }
        println(dp[n])
    }else{
        println(n)
    }
}
