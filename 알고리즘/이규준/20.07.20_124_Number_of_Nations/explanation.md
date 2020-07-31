# 20/07/20
- 정답 코드
```python
def solution(n):
    buffer = ['4', '1', '2']
    answer = ''

    while n > 0:
        n, r = divmod(n, 3)

        if r == 0:
            n = n - 1

        answer = buffer[r] + answer

    return answer
            
                
            
    
    return 0
```

### 풀이
- 생각해야할 점 .
    1. 몫을(n) 3으로 나눌 수 없을 때까지 나누어야한다.
    2. 나머지가 0이 나왔을 때 124밖에 존재하지않는다는 것을 생각해야함
    
- divmod(arg1, arg2) 는 몫과 나머지를 리턴함
- 나머지가 0일 땐 한자리수 낮춰줌 
    - ex) 9 // 3  --> 몫 3 
    - 이걸 낮춰줌 2로 ㅎㅎ