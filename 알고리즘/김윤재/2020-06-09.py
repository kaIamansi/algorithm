def solution(n, lost, reserve):
    answer = n - len(lost)

    for lost_student in lost.copy():
        if lost_student in reserve:
            reserve.remove(lost_student)
            lost.remove(lost_student)
            answer += 1

    for r in reserve:
        if r - 1 in lost:
            lost.remove(r-1)
            answer += 1

        elif r + 1 in lost:
            lost.remove(r+1)
            answer += 1

    return answer

"""
중복 제거 이후 reserve를 순회 한다. 단 양쪽 다 빌려줄 수 있는 친구는 왼쪽 친구에게 양보한다. 모든 리스트는 정렬되어 입력받기 때문.
"""
