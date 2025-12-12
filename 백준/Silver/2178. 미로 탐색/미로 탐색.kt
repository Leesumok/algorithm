fun main() {
    val (row, cols) = readln().split(" ").map { it.toInt() }
    val board = Array(row) {
        readln().map { it.toString().toInt() }.toIntArray()
    }

    val dirs = arrayOf(0 to -1, 0 to 1, -1 to 0, 1 to 0)
    val queue = ArrayDeque<Triple<Int, Int, Int>>()
    queue.add(Triple(0, 0, 1))
    board[0][0] = 0

    while (queue.isNotEmpty()) {
        val (currentX, currentY, dist) = queue.removeFirst()
        if (currentX == row - 1 && currentY == cols - 1) {
            println(dist)
            return
        }

        for ((dx, dy) in dirs) {
            val nextX = currentX + dx
            val nextY = currentY + dy

            if (nextX in 0 until board.size && nextY in 0 until board[0].size && board[nextX][nextY] == 1) {
                queue.add(Triple(nextX, nextY, dist + 1))
                board[nextX][nextY] = 0
            }
        }
    }
}