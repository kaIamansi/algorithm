## algorithm workspace

## 20/06/26

```js
function convertArrayTo2d(arr, n) {
  const newArray = [];
  while (arr.length) {
    newArray.push(arr.splice(0, n));
  }
  return newArray;
}

function solution(n, words) {
  let outString = "";
  let answer = [];

  for (let i = 1; i < words.length; i++) {
    const prevWord = words[i - 1];
    const case1 = prevWord.charAt(prevWord.length - 1) !== words[i].charAt(0);
    const case2 = words.findIndex((v) => v === words[i]) !== i;

    if (case1 || case2) {
      outString = words[i];
      words.splice(i + 1, words.length - 1);
      break;
    }
  }

  if (outString) {
    const array = convertArrayTo2d(words, n);

    for (let i in array) {
      for (let j in array[i]) {
        if (array[i][j] === outString) {
          answer = [Number(j) + 1, Number(i) + 1];
          break;
        }
      }
    }
  }

  return answer.length === 0 ? [0, 0] : answer;
}
```

### 풀이

1. case를 2개로 나누고 수행
2. for문돌면서 확인

---

## 20/06/26

```js
function solution(nums) {
  let answerObj = new Set(nums);
  answerObj = Array.from(answerObj);

  return nums.length / 2 < answerObj.length
    ? nums.length / 2
    : answerObj.length;
}
```

### 풀이

1. Set으로 중복을 제거하고 다시 배열로 바꿈
2. if문 처리

---

## 20/06/12

```js
function solution(begin, target, words) {
  if (!words.includes(target)) return 0; // words안에 target이 없으면 0 return
  const result = []; // target을 발견한 모든 경우의 count를 저장.

  function bfs(begin, words, count) {
    const queue = [];

    words.forEach((word, index) => {
      // begin과 문자를 비교하여 몇개가 다른지 counting.
      const wordCount = word
        .split("")
        .reduce((acc, v, i) => (begin[i] !== v ? acc + 1 : acc), 0);

      // 만약 하나의 글자만 다르면
      if (wordCount === 1) {
        if (word === target) {
          // 이때 target과 같으면 result에 올려줌.
          result.push(count + 1);
          return;
        }

        // words 배열에서 자신을 제외하고 다음 bfs에 넣어줄 word와 words를 만듬.
        const dummy = [...words];
        dummy.splice(index, 1);
        queue.push({ word, dummy });
      }
    });

    if (queue.length) {
      // 카운팅 하고
      ++count;
      queue.forEach((v) => {
        // 각 queue의 인자만큼 트리를 형성함.
        bfs(v.word, v.dummy, count);
      });
    }
  }

  bfs(begin, words, 0);

  // 가장 작은 값 return
  return result.sort((a, b) => a - b)[0];
}
```

### 풀이

1. dfs로다가 풀음
2. 주석 보셈

---

## 20/06/10

```js
function solution(n, computers) {
  var answer = 0;
  const check = [];

  computers.forEach(() => {
    check.push(false);
  });

  function DFS(index) {
    check[index] = true;

    for (let i = 0; i < computers.length; i++) {
      if (computers[index][i] === 1 && !check[i]) {
        DFS(i);
      }
    }
  }

  for (let i = 0; i < computers.length; i++) {
    if (!check[i]) {
      DFS(i);
      answer += 1;
    }
  }

  return answer;
}
```

### 풀이

1. computer의 개수만큼 배열 생성
2. 각각의 컴퓨터마다 DFS를 돌림.
3. answer에 하나씩 더해가면서 경우를 구함.

---

## 20/06/09

```js
function solution(n, losts, reserves) {
  const lost = [...losts];
  const reserve = [...reserves];

  losts.forEach((v) => {
    if (reserve.includes(v)) {
      lost.splice(lost.indexOf(v), 1);
      reserve.splice(reserve.indexOf(v), 1);
    }
  });

  [...lost].forEach((v) => {
    if (reserve.includes(v + 1) || reserve.includes(v - 1)) {
      if (reserve.includes(v + 1) && reserve.includes(v - 1)) {
        reserve.splice(reserve.indexOf(v - 1), 1);
        lost.splice(lost.indexOf(v), 1);
        return true;
      }

      if (!reserve.includes(v + 1) && !reserve.includes(v - 1)) {
        return true;
      }

      if (reserve.indexOf(v - 1)) {
        reserve.splice(reserve.indexOf(v - 1), 1);
        lost.splice(lost.indexOf(v), 1);
      } else {
        reserve.splice(reserve.indexOf(v + 1), 1);
        lost.splice(lost.indexOf(v), 1);
      }
    }
  });

  return n - lost.length;
}
```

### 풀이

1. 잃어버렸지만 여부 있으면 제외
2. 없는애한테 있는애가 빌려줌.
3. 그래도 없는애 개수를 n에서 제외

---

## 20/06/08

```js
function solution(priorities, location) {
  const locationArray = priorities.map((data, index) => ({
    docs: data,
    location: index,
  }));

  let i = 0;

  while (true) {
    for (let j = i; j < locationArray.length; j++) {
      if (locationArray[i].docs < locationArray[j].docs) {
        locationArray.push(...locationArray.splice(i, 1));
        break;
      }
      if (
        locationArray.length - 1 === j &&
        locationArray[i].docs >= locationArray[j].docs
      ) {
        i++;
      }
    }

    if (i === locationArray.length - 1) {
      break;
    }
  }

  return locationArray.findIndex((data) => data.location === location) + 1;
}
```

### 풀이

1. 데이터 검사
2. stack에 푸쉬
3. 팝도 함
4. 찾아서 리턴

---

## 20/06/03

