import java.util.*

fun main() {
    println(solution(intArrayOf(1,9,9), 0))
}

fun solution(priorities: IntArray, location: Int): Int {
    val queue = Array<Queue<Int>>(9) { LinkedList<Int>() }
    priorities.forEachIndexed {index: Int, it: Int ->
        queue[it-1].offer(index)
    }
    var index = 0
    val array = ArrayList<Int>()
    queue.indices.forEach {
        while(queue[8-it].size>0) {
            val value = queue[8-it].poll()
            if(index <= value) {
                array.add(value)
                index = value
            } else {
                queue[8-it].offer(value)
            }
            if(value > queue[8-it].peek() ?: infinity) index = 0
            if(queue[8-it].size==1) index = 0
        }
    }
    return array.indexOf(location) + 1
} // https://programmers.co.kr/learn/courses/30/lessons/42587