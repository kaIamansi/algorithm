## 2020-06-26

```Javascript
function solution(arr, divisor) {
    let answer = [];
    
    answer = arr.filter(item => item % divisor == 0);
    answer.sort((a,b) => a - b );
    
    if (answer == 0)
        answer.push(-1);
    
    return answer;
}
```

### 풀이

1. filter를 이용하여 divisor로 나누어지는 요소들만 answer에 담는다.
2. sort를 이용하여 정렬하는데 js는 ASCII 기준으로 정렬되기 때문에 함수를 설정해주어 크기 순으로 정렬한다.
3. 만약 배열에 아무것도 없다면 -1을 추가한다. 

## 2020-06-24

```Javascript
function solution(progresses, speeds) {
    let answer = [];
    let day = 0;
    
    for (let i=0; i<progresses.length; i++){
        let needDay = Math.ceil((100-progresses[i])/speeds[i]);
        
        if (needDay > day){
            day = needDay;
            answer.push(1);
        }
        else
            answer[answer.length-1]++;
    }
    
    return answer;
}
```

### 난관

- 필요한 개발 일수를 순차적으로 비교하여 카운트를 올리는 방법을 고민했다.
  - day라는 변수를 만들어 계속 비교하는 방법으로 해결했다.

### 풀이

1. Math.ceil을 이용해서 100에서 progresses를 빼고 speeds로 나누어 필요한 개발 일수를 구한다.
2. 필요한 개발 일수를 순차적으로 비교한다.
3. 필요한 개발 일수가 그 전 단계 일수보다 크다면 day에 저장하고 answer 배열에 1을 추가 한다.
4. 다른 경우에는 현재 머물러 있는 answer의 index에 카운트만 올려준다.


## 2020-06-23

```Javascript
function solution(arr) {
    let answer = new Array();

    answer = arr.filter((item, index, array) => {
        return item != array[index+1];
    });

    return answer;
}
```

### 풀이

1. filter를 사용하여 다음 인덱스 번호와 다른 요소만 담았다.

## 2020-06-09

```Javascript
function solution(array, commands) {
    let arr = [];
    let temp = [];
    
    commands.forEach((item, index) => {
        temp = array.slice(item[0]-1, item[1]);
        temp.sort((a, b) => a - b);
        arr.push(temp[item[2]-1]);
    })
    
    return arr;       
}
```

### 풀이

1. forEach를 사용해서 각 요소에 접근했다.
2. 요소에서 slice를 사용해서 인덱스 번호에 맞게 잘라냈다.
3. 내림차순으로 정렬한 후 인덱스 번호에 해당하는 요소를 arr 배열에 담았다.

## 2020-06-02

```Javascript
function solution(board, moves) {
    let order = new Array();
    let newBoard = new Array();
    let dolls = new Array();

    for(let i=0; i<board.length; i++) {
        for(let j=0; j<board.length; j++)
            order.push(board[j][i]);
        newBoard.push(order);
        order = [];
    }
    // 열을 기준으로 인형을 세는 배열 생성

    for (let i=0; i<moves.length; i++) {
        dolls.push(newBoard[moves[i]-1].find(item => { return item !=0 }));
        newBoard[moves[i]-1].splice(newBoard[moves[i]-1]
        .findIndex(item => item != 0 ), 1, 0);
    }

    let filtered = dolls.filter(item => item != undefined);
    let answer = filtered.length;

    for (let i=0; i<filtered.length; i++) {
        filtered.forEach((item,index,arr) => {
        if (item == arr[index+1])
            arr.splice(index, 2);
        });
    }

    return answer - filtered.length;
}
```

### 풀이

1. 행 기준의 인형을 열 기준으로 바꿨다.
2. 0이 아닌 숫자를 순서대로 가져온다.
3. 순서대로 가져온 인형 중 연속으로 중복된 요소는 삭제한다.
4. 총 인형 수와 남은 인형 수를 뺀다.

## 2020-06-01

```Javascript
ffunction solution(genres, plays) {
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
    // 재생 수가 많은 순으로 장르를 저장

    for (let i=0; i<bestGenres.length; i++) {
        for (let j=0; j<genres.length; j++) {
            if (bestGenres[i] == genres[j] && plays[j] >= max) {
                result.push(plays.indexOf(plays[j]));
                max = plays[j];
            }
        }
    }
    // 재생 수가 많은 순으로 노래의 고유 번호를 result에 저장

    return result;
}
```

### 난관

- 두 배열을 두고 서로의 인덱스 번호를 공유하면서 문제를 해결하려고 하니 복잡했다.
- 장르 별로 재생 수가 가장 많은 곡 두 개만 뽑으려는 방법을 어떻게 해야할지 몰라 고민했다.
  - 2차원 배열로 정렬하여 해결하는 방법을 찾았다.

### 풀이

