## algorithm workspace

# 2020/05/28
[소스코드(Javascript)](./2020-05-28/solution.js)
- 문제 : 마라톤 참가한 사람 이름 배열과 마라통을 완주한 사람들이 담긴 배열을 비교해서 완주하지 못한 사람을 찾는다. 단, 동명이인이 있을 수 있다.
<br>
- 설명 : 이 알고리즘 분류가 '해시' 이다. 완주한 사람을 `'이름'-'count'`로 데이터를 저장하고 전체 사람과 비교하여 완주하지 못한 사람을 찾는다.
<br>
- 풀이 : 
```javascript
function solution(participant, completion) {
  let completionCount = [];

  completion.forEach(cName =>
    completionCount[cName] = (completionCount[cName] | 0) + 1);

  return participant.find(name => !completionCount[name]-- !== false);
}
```
1. 완주한 사람을 카운팅할 배열(completionCount)을 생성한다.
2. forEach()을 이용하여 completion 배열을 순회하며 completionCoun 배열에 `이름: count`를 추가한다.
3. 처음 순회하는 이름이면 `0`으로 세팅하고, 중복(동명이인)으로 순회되는 '이름'이면 `+1`을 해준다.
4. find()를 이용해 participant 배열을 순회하면서 
5. completionCount 배열에서 같은 이름(Key)을 찾고 count(Value)가

6-1. `0`또는 `undefined`면 `true`로 내보내며 __'이름'을 바로 반환한다__.
6-2. `1`이상일 때는 반전시켜 `false`로 내보내며 __이어서 순회하도록 하고__, count-1을 해준다.

- 한줄 코드:
```javascript
const solution = (participant, completion) => participant.find(name => !completion[name]-- !== false, completion.forEach(cName => completion[cName] = (completion[cName] | 0) + 1));
```

# 2020/05/27

[소스코드(Javascript)](./tileOrnament/tileOrnament.js)

- 문제 : 정사각형의 타일을 달팽이 모양(나선형)으로 한변이 1인 타일부터 N개를 점점 큰 타일을 이어 붙이고 N개를 이어붙였을 때, 가장 큰 둘레 길이를 구해라.
  <br>
- 설명 : 귀납법으로 다음에 올 타일의 한변의 길이는 피보나치 수열을 따르는 것을 확인할 수 있고, 이를 토대로 둘레의 길이를 구할 수 있다.

  1.  [1, (여기부터 시작) 1, 2, 3, 5, 8, 13, 21, …]
  2.  다음 정사각형의 한변의 길이를 구하는 피보나치 수열의 점화식을 세운다.
      > `Fibo(0) = 0, Fibo(1) = 1, Fibo(n+2) = Fibo(n+1) + Fibo(n)`
  3.  직사각형의 둘레의 길이는 가로\*세로\*2이고
      - 긴 변의 길이는 _가장 큰 정사각형 한 변의 길이+두번째로 큰 정사각형 한 변의 길이_
      - 짧은 변의 길이는 _가장 큰 정사각형 한 변의 길이_ 다. 이를 토대로 점화식을 세운다.
  4.  F(n) = ((Fibo(n) + Fibo(n-1)) + Fibo(n))\*2
      - 점화식을 토대로 로 정리하면
      - `F(n) = 2(Fibo(n)+Fibo(n+1)) = 2(Fibo(n+2))`

    <br>

- 풀이 :

```javascript
function solution(N) {
  const arr = [1, 1];

  for (let i = 0; i < N; i++) arr.push(arr[i] + arr[i + 1]);

  return arr.pop() * 2; // arr[N+1] * 2
}
```

1. 배열을 피보나치 수열의 시작부분인 `[1, 1]`로 초기화한다.
   - 두자리를 채움으로 Fibo(n+2) 처럼 동작하게 된다.
2. 피보나치 수열을 N차 만큼 반복하며 배열에 저장한다.
3. 배열의 마지막 값은 `Fibo(n+2)`이고, 여기에 2를 곱하여 반환한다.

# 2020/05/26

[소스코드(Java)](./GetMidCharacter/src/GetMidCharacter.java)

[소스코드(Kotlin)](./GetMidCharacter/src/getMidCharacter.kt)

- 문자열이 주어지면, 중간의 글자를 반환하기(글자수가 짝수면 가운데 두 글자.)

1. (length-1)/2 글자수를 뽑아냄.
2. 짝수라면 그 다음 글자를 뽑아냄.

# 2020/05/25

[소스코드](./pAndYCounter/src/PAndYCounter.java)

- 문제 : 문자열이 주어지면 p,y(대소문자 구분 x)의 개수를 세어 같으면 true, 다르면 false 반환하기.

1. 문자열을 소문자로 바꾼다.(대문자도 상관없음.)
2. 알파벳 p, y의 개수를 센다.
3. 같으면 true 반환한다.
