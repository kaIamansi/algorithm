## algorithm workspace

#2020/07/21
[소스코드(Kotlin)](./JewelryShopping/JewelryShopping.kt)
+ 모든 보석의 종류를 진열할 수 있는 최소 길이의 구간의 위치를 구하기.
```kotlin
fun jewelryShopping(gems: Array<String>): IntArray {
    var (start, end) = 0 to 0
    val hashMap = HashMap<String, Int>()
    val lengthArray = IntArray(gems.size) { 987654321 }

    gems.forEachIndexed { index, it ->
        if(!hashMap.containsKey(it)) {
            end = index
            hashMap[it] = 0
        }
    } // 처음으로 모든 보석을 담는 위치를 to에 저장, hashMap에 보석의 종류 등록
    (0 until end).forEach {
        hashMap[gems[it]] = hashMap[gems[it]]!! + 1
    } // 해당 구간에서 보석의 개수 저장

    for(i in end until gems.size) {
        hashMap[gems[i]] = hashMap[gems[i]]!! + 1
        while(hashMap[gems[start]]!! > 1) {
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
}
```
+ 풀이
1. 처음부터 모든 보석이 진열되는 구간을 찾으며 보석의 종류를 등록하고, 개수를 저장함.
2. 구간의 시작 부분을 가능한 당긴다. (모든 보석이 진열되어있는지는 map을 통해 확인.)
3. 구간의 끝 부분을 하나씩 미룬다.
4. 2~3을 반복하며 구간의 길이를 저장한다.
5. 구간의 길이가 가장 짧은 곳의 위치를 반환한다.

## 시간복잡도 O(n)

#2020/07/20
[소스코드(Java)](./numberOf124Country/NumberOf124Country.java)
+ 1,2,4만의 숫자로 입력된 숫자 표현하기
```java
public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        String[] arr = new String[]{"4","1","2"};
        while (n>0) {
            String str;
            str = arr[n % 3];
            if (n % 3 == 0) { n--; }
            n /= 3;
            answer.insert(0, str);
        }
        return answer.toString();
    }
```
+ 풀이
1. 3으로 나눈 나머지 값을 통해 자리수마다의 숫자를 구함.
2. 나머지가 0인 경우, 그 다음 자리수의 값을 낮추기 위해 1을 뺌.

#2020/07/17
[소스코드(Kotlin)](./LiveEatingBroadcast/LiveEatingBroadcast.kt)
+ 라운드 로빈에서, K초 뒤 실행중인 것 반환.
```kotlin
fun liveEatingBroadcast(food_times: IntArray, k: Long): Int {
    var tempTime = 0
    var totalTime = k
    var result : Pair<Int, Int> = 0 to 0

    val sortByTimePriorityQueue = PriorityQueue<Pair<Int, Int>>(sortByTime).addAllWithIndex(food_times)

    while(sortByTimePriorityQueue.isNotEmpty() && totalTime>=sortByTimePriorityQueue.sumByMinTime(tempTime)) {
        totalTime -= sortByTimePriorityQueue.sumByMinTime(tempTime)
        tempTime = sortByTimePriorityQueue.peek().time
        
        while(sortByTimePriorityQueue.isNotEmpty() && tempTime>=sortByTimePriorityQueue.peek().time) sortByTimePriorityQueue.poll()
    }

    if(sortByTimePriorityQueue.isEmpty()) return -1

    val sortByIndexQueue = PriorityQueue<Pair<Int,Int>>(sortByIndex).addAllAndReturn(sortByTimePriorityQueue)
    val remainTime = totalTime % sortByIndexQueue.size

    for(i in 0..remainTime) { result = sortByIndexQueue.poll() }

    return result.index
}
```
+ 풀이
1. time 순으로 오름차순 정렬.
2. 가장 적은 시간 * 개수를 k에서 소요시킴. (다 사용한 음식은 제외시킴.)
3. 2번 반복. k > 가장 적은 시간 * 개수일 동안
4. 남은 k의 시간을 제외시킨 후의 요소의 개수로 나눈 나머지를 구함.
5. 제외시킨 후의 요소를 인덱스값을 기준으로 정렬.
6. 4번의 값을 인덱스로, 값을 구한 후 1을 더해 반환.

