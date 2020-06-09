const findIndexs = (array, findItem) => [array.indexOf(findItem-1), array.indexOf(findItem+1)]

function solution(n, lost, reserve) {
    // 여분의 옷을 가진 학생이 옷을 잃어버렸을 경우
    for(let i = 0; i<lost.length; i++) {
        let idx = reserve.indexOf(lost[i]); // reserve 배열에서 lost 원소의 위치를 찾는다.
        if(idx !== -1) { // 원소가 있으면 각각의 배열에서 해당 원소를 제거한다.
            reserve.splice(idx, 1);
            lost.splice(i, 1);
            i--; // 제거하면 뒤에 원소 index가 앞으로 당겨지기 때문에 맞춰주기 위해tj i-1을 해준다.
        }
    }
    
    // 옷을 빌려 입는 경우
    for(let i = 0; i<lost.length; i++) {
        let idxs = findIndexs(reserve, lost[i]);
        idxs.forEach(idx => {
            if(idx !== -1) {
                reserve.splice(idx, 1);
                lost.splice(i, 1);
                i--;
            }
        })
    }
    // lost배열에서 reserve배열의 원소를 제거했기 때문에 
    return n - lost.length; // n-lost.length를 하면 최댓값을 구할 수 있다.
}
