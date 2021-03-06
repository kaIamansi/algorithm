import java.util.*

fun islandConnection(n: Int, costs: Array<IntArray>): Int {
    var size = 0
    val visit = Array<Int?>(n) { null }
    val priorityQueue = PriorityQueue<IntArray>(compare)
    costs.forEach {
        priorityQueue.add(it)
    }
    while(size < n) {
        val value = priorityQueue.poll()
        if(visit[value[0]]==null) size++
        if(visit[value[1]]==null) size++
        visit[value[1]] = value[2]
    }
    return visit.sumBy { it ?: 0 }
}

val compare = { a : IntArray, b : IntArray ->
    if(a[2].compareTo(b[2])==0) {
        if(a[0].compareTo(b[0])==0) {
            a[1].compareTo(b[1])
        } else {
            a[0].compareTo(b[1])
        }
    } else {
        a[2].compareTo(b[2])
    }
}