import kotlin.math.pow

fun origami(n: Int): IntArray =
        (2.toDouble().pow(n.toDouble()) - 1).toInt().let {
            IntArray(it).apply {
                putData(0, it - 1)
            }
        }

fun IntArray.putData(left: Int, right: Int) {
    if (left == right) return
    val mid = left getMidWith right
    this[left getMidWith mid - 1] = 0
    this[mid + 1 getMidWith right] = 1
    putData(left, mid - 1)
    putData(mid + 1, right)
}

// https://programmers.co.kr/learn/courses/30/lessons/62049