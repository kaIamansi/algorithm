# algorithm workspace

## 20/06/10
```
function solution(n, computers) {
  let visit = []
  visit.length = n;
  visit.fill(false,0,n);
  var answer = 0;


  for(let i=0;i<n;i++){
    if(visit[i]==false){
      check(computers,visit,i);
      answer++;
    }
  }
  
  return answer;
}

function check(c,v,index) {
  if(v[index]==true) return;
  else{
    v[index]=true;
    for(let i=0;i<c.length;i++){
      if(c[index][i]==1){
        check(c,v,i)
      }
    }
  }
}
```

### 풀이

1. 방문을 했는지 알수있게 해주는 배열을 만들고 visit[i]가 false라면 check를 호출한다.

2. visit[i]가 true라면 return 하고 false라면 1이 인지 검사한뒤 check를 부른다.

## 20/06/09
```
function solution(n, lost, reserve) {
  const l = [...lost];
  lost.forEach(x=>{
    if(reserve.indexOf(x)!=-1){
      reserve.splice(reserve.indexOf(x),1);
      l.splice(l.indexOf(x),1);
    }
  });
  [...l].forEach(x=>{
    if(reserve.indexOf(x-1)!=-1){
      reserve.splice(reserve.indexOf(x-1),1);
      l.splice(l.indexOf(x),1);
    }else if(reserve.indexOf(x+1)!=-1){
      reserve.splice(reserve.indexOf(x+1),1);
      l.splice(l.indexOf(x),1);
    }
  });
  return n-l.length;
}
```
### 풀이

1. 처음에 여벌의 옷을 뺏긴 경우를 뺀다.

2. 그리고 1 작은 경우부터 검사하고 1 큰 경우를 검사하면서 뺀다.

3. l의 길이를 n에 빼주면 답이 나온다.

## 20/06/08
```
function solution(priorities, location) {
  var answer = 0;
  while(true){
    if(priorities[0]!=Math.max(...priorities)){      
      priorities.push(priorities.shift());
      if(location==0) location = priorities.length-1;
      else location--;
    }else{
      if(location==0){
        return ++answer;
      }else{
        answer++;
        priorities.shift();
        location--;
      }
    }
  }
}
```
### 풀이

1. priorities의 0번째가 가장 큰 수가 아니면 빼서 뒤로 넣는다.

2. 이때 location이 0이면 length-1로 하고 아니면 -1을 한다.

3. 만약 가장 큰 수라면 location이 0이라면 return 하고 아니면 answer+1을 하고 배열에 빼준다음 location-1을 한다.

## 20/06/03
- java
```
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = sort(new ArrayList(),n);
        int[] arr = new int[answer.size()];
        for(int i=0;i<arr.length;i++){
            arr[i] = answer.get(i);
        }
        return arr;
    }
    public static List sort(List<Integer> answer,int n) {
        if(n==1) {
            answer.add(0);
            return answer;
        }else{
            answer = sort(answer,--n);
            List<Integer> b = new ArrayList();
            b.addAll(answer);
            answer.add(0);
            for (int i=0;i<b.size();i++) {
                if(b.get(i)==1) b.set(i,0);
                else b.set(i,1);
            }
            Collections.reverse(b);
            answer.addAll(b);
        }
        return answer;
    }
}

```
- js
```
function solution(n) {
  var answer = [];
  answer = sort(answer,n);
  return answer;
}

function sort(answer,n) {
  if(n==1){
    answer.push(0);
    return answer;
  }else{
    answer = sort(answer,--n);
    let b = answer.map(x=>(x-1)*-1);
    b.reverse();
    
    answer.push(0);
    return answer.concat(b);
  }
}
```
### 풀이

1. b에 지금까지의 answer 요소를 넣고 answer에 0을 push 한다.

- Java
2. b에서 0을 1로, 1을 0으로 바꾼다. 

- js 
2. b 요소들을 -1하고 *-1를 해주면 0과 1이 바뀐다.

<strong> 0*-1을 하면 -0이 나온다. 근데 0과 -0이 같은거라해서 저렇게 나와도 정답처리 된다.</strong>

3. b를 반전시키고 answer에 함친다. 

4. 재귀가 끝날 때까지 위에 일을 반복한다.

## 20/06/02
```
def solution(board, moves):
    answer = 0
    arr = []
    for element in moves:
      for items in board:
        if items[element-1]:
          arr.append(items[element-1])
          items[element-1]=0
          break
        
      if len(arr)>1 and arr[len(arr)-1]==arr[len(arr)-2]:
        arr.pop()
        arr.pop()
        answer+=1
                
    return answer*2

```

### 풀이

1. board가 0이 아닐때 arr에 넣고 만약 arr길이가 1이상, 뒤에서 첫번째와 뒤에서 2번째가 같다면 pop으로 뺀다.


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
