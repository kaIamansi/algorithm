# 20/07/16
- 정답 코드 
```python
def solution(nums):
    answer = 0
    
    limit = int(len(nums) / 2)
    
    setlist = list(set(nums))

    if len(setlist) > limit:
        return limit
    else:
        return len(setlist)
    
    return answer

```

### 풀이

- limit == 고를 수 있는 최대 개수
- setlist == num 중복을 제거한 리스트

```python
if len(setlist) > limit:
        return limit
    else:
        return len(setlist)
```
- 중복을 제거안하고 선택했을 때의 값이 중복을 제거하고 난 후의 값보다 작으면 그냥 다 선택하면 되고
- 그 반대의 경우는 무조건 중복을 제거하고 선택한 값이 크다.
??
