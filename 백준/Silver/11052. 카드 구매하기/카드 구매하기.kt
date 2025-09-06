import kotlin.math.max

fun main() {
    val n = readln().toInt()
    // 카드 갯수 i 개 팩의 가격 = p[i]
    val p = intArrayOf(0) + readln().split(" ").map { it.toInt() }.toIntArray()
    // 카드 i 장 샀을때 드는 최대 비용 = dp[i]
    val dp = IntArray(n+1)
    dp[1] = p[1]

    for(i in 2..n){
        for(j in 1 .. i){
            dp[i] = max(
                dp[i], dp[i-j] + p[j]
             )
        }
    }

    println(dp[n])
}