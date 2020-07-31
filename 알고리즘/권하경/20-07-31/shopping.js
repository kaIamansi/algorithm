let arr = [];

function solution(gems) {
  let gems_kind = [];
  gems.forEach(element => {
    if(!gems_kind.includes(element)){
      gems_kind.push(element);
    }
  });

  find(gems_kind,gems,0,gems_kind.length-1);
  arr.sort((a,b)=>{
    if((a.end-a.start) - (b.end-b.start)>0) return 1;
    if(a.start>b.start) return 1;
  })
  return [arr[0].start+1,arr[0].end+1];
}

function find(gems_kind,gems,start,end) {
  let copy = gems.slice(start,end+1);
  if(end>gems.length-1) return;
  for(let i=0;i<gems_kind.length;i++){
    if(!copy.includes(gems_kind[i])) {
      find(gems_kind,gems,start,end+1);
      break;
    }
    if(i==gems_kind.length-1){
      arr.push({start,end});
      find(gems_kind,gems,start+1,(start+1)+gems_kind.length-1);
    }
  }
}

console.log(solution(		["AA", "AB", "AC", "AA", "AC"]));