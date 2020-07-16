def solution(n, words):
    buffer = []
    turn = 1
    seq = 2

    for i in range(1, len(words)):
        if seq > n:
            seq = 1
            turn += 1

        if words[i] in buffer:
            return [seq, turn]

        elif words[i - 1][-1] == words[i][0]:
            buffer.append(words[i - 1])

        else:
            return [seq, turn]

        seq += 1
    return [0, 0]
