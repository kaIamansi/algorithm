function solution(begin, target, words) {
  let visit = new Array(words.length).fill(false);
  let answer = dps(begin, target, words, visit, 0);
  if(answer === 51) answer = 0;

  return answer;
}

function dps(begin, target, words, visit, idx) {
  if(begin === target) return 0;
  let access = 51;
  
  if(!visit[idx]) {
      words.forEach((el, i) => {
          if(diffCounter(begin, el) && visit[i] === false) {
              visit[i] = true;
              let before_access = (dps(el, target, words, visit, i + 1) + 1);
              access = access > before_access ? before_access : access;
              visit[i] = false;
          }
      })
      
      return access;
  }
}

function diffCounter(a, b) {
  let cnt = 0;
  return a.split("").every((el, i) => {
      if(el !== b[i]) cnt++;
      return cnt <= 1;
  })
}