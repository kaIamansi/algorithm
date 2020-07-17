function solution(food_times, k) {
  let indexArr = [];
  let num = 0;
  for (let i = 0; i < food_times.length; i++) {
    indexArr.push({index:i,value:food_times[i]});
  }
  indexArr.sort((before, next) => {
    if (before.value > next.value) return 1;
    else if (before.value < next.value) return -1;
    else if (before.index > next.index) return -1;
    else if (before.index < next.index) return 1;
    return 0;
  });
  for(let i=0;i<indexArr.length;i++){
    
  }
}
