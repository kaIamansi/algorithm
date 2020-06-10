def dps(com, idx, visit, cnt):
    if visit[idx] > 0:
        return 0

    visit[idx] = cnt

    for i in range(len(com[idx])):
        if com[idx][i] == 1:
            dps(com, i, visit, cnt)

    return 0


def solution(n, computers):
    visit = []

    for i in range(len(computers)):
        visit.append(0)

    cnt = 0

    for i in range(len(computers)):
        if
            dps(computers, i, visit, cnt)

    return cnt