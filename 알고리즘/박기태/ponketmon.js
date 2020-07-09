function solution(nums) {
    let answer = 0;
    let set = new Set();
    
    for(const number of nums) set.add(number);
    
    if(set.size < nums.length/2) answer = set.size;
    
    else answer = nums.length/2;

    return answer;
}
