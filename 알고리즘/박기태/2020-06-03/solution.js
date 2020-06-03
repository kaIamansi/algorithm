function solution(n) {
    let answer = [0, 0, 1]; // 기본값 & 2일때 [0, 0, 1] 반환
    if (n === 1) return [0]; // 1일때 [0] 반환

    for (let i = 0; i < n - 2; i++)
        answer = answer.concat(0, answer.map(x => !x | 0).reverse());
    // 'answer 배열'에 '0'과 'answer에서 0과 1을 반전시키고(map(x => !x | 0)) 뒤집은 배열(reverse())'을 이어 붙여(concat()) answer에 대입
    return answer;
}