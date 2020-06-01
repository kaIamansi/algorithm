const DownSortGenre = (a, b) => b[1] - a[1];
const DownSortMusic = (a, b) => b.plays - a.plays;

function solution(genres, plays) {
    let answer = [];
    const genresCount = new Map();
    const musics = [];

    genres.forEach((genre, idx) => {
        if (genresCount.get(genre)) {
            genresCount.set(genre, genresCount.get(genre) + plays[idx]);
            musics[genre].push({ idx, plays: plays[idx] });
        } else {
            genresCount.set(genre, plays[idx]);
            musics[genre] = [{ idx, plays: plays[idx] }];
        }
    });

    [...genresCount].sort(DownSortGenre).forEach(item => {
        answer = answer.concat(musics[item[0]].sort(DownSortMusic).map(x => x.idx).slice(0, 2));
    });

    return answer;
}

//

const DownSortGenre = (a, b) => b[1] - a[1];
const DownSortMusic = (a, b) => b.plays - a.plays;

function solution(genres, plays) {
    let answer = [];
    const genresCount = new Map();
    const musics = [];

    genres.forEach((genre, idx) => {
        if (genresCount.get(genre)) {
            genresCount.set(genre, genresCount.get(genre) + plays[idx]);
            musics[genre].push({ idx, plays: plays[idx] });
        } else {
            genresCount.set(genre, plays[idx]);
            musics[genre] = [{ idx, plays: plays[idx] }];
        }
    });

    answer = answer.concat(...[...genresCount].sort(DownSortGenre).map(item =>
        musics[item[0]].sort(DownSortMusic).map(x => x.idx).slice(0, 2)));

    return answer;
}