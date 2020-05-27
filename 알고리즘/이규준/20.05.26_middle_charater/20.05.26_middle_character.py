def solution(s):
    str_len = len(s)

    if str_len % 2 == 0:
        return s[(len(s) // 2) - 1: len(s) // 2 + 1]
    else:
        return s[len(s) // 2]