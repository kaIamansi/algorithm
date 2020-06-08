function solution(n) {
  var answer = [];

  for (let i = 0; i < n; i++) {
    if (i === 0) {
      answer.push(0);
    } else {
      const arr = answer.reverse().map((d) => (d ? 0 : 1));
      answer.reverse();

      answer = [...answer, 0, ...arr];
    }
  }

  return answer;
}

// https://programmers.co.kr/learn/courses/30/lessons/62049
