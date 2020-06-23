fun workoutClothes(n: Int, lost: IntArray, reserve: IntArray): Int {
    val clothesArr = IntArray(n) {1}
    lost.forEach {
        clothesArr[it-1]--
    }
    reserve.forEach {
        clothesArr[it-1]++
    }
    clothesArr.forEachIndexed { index, i ->
        if(i==0) {
            if(index!=0 && clothesArr[index-1]==2) {
                clothesArr[index-1]--
                clothesArr[index]++
            } else if(index!=clothesArr.size-1 && clothesArr[index+1]==2) {
                clothesArr[index+1]--
                clothesArr[index]++
            }
        }
    }
    return clothesArr.filter { it > 0 }.size
} // https://programmers.co.kr/learn/courses/30/lessons/42862