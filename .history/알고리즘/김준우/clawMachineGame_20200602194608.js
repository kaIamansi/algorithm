function solution(board, moves) {
  const boardCopyed = [...board]; // 보드 복사
  const basket = [];
  let answer = 0;

  moves.forEach((v) => {
    if (boardCopyed[boardCopyed.length - 1][v - 1] === 0) return false; // 없으면 continue

    boardCopyed.some((arr, i) => {
      if (arr[v - 1] === 0) return false; // 없으면 continue

      if (basket.length > 0) {
        if (basket[basket.length - 1] === arr[v - 1]) {
          // 인형 똑같은거 2번 넣으면 pop하고 2더함
          answer += 2;
          basket.pop();
          boardCopyed[i][v - 1] = 0;
          return true; // break
        }
      }

      basket.push(arr[v - 1]); // 인형을 넣음
      boardCopyed[i][v - 1] = 0; // 배열에서 인형 지움
      return true; // break
    });
  });

  return answer;
}

// https://programmers.co.kr/learn/courses/30/lessons/64061
