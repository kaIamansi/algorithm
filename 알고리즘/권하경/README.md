## algorithm workspace

- 20/05/25
```
function solution(s){
  s = s.toLowerCase().split('');  
   
  return s.filter(word=> word=='p').length==s.filter(word=> word=='y').length;
}

```

### 풀이
1. 문자열 s를 소문자로 바꾸고 배열로 만든다.
2. filter함수로 p와 y만 따로 빼서 배열을 만든 다음 배열 길이를 비교하여 같으면 true, 다르면 false를 리턴한다.

- 20/05/26
```
function solution(s) {
  return s.length%2!=0 ? s[Number.parseInt(s.length/2)] : s[s.length/2-1]+s[s.length/2]
}
```

### 풀이
1. 문자열 s가 짝수인지 판별한 다음 짝수면 가운데 2개의 언어를, 홀수면 가운데 언어를 리턴한다.

- 20/05/27
```
function solution(N) {
  let arr = [1,1];
  for(let i=2;i<N;i++){
    arr.push(arr[i-2]+arr[i-1]);
  }
  
  return (arr[arr.length-2]+arr[arr.length-1])*2+arr[arr.length-1]*2;
}
```

### 풀이
1. 피보나치를 배열에 넣고 끝에서 두번째와 첫번째를 직사각형 길이로 구한다.