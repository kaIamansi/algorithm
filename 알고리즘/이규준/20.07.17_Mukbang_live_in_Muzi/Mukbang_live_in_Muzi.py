def solution(food_times, k):
    buffer = []

    if sum(food_times) <= k:
        return -1

    for i in range(len(food_times)):
        buffer.append([food_times[i], i + 1])

    while True:
        min_time = min(buffer)[0]
        print(len(buffer))

        buffer.sort(reverse=True)

        if k > k - len(buffer) * min(buffer)[0]:
            k = k - len(buffer) * min(buffer)[0]
            print("d여기")
            for i in range(len(buffer)):
                if min_time == buffer[-1][0]:
                    del buffer[-1]
                    print("asdf", buffer)
                else:
                    print("브레이크")
                    break

        elif k < k - len(buffer) * min(buffer)[0]:
            buffer = sorted(buffer, key=lambda x: x[1])
            print(buffer)
            for i in range(len(buffer)):
                k -= 1
                if k == 0:
                    buffer.append(buffer[0])
                    return buffer[i + 1][1]

        print("시발")

    return 0