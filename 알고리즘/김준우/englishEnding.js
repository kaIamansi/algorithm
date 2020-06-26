function convertArrayTo2d(arr, n) {
  const newArray = [];
  while (arr.length) {
    newArray.push(arr.splice(0, n));
  }
  return newArray;
}

function solution(n, words) {
  let outString = "";
  let answer = [];

  for (let i = 1; i < words.length; i++) {
    const prevWord = words[i - 1];
    const case1 = prevWord.charAt(prevWord.length - 1) !== words[i].charAt(0);
    const case2 = words.findIndex((v) => v === words[i]) !== i;

    if (case1 || case2) {
      outString = words[i];
      words.splice(i + 1, words.length - 1);
      break;
    }
  }

  if (outString) {
    const array = convertArrayTo2d(words, n);

    for (let i in array) {
      for (let j in array[i]) {
        console.log(i, j);
        if (array[i][j] === outString) {
          answer = [Number(j) + 1, Number(i) + 1];
          break;
        }
      }
    }
  }

  return answer.length === 0 ? [0, 0] : answer;
}

// https://programmers.co.kr/learn/courses/30/lessons/12981
