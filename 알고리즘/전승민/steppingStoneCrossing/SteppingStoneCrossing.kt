fun solution(stones: IntArray, k: Int): Int {
    var answer = 987654321
    var index = -1
    while (index < stones.size) {
        var max = index + 1
        for (i in index + 2..index + k) {
            if (i >= stones.size) break
            if (stones[max] < stones[i]) max = i
        }
        if (stones.size - k <= index) break
        index = max
        if (answer > stones[index]) answer = stones[index]
    }
    return answer
}