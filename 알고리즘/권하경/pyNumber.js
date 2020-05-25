function solution(s){
  s = s.toLowerCase().split('');  
   
  return s.filter(word=> word=='p').length==s.filter(word=> word=='y').length;
}

