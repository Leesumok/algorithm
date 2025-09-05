import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val tArr = mutableListOf<Int>()
    val pArr = mutableListOf<Int>()
    repeat(n) {
        val (t, p) = readln().split(" ").map { it.toInt() }
        tArr.add(t)
        pArr.add(p)
    }

    val dp = IntArray(n+1)

    for(i in n-1 downTo  0) {
        if(tArr[i]+i > n){ // 상담기간이 퇴사일을 넘는경우
            dp[i] = dp[i+1]
        }else{ // 상담 가능한 경우
            // 상담을 한다면?
            val work = pArr[i] + dp[i+tArr[i]]
            // 상담을 안한다면?
            val notWork = dp[i+1]
            dp[i] = max(work, notWork)
        }
    }

    println(dp[0])
}