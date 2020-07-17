# 20/07/16
- 정답 코드 
```python
def solution(n, words):
    buffer = []
    turn = 1
    seq = 2

    for i in range(1, len(words)):
        if seq > n:
            seq = 1
            turn += 1

        if words[i] in buffer:
            return [seq, turn]

        elif words[i - 1][-1] == words[i][0]:
            buffer.append(words[i - 1])

        else:
            return [seq, turn]

        seq += 1
    return [0, 0]

```

### 풀이

- buffer == 통과된 단어를 저장 --> 중복된 단어를 확인하기 위한 리스트
- turn == 어느 차례인지를 나타냄
- seq == 몇 번째 사람인지를 나타냄

```python
if words[i] in buffer:
            return [seq, turn]

        elif words[i - 1][-1] == words[i][0]:
            buffer.append(words[i - 1])

        else:
            return [seq, turn]
```
- 단어가 중복이 되면 지금 말한 사람의 순번(seq)과 차례(turn)을 리턴
- 끝말잇기 로직이 맞으면 해당 단어를 buffer에 저장
- 끝말잇기를 실패하면 지금 말한 사람의 순번(seq)과 차례(turn)을 리턴

```python
    if seq > n:
            seq = 1
            turn += 1
`
`
`
        seq += 1
    return [0, 0]
```
- 단어의 수가 N의 개수를 넘어가면 seq(몇번째 사람인지)를 1로 초기화해주고
- turn에는 1을 추가한다.
- 그리고 끝말잇기가 정상적으로 종료되었을때 [0, 0]을 리턴한다.