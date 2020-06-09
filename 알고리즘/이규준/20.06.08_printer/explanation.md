# 20/06/03
- 정답코드 
```python
def solution(priorities, location):
    
    q = []
    answer = 0
    
    for (num, priority) in enumerate(priorities):
        q.append((num, priority))
    
    while q:
        head = q.pop(0)
        
        if any( head[1] < i[1] for i in q ):
            q.append(head)
        else:
            answer += 1
            
            if head[0] == location:
                break
            
    return answer
```

#### 풀이 

- 초기 상태의 인덱스와 값을 저장함
```python
for (num, priority) in enumerate(priorities):
        q.append((num, priority))

---> q = [(0, 2), (1, 3) ...]
```

- while문에서 q의 첫 값을 빼내며 저장 --> pop(반환해줌)
```python
head = q.pop(0)
```

- any를 이용하여 남은 q 값중에 head 값보다 큰 것이 있다면 다시 head값을 q에 뒤에 저장
    - any : 값들중 하나라도 참이라면 True반환
```python
if any( head[1] < i[1] for i in q ):
            q.append(head)
        else:
            answer += 1
```

- 뺸값이 loaction이랑 같으면 탈출 

#### 오답노트
- 원래 코드
```python
def solution(priorities, location):
    
    cnt = 0
    
    while len(priorities) < 1:
        for i in priorities:
            if i < max(priorities):
                priorities.pop(i)
                cnt += 1
            else :
                priorities.append(i)
                priorities.pop(i)
            
            if location == 0:
                return
        
    return count
```
- 뭐하려고 한건지 모르겠음ㅋㅋ