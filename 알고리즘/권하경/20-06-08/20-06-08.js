function solution(priorities, location) {
  var answer = 0;
  while(true){
    if(priorities[0]!=Math.max(...priorities)){      
      priorities.push(priorities.shift());
      if(location==0) location = priorities.length-1;
      else location--;
    }else{
      if(location==0){
        return ++answer;
      }else{
        answer++;
        priorities.shift();
        location--;
      }
    }
  }
}