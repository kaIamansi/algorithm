
fun solution(n: Int): IntArray {
    val size = (Math.pow(2.toDouble(), n.toDouble())-1).toInt()
    val answer = IntArray(size)
    putData(answer, 0, size-1)
    return answer
}

fun putData(array : IntArray, left : Int, right : Int ) {
    if(left==right) return
    val mid = (left + right) / 2
    val leftMid = (left + mid-1) / 2
    val rightMid = (right + mid+1) / 2
    array[leftMid] = 0
    array[rightMid] = 1
    putData(array, left, mid-1)
    putData(array, mid+1, right)
}

// [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5]