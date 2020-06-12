function solution(n, computers) {
  var answer = 0;
  const check = [];

  computers.forEach(() => {
    check.push(false);
  });

  function DFS(index) {
    check[index] = true;

    for (let i = 0; i < computers.length; i++) {
      if (computers[index][i] === 1 && !check[i]) {
        DFS(i);
      }
    }
  }

  for (let i = 0; i < computers.length; i++) {
    if (!check[i]) {
      DFS(i);
      answer += 1;
    }
  }

  return answer;
}

// https://programmers.co.kr/learn/courses/30/lessons/43162
