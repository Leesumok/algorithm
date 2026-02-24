fun main() {
    var input = readln()
    val croMap = listOf("c=" , "c-", "dz=", "d-", "lj", "nj", "s=", "z=")

    for (c in croMap) {
        if(input.contains(c)){
            input = input.replace(c, "0")
        }
    }

    println(input.length)
}
