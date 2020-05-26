function solution(s) {
  const answer = Math.round(s.length / 2) - 1;

  if (s.length % 2 === 0) {
    return s.slice(answer, answer + 2);
  } else {
    return s.slice(answer, answer + 1);
  }
}

// https://programmers.co.kr/learn/courses/30/lessons/12903
