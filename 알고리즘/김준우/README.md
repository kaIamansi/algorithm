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
