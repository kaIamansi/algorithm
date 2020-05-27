## algorithm workspace

### 2020-05-25
- 문자열을 모두 소문자로 변경 후 p의 갯수와 y의 갯수 비교

### 2020-05-26
```python
def solution(s):
    return s[(len(s) - 1) // 2: len(s) // 2 + 1]
```
- 문자열의 갯수가 짝수일 때 1을 뺀 후 2로 나눈 몫을 구하면 나머지 1이 탈락되지만
- 문자열의 갯수가 홀수일 때 1을 뺀 후 2로 나눈 몫은 나누어 떨어진다

- 따라서 `(len(s) - 1) // 2`와 `len(s) // 2 + 1`의 차이는 문자열의 갯수가 홀수일 때 1 차이, 짝수일 때 2 차이가 나기 때문에 각각 1글자, 2글자를 반환함.

### 2020-05-27
```python
def solution(n):
    cache = [0 for _ in range(n + 2)]

    for i in range(1, n + 2):
        if i == 1 or i == 2:
            cache[i] = 1
            continue

        cache[i] = cache[i - 1] + cache[i - 2]

    return (cache[n + 1] + cache[n]) * 2
```
- 1번쨰와 2번째는 1, 3번째부터는 arr[n-1], arr[n-2]번째를 더한 값이 된다(피보나치와 비슷하다)
- n개의 타일로 구성된 직사각형은 긴 변의 길이가 arr[n+1]이 되고, 짧은 변의 길이가 arr[n]이 된다.
- 따라서 `(가로+세로)*2`로 구할 수 있었다.
