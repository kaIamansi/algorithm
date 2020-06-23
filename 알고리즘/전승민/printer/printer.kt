import java.util.*

fun printer(priorities: IntArray, location: Int): Int {
    val queue = Array<Queue<Int>>(9) { LinkedList<Int>() }
    priorities.forEachIndexed {index: Int, it: Int ->
        queue[it-1].offer(index)
    }
    var index = 0
    val array = ArrayList<Int>()
    queue.reversedArray().forEach {
        val tempQueue = LinkedList<Int>()
        while(it.size>0) {
            val value = it.poll()
            if(index <= value) {
                array.add(value)
                index = value
            } else {
                tempQueue.offer(value)
            }
            if(value > it.peek() ?: infinity) index = 0
        }
        while(tempQueue.size > 0) {
            val value = tempQueue.poll()
            array.add(value)
            index = value
        }
    }
    return array.indexOf(location) + 1
} // https://programmers.co.kr/learn/courses/30/lessons/42587
