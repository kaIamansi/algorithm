function solution(skill, skill_trees) {
    let compare = '', result = '';
    let count = 0;
    
    for (let i=0; i<skill_trees.length; i++) {
        compare = skill_trees[i];
        result = '';
        
        for (let j=0; j<compare.length; j++) 
            if (skill.search(compare[j]) != -1)
                result += compare[j];
        
        if (skill.search(result) == 0) 
            count++;
    }
    
    return count;
}