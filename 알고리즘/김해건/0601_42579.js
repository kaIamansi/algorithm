function solution(genres, plays) {
    let max = 0;
    let sum = new Array();
    let result = new Array();
    let bestGenres = new Array();
    let bestPlays = new Array();
    
    let filtered = genres.filter((item, index) => genres.indexOf(item) == index);
    // 장르에서 중복되는 장르를 제거하여 배열 생성
    
    for (let i=0; i<filtered.length; i++)
        sum[i] = 0;
    // 장르의 수만큼 배열 생성
    
    for (let i=0; i<filtered.length; i++)
        for (let j=0; j<genres.length; j++) 
            if (filtered[i] == genres[j]) 
                sum[i] += plays[j];
    // sum 배열에 장르의 인덱스에 맞춰 재생 수를 저장

    for (let i=0; i<filtered.length; i++) {
        bestGenres.push(filtered[sum.indexOf(Math.max.apply(null, sum))]);
        sum.splice(sum.indexOf(Math.max.apply(null, sum)), 1);
    }
    console.log(bestGenres);
    // 재생 수가 많은 순으로 장르를 저장
    
    for (let i=0; i<bestGenres.length; i++) {
        for (let j=0; j<genres.length; j++) {
            if (bestGenres[i] == genres[j] && plays[j] >= max) {
                result.push(plays.indexOf(plays[j]));
                max = plays[j];
            }
        }
        max = 0;
    }
    // 재생 수가 가장 많은 노래의 고유 번호를 bestPlays에 저장

    return result;
}