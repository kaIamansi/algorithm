def fibo(n):
    # 피보나치 수열 구하는 함수
    buff = [1, 1]
    for i in range(n - 2):
        buff.append(buff[i] + buff[i + 1])

    return buff


def solution(n):
    # 둘레구하는 함수
    fibo_list = []
    fibo_list.extend(fibo(n))

    return fibo_list[-1] * 4 + fibo_list[-2] * 2