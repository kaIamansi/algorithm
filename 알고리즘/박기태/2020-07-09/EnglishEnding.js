function solution(n, words) {
    var out = false;
    
    for(var i = 1; i<words.length; i++){
        // 현재 단어 첫 글자와 이전 단어의 끝 글자가 다른지 비교
        // || 앞에서부터 현재단어와 중복되는 단어 탐색하여 햔재 위치와 다른지 확인 
        if((words[i].slice(0, 1) != words[i-1].slice(-1)) || (i != words.indexOf(words[i]))) {
            out = true;
            break;
        }
    }
    
    return out
            ? [(i%n) + 1, parseInt(i/n) + 1]
            : [0, 0];
}
