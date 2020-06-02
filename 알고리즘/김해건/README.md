2020-06-01
-----------

```Javascript
ffunction solution(genres, plays) {
    let max = 0;
    let sum = new Array();
    let result = new Array();
    let bestGenres = new Array();
    let bestPlays = new Array();
    
    let filtered = genres.filter((item, index) => genres.indexOf(item) == index);
    // 장르에서 중복되는 장르를 제거하여 배열 생성
    
    for (let i=0; i<filtered.length; i++)
        sum[i] = 0;
    // 장르의 수만큼 배열 생성
    
    for (let i=0; i<filtered.length; i++)
        for (let j=0; j<genres.length; j++) 
            if (filtered[i] == genres[j]) 
                sum[i] += plays[j];
    // sum 배열에 장르의 인덱스에 맞춰 재생 수를 저장

    for (let i=0; i<filtered.length; i++) {
        bestGenres.push(filtered[sum.indexOf(Math.max.apply(null, sum))]);
        sum.splice(sum.indexOf(Math.max.apply(null, sum)), 1);
    }
    // 재생 수가 많은 순으로 장르를 저장
    
    for (let i=0; i<bestGenres.length; i++) {
        for (let j=0; j<genres.length; j++) {
            if (bestGenres[i] == genres[j] && plays[j] >= max) {
                result.push(plays.indexOf(plays[j]));
                max = plays[j];
            }
        }
    }
    // 재생 수가 많은 순으로 노래의 고유 번호를 result에 저장

    return result;
}
```  

### 난관
- 두 배열을 두고 서로의 인덱스 번호를 공유하면서 문제를 해결하려고 하니 복잡했다.
- 장르 별로 재생 수가 가장 많은 곡 두 개만 뽑으려는 방법을 어떻게 해야할지 몰라 고민했다.
    - 2차원 배열로 정렬하여 해결하는 방법을 찾았다.

### 풀이
1. genres에서 중복되는 것들을 제거하여 장르의 수를 파악했다.
2. 각 장르의 총 재생 수를 sum 배열에 넣었다.
3. sum을 바탕으로 재생 수가 많은 순으로 장르를 bestGenres에 저장
4. 마지막으로 재생 수가 많은 노래 순으로 정렬하려고 했으나 실패하였다.

### 해결하지 못함


2020-05-29
-----------

```Javascript
function solution(skill, skill_trees) {
    let compare = '', result = '';
    let count = 0;
    
    for (let i=0; i<skill_trees.length; i++) {
        compare = skill_trees[i];
        result = '';
        
        for (let j=0; j<compare.length; j++) 
            if (skill.search(compare[j]) != -1)
                result += compare[j];
        
        if (skill.search(result) == 0) 
            count++;
    }
    
    return count;
}
```  

### 난관
- 첫번째 방법으로 배열안의 문자열을 배열화하고 스킬트리를 문자열해서 서로 비교하려고 했다.
    - 그러나 너무 복잡하고 비효율적인 방법인 것 같아 다른 방법을 찾았다.
- 두번째 방법으로 replace 함수를 사용해서 skill_trees 안의 요소에서 skill의 요소들이 없다면 지우고 그 후 남아있는 요소들의 순서를 비교하려고 했다.
    - 그러나 지우는 과정이 복잡하고 그 후 남은 요소들끼리의 비교도 복잡하여 마지막 방법을 생각해냈다.

### 풀이
1. 배열에서 각 문자열들을 하나씩 꺼낸다. (compare에 하나씩 저장)
2. 꺼낸 문자열에서 skill에 해당하는 문자들만 추출한다. (search 함수를 사용하여 판별)
3. 추출한 문자들이 skill과 같거나 순서에 맞게 배열되어 있다면 count를 올린다. (search함수를 사용하여 판별)

### 부가 설명
- **skill.search(compare[j]) != -1**
    - -1이라면 포함되어 있지 않다는 뜻이기 때문에 -1만 아니면 포함되어 있음을 알 수 있다.
- **skill.search(result) == 0**
    - 0인 이유는 result가 skill의 순서에 맞게 추출되어 있기 때문에 search를 통해 찾게 되면 인덱스 값은 0이 나오기 때문이다.


2020-05-28
-----------

```Javascript
function solution(participant, completion) {       
    /* 
    let answer = participant.filter(name => return !completion.includes(name));
    
    return answer.pop(); 
    */
    
    let result = participant.sort();
    let done = completion.sort();
    
    for (let i=0; i<result.length; i++)
        if (result[i] != done[i])
            return result[i];
}
```  

### 난관
- 처음엔 두 배열을 합쳐서 중복제거 하려고 했다.
    - 그러나 동명이인의 문제를 해결하지 못해 다른 방법을 모색하였다.

### 풀이
1. 두 배열을 정렬한다.  
2. 두 배열을 순서대로 비교하여 서로 같지 않는다면 완주자가 아님으로 반환한다.
3. 동명이인의 문제는 같은 이름이 두명이므로 첫번째는 통과하지만 두번째 사람은 통과되지 못하므로 해결된다.


2020-05-27
-----------

```Javascript
function solution(N) {
    let arr = [1,1];
    
    for (var i=2; i<N; i++)
        arr.push(arr[i-1]+arr[i-2]);
    
    return (arr[N-1]*4) + (arr[N-2]*2);
}
```  

### 난관
- js에서 배열에 요소를 추가하는 방법을 몰랐다.
    - push 함수를 알고 적용하였다.

### 풀이
1. 피보나치 알고리즘과 같은 문제 접근했다.   
2. 생성한 배열에 피보나치 수열 알고리즘으로 배열에 요소를 추가한다.
3. N-1(가장 마지막에 생성한 타일)의 둘레와 N-2(그 전 타일)의 두 변의 길이를 더한다.


2020-05-26
-----------

```Javascript
function solution(s) {
    let answer = '';
    
    if (s.length%2 == 0) 
        answer = s.substr((s.length/2)-1,2);
    else
        answer = s.substr(s.length/2,1);
    
    return answer;
}
```  

### 난관
- js에서 문자를 추출하는 함수를 몰랐다.
    - substr과 splice 함수를 공부하여 해결하였다.

### 풀이
1. 홀수와 짝수를 구분한다.   
2. substr로 시작위치와 자를 크기를 정해준다.   
3. 짝수는 가운데 2글자를 추출하기 위해 시작위치를 1 뺴준다.   
4. answer에 저장 후 반환한다.   


2020-05-25
-----------

```Javascript
function solution(s){
    let count1 = 0, count2 = 0;

    for (var i=0; i<s.length; i++) {
        if (s.match('y') == s[i] || s.match('Y') == s[i])
            count1++;
    }
    
    for (var i=0; i<s.length; i++) {
        if (s.match('p') == s[i] || s.match('P') == s[i])
            count2++;
    }
    
    if (count1 == count2)
        return true;
   else 
       return false;
}
```

### 풀이
1. match를 이용해 s에 있는 y와 p를 찾고 카운트를 센다.   
2. 카운트가 같으면 true를 출력 아니면 false 반환한다.   

### 난관
- js는 처음이라 여러 함수를 찾으면 해결했다.    