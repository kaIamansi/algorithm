## 2020-05-25

~~~
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

## 풀이
match를 이용해 s에 있는 y와 p를 찾고 카운트를 셈
카운트가 같으면 true를 출력 아니면 false 출력
