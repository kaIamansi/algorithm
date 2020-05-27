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