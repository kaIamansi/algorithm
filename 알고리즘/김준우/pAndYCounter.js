function solution(s) {
  const answerObj = [...s.toUpperCase()].reduce(
    (acc, d) => {
      if (d === "Y" || d === "P") {
        return { ...acc, [d]: acc[d] + 1 };
      }
      return acc;
    },
    { P: 0, Y: 0 }
  );

  return answerObj.P === answerObj.Y ? true : false;
}

// https://programmers.co.kr/learn/courses/30/lessons/12916
