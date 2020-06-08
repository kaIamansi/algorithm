function Print(priorities, location) {
  let copy = [...priorities].slice(1);
  if(priorities.find(el => el > priorities[0]) === undefined) {
      if(location === 0) return 1; // 같으면 1 리턴
      else return Print(copy, location - 1) + 1; // Print 재귀 호출 후 나온 리턴 값에 1 더함.
  }
  else {
      if(location === 0) return Print(copy.concat([...priorities].shift()), copy.length)
      else return Print(copy.concat([...priorities].shift()), location - 1)
  }
}

function solution(priorities, location) {
  return Print([...priorities], location)
}