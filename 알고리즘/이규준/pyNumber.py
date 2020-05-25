def solution(s):
    lower_s = s.lower()
    cnt_p = lower_s.count('p')
    cnt_y = lower_s.count('y')

    if cnt_p is 0 and cnt_y is 0:
        return True

    if cnt_p is cnt_y:
        return True
    else:
        return False
