// Recommended: (Fibo(n)+Fibo(n+1))*2
function solution(N) {
  let prev = 1;
  let now = 1;
  let temp = 0;
  
  for (let i = 0; i < N-1; i++) {
    temp = now;
    now = prev + now;
    prev = temp;
  }
  
  return 2*(now+prev);
}


// Other: Fibo(n+2)*2
function solution2(N) {
  let prev = 1;
  let now = 1;
  let temp = 0;
  
  for (let i = 0; i < N; i++) {
    temp = now;
    now = prev + now;
    prev = temp;
  }
  
  return 2*now;
}


// https://programmers.co.kr/learn/courses/30/lessons/43104
