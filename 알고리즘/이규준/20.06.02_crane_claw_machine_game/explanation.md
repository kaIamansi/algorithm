# 20/06/02
- 정답코드 
```python
def solution(board, moves):
    answer = 0
    temp = []

    for i in moves:
        for j in range(0, len(board)):
            if board[j][i - 1] is not 0:
                temp.append(board[j][i - 1])
                board[j][i - 1] = 0
                if len(temp) > 1 and temp[-1] is temp[-2]:
                    answer = answer + 2
                    del temp[-2:]
                break

    return answer
```

### 풀이 
```python
for i in moves:
        for j in range(0, len(board)):
            if board[j][i - 1] is not 0:
                temp.append(board[j][i - 1])
                board[j][i - 1] = 0
```
- j를 행, i - 1을 열로 생각하여 moves의 숫자의 -1 한 값이 열이 된다
- 그때 J행의 I가 0이 아닌 수가 존재하면 temp(바구니)에 저장하고 0으로 만들어줌

```python
if len(temp) > 1 and temp[-1] is temp[-2]:
    answer = answer + 2
    del temp[-2:]
```
- 바구니의 마지막과 2번째 마지막이 같으면 answer + 2를하고 그 수들을 제거한다.