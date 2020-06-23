# 20/06/09
- 정답이 될 코드 
```python
def dps(com, idx, visit, cnt):
    if visit[idx] > 0:
        return 0

    visit[idx] = cnt

    for i in range(len(com[idx])):
        if com[idx][i] == 1:
            dps(com, i, visit, cnt)

    return 0


def solution(n, computers):
    visit = []

    for i in range(len(computers)):
        visit.append(0)

    cnt = 0

    for i in range(len(computers)):
        if visit[i] == 0:
            cnt += 1
            dps(computers, i, visit, cnt)

    return cnt
```

### 풀이

- visit에 체크를 해줘서 처음으로 연결된 네트워크는 1로 시작하고 다음 그룹은 1씩증가해서 그룹의 수를 리턴