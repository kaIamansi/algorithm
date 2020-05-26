function solution(n) {
  const array = [1, 1];

  for (let i = 1; i <= n - 2; i++) {
    array.push(array[i - 1] + array[i]);
  }

  const reverseArray = array.reverse();

  return reverseArray[0] * 2 + (reverseArray[0] + reverseArray[1]) * 2;
}

// https://programmers.co.kr/learn/courses/30/lessons/43104
