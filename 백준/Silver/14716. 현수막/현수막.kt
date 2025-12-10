package boj.y2025.dec.week2.dfs

fun main() {
    // 입력값 받기
    val (m, n) = readln().split(" ").map { it.toInt() }

    val board = Array(m) {
        readln().split(" ").map { it.toInt() }.toIntArray()
    }

    val dirs = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1, -1 to -1, 1 to -1, -1 to 1, 1 to 1)
    val queue = ArrayDeque<Pair<Int, Int>>()

    var answer = 0

    for (x in 0 until m) {
        for (y in 0 until n) {
            // bfs
            if (board[x][y] == 1) answer += bfs(x, y, board, dirs, queue)
        }
    }

    println(answer)

}

fun bfs(x: Int, y: Int, board: Array<IntArray>, dir: Array<Pair<Int, Int>>, queue: ArrayDeque<Pair<Int, Int>>): Int {
    queue.add(x to y)
    board[x][y] = 2

    while (queue.isNotEmpty()) {
        val (currentX, currentY) = queue.removeFirst()

        for ((dx, dy) in dir) {
            val nextX = currentX + dx
            val nextY = currentY + dy

            if (nextX in 0 until board.size && nextY in 0 until board[0].size && board[nextX][nextY] == 1) {
                queue.add(nextX to nextY)
                board[nextX][nextY] = 2
            }
        }
    }

    return 1
}
