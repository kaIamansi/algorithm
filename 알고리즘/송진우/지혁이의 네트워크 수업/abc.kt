class Solution {
    fun solution(개수: Int, 콤퓨타: Array<IntArray>): Int {
        var 정답 = 0
        val 넽웤 = Array(개수) { BooleanArray(개수) }

        넽웤.forEach { it.forEach { print("$it ") } }

        println()

        for (아이 in 0 until 개수) {
            if (!넽웤[아이][아이]) {
                정답++
                깊이우선탐색(콤퓨타, 넽웤, 아이, 개수)
            }
        }

        넽웤.forEach { it.forEach { print("$it ") } }

        println()

        return 정답
    }

    fun 깊이우선탐색 (콤퓨타: Array<IntArray>, 넽웤: Array<BooleanArray>, 인덱스: Int, 개수: Int) {
        for (아이 in 0 until 개수) {
            if (콤퓨타[인덱스][아이] == 1 && !넽웤[인덱스][아이]) {
                넽웤[아이][인덱스] = true
                넽웤[인덱스][아이] = true
                깊이우선탐색(콤퓨타, 넽웤, 아이, 개수)
            }
        }
    }
}

fun main(args: Array<String>) {
    Solution().solution(3, arrayOf(
            intArrayOf(
                    1, 1, 0
            ),
            intArrayOf(
                    1, 1, 0
            ),
            intArrayOf(
                    0, 0, 1
            )
    ))
}