1. genres에서 중복되는 것들을 제거하여 장르의 수를 파악했다.
2. 각 장르의 총 재생 수를 sum 배열에 넣었다.
3. sum을 바탕으로 재생 수가 많은 순으로 장르를 bestGenres에 저장
4. 마지막으로 재생 수가 많은 노래 순으로 정렬하려고 했으나 실패하였다.

### 해결하지 못함

## 2020-05-29

```Javascript
function solution(skill, skill_trees) {
    let compare = '', result = '';
    let count = 0;

    for (let i=0; i<skill_trees.length; i++) {
        compare = skill_trees[i];
        result = '';

        for (let j=0; j<compare.length; j++)
            if (skill.search(compare[j]) != -1)
                result += compare[j];

        if (skill.search(result) == 0)
            count++;
    }

    return count;
}
```

### 난관

- 첫번째 방법으로 배열안의 문자열을 배열화하고 스킬트리를 문자열해서 서로 비교하려고 했다.
  - 그러나 너무 복잡하고 비효율적인 방법인 것 같아 다른 방법을 찾았다.
- 두번째 방법으로 replace 함수를 사용해서 skill_trees 안의 요소에서 skill의 요소들이 없다면 지우고 그 후 남아있는 요소들의 순서를 비교하려고 했다.
  - 그러나 지우는 과정이 복잡하고 그 후 남은 요소들끼리의 비교도 복잡하여 마지막 방법을 생각해냈다.

### 풀이

1. 배열에서 각 문자열들을 하나씩 꺼낸다. (compare에 하나씩 저장)
2. 꺼낸 문자열에서 skill에 해당하는 문자들만 추출한다. (search 함수를 사용하여 판별)
3. 추출한 문자들이 skill과 같거나 순서에 맞게 배열되어 있다면 count를 올린다. (search함수를 사용하여 판별)

### 부가 설명

- **skill.search(compare[j]) != -1**
  - -1이라면 포함되어 있지 않다는 뜻이기 때문에 -1만 아니면 포함되어 있음을 알 수 있다.
- **skill.search(result) == 0**
  - 0인 이유는 result가 skill의 순서에 맞게 추출되어 있기 때문에 search를 통해 찾게 되면 인덱스 값은 0이 나오기 때문이다.

## 2020-05-28

```Javascript
function solution(participant, completion) {
    /*
    let answer = participant.filter(name => return !completion.includes(name));

    return answer.pop();
    */

    let result = participant.sort();
    let done = completion.sort();

    for (let i=0; i<result.length; i++)
        if (result[i] != done[i])
            return result[i];
}
```

### 난관

- 처음엔 두 배열을 합쳐서 중복제거 하려고 했다.
  - 그러나 동명이인의 문제를 해결하지 못해 다른 방법을 모색하였다.

### 풀이

1. 두 배열을 정렬한다.
2. 두 배열을 순서대로 비교하여 서로 같지 않는다면 완주자가 아님으로 반환한다.
3. 동명이인의 문제는 같은 이름이 두명이므로 첫번째는 통과하지만 두번째 사람은 통과되지 못하므로 해결된다.

## 2020-05-27

```Javascript
function solution(N) {
    let arr = [1,1];

    for (var i=2; i<N; i++)
        arr.push(arr[i-1]+arr[i-2]);

    return (arr[N-1]*4) + (arr[N-2]*2);
}
```

### 난관

- js에서 배열에 요소를 추가하는 방법을 몰랐다.
  - push 함수를 알고 적용하였다.

### 풀이

1. 피보나치 알고리즘과 같은 문제 접근했다.
2. 생성한 배열에 피보나치 수열 알고리즘으로 배열에 요소를 추가한다.
3. N-1(가장 마지막에 생성한 타일)의 둘레와 N-2(그 전 타일)의 두 변의 길이를 더한다.

## 2020-05-26

```Javascript
function solution(s) {
    let answer = '';

    if (s.length%2 == 0)
        answer = s.substr((s.length/2)-1,2);
    else
        answer = s.substr(s.length/2,1);

    return answer;
}
```

### 난관

- js에서 문자를 추출하는 함수를 몰랐다.
  - substr과 splice 함수를 공부하여 해결하였다.

### 풀이

1. 홀수와 짝수를 구분한다.
2. substr로 시작위치와 자를 크기를 정해준다.
3. 짝수는 가운데 2글자를 추출하기 위해 시작위치를 1 뺴준다.
4. answer에 저장 후 반환한다.

## 2020-05-25

```Javascript
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
```

### 풀이
1. toLowerCase를 이용해 문자열을 모두 소문자로 만든다.
2. match를 이용해 y와 p를 찾고 각각의 변수에 저장한다. 
2. 그 후 y와 p의 배열 길이를 구해 같으면 true를 반환하고 아니면 false를 반환한다. 

### 난관
- js는 처음이라 여러 함수를 찾으면 해결했다.
