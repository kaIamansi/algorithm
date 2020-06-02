function solution(board, moves) {
  var answer = 0;
  let arr = [];
  moves.forEach(element => {
    board.some(items => {
      if(items[element-1]!=0){
        arr.push(items[element-1]);
        items[element-1]=0;
        return 1;
      }
    });
    if(arr[arr.length-1]==arr[arr.length-2]&arr.length>1) {
      arr.pop();
      arr.pop();
      answer++;
    }
  });
  return answer*2;
}