# 2020/07/02
[소스코드(Java)](./phoneketmon/phoneketmon.java)
+ 가져갈 수 있는 포켓몬 종류 반환하기
```java
public int solution(int[] nums) {
    int answer = 0;
    Set<Integer> set = new HashSet();
    for(int i : nums) {
        set.add(i);
    }
    if(nums.length/2>set.size()) {
        answer = set.size();
    } else {
        answer = nums.length/2;
    }
    return answer;
}
```

# 2020/07/02
[소스코드(Kotlin)](./numberBaseball/numberBaseball.kt)
+ 숫자야구에서 답이 될 수 있는 경우의 수 구하기
```kotlin
fun numberBaseball(baseball: Array<IntArray>): Int {
    var answer = 0
    (123..987).forEach { number ->
        val str = number.toString()
        if(str[0]==str[1]||str[1]==str[2]||str[0]==str[2]||str[0]=='0'||str[1]=='0'||str[2]=='0') return@forEach
        var check = true
        baseball.forEach {
            var strike = 0
            var ball = 0
            (0..2).forEach {i ->
                (0..2).forEach {j ->
                    if(str[i]==it[0].toString()[j]) {
                        if(i==j) strike++
                        else ball++
                    }
                }
            }
            if(strike!=it[1]||ball!=it[2]) check = false
        }
        if(check) answer++
    }
    return answer
}
```
+ 풀이
1. 123~987를 돌면서 주어진 배열의 조건을 모두 만족하는 값이 있을 때마다 답을 추가함.

# 2020/07/02
[소스코드(Java)](./EnglishWordChaining/EnglishWordChaining.java)
+ 끝말잇기에서 탈락한 사람, 번째 수 구하기
```java
int[] solution(int n, String[] words) {
    int[] answer = {0,0};
    Set<String> hashSet = new HashSet<String>();
        
    hashSet.add(words[0]);
    for(int i=1; i<words.length; i++) {
        hashSet.add(words[i]);
        if(hashSet.size()!=i+1 || firstIndex(words[i])!=lastIndex(words[i-1])) {
            answer[0] = i%n+1;
            answer[1] = i/n+1;
        }
    }
    return answer;
}
```

# 2020/06/25
[소스코드(Kotlin)](./steppingStoneCrossing/SteppingStoneCrossing.kt)
+ 징검다리를 건널 수 있는 최대 인원을 구하는 문제.
```kotlin
fun solution(stones: IntArray, k: Int): Int {
    var (answer, index) = Pair(987654321, -1)
        while (index < stones.size - k) {
            index = (index + 1..index + k).maxBy { stones[it] }!!
            if (answer > stones[index]) answer = stones[index]
        }
        return answer
}
```
+ 풀이
1. 처음에는 인덱스를 -1로 둠(징검다리를 밟기 전)
2. 캐릭터가 있는 바위 이후의 k개 바위 중 가장 숫자가 큰 바위를 선택함.
(만약, k개의 바위가 있다면, 결국 마지막 캐릭터는 그 중 가장 큰 바위를 밟고 다리를 건너기 때문.)
3. 캐릭터의 위치를 선택한 바위의 인덱스로 바꿈.
4. 캐릭터의 인덱스가 stones-k보다 커질때까지 2, 3번을 반복함. (캐릭터의 인덱스가 stones-k가 되면 바로 다리를 건널 수 있음.)
5. 선택된 바위 중 숫자가 가장 낮은 바위를 선택해 반환함.
## 시간복잡도 O(nk)

## 다른 풀이
```kotlin
fun binarySearch(stones: IntArray, k: Int, left: Int, right: Int): Int {
    val mid = (left + right) / 2
    val result = isPossible(stones, k, mid)
    if (left >= right) return left
    else if (result) return binarySearch(stones, k, mid + 1, right)
    else return binarySearch(stones, k, left, mid)
}

fun isPossible(stones: IntArray, k: Int, count: Int): Boolean {
    var index = -1
    while (index < stones.size - k) {
        val temp = index
        (index + 1..index + k).forEach { if (stones[it] >= count) index = it }
        if (index == temp) return false
    }
    return true
}
```
+ 풀이
1. 바위를 밟을 수 있는 횟수는 1~200000000. 이를 lower bound기법을 응용함.
2. isPossible함수를 호출했을 때, false를 반환하는 첫 값을 찾음.
3. 결과에 1을 뺀 후에 답을 반환함.

