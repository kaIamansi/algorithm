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