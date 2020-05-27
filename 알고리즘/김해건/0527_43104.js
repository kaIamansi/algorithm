function solution(N) {
    let arr = [1,1];
    
    for (var i=2; i<N; i++)
        arr.push(arr[i-1]+arr[i-2]);
    
    return (arr[N-1]*4) + (arr[N-2]*2);
}