## 시간복잡도 O(nlogk) 
+ k: 200000000

# 2020/06/10
[소스코드(Kotlin)](./network/network.kt)
+ 컴퓨터가 서로 연결된 네트워크의 개수를 구하는 문제.
```kotlin
private fun solution(n: Int, computers: Array<IntArray>): Int {
    parent = IntArray(n)
    rank = IntArray(n) { 0 }
    for (i in 0 until n) {
        parent[i] = i
    }
    computers.forEachIndexed { i, ints ->
        for(j in i+1 until n) {
            if(computers[i][j]==1) {
                union(i,j)
            }
        }
    }
    return parent.map {
        find(it)
    }.toHashSet().size
}
```
+ 풀이
1. 연결된 네트워크 정보를 기반으로 유니온 파인드 기법을 활용.
2. 유니온 파인드 기법을 활용해 값이 다른 부모의 개수를 반환.
### 시간복잡도 : O(n^2).
+ 유효한 간선의 개수. O(n^2)
+ union() O(1)
+ find() O(1)
+ map() O(n)
+ toHashSet() O(n)

# 2020/06/09
[소스코드(Kotlin)](./workoutClothes/workoutClothes.kt)
+ 여벌의 체육복을 가져온 친구가 체육복을 잃어버린 친구에게 빌려줬을 때, 체육복을 입을 수 있는 학생 수 반환.(바로 옆자리 친구에게만 빌려줄 수 있음.)
```kotlin
fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
    val clothesArr = IntArray(n) {1}
    lost.forEach {
        clothesArr[it-1]--
    }
    reserve.forEach {
        clothesArr[it-1]++
    }
    clothesArr.forEachIndexed { extend.getIndex, i ->
        if(i==0) {
            if(extend.getIndex!=0 && clothesArr[extend.getIndex-1]==2) {
                clothesArr[extend.getIndex-1]--
                clothesArr[extend.getIndex]++
            } else if(extend.getIndex!=clothesArr.size-1 && clothesArr[extend.getIndex+1]==2) {
                clothesArr[extend.getIndex+1]--
                clothesArr[extend.getIndex]++
            }
        }
    }
    return clothesArr.filter { it > 0 }.size
}
```
+ 풀이
1. 학생 수만큼 배열을 만들어 1로 초기화
2. 잃어버린 친구는 0, 여벌을 가지고 있는 친구는 2로 증가.(여벌을 갖고 있지만 잃어버렸다면 1.)
3. 배열을 탐색하며 체육복을 잃어버린 친구가 있으면 왼쪽, 오른쪽 순서로 여벌 옷이 있는지 탐색.
4. 체육복을 가진 학생 수 반환.

### 시간복잡도 : O(n)
+ lost.forEach : O(n)
+ reserve.forEach : O(n)
+ clothesArr.forEachIndexed : O(n)
+ clothesArr.filter : O(n)

# 2020/06/08
[소스코드(Kotlin)](./printer/printer.kt)
+ 프린터 큐가 들어오는데, 우선순위에 따라 출력했을때, 원하는 출력물이 몇번째로 출력되는지 반환하는 문제.
```kotlin
fun solution(priorities: IntArray, location: Int): Int {
    val queue = Array<Queue<Int>>(9) { LinkedList<Int>() }
    priorities.forEachIndexed {extend.getIndex: Int, it: Int ->
        queue[it-1].offer(extend.getIndex)
    }
    var extend.getIndex = 0
    val array = ArrayList<Int>()
    queue.reversedArray().forEach {
        val tempQueue = LinkedList<Int>()
        while(it.size>0) {
            val value = it.poll()
            if(extend.getIndex <= value) {
                array.add(value)
                extend.getIndex = value
            } else {
                tempQueue.offer(value)
            }
            if(value > it.peek() ?: infinity) extend.getIndex = 0
        }
        while(tempQueue.size > 0) {
            val value = tempQueue.poll()
            array.add(value)
            extend.getIndex = value
        }
    }
    return array.indexOf(location) + 1
}
```
+ 풀이
1. 큐 9개를 만들어 우선순위에 맞게 큐에 삽입.
2. 마지막 출력 인덱스를 저장하며 큐에서 순서에 맞게 꺼내 배열에 넣음.
3. 해당 인덱스가 몇 번째인지 반환.

