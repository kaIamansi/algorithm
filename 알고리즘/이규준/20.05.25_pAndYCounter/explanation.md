# 20/05/25
```
def solution(s):
    lower_s = s.lower()
    cnt_p = lower_s.count('p')
    cnt_y = lower_s.count('y')
    
    if cnt_p is 0 and cnt_y is 0:
        return True
    
    if cnt_p is cnt_y :
        return True
    else:
        return False

    return True
```
### 풀이
```
s.lower()
```
- lower()함수가 바뀐값을 리턴만 해주고 s에 저장이 되지 않아서 헷갈렸었음 
```
lower_s = s.lower()
```
- 로 바꿔서 풀음
