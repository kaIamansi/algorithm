function solution(n, lost, reserve) {
  const l = [...lost];
  lost.forEach(x=>{
    if(reserve.indexOf(x)!=-1){
      reserve.splice(reserve.indexOf(x),1);
      l.splice(l.indexOf(x),1);
    }
  });
  [...l].forEach(x=>{
    if(reserve.indexOf(x-1)!=-1){
      reserve.splice(reserve.indexOf(x-1),1);
      l.splice(l.indexOf(x),1);
    }else if(reserve.indexOf(x+1)!=-1){
      reserve.splice(reserve.indexOf(x+1),1);
      l.splice(l.indexOf(x),1);
    }
  });
  return n-l.length;
}