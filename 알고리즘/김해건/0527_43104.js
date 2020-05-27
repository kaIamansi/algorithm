function solution(N) {
    let arr = [0,1];
    
    for (var i=2; i<=N; i++)
        arr.push(arr[i-1]+arr[i-2]);
    
    return (arr[N]*4) + (arr[N-1]*2);
}