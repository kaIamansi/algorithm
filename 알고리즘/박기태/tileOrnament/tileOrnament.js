function solution(N) {
  let answer = 0;
  let prev = 1;
  let now = 1;

  for (var i = 0; i < N; i++) {
    answer = prev + now;
    prev = now;
    now = answer;
  }

  answer += answer;
  return answer;
}

// https://programmers.co.kr/learn/courses/30/lessons/43104
