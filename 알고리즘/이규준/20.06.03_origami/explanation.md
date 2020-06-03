# 20/06/03
- 정답코드 
```python
def solution(n ):
    answer = [0, 0, 1]
    n -= 1
    for i in range(1, n):
        temp = []
        for j in range(len(answer)):
            if j % 2 == 0:
                temp.extend([0, answer[j], 1])
            else:
                temp.append(answer[j])
        answer = temp
        
    return answer
```
---
- 원래 코드
```python
def solution(n):
    n = 2
    answer = [0]
    
    for h in range(1, n):
        for i in range(len(answer) + 1):
            if i % 2 is 0 :
                answer.insert(i, 0)
                print(answer)
                answer.insert(i+1, 1)
    
            
    
    return answer
```

#### 풀이 
- 그전에 추가 된 수의 양옆에 0, 1이 붙는 규칙을 이용함 --> 짝수의 옆에 0, 1이 붙음
    - ex) 0, 0, 1 ---> (0), 0, (1), 0, (0), 1, (1)

```python
.
.
.
for i in range(1, n):
    for j in range(len(answer)):
        if j % 2 == 0:
            temp.extend([0, answer[j], 1])
        else:
            temp.append(answer[j])
    answer = temp
```
- i는 몇번 추가 할건지 --> 몇번 접은지를 의미함
- j는 0, 1을 추가하는 행동을 몇번 할 지
- j가 짝수일 때는 오른쪽에는 0과 answer의 j번째를 그대로 가져오고 오른쪽에는 1을 더함
- 아닐 때는 answer의 j를 그냥 가져옴


#### 오답노트
- 원래 코드
```python
def solution(n):
    n = 2
    answer = [0]
    
    for h in range(1, n):
        for i in range(len(answer) + 1):
            if i % 2 is 0 :
                answer.insert(i, 0)
                print(answer)
                answer.insert(i+1, 1)
    return answer
```
- temp를 사용하지 않고 바로 answer에 넣어버려 인덱스가 계속 밀려났음
- --> 즉, 추가되기 전의 수의 양옆에 0, 1이 들어가야하는데 방금 추가된 수에도 0, 1이 들어가서 정답만들어지지않음

##### 이때는 너무 멍청이여서 3일걸려서 이코드가 나왔음. 지금은 30분하고 풀어버림 진짜 화난다.
