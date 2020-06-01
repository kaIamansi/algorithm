import java.util.*

val sorting: (Pair<Int, Int>, Pair<Int, Int>) -> Int = { a, b ->
    if (a.first.compareTo(b.first) == 0) b.second.compareTo(a.second) else a.first.compareTo(b.first)
}

fun solution(genres: Array<String>, plays: IntArray): IntArray = getResult(getInputData(genres, plays))

fun getInputData(genres: Array<String>, plays: IntArray): Map<String, Pair<Int, TreeSet<Pair<Int, Int>>>> {
    val genreMap = HashMap<String, Pair<Int, TreeSet<Pair<Int, Int>>>>()

    for (i in plays.indices) {
        genreMap[genres[i]] = calculateTotalPlayCount(genreMap, genres[i], plays[i]).apply { playCountIntoGenre(plays[i], i) }
    }

    return genreMap
}

fun getResult(genreMap: Map<String, Pair<Int, TreeSet<Pair<Int, Int>>>>): IntArray {
    val array = arrayListOf<Int>()

    genreMap.values.sortedBy {
        it.first.toNagative()
    }.forEach {
        it.second addLastInto array
        it.second addLastInto array
    }

    return array.toIntArray()
}

fun calculateTotalPlayCount(genreMap: HashMap<String, Pair<Int, TreeSet<Pair<Int, Int>>>>, genre: String, playCount: Int): Pair<Int, TreeSet<Pair<Int, Int>>>
    = if (genreMap.containsKey(genre)) {
        genreMap[genre]!!.first + playCount to genreMap[genre]!!.second
    } else {
        playCount to TreeSet(sorting)
    }


fun Pair<Int, TreeSet<Pair<Int, Int>>>.playCountIntoGenre(playCount: Int, index: Int) = this.second.add(playCount to index)

fun Int.toNagative() = this * -1

infix fun TreeSet<Pair<Int, Int>>.addLastInto(array : ArrayList<Int>) = array.addNullableInt(this.pollLast()?.second)

fun ArrayList<Int>.addNullableInt(number : Int?) = if(number!=null) this.add(number) else false

// https://programmers.co.kr/learn/courses/30/lessons/42579