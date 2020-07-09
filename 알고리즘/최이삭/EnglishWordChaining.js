function solution(n, words) {
  let prev = words[0][0];
  let answer = [0, 0];
  let map = new Map();
  
  words.every((el, idx) => {
      if(prev !== el[0] || map.get(el) === true) {
          answer = [(idx+1) % n === 0 ? n : (idx+1) % n, Math.ceil((idx+1) / n)]
          return false;
      }
      map.set(el, true);
      prev = el.charAt(el.length - 1);
      
      return true;
  })
  
  return answer;
}