```js
function solution(n) {
  var answer = [];

  for (let i = 0; i < n; i++) {
    if (i === 0) {
      answer.push(0);
    } else {
      const arr = answer.reverse().map((d) => (d ? 0 : 1));
      answer.reverse();

      answer = [...answer, 0, ...arr];
    }
  }

  return answer;
}
```

### 풀이

- 종이접기 규칙
  절반을 기준으로 한쪽을 reverse하고 0은 1로, 1은 0으로 바꾸면 반대쪽과 같은 값이 나온다.

ex]
[0,0,1,0,0,1,1]의 중간을 기준으로 왼쪽은 [0,0,1] 오른쪽은 [0,1,1] 이다.
이 때 오른쪽을 reverse = [1,1,0] ->
0은 1로, 1은 0으로 = [0,0,1] -> 왼쪽과 동일.

규칙을 이용한 풀이.

시간복잡도 O(n^2)

---

## 20/06/02

```js
function solution(board, moves) {
  const boardCopyed = [...board];
  const basket = [];
  let answer = 0;

  moves.forEach((v) => {
    if (boardCopyed[boardCopyed.length - 1][v - 1] === 0) return false;

    boardCopyed.some((arr, i) => {
      if (arr[v - 1] === 0) return false;

      if (basket.length > 0) {
        if (basket[basket.length - 1] === arr[v - 1]) {
          answer += 2;
          basket.pop();
          boardCopyed[i][v - 1] = 0;
          return true;
        }
      }

      basket.push(arr[v - 1]);
      boardCopyed[i][v - 1] = 0;
      return true;
    });
  });

  return answer;
}
```

### 풀이

1. moves에 for문을 돌고 안에서 board에 for문을 돔
2. 검사해서 스택처럼 넣고 뺴고 더하고 함

---

## 20/06/01

[소스코드](./bestAlbum.js)

### 풀이

- sum 함수: arr를 받아서 모든 인자값을 더한 값을 return.
- findIndex 함수: arr에서 find인자의 index번호를 return.

1. `newGenres`를 만듬. -> genres에 따른 plays의 해쉬맵.

```
genres: ["classic", "pop", "classic", "classic", "pop"]
plays: [500, 600, 150, 800, 2500]

result: {
  classic: [ 800, 500, 150 ],
  pop: [ 2500, 600 ]
}
```

2. 해쉬 장르의 plays를 정렬.
3. 각 장르의 총 play 횟수를 더해서 `Array<{ genres: 장르, count: 총 횟수 }>`배열(rank)에 담음.
4. `rank`를 총 play횟수 순서대로 정렬
5. plays배열의 index번호를 return해야하기 떄문에 plays배열에서 인덱스 번호를 구해서 리턴함.

---

## 20/05/29

```javascript
function solution(skill, skill_trees) {
  let answer = 0;

  skill_trees.forEach((skillTree) => {
    const newSkillTree = [...skillTree]
      .filter((d) => skill.includes(d))
      .join("");
    let checker = true;

    for (let i = 0; i < newSkillTree.length; i++) {
      if (newSkillTree[i] !== skill[i]) {
        checker = false;
      }
    }

    if (checker) answer++;
  });

  return answer;
}
```

### 풀이

1. `skill_trees`의 데이터에 접근해서 이를 배열로 변경함. (EX] ["BACDE", ...] -> [["B", "A", "C", "D", "E"], ...])
2. skillTree와 skill을 비교하여 중복 문자열을 제거.
3. 다시 문자열로 변경.
4. 중복을 제거한 문자와 skill을 차례대로 비교하여 순서를 확인.
5. 순서가 옳바르면 answer를 올림.

---

## 20/05/28

```javascript
function solution(participant, completion) {
  const partSort = participant.sort();
  const compSort = completion.sort();

  for (let i = 0; i < partSort.length; i++) {
    if (compSort[i] === undefined || partSort[i] !== compSort[i])
      return partSort[i];
  }
}
```

### 풀이

1. 두 배열을 정렬
2. 순서대로 비교
3. 필터링

---

## 20/05/27

```javascript
function solution(n) {
  const array = [1, 1];

  for (let i = 1; i <= n - 2; i++) {
    array.push(array[i - 1] + array[i]);
  }

  const reverseArray = array.reverse();

  return reverseArray[0] * 2 + (reverseArray[0] + reverseArray[1]) * 2;
}
```

### 풀이

1. 문제에 나온 array를 만듬
2. 가장 큰 상자 \* 2 === 세로 or 가로길이
3. (가장 큰 상자 + 두번째 상자) \* 2 === 새로 or 가로길이
4. 합체

---

## 20/05/26

```javascript
function solution(s) {
  const answer = Math.round(s.length / 2) - 1;

  if (s.length % 2 === 0) {
    return s.slice(answer, answer + 2);
  } else {
    return s.slice(answer, answer + 1);
  }
}
```

### 풀이

1. 문자열의 중간 index를 구함
2. 짝수, 홀수를 구분함.
3. 짝수면 문자열의 중간 부분의 2개를 return
4. 홀수면 문자열의 중간 부분을 return

---

## 20/05/25

```javascript
function solution(s) {
  const answerObj = [...s.toUpperCase()].reduce(
    (acc, d) => {
      if (d === "Y" || d === "P") {
        return { ...acc, [d]: acc[d] + 1 };
      }
      return acc;
    },
    { P: 0, Y: 0 }
  );

  return answerObj.P === answerObj.Y ? true : false;
}
```

### 풀이

1. 문자열을 대문자로 바꾸고 배열화함.
2. 배열을 하나하나 검사하면서 Y 또는 P일 경우 hash map을 이용하여 P와 Y의 개수를 체크한다.
3. 개수를 비교하여 true or false를 리턴한다.
