# 20/05/27
- 정답 코드
```python
def solution(participant, completion):
    uncomplete = list(set(participant) - set(completion))
    
    if len(uncomplete) ==  0:
        for i in completion:
            if participant.count(i) > completion.count(i):
                return i
    return  uncomplete[0]  
```
- 원래 코드
```python
def solution(participant, completion):
    uncomplete = list(set(participant) - set(completion))
    
    if len(uncomplete) ==  0:
        for i in completion[::-1]:
            if participant.count(i) > completion.count(i):
                return i
    return  uncomplete[0]  
```

### 풀이
```python
set(participant)
``` 
- 1.집합으로 바꿈
```python
uncomplete = list(set(participant) - set(completion))
return  uncomplete[0]
``` 
- 2.차집합으로 계산하고 다시 리스트로. 이때 uncomplete에 값이 존재하면 if문 통과하면서 바로 리턴
```python
if len(uncomplete) ==  0:
        for i in completion[::-1]:
            if participant.count(i) > completion.count(i):
                return i
```
- 3.중복 참가자 존재시 완주리스트에서 참가자를 .count로 비교하며 양쪽 리스트의 수가 다르면 해당참가자를 바로 리턴


- 로꾸거에서 순서대로했더니 성공했음.
