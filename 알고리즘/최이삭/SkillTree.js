function solution(skill, skill_trees) {
  var answer = 0;
  let arr = skill.split("")
  let replaced_skill_trees = []
  let cnt = 0;
  let flag = true;
  skill_trees.forEach((el, idx) => {
      replaced_skill_trees[idx] = el;
      cnt = 0
      arr.forEach(char => {
          replaced_skill_trees[idx] = replaced_skill_trees[idx].replace(char, cnt++)
      })
  })
      
  for(let i = 0; i < replaced_skill_trees.length; i++) {
      flag = true
      cnt = 0
      for(let j = 0; j < replaced_skill_trees[i].length; j++) {
          let num = parseInt(replaced_skill_trees[i][j])
          if(!isNaN(num) && num === cnt) {
              cnt++
              if(num === arr.length - 1) {
                  break;
              }
          }
          else if(isNaN(num)) {
              continue;
          }
          else {
              flag = false
              break;
          }
      }
      if(flag === true) {
          answer++;
      }
  }
  return answer;
}