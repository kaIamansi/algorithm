from collections import Counter, defaultdict


def solution(participant, completion):
    d = defaultdict(int)
    for name in participant:
        d[name] += 1

    for name in completion:
        d[name] -= 1
        if d[name] == 0:
            del d[name]

    return list(d.keys())[0]


def solution(participant, completion):
    return list(Counter(participant) - Counter(completion))[0]
