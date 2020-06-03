function solution(board, moves) {
  const boardCopyed = [...board];
  const basket = [];
  let answer = 0;

  moves.forEach((v) => {
    if (boardCopyed[boardCopyed.length - 1][v - 1] === 0) return false;

    boardCopyed.some((arr, i) => {
      if (arr[v - 1] === 0) return false;

      if (basket.length > 0) {
        if (basket[basket.length - 1] === arr[v - 1]) {
          answer += 2;
          basket.pop();
          boardCopyed[i][v - 1] = 0;
          return true;
        }
      }

      basket.push(arr[v - 1]);
      boardCopyed[i][v - 1] = 0;
      return true;
    });
  });

  return answer;
}

// https://programmers.co.kr/learn/courses/30/lessons/64061
