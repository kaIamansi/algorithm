import java.util.*

val Pair<Int,Int>.time get() = this.first
val Pair<Int,Int>.index get() = this.second

val sortByTime = {i1 : Pair<Int,Int>, i2 : Pair<Int,Int> -> i1.time.compareTo(i2.time)}
val sortByIndex = {i1 : Pair<Int,Int>, i2 : Pair<Int,Int> -> i1.index.compareTo(i2.index)}

fun liveEatingBroadcast(food_times: IntArray, k: Long): Int {
    var tempTime = 0
    var totalTime = k
    var result : Pair<Int, Int> = 0 to 0

    val timeSortQueue = PriorityQueue<Pair<Int, Int>>(sortByTime).addAllWithIndex(food_times)

    while(timeSortQueue.isNotEmpty() && totalTime>=timeSortQueue.sumByMinTime(tempTime)) {
        totalTime -= timeSortQueue.sumByMinTime(tempTime)
        tempTime = timeSortQueue.peek().time
        while(timeSortQueue.isNotEmpty() && tempTime>=timeSortQueue.peek().time) timeSortQueue.poll()
    }

    if(timeSortQueue.isEmpty()) return -1

    val sortByIndexQueue = PriorityQueue<Pair<Int,Int>>(sortByIndex).addAllAndReturn(timeSortQueue)
    val remainTime = totalTime % sortByIndexQueue.size.toLong()

    for(i in 0 .. remainTime) { result = sortByIndexQueue.poll() }

    return result.index
}

fun PriorityQueue<Pair<Int,Int>>.addAllWithIndex(list : IntArray) : PriorityQueue<Pair<Int,Int>> {
    list.forEachIndexed { index, i ->
        this.add(i to index)
    }
    return this
}

fun PriorityQueue<Pair<Int,Int>>.sumByMinTime(currentTime : Int) : Long = (this.peek().index-currentTime).toLong() * this.size.toLong()

fun <T>PriorityQueue<T>.addAllAndReturn(list : Collection<T>) : PriorityQueue<T> {
    this.addAll(list)
    return this
}

//https://programmers.co.kr/learn/courses/30/lessons/42891?language=kotlin