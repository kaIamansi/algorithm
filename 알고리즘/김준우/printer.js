function solution(priorities, location) {
  const locationArray = priorities.map((data, index) => ({
    docs: data,
    location: index,
  }));

  let i = 0;

  while (true) {
    for (let j = i; j < locationArray.length; j++) {
      if (locationArray[i].docs < locationArray[j].docs) {
        locationArray.push(...locationArray.splice(i, 1));
        break;
      }
      if (
        locationArray.length - 1 === j &&
        locationArray[i].docs >= locationArray[j].docs
      ) {
        i++;
      }
    }

    if (i === locationArray.length - 1) {
      break;
    }
  }

  return locationArray.findIndex((data) => data.location === location) + 1;
}

// https://programmers.co.kr/learn/courses/30/lessons/42587
