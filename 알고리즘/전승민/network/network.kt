lateinit var parent: IntArray
lateinit var rank: IntArray

fun network(n: Int, computers: Array<IntArray>): Int {
    parent = IntArray(n)
    rank = IntArray(n) { 0 }
    for (i in 0 until n) {
        parent[i] = i
    }
    computers.forEachIndexed { i, ints ->
        for(j in i+1 until n) {
            if(computers[i][j]==1) {
                union(i,j)
            }
        }
    }
    return parent.map {
        find(it)
    }.toHashSet().size
}

fun find(value: Int): Int {
    if (parent[value] == value) return value
    else parent[value] = find(parent[value])
    return parent[value]
}

fun union(x: Int, y: Int) {
    val x = find(x)
    val y = find(y)
    if (x == y) return
    if (rank[x] > rank[y]) parent[y] = x else parent[x] = y
    if (rank[x] == rank[y]) rank[y]++
}

fun solution(arr: IntArray): Int {
    var answer = 0

    return answer
}