function solution(n) {
  let answer = [0];
  for(let i = 1; i < n; i++) {
      let answerLength = answer.length;
      let hello = answer.map((el, idx) => {
          if(Math.floor(answerLength / 2) === idx) return 1; // 중앙을 1로
          else return el;
      }) 
      
      answer = [...answer, 0, ...hello] // 답
  }
  return answer;
}