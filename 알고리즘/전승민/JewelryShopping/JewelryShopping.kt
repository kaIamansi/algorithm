fun jewelryShopping(gems: Array<String>): IntArray {
    var (start, to) = 0 to 0
    val hashMap = HashMap<String, Int>()
    val lengthArray = IntArray(gems.size){987654321}

    gems.forEachIndexed { index, it ->
        if(!hashMap.containsKey(it)) {
            to = index
            hashMap[it] = 0
        }
    } // 처음으로 모든 보석을 담는 위치를 to에 저장, hashMap에 보석의 종류 등록
    (0 until to).forEach {
        hashMap[gems[it]] = (hashMap[gems[it]] ?: 0) + 1
    } // 해당 구간에서 보석의 개수 저장

    for(i in to until gems.size) {
        hashMap[gems[i]] = hashMap[gems[i]]!! + 1
        while(hashMap[gems[start]] ?: 0 > 1 && start < i) {
            hashMap[gems[start]] = hashMap[gems[start]]!! - 1
            start++
        } // 구간 시작 부분을 가능한 뒤로 미룸(모든 보석이 최소한 하나씩은 존재.)
        lengthArray[i] = i - start
    } // 구간 끝 부분을 하나씩 뒤로 미룸.(각 위치에서 조건을 만족하는 길이를 저장해둠.)

    var min = 0
    for(i in gems.indices) {
        if(lengthArray[min]>lengthArray[i]) min = i
    } // 구간의 길이가 가장 짧은 곳을 찾음.
    return intArrayOf(min-lengthArray[min]+1, min+1)
} // https://programmers.co.kr/learn/courses/30/lessons/67258?language=kotlin