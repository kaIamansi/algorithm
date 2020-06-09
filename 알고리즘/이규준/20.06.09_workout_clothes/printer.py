def solution(n, lost, reserve):

    lost_buff = lost[:]

    for i in range(len(lost)):
        if lost[i] in reserve:
            lost_buff.remove(lost[i])
            reserve.remove(lost[i])

    buff = reserve[:]
    n = n - (len(lost_buff) + len(reserve))

    for i in lost_buff:
        if i - 1 in reserve:
            buff.append(i)
            reserve.remove(i - 1)

        elif i + 1 in reserve:
            buff.append(i)
            reserve.remove(i + 1)

    return n + len(buff)