## algorithm workspace


# 2020/06/02
[소스코드(Javascript)](./2020-06-02/solution.js)

- url : https://programmers.co.kr/learn/courses/30/lessons/42579  

- 설명 : moves 배열의 순서대로 주어진 2차원 배열(board)의 하나의 라인에서 0이 아닌 것을 뽑아, 버킷에 쌓아두되, 버킷에 같은것이 연속으로 있으면 제거하고, 제거된  요소의 개수를 return하는 solution함수 작성  

- 풀이 :  
```javascript
1  function solution(board, moves) {
2    const basket = [];
3    let result = 0;
4
5    moves.forEach(move => {
6      let v = move-1;
7      let doll = null;
8
9      for(let i = 0; i < board.length; i++) {
10       if(board[i][v] !== 0)  {
11         doll = board[i][v];
12         board[i][v] = 0;
13         break;
14       }
15     }
16 
17     if(doll !== null) {
18       if(basket[basket.length-1] === doll) {
19         basket.pop();
20         result += 2;
21       }
22       else basket.push(doll);
23     }
24   });
25   return result;
26 }
```   
1. 9~15라인: 인형을 뽑는 과정이다. `board[i][moves[index]-1]`를 반복하며
2. 인형이 있으면 뽑고(저장하고, 보드에는 지운다.), 없으면 무시한다.
3. 17라인: 인형이 뽑혀있는지 확인한다.
4. 18라인: 뽑혀있다면 `basket`의 마지막 원소(인형)과 같은지 확인한다.
5. 19~20라인: 같으면 마지막 원소를 `pop()`으로 제거한다. 실질적으로 2개가 없어진것과 같음으로 `answer`에 2를 더한다.
6. 22라인: 같지 않으면 뽑은 인형을 `push()`한다.
7. 위 과정을 `moves`의 길이 만큼 반복한다.

# 2020/06/01
[소스코드(Javascript)](./2020-06-01/solution.js)

- url : https://programmers.co.kr/learn/courses/30/lessons/42579

- 설명 : 대충 게시판 카테고리별 인기글 2개씩 뽑는거랑 같은 알고리즘   

- 풀이 :   
```javascript   
1  const DownSortGenre = (a, b) => b[1] - a[1];
2  const DownSortMusic = (a, b) => b.plays - a.plays;
3
4  function solution(genres, plays) {
5    let answer = [];
6    const genresCount = new Map();
7    const musics = [];
8
9    genres.forEach((genre, idx) => {
10     if (genresCount.get(genre)) {
11       genresCount.set(genre, genresCount.get(genre) + plays[idx]);
12       musics[genre].push({ idx, plays: plays[idx] });
13     } else {
14       genresCount.set(genre, plays[idx]);
15       musics[genre] = [{ idx, plays: plays[idx] }]; // [classic: [{idx: 1, plays: 150}, ...]]
16     }
17   });
18   // [...genresCount]는 Map을 배열로 변환. [['classic', 1450], ['pop', 600]]
19   [...genresCount].sort(DownSortGenre).forEach(item => {
20     answer = answer.concat(musics[item[0]].sort(DownSortMusic).map(x => x.idx).slice(0, 2));
21   });
22
23   return answer;
24 }
```   
1. 찐해쉬멥(`genresCount`)에는 장르별 plays를 누적 카운트 한다.  
2. 배열로 구현한 짭해쉬맵(`musics`)에는 장르별로 노래의 index와 plays를 객체로 저장한다.
    > [classic: [{idx: 1, plays: 150}, {idx: 3, plays: 800}], ...]`
3. `genresCount`를 배열로 만들고 카운트를 기준으로 내림차순 정렬을 한 배열을 만든다.  
4. 위에서 만든 배열을 순회하면서 `musics`에서 장르별로 배열을 추출한다.  
5. 추출한 배열을 plays 기준으로 내림차순 정렬한 배열을 만들고 그 배열에서 idx를 추출한 배열을 만든다.  
6. 위에서 만들어진 배열에서 2 이상 index를 자르고 answer 배열에 이어 붙인다.  
7. 4~6을 반복한다.

# 2020/05/29
[소스코드(Javascript)](./2020-05-29/solution.js)
- 문제 : 주어진 선행 스킬(문자) 순서(문자열)에 맞는 스킬트리(문자열)의 개수를 구해라.  

- 설명 :
  1. 하나의 스킬트리에는 중복된 스킬이 없다.  
  2. __이전 스킬을 배우지 않은 경우__ 불가능한 스킬트리다.  
  3. __스킬을 배우는 순서가 바뀌는 경우__ 불가능한 스킬트리다.  
  4. 위 문제가 없으면 가능한 스킬트리다.  
  <br>
- 풀이 :
```javascript
function solution(skill, skill_trees) {
  return skill_trees.length - skill_trees.filter(skill_tree => {
    let marked = false;
    let prev = -1; // 스킬 index는 0이상. 처음엔 prev에 저장되도록 -1 설정

    for (let i = 0; i < skill.length; i++) {
      let temp = skill_tree.indexOf(skill[i]);

      if (temp === -1) marked = true;
      else if (marked === true || temp < prev) return true;
      else prev = temp;
    }
  }).length;
}
```  
1. 하나의 스킬트리에는 중복된 스킬이 없기 때문에 `indexOf()`로 스킬트리에서 선행스킬 index를 추출한다.  
2. 이번 선행 스킬이 스킬트리에 없다면 marked를 true로 둔다.  
3. __스킬트리에 있다면 `marked`가 true(이전 스킬을 배우지 않았음)이거나 `prev`와 비교하여 이전 선행 스킬의 index가 더 높다면(스킬 배우는 순서가 바뀜) 이것은 _망트리_ 이기 때문에 바로 폐기시킨다.__  
4. 위의 문제가 없으면 다시 prev에 현재 index를 저장한다.  
5. 2~3번을 선행 스킬 개수만큼 반복한다.  
6. 5번을 스킬트리 개수만큼 반복한다.  
7. __전체 스킬트리 개수 - 폐기한 스킬트리의 개수__ 로 가능한 스킬트리 개수를 구한다.   

# 2020/05/28
[소스코드(Javascript)](./2020-05-28/solution.js)
- 문제 : 마라톤 참가한 사람 이름 배열과 마라통을 완주한 사람들이 담긴 배열을 비교해서 완주하지 못한 사람을 찾는다. 단, 동명이인이 있을 수 있다.

- 설명 : 이 알고리즘 분류가 '해시' 이다. 완주한 사람을 `'이름'-'count'`로 데이터를 저장하고 전체 사람과 비교하여 완주하지 못한 사람을 찾는다.

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
