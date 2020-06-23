fun steppingStoneCrossing(stones: IntArray, k: Int): Int {
    var answer = 987654321
    var index = -1
    while (index < stones.size - k) {
        index = (index+1..index+k).maxBy { stones[it] } ?: -1
        if(answer > stones[index]) answer = stones[index]
    }
    return answer
}
// https://programmers.co.kr/learn/courses/30/lessons/64062

/*
fun solution(stones: IntArray, k: Int): Int {
    var answer = infinity
    var index = -1
    while (index < stones.size-k) {
        var max = index + 1
        for (i in index + 2..index + k) {
            if (stones[max] <= stones[i]) max = i
        }
        index = max
        if(answer > stones[index]) answer = stones[index]
    }
    return answer
}
 */