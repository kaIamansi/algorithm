def solution(n):
    cache = [0 for _ in range(n + 2)]

    for i in range(1, n + 2):
        if i == 1 or i == 2:
            cache[i] = 1
            continue

        cache[i] = cache[i - 1] + cache[i - 2]

    return (cache[n + 1] + cache[n]) * 2

