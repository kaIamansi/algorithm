from typing import List, Union, Iterable


def stepping_stones(stones: List[int], k: int, start: int, end: int) -> Union[int, Iterable['stepping_stones']]:
    if start >= end - 1:
        return start

    mid = (start + end) // 2
    flag = 0

    for stone in stones:
        if stone < mid:
            flag += 1
            if flag == k:
                return stepping_stones(stones, k, start, mid)
        else:
            flag = 0

    return stepping_stones(stones, k, mid, end)


def solution(stones: List[int], k: int) -> int:
    start = min(stones)
    end = max(stones)

    return stepping_stones(stones, k, start, end)


print(solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1], 3))
