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

### 난관
- js는 처음이라 여러 함수를 찾으면 해결했다.    


### 풀이
1. match를 이용해 s에 있는 y와 p를 찾고 카운트를 센다.   
2. 카운트가 같으면 true를 출력 아니면 false 반환한다.   


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

### 풀이
1. 홀수와 짝수를 구분한다.   
2. substr로 시작위치와 자를 크기를 정해준다.   
3. 짝수는 가운데 2글자를 추출하기 위해 시작위치를 1 뺴준다.   
4. answer에 저장 후 반환한다.   

