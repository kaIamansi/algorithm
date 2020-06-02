def solution(board, moves):
    answer = 0
    stack = []

    for moves_idx, move in enumerate(moves):
        idx = 0
        # 초기에 가지고 있는 캐릭터는 빈 칸(0)으로 설정
        current_character = 0

        # 현재 캐릭터가 빈 칸이 아니거나, 전부 순회했을 경우
        while not current_character and idx < len(board):
            current_character = board[idx][move - 1]
            idx += 1

        # 전부 순회했지만 더 이상 가져올 캐릭터가 없는 경우 pass
        if not current_character:
            continue

        # 가져온 캐릭터의 위치를 빈 칸으로 만들어 줍니다.
        board[idx - 1][move - 1] = 0

        # stack 의 길이가 1 이상이어야 함. 같은 캐릭터가 만나 함께 사라지기 위해서는 2개 이상이어야 하기 때문.
        # Last In 된 캐릭터가 현재 뽑은 캐릭터랑 같은 경우, 현재 캐릭터는 스택에 삽입하지 않고, 현재 Last In 된 캐릭터만 pop
        # 총 2개의 캐릭터가 사라졌으므로 answer += 2
        if len(stack) >= 1 and stack[-1] == current_character:
            stack.pop(len(stack) - 1)
            answer += 2
            continue

        # 함께 사라질 캐릭터가 없을 경우 스택에 삽입한다.
        stack.append(current_character)

    return answer

"""
레거시 코드

def solution(board, moves):
    answer = 0
    stack = []

    for move in moves:
        idx = 0
        current_character = 0

        while not current_character and idx < len(board):
            current_character = board[idx][move - 1]
            idx += 1

        if not current_character:
            continue

        stack.append(current_character)
        board[idx - 1][move - 1] = 0

    idx = 0

    while idx < len(stack):
        if not idx:
            idx += 1
            continue

        if stack[idx] == stack[idx - 1]:
            stack.pop(idx)
            stack.pop(idx - 1)
            answer += 2
            idx -= 2

        idx += 1

    return answer
"""

