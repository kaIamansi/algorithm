import java.util.*

val sorting: (Pair<Int, Int>, Pair<Int, Int>) -> Int = { a, b ->
    if (a.first.compareTo(b.first) == 0) b.second.compareTo(a.second) else a.first.compareTo(b.first)
}

fun bestAlbum(genres: Array<String>, plays: IntArray): IntArray = getResult(getInputData(genres, plays))

fun getInputData(genres: Array<String>, plays: IntArray): Map<String, Pair<Int, TreeSet<Pair<Int, Int>>>> {
    val genreMap = HashMap<String, Pair<Int, TreeSet<Pair<Int, Int>>>>()

    plays.indices.forEach {
        genreMap[genres[it]] = calculateTotalPlayCount(genreMap[genres[it]], plays[it]).apply { playCountIntoGenre(plays[it], it) }
    }

    return genreMap
}

fun getResult(genreMap: Map<String, Pair<Int, TreeSet<Pair<Int, Int>>>>): IntArray {
    val array = arrayListOf<Int>()

    genreMap.values.sortedBy {
        it.playCount.nagative
    }.forEach {
        it.treeSet addLastInto array
        it.treeSet addLastInto array
    }

    return array.toIntArray()
}

fun calculateTotalPlayCount(genrePair: Pair<Int, TreeSet<Pair<Int, Int>>>?, playCount: Int): Pair<Int, TreeSet<Pair<Int, Int>>>
    = if (genrePair!=null) {
        genrePair.totalPlayCount + playCount to genrePair.treeSet
    } else {
        playCount to TreeSet(sorting)
    }


val Pair<Int, TreeSet<Pair<Int, Int>>>.totalPlayCount : Int
    get() = this.first

val Pair<Int, TreeSet<Pair<Int, Int>>>.treeSet : TreeSet<Pair<Int, Int>>
    get() = this.second

val Pair<Int, TreeSet<Pair<Int, Int>>>.playCount : Int
    get() = this.first

fun Pair<Int, TreeSet<Pair<Int, Int>>>.playCountIntoGenre(playCount: Int, index: Int) = this.second.add(playCount to index)

infix fun TreeSet<Pair<Int, Int>>.addLastInto(array : ArrayList<Int>) = array.addNullableInt(this.pollLast()?.second)

// https://programmers.co.kr/learn/courses/30/lessons/42579