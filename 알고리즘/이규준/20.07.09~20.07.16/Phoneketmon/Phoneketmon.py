def solution(nums):
    answer = 0

    limit = int(len(nums) / 2)

    setlist = list(set(nums))

    if len(setlist) > limit:
        return limit
    else:
        return len(setlist)

    return answer