def solution(participant, completion):
    uncomplete = list(set(participant) - set(completion))

    if len(uncomplete) == 0:
        for i in completion:
            if participant.count(i) > completion.count(i):
                return i
    uncomplete = list(set(participant) - set(completion))
    return uncomplete[0]