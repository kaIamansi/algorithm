import java.util.*

fun main() {
    val genres = arrayOf("classic", "pop", "classic", "classic", "pop")
    val plays = intArrayOf(1500, 200, 150, 800, 2200)
    solution(genres, plays).forEach {
        println(it)
    }
}

fun solution(genres: Array<String>, plays: IntArray): IntArray {
    val genreMap = HashMap<String, Pair<Int, TreeSet<Pair<Int, Int>>>>()
    val sorting: (Pair<Int, Int>, Pair<Int, Int>) -> Int = { a, b ->
        if (a.first.compareTo(b.first) == 0) b.second.compareTo(a.second) else a.first.compareTo(b.first)
    }

    for (i in plays.indices) {
        if (genreMap.containsKey(genres[i])) { // 장르정보가 이미 있는경우에 실행
            val pair = genreMap[genres[i]]!!
            val set = pair.second
            set.add(plays[i] to i)
            genreMap[genres[i]] = pair.copy(first = pair.first + plays[i], second = set)
            // 장르 총 재생횟수 증가, 해당 노래의 인덱스와 재생횟수 저장
        } else { // 해당 장르 데이터가 없을 경우 실행
            val set = TreeSet<Pair<Int, Int>>(sorting)
            set.add(plays[i] to i)
            genreMap[genres[i]] = plays[i] to set
            // 장르 정보 생성, 해당 노래의 인덱스와 재생횟수 저장
        }
    }

    val array = arrayListOf<Int>()
    genreMap.values.sortedBy {
        it.first
    }.asReversed().forEach {
        /*if(it.second.size==1) array.add(it.second.pollLast()!!.second)
        while(it.second.size>1) {
            array.add(it.second.pollLast()!!.second)
            array.add(it.second.pollLast()!!.second)
        }*/
        it.second.pollLast()?.apply {
            array.add(this.second)
        }
        it.second.pollLast()?.apply {
            array.add(this.second)
        }
    }

    return array.toIntArray()
}