### 시간복잡도 O(n)
프린터의 대기열의 개수를 n이라 했을때,
+ forEachIndexed : O(n)
+ reversedArray : O(n)
+ forEach : O(1)
    + while : O(n)
    + while : O(n)
+ indexOf : O(n).

# 2020/06/04
[소스코드(Kotlin)](./wordTranslate/wordTranslate.kt)
+ 기존 문자열에서 단어를 한 글자씩 변환해 목표 문자열을 만들 수 있는 최소한의 횟수를 반환하는 문제.
```kotlin
val infinity = 987654321
fun dps(cur: String, target: String, visit: Array<Boolean>, words: Array<String>): Int {
    if (cur == target) {
        return 0
    }
    var minimum = infinity
    words.indices.forEach {
        if (!visit[it]) {
            visit[it] = true
            minimum = if (cur.isOneLetterDiff(words[it])) min(dps(words[it], target, visit, words) + 1, minimum) else minimum
            visit[it] = false
        }
    }
    return minimum
}
```
### 풀이
1. DFS를 이용해 구현. 주어진 words 내의 각 요소부터 시작해 DFS를 진행함. 
2. 목표 문자열에 도달할 수 없는 경우나 변환할 수 없는 경우에는 infinity(987654321)를 반환한다.
3. infinity가 반환됐을 경우, 0을 반환하고, 아닐 경우에는 최소 경로의 변환 횟수를 반환하게 됨.

### 시간복잡도
+ 단어 길이 s, 단어 개수 n개에 대한 시간복잡도는 O(s * n^2이다.) 
# 2020/06/03
[소스코드(Kotlin)](./origami/src/origami.kt)
+ 종이를 왼쪽으로 n번 접고 폈을 때, 접힌 부분의 모양(방향)을 반환하는 문제. 안쪽으로 접히면 0, 바깥으로 접히면 1.

```kotlin
// 첫 호출 시 left : 0, right : 2^n-1
fun IntArray.putData(left: Int, right: Int) {
    if (left == right) return
    val mid = left getMid right
    this[left getMid mid - 1] = 0
    this[mid + 1 getMid right] = 1
    putData(left, mid - 1)
    putData(mid + 1, right)
}
```

### 풀이
1. 규칙을 찾는다. n번째 접었을 때, n+1번째는 n번째를 기준으로 왼쪽에는 0, 오른쪽에는 1 방향으로 접힌다.
2. 리프 노드를 제외한 모든 노드가 자식 노드로 왼쪽에는 0, 오른쪽에는 1을 가지고 있는 완전 이진 트리 형태이다.
3. 배열을 이용해 완전이진트리를 구성한다.

### 시간복잡도
+ O(2^n)
    + 배열의 크기가 2^n-1이기 때문에, 초기화 과정을 거치면 2^n이 됨.

# 2020/06/02

[소스코드(Kotlin)](./clawMachineGame/src/clawMachineGame.kt)

+ board에서 인형을 뽑아 stack에 넣고, stack에 두 개의 같은 인형이 들어가면 2점을 획득. 총 점수를 구하는 문제.

```kotlin
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
```

### 풀이

1. 각 열의 인형의 최고 높이를 구해 배열에 저장함. (이진 탐색 이용.)
2. moves를 순회하며 각 열의 최고 높이에서 인형을 꺼낸 후, 최고 높이값을 1 낮춤.
3. 꺼낸 인형은 스택에서 꺼내 값을 비교해 같다면 2점을 추가, 다르면 스택에 push함.

### 시간복잡도

+ O(nlogn)
  + buildTopIndexArray() : 배열생성
  + getTopIndexArray() : O(nlogn) (이진 탐색 n번 시행.)
  + map() : O(n)
  + forEach() : O(n)
  + pull() : O(1)
  + getPointOrPush() : O(1)

# 2020/06/01

[소스코드(Kotlin)](./bestAlbum/src/BestAlbum.kt)

+ 장르와 각 노래의 재생 횟수가 주어지면, 가장 재생횟수가 높은 장르부터, 그 안에서 가장 재생횟수가 높은 노래 2곡을 뽑아 반환하는 문제.

