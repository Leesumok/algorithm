fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()
    var currentSum = arr[0]
    var maxSum = arr[0]

    for( i in 1 until n){
        currentSum = maxOf(arr[i], arr[i] + currentSum)
        maxSum = maxOf(currentSum, maxSum)
    }

    println(maxSum)
}