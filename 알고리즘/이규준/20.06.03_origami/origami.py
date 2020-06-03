def solution(n):
    answer = [0, 0, 1]
    n -= 1
    for i in range(1, n):
        temp = []
        for j in range(len(answer)):
            if j % 2 == 0:
                temp.extend([0, answer[j], 1])
            else:
                temp.append(answer[j])
        answer = temp

    return answer