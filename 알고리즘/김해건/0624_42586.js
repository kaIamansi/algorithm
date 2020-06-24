function solution(progresses, speeds) {
    let answer = [];
    let day = 0;
    
    for (let i=0; i<progresses.length; i++){
        let needDay = Math.ceil((100-progresses[i])/speeds[i]);
        
        if (needDay > day){
            day = needDay;
            answer.push(1);
        }
        else
            answer[answer.length-1]++;
    }
    
    return answer;
}