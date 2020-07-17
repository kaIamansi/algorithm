function solution(baseball) {
  var answer = [];
  for(let i=324;i<=987;i++){
    let bool = true;
    let arr = i.toString().split("");
    for(let j=0;j<baseball.length;j++){
      let Scount=0;
      let Bcount=0;
      let str = baseball[j][0].toString();
      for(let k=0;k<3;k++){
        if(arr[k]==(str[k]))Scount++;
        else if(str.includes(arr[k])==1) Bcount++;
      }
      if(Scount!=baseball[j][1]||Bcount!=baseball[j][2])  {
        bool=false;
        break;
      }
    }
    if(bool) answer.push(i);
  }
  return answer.length;
}
console.log(solution(	[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]));
