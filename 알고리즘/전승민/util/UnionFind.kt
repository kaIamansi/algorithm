class UnionFind<T>(val n : Int) {
    val parent : IntArray by lazy { IntArray(n){it} }
    val rank: IntArray by lazy { IntArray(n){it} }

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
}