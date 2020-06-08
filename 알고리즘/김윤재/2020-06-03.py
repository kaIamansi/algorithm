def solution(n):
    # 0
    # 0 0 1
    # 001 0 011
    # 001 0 011 0 001 1 011

    # 짝수 번째는 양쪽에 숫자 삽입하지 않고 그냥 삽입, 홀수 번째는 왼쪽에 0, 오른쪽에 1 삽입
    # 인덱스로 표현 시 짝수와 홀수를 변경.

    answer = [0]

    for _ in range(n - 1):
        result = []
        for index, item in enumerate(answer):
            if index % 2 == 1:
                result.append(item)
                continue

            result.extend([0, item, 1])

        answer = result

    return answer

