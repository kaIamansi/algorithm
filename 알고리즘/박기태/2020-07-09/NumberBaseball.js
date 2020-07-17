function strike(cur, target, num) { // 스트라이크인지 판별
    let temp = 0;

    for (let i = 0; i < 3; i++)
        if (String(cur)[i] === String(target)[i]) temp++;
    
    return temp === num;
}


function ball(cur, target, num) { // 볼인지 판별
    let temp = 0;

    for (let i = 0; i < 3; i++)
        if (String(cur).indexOf(String(target)[i]) >= 0) temp++;

    return temp === num;
}

function solution(baseball) {
    var answer = 0;
    var numbers = [];
    
    // 모든 세 자리 수 생성
    for(let i = 1; i < 10; i++)
        for(let j = 1; j < 10; j++)
            for(let k = 1; k < 10; k++)
                if(k !== i && k !== j && i !== j)
                    numbers.push(i * 100 + j * 10 + k);
    
    for(let i = 0; i < numbers.length; i++) {
        let flag = true;
        
        for (let j = 0; j < baseball.length; j++) {
            let s = strike(numbers[i], baseball[j][0], baseball[j][1]);
            let b = ball(numbers[i], baseball[j][0], baseball[j][1] + baseball[j][2]);
            // 일치하는 숫자를 찾는 것임으로 스트라이크 + 볼의 갯수만큼 찾도록 한다.
             
            if (!s || !b) {
                 flag = false;
                 break;
             }
        }
        if(flag) answer++;
    }
    return answer;
}
