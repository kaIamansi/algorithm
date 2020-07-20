def solution(n):
    buffer = ['4', '1', '2']
    answer = ''

    while n > 0:
        n, r = divmod(n, 3)

        if r == 0:
            n = n - 1

        answer = buffer[r] + answer

    return answer