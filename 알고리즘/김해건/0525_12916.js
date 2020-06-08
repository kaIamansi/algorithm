function solution(s){
    let lower = s.toLowerCase();
    let y = 0, p = 0;
    
    y = lower.match(/y/g);
    p = lower.match(/p/g);

    if(y.length == p.length)
        return true;
    else
        return false;
} 