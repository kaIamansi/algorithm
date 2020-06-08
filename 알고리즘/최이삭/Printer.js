function Print(priorities, location) {
  let copy = [...priorities].slice(1);
  let print = 0;
  if(priorities.find(el => el > priorities[0]) === undefined) {
      if(location === 0) return 1;
      else print = Print(copy, location - 1) + 1;
  }
  else {
      if(location === 0) print = Print(copy.concat([...priorities].shift()), copy.length)
      else print = Print(copy.concat([...priorities].shift()), location - 1)
  }
  return print;
}

function solution(priorities, location) {
  return Print([...priorities], location)
}