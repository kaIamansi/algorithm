function solution(participant, completion) {       
    /* 
    let answer = participant.filter(function(name) {
         return !completion.includes(name)
     });
    
    return answer.pop(); 
    */
    
    let answer = participant.sort();
    let remove = completion.sort();
    
    for (let i=0; i<answer.length; i++) {
        if (answer[i] != remove[i]) {
            return answer[i];
        }
    }
}