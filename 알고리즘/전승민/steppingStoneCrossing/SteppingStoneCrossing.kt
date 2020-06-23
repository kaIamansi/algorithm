fun steppingStoneCrossing(stones: IntArray, k: Int): Int {
    var (answer, index) = Pair(987654321, -1)
    while (index < stones.size - k) {
        index = (index + 1..index + k).maxBy { stones[it] }!!
        if (answer > stones[index]) answer = stones[index]
    }
    return answer
}
// https://programmers.co.kr/learn/courses/30/lessons/64062

fun steppingStoneCrossingBinarySearch(stones: IntArray, k: Int): Int {
    return binarySearch(stones, k, 1, 200000000) - 1
}

fun binarySearch(stones: IntArray, k: Int, left: Int, right: Int): Int {
    val mid = (left + right) / 2
    val result = isPossible(stones, k, mid)
    if (left >= right) return left
    else if (result) return binarySearch(stones, k, mid + 1, right)
    else return binarySearch(stones, k, left, mid)
}

fun isPossible(stones: IntArray, k: Int, count: Int): Boolean {
    var index = -1
    while (index < stones.size - k) {
        val temp = index
        (index + 1..index + k).forEach { if (stones[it] >= count) index = it }
        if (index == temp) return false
    }
    return true
}