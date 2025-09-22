fun main() {
    val heightsList = MutableList(9) { readLine()!!.toInt() }
    val allSum = heightsList.sum()
    val target = allSum - 100

    var isBreak = false
    for(i in 0 until heightsList.size){
        for(j in i+1 until heightsList.size){
            if(heightsList[i]+ heightsList[j] == target){
                heightsList.removeAt(j)
                heightsList.removeAt(i)
                isBreak = true
                break
            }
        }
        if(isBreak){
            break
        }
    }

    heightsList.sort();
    heightsList.forEach { println(it) }

}