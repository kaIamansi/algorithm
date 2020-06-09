function solution(n, losts, reserves) {
  const lost = [...losts];
  const reserve = [...reserves];

  losts.forEach((v) => {
    if (reserve.includes(v)) {
      lost.splice(lost.indexOf(v), 1);
      reserve.splice(reserve.indexOf(v), 1);
    }
  });

  [...lost].forEach((v) => {
    if (reserve.includes(v + 1) || reserve.includes(v - 1)) {
      if (reserve.includes(v + 1) && reserve.includes(v - 1)) {
        reserve.splice(reserve.indexOf(v - 1), 1);
        lost.splice(lost.indexOf(v), 1);
        return true;
      }

      if (!reserve.includes(v + 1) && !reserve.includes(v - 1)) {
        return true;
      }

      if (reserve.indexOf(v - 1)) {
        reserve.splice(reserve.indexOf(v - 1), 1);
        lost.splice(lost.indexOf(v), 1);
      } else {
        reserve.splice(reserve.indexOf(v + 1), 1);
        lost.splice(lost.indexOf(v), 1);
      }
    }
  });

  return n - lost.length;
}

// https://programmers.co.kr/learn/courses/30/lessons/42862
