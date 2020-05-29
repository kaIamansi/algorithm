/* 처음 - 효율성 0점(시간초과)
  - 전체 사람중에서 완주한 사람을 주어진 배열 앞에서부터 삭제를 반복하고 남은 사람을 반환
  - 문자열 비교를 수없이 반복. 데이터가 적으면 빠르다.
정확성  테스트
  테스트 1 〉	통과 (1.67ms, 37.5MB)
  테스트 2 〉	통과 (1.66ms, 37.7MB)
  테스트 3 〉	통과 (1.87ms, 37.5MB)
  테스트 4 〉	통과 (2.71ms, 37.7MB)
  테스트 5 〉	통과 (2.63ms, 37.7MB)
효율성  테스트
  테스트 1 〉	실패 (시간 초과)
  테스트 2 〉	실패 (시간 초과)
  테스트 3 〉	실패 (시간 초과)
  테스트 4 〉	실패 (시간 초과)
  테스트 5 〉	실패 (시간 초과)
*/
function solution(participant, completion) {
  completion.filter((name) => participant.splice(participant.indexOf(name), 1));
  return participant[0];
}



/* 두번째 - 효율성 통과
  - sort를 통해 정렬하여 문자열 비교 횟수를 N번으로 줄였다.
  - 단, 가장 큰 문제점으로는 데이터가 많아지면 sort시간이 폭주한다.
정확성  테스트
  테스트 1 〉	통과 (2.10ms, 37.4MB)
  테스트 2 〉	통과 (2.08ms, 37.4MB)
  테스트 3 〉	통과 (3.19ms, 37.5MB)
  테스트 4 〉	통과 (6.12ms, 37.9MB)
  테스트 5 〉	통과 (6.81ms, 37.8MB)
효율성  테스트
  테스트 1 〉	통과 (97.06ms, 53.5MB)
  테스트 2 〉	통과 (135.98ms, 61.1MB)
  테스트 3 〉	통과 (167.93ms, 68MB)
  테스트 4 〉	통과 (189.75ms, 70.1MB)
  테스트 5 〉	통과 (181.21ms, 70.1MB)
*/
function solution(participant, completion) {
  participant.sort();
  completion.sort();

  for (let i = 0; i < participant.length; i++)
    if (participant[i] !== completion[i]) return participant[i];
}



/* 세번째 - 최종
  - 완주한 사람을 [Kang: 1, Roh: 2, Kim: 1, Cho: 2] 카운팅 하고
  - 전체 사람을 순회하면서 카운팅한 배열에서 1씩 뺀다.
  - 만약, 배열에 없거나 count가 0이되면 완주하지 못한 사람으로 반환
정확성  테스트
  테스트 1 〉	통과 (1.64ms, 37.4MB)
  테스트 2 〉	통과 (1.66ms, 37.5MB)
  테스트 3 〉	통과 (1.89ms, 37.6MB)
  테스트 4 〉	통과 (2.05ms, 37.6MB)
  테스트 5 〉	통과 (1.94ms, 37.4MB)
효율성  테스트
  테스트 1 〉	통과 (17.57ms, 53.4MB)
  테스트 2 〉	통과 (22.70ms, 61.2MB)
  테스트 3 〉	통과 (25.08ms, 68MB)
  테스트 4 〉	통과 (27.81ms, 70.2MB)
  테스트 5 〉	통과 (34.78ms, 70.3MB)
*/
function solution(participant, completion) {
  let completionCount = [];

  completion.forEach(cName =>
    completionCount[cName] = (completionCount[cName] | 0) + 1);

  return participant.find(name => !completionCount[name]-- !== false);
}



/* 아래는 코드라인 줄이는 뻘 짓. 수행시간은 동일*/

// Array.prototype.find()의 두번째 인자로 먼저 수행할 함수를 집어 넣음
function solution(participant, completion) {
  let completionCount = [];

  return participant.find(
    name => !completionCount[name]-- !== false,
    completion.forEach(cName => {
      completionCount[cName] = (completionCount[cName] | 0) + 1;
    })
  );
}

// 완주한 사람 count할 배열을 따로 생성하지 않고 기존 배열을 이용
function solution(participant, completion) {
  return participant.find(
    name => !completion[name]-- !== false,
    completion.forEach(cName => completion[cName] = (completion[cName] | 0) + 1)
  );
}

// 1줄짜리(개행 안할시)
const solution = (participant, completion) =>
  participant.find(
    name => !completion[name]-- !== false,
    completion.forEach(cName => completion[cName] = (completion[cName] | 0) + 1)
  );
