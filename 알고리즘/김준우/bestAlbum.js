const sum = (arr) => arr.reduce((result, v) => result + v, 0);
const findIndex = (arr, find) => arr.findIndex((v) => v === find);

function solution(genres, plays) {
  const answer = [];
  const rank = [];
  const newGenres = genres.reduce((acc, v, i) => {
    let dummyAcc = acc;
    const data = dummyAcc[v] || [];

    data.push(plays[i]);
    dummyAcc[v] = data;

    return dummyAcc;
  }, {});

  for (let i in newGenres) {
    newGenres[i] = newGenres[i].sort((a, b) => b - a);
    rank.push({ genres: i, count: sum(newGenres[i]) });
  }

  rank.sort((a, b) => b.count - a.count);

  rank.forEach((v) => {
    answer.push(findIndex(plays, newGenres[v.genres][0]));

    if (newGenres[v.genres][1]) {
      answer.push(
        plays
          .map((d, i) => (d === newGenres[v.genres][1] ? i : ""))
          .filter(String)
          .sort((a, b) => b - a)[0]
      );
    }
  });

  return answer;
}

// https://programmers.co.kr/learn/courses/30/lessons/42579
