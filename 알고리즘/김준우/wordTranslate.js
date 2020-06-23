function solution(begin, target, words) {
  if (!words.includes(target)) return 0;
  const result = [];

  function bfs(begin, words, count) {
    const queue = [];

    words.forEach((word, index) => {
      const wordCount = word
        .split("")
        .reduce((acc, v, i) => (begin[i] !== v ? acc + 1 : acc), 0);

      if (wordCount === 1) {
        if (word === target) {
          result.push(count + 1);
          return;
        }

        const dummy = [...words];
        dummy.splice(index, 1);
        queue.push({ word, dummy });
      }
    });

    if (queue.length) {
      ++count;
      queue.forEach((v) => {
        bfs(v.word, v.dummy, count);
      });
    }
  }

  bfs(begin, words, 0);

  return result.sort((a, b) => a - b)[0];
}

// https://programmers.co.kr/learn/courses/30/lessons/43163
