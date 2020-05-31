function isExist(arr, data) {
  if(arr instanceof Array) {
      return [...arr].concat({...data})
  }
  else {
      return [].concat({...data})
  }
}

function summit(arr) {
  let sum = 0;
  
  arr.forEach(el => {
    sum += el.play;  
  })
  
  return sum;
}

function solution(genres, plays) {
  let answer = [];
  let genreMap = {}
  let sorted = []
  
  for(let i =  0; i < genres.length; i++) {
      genreMap[genres[i]] = isExist(genreMap[genres[i]], {
          i, 
          play: plays[i]
      })
  }
  
  for(let copiedGenre in genreMap) {
      genreMap[copiedGenre].sort((_1, _2) => {
          return _2.play - _1.play
      })
  }
  
  for(let copiedGenre in genreMap) {
      sorted.push({genre: copiedGenre, max: summit(genreMap[copiedGenre])})
  }
  
  sorted.sort((_1, _2) => {
      return _2.max - _1.max
  })
  
  for(let el of sorted) {
      if(genreMap[el.genre].length > 1) {
          answer.push(genreMap[el.genre][0].i, genreMap[el.genre][1].i)
      }
      else {
          answer.push(genreMap[el.genre][0].i)
      }
  }

  return answer;
}