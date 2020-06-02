import java.util.*

fun solution(board: Array<IntArray>, moves: IntArray): Int {
    val length = board.size
    val stack: Stack<Int> = Stack()
    var result = 0

    val topIndexArray = buildTopIndexArray(length).getTopIndexArray(board, length)

    moves.map { it - 1 }.forEach {
        result += board.pull(topIndexArray, length, it).getPointOrPush(stack)
    }
    return result
}

// 배열 초기화 함수 (가장 높이 있는 인형의 위치를 담을 배열)
fun buildTopIndexArray(size: Int) = IntArray(size) { size - 1 }

// board의 각 열에 가장 높이 있는 인형을 찾기 위한 함수.
fun IntArray.getTopIndexArray(board: Array<IntArray>, length: Int) = this.apply {
    this.indices.forEach {
        this[it] = getTopIndex(board, it, 0, length - 1)
    }
}

// board의 각 열에서 가장 높은 인형의 위치를 찾기 위한 이진 탐색 재귀함수.
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

// board에서 인형을 뺀 후 인형의 종류를 반환하는 함수
fun Array<IntArray>.pull(topIndexArray: IntArray, length: Int, move: Int): Int {
    if (topIndexArray[move] >= length) return 0
    val value = this[topIndexArray[move]][move]
    topIndexArray[move]++
    return value
}

// 인형을 뺀 후, 점수를 올릴지 혹은 스택에 값을 넣을지를 결정하는 함수.
fun Int.getPointOrPush(stack: Stack<Int>): Int =
        if (stack.peek == this) { // 스택의 최상위의 인형과 방금 뽑은 인형이 같으면 스택에서 pop연산을 한 후, 2점을 추가함.
            stack.pop()
            2
        } else { // 스택의 최상위의 인형과 다른 경우, 스택에 push함. (인형이 뽑히지 않았을 경우, 아무런 작업을 하지 않음.)
            stack.pushIfNotNagative(this)
            0
        }

// 인형의 종류가 -1이 아닐 경우에 stack에 push함.
fun Stack<Int>.pushIfNotNagative(value: Int): Int = if (value > 0) this.push(value) else 0

// 스택에서 pop연산을 함. 비었을 경우 -1 반환.
val Stack<Int>.peek: Int
    get() = if (this.size == 0) -1 else this.peek()

//https://programmers.co.kr/learn/courses/30/lessons/64061