function solution(genres, plays) {
    let answer = [];
    const genresCount = new Map();
    const musics = [];

    genres.forEach((genre, idx) => {
        genresCount.get(genre) ?
            genresCount.set(genre, genresCount.get(genre) + plays[idx])
            : genresCount.set(genre, plays[idx])

        musics[idx] = { genre: genre, plays: plays[idx], idx: idx };
    });

    musics.sort(DownSortMusic);

    [...genresCount].sort(DownSortGenre).forEach(item => {
        let temp = [];

        musics.forEach(({ genre, idx }) => {
            if (genre === item[0]) temp.push(idx);
        });

        answer = answer.concat(temp.slice(0, 2));
    });

    return answer;
}

const DownSortGenre = (a, b) => b[1] - a[1];
const DownSortMusic = (a, b) => b.plays - a.plays;