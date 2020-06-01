import java.util.*

fun main() {
    val board = arrayOf(intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 1, 0, 3), intArrayOf(0, 2, 5, 0, 1), intArrayOf(4, 2, 4, 4, 2), intArrayOf(3, 5, 1, 3, 1))
    val moves = intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
    println(solution(board, moves))
}

fun solution(board: Array<IntArray>, moves: IntArray): Int {
    val length = board.size
    val stack : Stack<Int> = Stack()
    var result = 0

    val topIndexArray = buildTopIndexArray(length).apply {
        for (i in 0 until length) {
            this[i] = getTopIndex(board, i, 0, length - 1)
        }
    }

    moves.map { it - 1 }.forEach {
        if(topIndexArray[it] < length) {
            val value = board[topIndexArray[it]][it]
            board[topIndexArray[it]][it] = 0
            topIndexArray[it]++
            if (stack.peek == value) {
                result += 2
                stack.pop()
            } else {
                stack.push(value)
            }
        }
    }
    return result
}

fun buildTopIndexArray(size: Int) = IntArray(size) { size - 1 }

fun getTopIndex(board: Array<IntArray>, index: Int, left: Int, right: Int): Int {
    val mid = (left + right) / 2
    return if (board[mid][index] > 0) {
        if (mid == 0 || board[mid - 1][index] == 0) mid
        else getTopIndex(board, index, left, mid)
    } else {
        if (left == right) -1
        else getTopIndex(board, index, mid + 1, right)
    }
}

val Stack<Int>.peek : Int
    get() = if(this.size==0) -1 else this.peek()