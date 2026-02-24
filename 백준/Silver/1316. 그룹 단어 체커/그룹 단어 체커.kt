fun main() {
    var answer = 0
    repeat(readln().toInt()){
        answer++
        val word = readln()
        val visited = mutableSetOf<Char>()
        visited.add(word[0])
        for (c in 1 until word.length){
            if(!visited.contains(word[c])){visited.add(word[c])}
            // 본적있는데 이전문자와도 다르다면
            if(visited.contains(word[c]) && word[c-1] != word[c]){
                val cutWord = word.substring(0, c)
                if(cutWord.contains(word[c])){
                    answer--
                    break
                }
            }
        }
    }
    println(answer)
}