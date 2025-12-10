import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val nodeCount = nextInt()
    val edgeCase = nextInt()
    val start = nextInt()

    val visitedDfs = BooleanArray(nodeCount+1)
    val visitedBfs = BooleanArray(nodeCount+1)

    val graph = List(nodeCount+1) { mutableListOf<Int>() }

    repeat(edgeCase) {
        val a = nextInt()
        val b = nextInt()
        graph[a].add(b)
        graph[b].add(a)
    }

    graph.forEach { it.sort() }

    fun dfs(node: Int){
        visitedDfs[node] = true
        print("$node ")

        for(nextNode in graph[node]){
            if(!visitedDfs[nextNode]){
                dfs(nextNode)
            }
        }
    }

    dfs(start)
    println()

    val queue = ArrayDeque<Int>()
    queue.add(start)
    visitedBfs[start] = true

    while (queue.isNotEmpty()){
        val nowNode = queue.removeFirst()
        print("$nowNode ")

        for(nextNode in graph[nowNode]){
            if(!visitedBfs[nextNode]){
                queue.add(nextNode)
                visitedBfs[nextNode] = true
            }
        }
    }
}
