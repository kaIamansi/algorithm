function solution(nums) {
  let answerObj = new Set(nums);
  answerObj = Array.from(answerObj);

  return nums.length / 2 < answerObj.length
    ? nums.length / 2
    : answerObj.length;
}

// https://programmers.co.kr/learn/courses/30/lessons/1845
