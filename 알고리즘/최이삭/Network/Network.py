def dfs(computers, v, i, n):
    if(v[i] == True):
        return
    else:
        v[i] = True
        for j in range(0, n):
            if(computers[i][j] == 1):
              dfs(computers, v, j, n)
    

def solution(n, computers):
    visit = {}
    for i in range(0, n):
        visit[i] = False
    answer = 0
    for i in range(0, n):
        if(visit[i] == False):
            dfs(computers, visit, i, n)
            answer += 1
    return answer