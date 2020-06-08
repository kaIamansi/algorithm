function solution(board, moves) {
  let order = new Array();
  let newBoard = new Array();
  let dolls = new Array();

  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board.length; j++) order.push(board[j][i]);
    newBoard.push(order);
    order = [];
  }
  // 열을 기준으로 인형을 세는 배열 생성

  for (let i = 0; i < moves.length; i++) {
    dolls.push(
      newBoard[moves[i] - 1].find((item) => {
        return item != 0;
      })
    );
    newBoard[moves[i] - 1].splice(
      newBoard[moves[i] - 1].findIndex((item) => item != 0),
      1,
      0
    );
  }

  let filtered = dolls.filter((item) => item != undefined);
  let answer = filtered.length;

  for (let i = 0; i < filtered.length; i++) {
    filtered.forEach((item, index, arr) => {
      if (item == arr[index + 1]) arr.splice(index, 2);
    });
  }

  return answer - filtered.length;
}
