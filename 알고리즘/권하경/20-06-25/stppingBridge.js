function solution(stones, k) {
  let max = Math.max(...stones);
  if(max==0){
    if(k<=stones.length) return 0;
  }
  let result = find(stones,0,max,k);
  
  return result
}

function find(stones,start,end,k) {
  if(start+1==end) return end
  let num=0;
  let result;
  let bool = false;
  for(let i=0;i<stones.length;i++){
    if((start+end)/2>=stones[i]) num++;
    else if((start+end)/2<stones[i]) num=0;
    if(num==k) bool = true;
  }
  if(bool){
    result = find(stones,start,parseInt((start+end)/2),k);
  }else{    
    result = find(stones,parseInt((start+end)/2),end,k);
  }
  return result;
}