function solution(N) {
  var answer = 0;
  let arr = [1,1];
  for(let i=2;i<N;i++){
    arr.push(arr[i-2]+arr[i-1]);
  }
  
  return (arr[arr.length-2]+arr[arr.length-1])*2+arr[arr.length-1]*2;
}