# algorithm workspace

## 20/05/30

```javascript
function solution(genres, plays) {
  var answer = [];
  let sortA = [];
  let arr = [];

  const map = new Map();
  
  for(let i=0;i<genres.length;i++){
    if(map.has(genres[i])){
      map.set(genres[i],(map.get(genres[i])+plays[i]));
    }else{
      map.set(genres[i],plays[i]);
    }
  }
  for (const entry of map) {
    sortA.push(entry);
  }
  for (let i = 0; i < plays.length; i++) {
    arr.push([i,plays[i]]);
  }
  sortA.sort(com);
  arr.sort(com);

  sortA.forEach(element=>{
    let num=0;
    for(let i=0;i<arr.length;i++){
      if(genres[arr[i][0]]==element[0]){
        num++;
        answer.push(arr[i][0]);
        if(num==2){
          break;
        }
      }
    }
  });
  return answer;
}

function com(a,b){
  return b[1]-a[1];
}
```

### 풀이

1. map으로 장르와 장르 총합을 묶는다.
2. map을 배열로 변경해 정렬한다. -> sortA
3. plays를 인덱스와 묶고 정렬한다. -> arr
4. sortA와 장르가 같은 arr를 찾아 answer에 인덱스를 넣는다.

## 20/05/29

```
function solution(skill, skill_trees) {
  let answer=0;
  skill_trees.forEach(element => {
    let index=0;
    for(let i in element){
      if(element[i]==skill[index])  index++;
      else if(element[i]!=skill[index]&&skill.includes(element[i]))  break;
      if(i==element.length-1||index==skill.length) {
        answer++;
        break;
      }
    }
  });
  return answer;
}

```


### 풀이

1. 선행스킬 순서가 맞으면 index를 하나씩 늘리고 선행스킬 순서가 틀리면 break문으로 빠져나간 다음 다시 돈다.
2. index가 skill 길이와 같거나 i가 element길이와 같으면 answer값을 하나씩 늘린다. 


## 20/05/28

- js
```
function solution(participant, completion) {
  participant.sort();
  completion.sort();
  for(let i=0;i<participant.length;i++){
      if(participant[i]!=completion[i])   return participant[i];
  }
  return participant[participant.length-1];
}
```

- java

```
import java.util.HashMap;

class Solution {
  public static String solution(String[] participant, String[] completion) {
    String answer = "";
    var product = new HashMap<String, Integer>();

    for (int i = 0; i < completion.length; i++) {
      if (product.containsKey(completion[i])) {
        product.put(completion[i], product.get(completion[i]) + 1);
      } else {
        product.put(completion[i], 1);
      }
    }

    for (int i = 0; i < participant.length; i++) {
      if (product.containsKey(participant[i])) {
        if (product.get(participant[i]) == 0) {
          return participant[i];
        } else product.put(participant[i], product.get(participant[i]) - 1);
      } else return participant[i];
    }
    return answer;
  }
}
```

### 풀이

- js 
1. participant와 compeltion을 정렬하고 인덱스대로 맞지 않는 값을 찾아 리턴한다.

- java
1. HashMap을 만든 다음 이름을 key값으로 하고 배열에 들어있는 이름 개수를 value값으로 한다.
2. participant에 이름이 나올 때마다 value-1을 하고 value가 0인데 이름이 나올 때나 key에 이름이 없을 때 그 값을 리턴한다.


## 20/05/27
```
function solution(N) {
  let arr = [1,1];
  for(let i=2;i<N;i++){
    arr.push(arr[i-2]+arr[i-1]);
  }
  
  return (arr[arr.length-2]+arr[arr.length-1])*2+arr[arr.length-1]*2;
}
```

### 풀이
1. 문자열 s를 소문자로 바꾸고 배열로 만든다.
2. filter함수로 p와 y만 따로 빼서 배열을 만든 다음 배열 길이를 비교하여 같으면 true, 다르면 false를 리턴한다.

## 20/05/26
```
function solution(s) {
  return s.length%2!=0 ? s[Number.parseInt(s.length/2)] : s[s.length/2-1]+s[s.length/2]
}
```

### 풀이
1. 문자열 s가 짝수인지 판별한 다음 짝수면 가운데 2개의 언어를, 홀수면 가운데 언어를 리턴한다.



### 풀이
1. 피보나치를 배열에 넣고 끝에서 두번째와 첫번째를 직사각형 길이로 구한다.

## 20/05/25
```
function solution(s){
  s = s.toLowerCase().split('');  
   
  return s.filter(word=> word=='p').length==s.filter(word=> word=='y').length;
}

```
