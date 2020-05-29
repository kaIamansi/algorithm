2020-05-28
-----------

```
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

```
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

```
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

```
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