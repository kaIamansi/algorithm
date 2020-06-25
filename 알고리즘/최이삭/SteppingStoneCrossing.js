function solution(stones, k) {
  let right = 200000000
  let left = 1
  
  while(left <= right) {
      let mid = Math.floor((right + left) / 2);
      let cnt = 0;
      let flag = stones.some(el => {
          if(el - mid <= 0) {
              cnt++;
          }
          else {
              cnt = 0;
          }
          return cnt >= k;
      })
      if(flag) right = mid - 1;
      else left = mid + 1;
  }
  
  return left
}