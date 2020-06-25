function solution(stones, k) {
    let answer = 0;
    let off = false;
    
    for(let i =0; i<200000; i++) {
        let pass = 0;
        
        stones = stones.map(stone => {    
            if(stone === 0) {
                pass++;
                
                if(pass === k) off = true;
                
                return stone;
            }

            pass = 0;
            
            return stone-1;
        });
        
        if(off) break;
        
        answer++
    }
    
    return answer;
}
