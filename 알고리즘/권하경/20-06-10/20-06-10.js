function solution(n, computers) {
  let visit = []
  visit.length = n;
  visit.fill(false,0,n);
  var answer = 0;


  for(let i=0;i<n;i++){
    if(visit[i]==false){
      check(computers,visit,i);
      answer++;
    }
  }
  
  return answer;
}

function check(c,v,index) {
  if(v[index]==true) return;
  else{
    v[index]=true;
    for(let i=0;i<c.length;i++){
      if(c[index][i]==1){
        check(c,v,i)
      }
    }
  }
}