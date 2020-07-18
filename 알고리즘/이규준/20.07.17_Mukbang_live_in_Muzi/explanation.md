# 20/07/17
- 정답이였어야할 코드

def solution(food_times, k):
    buffer = []
    
    if sum(food_times) < k:
        return -1
    
    for i in range(len(food_times)):
        buffer.append([food_times[i], i])
    
    buffer.sort()
    
    while True:
        if k > k - len(food_times) * len(buffer):
            
                
            
    
    return 0

### 풀이
- 음식에 인덱스를 달고 최솟값을 구하고 k값을 빼고, 최소값을 가진 음식의 값을 뺀다.