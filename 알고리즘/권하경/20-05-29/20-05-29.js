function solution(skill, skill_trees) {
  let answer=0;
  skill_trees.forEach(element => {
    let index=0;
    for(let i in element){
      if(element[i]==skill[index])  index++;
      else if(element[i]!=skill[index]&&skill.includes(element[i]))  break;
      if(i==element.length-1||index==skill.length-1) {
        answer++;
        break;
      }
    }
  });
  return answer;
}

console.log(solution(	"CBD",["BACDE", "CBADF", "AECB", "BDA"]));

