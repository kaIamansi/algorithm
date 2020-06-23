function solution(begin, target, words) {
    const checked = [];
    const queue = [[begin, 0]];
    
    while(queue.length > 0) {
        const [cur, acc] = queue.shift();
        
        if(cur === target) return acc;

        words.forEach(word => {
            if(!checked.includes(word)) {
                let again = 0;
                
                for(let i = 0; i < cur.length; i++){
                    if(cur[i] !== word[i]) {
                        again++;
                        
                        if(again > 1) break;
                    }
                }
                
                if(again < 2) queue.push([word, acc+1]);
            }
        }, checked.push(cur));
    }
    
    return 0;
}
