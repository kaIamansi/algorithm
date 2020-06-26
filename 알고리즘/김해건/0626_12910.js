function solution(arr, divisor) {
    let answer = [];
    
    answer = arr.filter(item => item % divisor == 0);
    answer.sort((a,b) => a - b );
    
    if (answer == 0)
        answer.push(-1);
    
    return answer;
}