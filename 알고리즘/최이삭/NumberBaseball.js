function solution(baseball) {
  let answer = 0;
  for(let i = 123; i < 987; i++) {
      let str = i.toString()
      if(str[0] === str[1] || str[0] === str[2] || str[1] === str[2]) continue;
      if(str[0] === "0" || str[1] === "0" || str[2] === "0") continue;
      let flag = true;
      baseball.every(el => {
          let target = el[0].toString();
          let strike = 0;
          let ball = 0;
          for(let j = 0; j < 3; j++) {
              for(let k = 0; k < 3; k++) {
                  if(j === k && target[j] === str[k]) strike++;
                  else if(j !== k && target[j] === str[k]) ball++;
              }
          }
          flag = el[1] === strike && el[2] === ball;
          return flag;
      })
      if(flag === true) answer++;
  }
  return answer;
}