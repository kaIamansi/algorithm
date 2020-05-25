function solution(s){
  var answer = true;
  s = s.toLowerCase().split('');  

  if(s.filter(word=> word=='p').length!=s.filter(word=> word=='y').length) answer = false;
   
  return answer;
}

