def solution(nums):
    size = len(set(nums))
    return len(nums) / 2 if size > len(nums) / 2 else size
