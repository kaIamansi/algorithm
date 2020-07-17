function solution(nums) {
  let arr = [];
  for(let i=0;i<nums.length;i++){
    if(!arr.includes(nums[i])) arr.push(nums[i]);
  }
  return arr.length<=nums.length/2 ? arr.length : nums.length/2
}
