function solution(priorities, location) {
    let answer = 1;
    
    while (priorities.length !== 0) {
        let first = priorities.shift(); // 가장 앞에 문서를 대기목록에서 꺼냄
        // 뒤에 중요도가 높은 문서기 있는지 확인
        if (priorities.some((targ, idx) => targ > first)) priorities.push(first); // (있으면) 꺼낸 문서를 대기목록 가장 마지막에 넣음
        else if (location !== 0) answer++; // 요청한 문서가 맨 앞에 있지 않으면 일단 다른 문서를 출력하기 때문에 +1 함 
        else break; // 맨 앞에 있으면 중단
        
        if (location !== 0) location--; // 요청한 문서가 맨 앞에 있지 않을 때 앞문서를 꺼냈기 때문에 location index를 -1 함
        else location = priorities.length - 1; // 맨 앞문서가 요청한 문서라면 대기목록 가장 마지막으로 넣음 
    }
    
    return answer;
}
