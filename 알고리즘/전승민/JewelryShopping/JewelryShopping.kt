fun jewelryShopping(gems: Array<String>): IntArray {
    var (start, to) = 0 to 0
    val hashMap = HashMap<String, Int>()
    val lengthArray = IntArray(gems.size){987654321}
    gems.forEachIndexed { index, it ->
        if(!hashMap.containsKey(it)) { to = index }
        hashMap[it] = 0
    }
    (0..to).forEach {
        hashMap[gems[it]] = (hashMap[gems[it]] ?: 0) + 1
    }
    while(hashMap[gems[start]] ?: 0 > 1 && start < to) {
        hashMap[gems[start]] = hashMap[gems[start]]!! - 1
        start++
    }
    lengthArray[to] = to - start
    for(i in to+1 until gems.size) {
        hashMap[gems[i]] = hashMap[gems[i]]!! + 1
        while(hashMap[gems[start]] ?: 0 > 1) {
            hashMap[gems[start]] = hashMap[gems[start]]!! - 1
            start++
        }
        lengthArray[i] = i - start
    }
    var min = 0
    for(i in gems.indices) {
        if(lengthArray[min]>lengthArray[i]) min = i
    }
    return intArrayOf(min-lengthArray[min]+1, min+1)
}