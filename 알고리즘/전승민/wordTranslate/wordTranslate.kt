import kotlin.math.min

fun wordTranslate(begin: String, target: String, words: Array<String>): Int
    = dps(begin, target, Array(words.size) { false }, words).let {
        if(it==infinity) 0 else it
    }

fun dps(cur: String, target: String, visit: Array<Boolean>, words: Array<String>): Int {
    if (cur == target) {
        return 0
    }
    var minimum = infinity
    words.indices.forEach {
        if (!visit[it]) {
            visit[it] = true
            minimum = if (cur.isOneLetterDiff(words[it])) min(dps(words[it], target, visit, words) + 1, minimum) else minimum
            visit[it] = false
        }
    }
    return minimum
}

fun String.isOneLetterDiff(other: String): Boolean {
    var count = 0
    this.indices.forEach {
        if (this[it] == other[it]) count++
    }
    return this.length - 1 == count
}
// https://programmers.co.kr/learn/courses/30/lessons/43163