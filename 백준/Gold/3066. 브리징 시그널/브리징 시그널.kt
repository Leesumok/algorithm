fun main() {
    val num = readln().toInt()

    repeat(num){
        val t = readln().toInt()
        val arr = IntArray(t)
        repeat(t){ i ->
            arr[i] = readln().toInt()
        }
        binarySearch(arr)
    }
}

fun binarySearch(arr: IntArray){
    val dp = mutableListOf<Int>()
    for(a in 0 until arr.size){
        val target = arr[a]
        val pos = lowerBound(dp, target)

        if(pos == dp.size){
            dp.add(target)
        }else{
            dp[pos] = target
        }
    }
    println(dp.size)
}

fun lowerBound(dp: MutableList<Int>, target: Int): Int{
    var left = 0
    var right = dp.size

    while (left < right){
        val mid = (left + right) / 2
        if(dp[mid] < target){
            left = mid+1
        }else{
            right = mid
        }
    }
    return left
}