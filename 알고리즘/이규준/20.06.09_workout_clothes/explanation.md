# 20/06/09
- 정답코드 
```python
def solution(n, lost, reserve):

    lost_buff = lost[:]

    for i in range(len(lost)):
        if lost[i] in reserve:
            lost_buff.remove(lost[i])
            reserve.remove(lost[i])

    buff = reserve[:]
    n = n - (len(lost_buff) + len(reserve))

    for i in lost_buff:
        if i - 1 in reserve:
            buff.append(i)
            reserve.remove(i - 1)

        elif i + 1 in reserve:
            buff.append(i)
            reserve.remove(i + 1)

    return n + len(buff)
```

#### 풀이 

```python
for i in range(len(lost)):
        if lost[i] in reserve:
            lost_buff.remove(lost[i])
            reserve.remove(lost[i])
```

- 도둑 맡은 사람이랑 여분의 옷을 챙긴 사람이 겹치는지 확인하고 겹치면 서로 제거
    - 즉 lost[i]가 reserve에 존재하면 해당 값들을 삭제
    
```python
n = n - (len(lost_buff) + len(reserve))
```

- 아무것도 아닌 친구들의 수를 구해줌
    - --> 도둑맞지도, 여분의 옷을 가져오지도 않은 친구들의 수

```python
for i in lost_buff:
        if i - 1 in reserve:
            buff.append(i)
            reserve.remove(i - 1)
        elif i + 1 in reserve:
            buff.append(i)
            reserve.remove(i + 1)
```

- lost의 수보다 작거나 큰 수가 reverse에 존재하면 해당값을 buff에 저장하고, reserve에선 삭제

```python
return n + len(buff)
```

- 암것도 아닌 친구들 + 체육복을 가지고있는 배열의 크기 --> 체육을 할 수 있는 애들의 수

#### 오답노트

- 머리가 하얗다 