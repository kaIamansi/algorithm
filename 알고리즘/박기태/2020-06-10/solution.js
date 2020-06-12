function solution(n, computers) {
    let answer = 0;
    
    const checked = []; // 방문 여부 배열
    checked.fill(false, 0, computers.length - 1); // false로 초기화
    
    function DFS(idx){
        checked[idx] = true; // 현재 컴퓨터 방문 처리
        // 방문하지 않았으면서 연결 되어 있는 컴퓨터에 방문
        for(let i = 0; i < computers.length; i++)
            if(!checked[i] && computers[idx][i])
                DFS(i);
    }
    
    for(let i = 0; i < computers.length; i++) {
        if(!checked[i]) { // 방문하지 않았을 때만 실행
            answer++; // 네트워크 개수 + 1
            DFS(i); // DFS
        }
    }

    return answer;
}
