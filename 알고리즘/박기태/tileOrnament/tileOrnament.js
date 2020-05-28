// 초기에 작성한 코드 최적화
function solution(N) {
  const arr = [1, 1];

  for (let i = 0; i < N; i++) {
    arr.push(arr[0] + arr[1]);
    arr.shift();
  }
  return arr.pop() * 2; // arr[N+1] * 2
}

// Recommended & 20%~ Fast
function solution(N) {
  const arr = [1, 1];

  for (let i = 0; i < N; i++) arr.push(arr[i] + arr[i + 1]);

  return arr.pop() * 2; // arr[N+1] * 2
}

// https://programmers.co.kr/learn/courses/30/lessons/43104
