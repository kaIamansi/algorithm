def solution(board, moves):
    answer = 0
    temp = []

    for i in moves:
        for j in range(0, len(board)):
            if board[j][i - 1] is not 0:
                temp.append(board[j][i - 1])
                board[j][i - 1] = 0
                if len(temp) > 1 and temp[-1] is temp[-2]:
                    answer = answer + 2
                    del temp[-2:]
                break

    return answer
