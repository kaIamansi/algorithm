// 완성 코드
function solution(skill, skill_trees) {
    return skill_trees.length - skill_trees.filter(skill_tree => {
        let check = false;
        let prev = -1; // 스킬 index는 0이상. 처음엔 prev에 저장되도록 -1 설정

        for (let i = 0; i < skill.length; i++) {
            let temp = skill_tree.indexOf(skill[i]);

            if (temp === -1) check = true;
            else if (check === true || temp < prev) return true; // 폐기처리
            else prev = temp;
        }
    }).length;
}
/*
    filter()는 배열 등을 순회하면서 인자로 콜백함수를 받고 
    콜백함수에서 true로 반환되면 순회중인 데이터를 반환될 배열에 넣는다.
    > 폐기된 스킬트리들을 배열로 반환하고 배열의 길이로 개수를 구한다.
*/



// 처음 코드(동작은 같음)
function solution(skill, skill_trees) {
    let answer = skill_trees.length;

    skill_trees.forEach(skill_tree => {
        let check = false;
        let prev = -1;

        for (let i = 0; i < skill.length; i++) {
            let temp = skill_tree.indexOf(skill[i]);

            if (temp === -1) check = true;
            else {
                if (check === true || temp < prev) {
                    answer -= 1;
                    break;
                }
                prev = temp; // else prev = temp;
            }
        }
    });
    return answer;
}