fun main() {
    var answer = 0
    repeat(readln().toInt()){
        val word = readln()
        val visited = mutableSetOf<Char>()
        var prev: Char? = null
        var isGroup = true
        for (c in 0 until word.length){
            if (prev != word[c]){
                if(visited.contains(word[c])){
                    isGroup = false
                    break
                }
                visited.add(word[c])
            }
            prev = word[c]
        }

        if(isGroup){
            answer++
        }
    }
    println(answer)
}