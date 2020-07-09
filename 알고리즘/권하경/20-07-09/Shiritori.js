function solution(n, words) {
  let num = 0;
  if(words.length==0) return [0,0]
  for(let i=1;i<words.length;i++){
    if(words[i-1][words[i-1].length-1]!=words[i][0]||words.indexOf(words[i])!=i){
      num = i+1;
      break;
    }
    if(i==words.length-1) return [0,0];
  }
  
  if(num%n==0) return [n,Math.round(num/n)]
  else return [num%n,Math.round(num/n)];
}