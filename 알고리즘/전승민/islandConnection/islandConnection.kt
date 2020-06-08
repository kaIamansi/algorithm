import java.util.*

fun main() {
    val n = 4
    val costs = arrayOf(intArrayOf(0,1,1), intArrayOf(0,2,2), intArrayOf(1,2,5), intArrayOf(1,3,1), intArrayOf(2,3,8))
    println(solution(n, costs))
}

fun solution(n: Int, costs: Array<IntArray>): Int {
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