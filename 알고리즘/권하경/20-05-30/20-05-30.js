function solution(genres, plays) {
  var answer = [];
  let sortA = [];
  let arr = [];

  const map = new Map();
  
  for(let i=0;i<genres.length;i++){
    if(map.has(genres[i])){
      map.set(genres[i],(map.get(genres[i])+plays[i]));
    }else{
      map.set(genres[i],plays[i]);
    }
  }
  for (const entry of map) {
    sortA.push(entry);
  }
  for (let i = 0; i < plays.length; i++) {
    arr.push([i,plays[i]]);
  }
  sortA.sort(com);
  arr.sort(com);

  sortA.forEach(element=>{
    let num=0;
    for(let i=0;i<arr.length;i++){
      if(genres[arr[i][0]]==element[0]){
        num++;
        answer.push(arr[i][0]);
        if(num==2){
          break;
        }
      }
    }
  });
  return answer;
}

function com(a,b){
  return b[1]-a[1];
}