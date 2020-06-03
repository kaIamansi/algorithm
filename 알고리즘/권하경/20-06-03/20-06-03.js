function solution(n) {
  var answer = [];
  answer = sort(answer,n);
  return answer;
}

function sort(answer,n) {
  if(n==1){
    answer.push(0);
    return answer;
  }else{
    answer = sort(answer,--n);
    let b = answer.map(x=>(x-1)*-1);
    b.reverse();
    
    answer.push(0);
    return answer.concat(b);
  }
}