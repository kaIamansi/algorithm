class Solution {
    fun solution(n: Int): IntArray {
        val answer = arrayListOf<Int>()

        for (i in 0 until n) {
            answer.map {
                if (it == 0) 1
                else 0
            }.reversed().let {
                answer.add(0)
                answer.addAll(it)
            }
        }

        return answer.toIntArray()
    }

}


fun main(args: Array<String>) {
    print(Solution().solution(3).toList())
}