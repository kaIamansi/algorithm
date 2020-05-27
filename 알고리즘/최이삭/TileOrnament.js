function solution(N) {
    let answer = 0;
    let init = [0, 1, 1, 2];
    
    for(let i = 4; i <= N + 1; i++) {
        init.push(init[i-1]+init[i-2]);
    }
    
    answer = init[N+1] * 2 + init[N] * 2
    
    return answer;
}