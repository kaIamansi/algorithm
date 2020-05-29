## algorithm workspace

### 2020-05-29
#### [스킬트리](https://programmers.co.kr/learn/courses/30/lessons/49993) 
```python
def solution(skill, skill_trees):
    answer = len(skill_trees)

    for input_skills in skill_trees:
        index = 0

        for input_skill in input_skills:
            if input_skill in skill and input_skill is not skill[index]:
                answer -= 1
                break

            if len(skill) == index:
                break

            if input_skill == skill[index]:
                index += 1

    return answer
```
리스트 안의 스트링 순회하면서 skill 문자열도 순회. 3중 for문 사용하여 해결하였음
O(n^3) 이외의 방법이 있을까요..

### 2020-05-28
```python
from collections import Counter, defaultdict


def solution(participant, completion):
    d = defaultdict(int)
    for name in participant:
        d[name] += 1

    for name in completion:
        d[name] -= 1
        if d[name] == 0:
            del d[name]

    return list(d.keys())[0]


def solution(participant, completion):
    return list(Counter(participant) - Counter(completion))[0]
```
#### 해결 방법
- key값에 대한 갯수를 value로 두어서 남은 key 값을 리턴해주었다. 

#### 효율성
- python의 dictionary는 hash table과 같은 원리이다.
- list 안의 string끼리 비교하는 것은 O(n^2) 이므로 시간 초과가 된다. 
- hash 값으로 비교하면 상수 비교로 작동하기 때문에 더 효율적이다. 
---
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

### 2020-05-26
```python
def solution(s):
    return s[(len(s) - 1) // 2: len(s) // 2 + 1]
```
- 문자열의 갯수가 짝수일 때 1을 뺀 후 2로 나눈 몫을 구하면 나머지 1이 탈락되지만
- 문자열의 갯수가 홀수일 때 1을 뺀 후 2로 나눈 몫은 나누어 떨어진다

- 따라서 `(len(s) - 1) // 2`와 `len(s) // 2 + 1`의 차이는 문자열의 갯수가 홀수일 때 1 차이, 짝수일 때 2 차이가 나기 때문에 각각 1글자, 2글자를 반환함.

### 2020-05-25
- 문자열을 모두 소문자로 변경 후 p의 갯수와 y의 갯수 비교

