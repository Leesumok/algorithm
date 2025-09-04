fun main() {
    val (E,S,M) = readln().split(" ").map { it.toInt() }
    var baseE = 1
    var baseS = 1
    var baseM = 1
    var result = 1

    while (true){
        if(baseE == E && baseS == S && baseM == M){
            break
        }else{
            baseE += if(baseE == 15) -14 else 1
            baseS += if(baseS == 28) -27 else 1
            baseM += if(baseM == 19) -18 else 1
            result += 1
        }
    }
    println(result)
}
