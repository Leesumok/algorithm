fun main() {
    val n = readln().toInt()
    val graph = Array(n) { readln().map { it.digitToInt() }.toIntArray() }
    val result = mutableListOf<Int>()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] == 1) {
                result.add(dfs(i, j, graph))
            }
        }
    }

    println(result.size)
    result.sort()
    result.forEach { println(it) }
}

private fun dfs(x: Int, y: Int, graph: Array<IntArray>): Int {
    graph[x][y] = 2
    val dirs = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
    val range = graph.size
    var count = 1

    for ((dx, dy) in dirs) {
        val nx = dx + x
        val ny = dy + y
        if (validateRange(nx, ny, range) && graph[nx][ny] == 1){
            count += dfs(nx, ny, graph)
        }
    }

    return count
}

private fun validateRange(x: Int, y: Int, range: Int): Boolean = x in 0 until range && y in 0 until range