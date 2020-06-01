function solution(board, moves) {
  let answer = 0;
  let max = board.length;
  let idx = [];
  let stack = [];
  
  for(let i = 0; i < max; i++) {
      for(let j = 0; j < max; j++) {
          if(board[j][i] !== 0) {
              idx.push(j); // j라인 중 가장 처음으로 인형잊 존재하는 인덱스 push
              break;
          }
      }
  }
  
  moves.forEach(el => {
      if(idx[el - 1] + 1 <= max) { // [el - 1]라인의 인덱스가 max를 초과하지 않는다면,
          stack.push(board[idx[el-1]][el-1]); // idx[el - 1]라인의 맨 위 인형을 꺼내서 push
          idx[el - 1]++; // 꺼낸 라인의 인덱스 증가
          if(stack[stack.length - 1] === stack[stack.length - 2]) { // 현 인형과 이전 인형이 같다면
              stack.pop() // 팝
              stack.pop() // 팝    
              answer += 2; // 더하기 2
          }
      }
  })
  return answer; // 정답 출력
}