import kotlin.math.pow

fun solution(n: Int): IntArray =
        (2.toDouble().pow(n.toDouble()) - 1).toInt().let {
            IntArray(it).apply {
                putData(0, it - 1)
            }
        }

fun IntArray.putData(left: Int, right: Int) {
    if (left == right) return
    val mid = left getMid right
    this[left getMid mid - 1] = 0
    this[mid + 1 getMid right] = 1
    putData(left, mid - 1)
    putData(mid + 1, right)
}

infix fun Int.getMid(b: Int) = (this + b) / 2

// https://programmers.co.kr/learn/courses/30/lessons/62049