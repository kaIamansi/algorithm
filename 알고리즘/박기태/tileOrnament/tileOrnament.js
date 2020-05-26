function solution(N) {
  let prev = 1;
  let now = 1;
  let temp = 0;
  
  for (var i = 0; i < N-1; i++) {
    temp = now;
    now = prev + now;
    prev = temp;
  }
  
  return 2*(now+prev);
}

// https://programmers.co.kr/learn/courses/30/lessons/43104
