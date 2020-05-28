function solution(participant, completion) {
  const partSort = participant.sort();
  const compSort = completion.sort();

  for (let i = 0; i < partSort.length; i++) {
    if (compSort[i] === undefined || partSort[i] !== compSort[i])
      return partSort[i];
  }
}

// https://programmers.co.kr/learn/courses/30/lessons/42576
