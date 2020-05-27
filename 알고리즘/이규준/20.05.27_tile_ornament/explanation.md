# 20/05/27
```python
def fibo(n):
    # 피보나치 수열 구하는 함수
    buff = [1, 1]
    for i in range(n - 2):
        buff.append(buff[i] + buff[i + 1])

    return buff

def solution(n):
    # 둘레구하는 함수
    fibo_list = []
    fibo_list.extend(fibo(n))

    return fibo_list[-1] * 4 + fibo_list[-2] * 2
```

### 풀이
- 처음코드
```python
    def solution(n):
	
    for i in range(len(fibo_list) - 1, 0, -1):
		if cnt == 0:
			return answer + fibo_list[i]
		if cnt == 2:
			answer += fibo_list[i] * 2
			cnt -= 1
		else:
			answer += fibo_list[i] * (cnt - 1)
			cnt -= 1
```
- 처음에는 (마지막 수 * 3) + (마지막수(인덱스) - 1 * 2) + (마지막수(인덱스) - 2 * 2) + (마지막수(인덱스) - 3)
    - ex) n = 5일 때 (5 * 3) + (3 * 2) + (2 + 2) + 1 = 26
- 채점시 2개 틀림
---
- 최종코드
```python
fibo_list[-1] * 4 + fibo_list[-2] * 2
```
- 로 바꾸면서 바로 풀림