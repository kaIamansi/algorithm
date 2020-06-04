fun main() {
    val string = "hit"
    val arr = arrayOf("hot", "dot", "dog", "lot", "log", "cog")
    val target = "cog"
    println(solution(string, target, arr))
}

val infinity = 987654321

fun solution(begin: String, target: String, words: Array<String>): Int {
    val length = words.size
    val result = dps(begin, target, Array(length) { false }, words)
    return if(result==infinity) 0 else result
}

fun dps(cur: String, target: String, visit: Array<Boolean>, words: Array<String>): Int {
    if (cur == target) {
        return 0
    }
    var min = infinity
    words.indices.forEach {
        if (!visit[it]) {
            visit[it] = true
            if (cur.isOneLetterDiff(words[it])) {
                val value = dps(words[it], target, visit, words) + 1
                if (min > value) min = value
            }
            visit[it] = false
        }
    }
    return min
}

fun String.isOneLetterDiff(other: String): Boolean {
    val length = this.length
    var count = 0
    this.indices.forEach {
        if (this[it] == other[it]) count++
    }
    return length - 1 == count
}

val String.indices
    get() = IntRange(0, this.length - 1)

val <T> Array<T>.indices
    get() = IntRange(0, this.size - 1)