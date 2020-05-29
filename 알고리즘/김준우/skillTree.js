function solution(skill, skill_trees) {
  let answer = 0;

  skill_trees.forEach((skillTree) => {
    const newSkillTree = [...skillTree]
      .filter((d) => skill.includes(d))
      .join("");
    let checker = true;

    for (let i = 0; i < newSkillTree.length; i++) {
      if (newSkillTree[i] !== skill[i]) {
        checker = false;
      }
    }

    if (checker) answer++;
  });

  return answer;
}

// https://programmers.co.kr/learn/courses/30/lessons/49993
