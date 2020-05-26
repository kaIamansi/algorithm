## algorithm workspace

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

# 20/05/26
```python
def solution(s):
    str_len = len(s)

    if str_len % 2 == 0:
        return s[(len(s) // 2) - 1: len(s) // 2 + 1]
    else:
        return s[len(s) // 2]
```
```javascript
function solution(s) {
    if(s.length % 2 == 0)
    {
        return s.slice(parseInt(s.length / 2 - 1) , parseInt(s.length / 2 + 1))
    }
    else
        return s[parseInt(s.length / 2)]
}
```
### 풀이
```
s[s.length / 2]
```
- js는 몫만 구하는 연산자가 없어서 그냥 썼다가 소수가 나와 빈문자열이 나옴
```
parseInt 함수로 정수로 바꿔서 계산
```
- JS 아직 적응 중
