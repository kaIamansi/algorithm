// Recommended: (Fibo(n)+Fibo(n+1))*2
// temp 변수대신 배열을 이용하고, shift()로 대입해준다.
function solution(N) {
  let arr = [1, 2];

  for (let i = 2; i < N; i++) {
    arr[2] = arr[0] + arr[1];
    arr.shift();
  }

  return (arr[0] + arr[1]) * 2;
}

// (Fibo(n)+Fibo(n+1))*2
// temp 변수를 이용한 교환 방법
function solution2(N) {
  let prev = 1;
  let now = 1;
  let temp = 0;

  for (let i = 1; i < N; i++) {
    temp = now;
    now = prev + now;
    prev = temp;
  }

  return 2 * (now + prev);
}

// Other: Fibo(n+2)*2
function solution3(N) {
  let prev = 1;
  let now = 1;
  let temp = 0;

  for (let i = 0; i < N; i++) {
    temp = now;
    now = prev + now;
    prev = temp;
  }

  return 2 * now;
}

// https://programmers.co.kr/learn/courses/30/lessons/43104
