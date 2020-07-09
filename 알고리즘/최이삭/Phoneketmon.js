function solution(nums) {
  let size = new Set(nums).size
  return size > nums.length / 2 ? nums.length / 2 : size;
}