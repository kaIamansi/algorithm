def solution(priorities, location):
    q = []
    answer = 0

    for (num, priority) in enumerate(priorities):
        q.append((num, priority))

    while q:
        head = q.pop(0)

        if any(head[1] < i[1] for i in q):
            q.append(head)
        else:
            answer += 1

            if head[0] == location:
                break

    return answer