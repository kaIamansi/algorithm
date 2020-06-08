import java.util.*

fun main(args: Array<String>) {
    println(
            Solution().solution(intArrayOf(2, 1, 3, 2), 2)
    )
}

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 1

        val priority = PriorityQueue(Collections.reverseOrder<Any>())

        for (task in priorities) {
            priority.add(task)
            println(priority)
        }

        while (!priority.isEmpty()) {
            for (i in priorities.indices) {
                if (priorities[i] == priority.peek() as Int) {
                    if (i == location) return answer
                    priority.poll()
                    answer++
                }
            }
        }

        return answer
    }
}
