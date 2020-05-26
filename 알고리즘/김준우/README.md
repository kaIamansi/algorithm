## algorithm workspace

- 20/05/25

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

- 20/05/26

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
