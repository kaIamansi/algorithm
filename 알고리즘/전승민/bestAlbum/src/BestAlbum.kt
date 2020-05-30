import java.util.*

fun solution(genres: Array<String>, plays: IntArray): IntArray
    = getResult(getInputData(genres, plays))

fun getInputData(genres: Array<String>, plays: IntArray) : HashMap<String, Pair<Int, TreeSet<Pair<Int, Int>>>> {
    val genreMap = HashMap<String, Pair<Int, TreeSet<Pair<Int, Int>>>>()
    val sorting: (Pair<Int, Int>, Pair<Int, Int>) -> Int = { a, b ->
        if (a.first.compareTo(b.first) == 0) b.second.compareTo(a.second) else a.first.compareTo(b.first)
    }

    for (i in plays.indices) {
        genreMap[genres[i]] = if (genreMap.containsKey(genres[i])) { // 장르정보가 이미 있는경우 장르 총 재생 수 저장
            genreMap[genres[i]]!!.first + plays[i] to genreMap[genres[i]]!!.second
        } else { // 해당 장르 데이터가 없을 경우 장르 총 재생 수 저장, TreeSet 초기화
            plays[i] to TreeSet(sorting)
        }.apply {// 노래의 재생 수, 인덱스 저장
            this.second.add(plays[i] to i)
        }
    }

    return genreMap
}

fun getResult(genreMap : HashMap<String, Pair<Int, TreeSet<Pair<Int, Int>>>>) : IntArray {
    val array = arrayListOf<Int>()
    genreMap.values.sortedBy {// 장르별 재생횟수 총합을 기준으로 정렬
        it.first
    }.asReversed().forEach {
        it.second.pollLast()?.apply {
            array.add(this.second)
        }
        it.second.pollLast()?.apply {
            array.add(this.second)
        } // 값 존재 여부 확인 후 배열에 추가.
    }
    return array.toIntArray()
}