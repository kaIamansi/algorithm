function solution(n, lost, reserve) {
  let lost_obj = {}
  let reserve_obj = {}
  lost.forEach(el => lost_obj[el] = true)
  reserve.forEach(el => reserve_obj[el] = true) 
  lost.forEach(el => {
      if(reserve_obj[el] === true) {
          delete lost_obj[el];
          delete reserve_obj[el];
      }
      else if(reserve_obj[el - 1] === true && lost_obj[el - 1] !== true) {
          delete lost_obj[el];
          delete reserve_obj[el - 1];         
      }
      else if(reserve_obj[el + 1] === true && lost_obj[el + 1] !== true) {
          delete lost_obj[el];
          delete reserve_obj[el + 1];         
      }
  })    
  return n - Object.keys(lost_obj).length;
}