### 풀이

1. 장르 이름, 장르 총 재생횟수, 각 노래의 재생횟수와 인덱스를 저장한다. => Map<String, Pair<Int, TreeSet<Pair<Int, Int>>>>. { 장르 이름, ( 장르 총 재생횟수, [ ( 노래의 재생횟수, 인덱스 ) ] ) }
2. TreeSet 정렬 방식을 정의한다. 노래 재생횟수 오름차순, 같다면 인덱스 내림차순.
3. 장르 총 재생횟수를 정렬해 가장 재생횟수가 많은 장르부터, 노래의 인덱스를 최대 2개씩 꺼낸다.

### 시간복잡도

+ O(nlogn)

  + forEach() : O(n)
    + caculateTotalPlayCount() : O(logn)
    + playCountIntoGenre() : O(1)

  + sortBy() : O(nlogn)
  + forEach() : O(n)
  + addLastInto() : O(1)
  + toIntArray() : O(n)

# 2020/05/29

[소스코드(Kotlin)](./skillTree/src/SkillTree.kt)

[소스코드(Java)](./skillTree/src/SkillTree.java)

+ 선행 스킬 순서 skill 순서를 준수한 스킬트리의 수를 반환하는 문제.
+ 모든 스킬과 스킬트리는 각각 대문자 알파벳 한 글자로 주어짐.

### 풀이

1. 대문자 알파벳 A의 아스키코드(65)를 뺀 후, 26개 크기의 배열에 스킬 순서를 저장.
2. 각 스킬트리를 순서대로 검색해 선행 스킬에 맞게 스킬트리를 짰는지 확인.

# 2020/05/28

[소스코드(Map)](./uncompletedPlayer/src/UncompletedPlayerMap.java)

[소스코드(정렬)](./uncompletedPlayer/src/UncompletedPlayerSort.java)

+ 참여 선수, 완주한 선수(참여 선수 수 - 1)가 주어지면, 완주하지 못한 선수 (1명)을 반환하는 문제.

### 풀이 1(Map)

1. 완주한 선수들의 컬렉션(Map)을 만들어 인원을 카운팅함.
2. 완주한 선수들의 이름을 뽑아내 완주하지 못한 선수를 찾아냄.

### 풀이 2(정렬)

1. 완주한 선수, 참여 선수를 정렬함.
2. 반복문을 돌려 값이 다른 경우에 함수를 반환시킴.

# 2020/05/27

[소스코드](./TileOrnament/src/TileOrnament.java)

+ 나선형으로 정사각형을 하나씩 이어 붙여 N번째 정사각형을 붙였을 때, 둘레를 구하는 문제.

1. 점화식을 도출한다. N번째 정사각형의 변의 길이 = N-1번째 정사각형의 변의 길이 + N-2번째 정사각형의 변의 길이. => N번째 정사각형의 한 변의 길이를 R(N)이라고 하면, R(N) = R(N-1) + R(N-2) 라는 점화식을 세울 수 있다. => **피보나치 수열과 점화식이 같음**
2. 각 정사각형의 변의 길이를 저장할 배열을 사용한다. (소스코드에서는 dp 배열 사용.)
3. 반복문을 통해 N번째까지 반복문을 돌린다.
4. N번째 정사각형의 변의 길이 \* 2 + N-1번째 정사각형의 변의 길이 \* 2가 답이 된다.

# 2020/05/26

[소스코드(Java)](./GetMidCharacter/src/GetMidCharacter.java)

[소스코드(Kotlin)](./GetMidCharacter/src/getMidCharacter.kt)

+ 문자열이 주어지면, 중간의 글자를 반환하기(글자수가 짝수면 가운데 두 글자.)

1. (length-1)/2 글자수를 뽑아냄.
2. 짝수라면 그 다음 글자를 뽑아냄.



# 2020/05/25

[소스코드](./pAndYCounter/src/PAndYCounter.java)

+ 문제 : 문자열이 주어지면 p,y(대소문자 구분 x)의 개수를 세어 같으면 true, 다르면 false 반환하기.

1. 문자열을 소문자로 바꾼다.(대문자도 상관없음.)
2. 알파벳 p, y의 개수를 센다.
3. 같으면 true 반환한다.
