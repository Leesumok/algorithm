fun main() {
    val comNum = readln().toInt()
    val netNum = readln().toInt()
    val graph = Array(comNum + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(comNum + 1)

    repeat(netNum) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    fun dfs(node: Int, graph: Array<MutableList<Int>>, visited: BooleanArray): Int {
        visited[node] = true
        var count = 1

        for(next in graph[node]){
            if(!visited[next]){
                count += dfs(next, graph, visited)
            }
        }

        return count
    }

    val result = dfs(1, graph, visited)

    println(result - 1)
}