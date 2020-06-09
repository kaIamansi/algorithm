## algorithm workspace



### 2020.06.09 알고리즘

문제: https://programmers.co.kr/learn/courses/30/lessons/42862

소스코드:

```java
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n];
        
        for(int i = 0; i < n; i++) {
            student[i] = 1;
        }
        for(int l : lost) {
            student[l-1]--;
        }
        for(int r : reserve) {
            student[r-1]++;
        }
        
        for(int i = 0; i < n; i++) {
            if(student[i] == 0) {
                if(i + 1 < n && student[i+1] == 2) {
                    student[i]++;
                    student[i+1]--;
                } else if(i - 1 > 0 && student[i-1] == 2) {
                    student[i]++;
                    student[i-1]--;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(student[i] > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
```

기강이의 풀이:

1. 모든 학생들이 기본적으로 체육복을 갖고 있다.
2. 도난 당한 것과 여분의 체육복을 계산한다.
3. 도난 당한 학생의 앞, 뒤 번호 학생에게 빌릴 수 있는 옷이 있는지 검사한다.
4. 체육복이 1개 이상 있으면 수업을 들을 수 있다.



### 2020.06.08 알고리즘

문제: https://programmers.co.kr/learn/courses/30/lessons/42587

소스코드:

```java
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        
        Queue<qtem> queue = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++) {
            qtem tem  = new qtem(priorities[i]);
            if(i == location) {
                tem.ud = true;
            }
            queue.add(tem);
        }
        Arrays.sort(priorities);
        
        int where = priorities.length -1;
        
        while(!queue.isEmpty()) {
            qtem tem = queue.poll();
            if(tem.priority == priorities[where]) {
                if(tem.ud) {
                    return answer;
                }
                answer++;
                where--;
            } else {
                queue.add(tem);
            }   
        }
        
        return answer;
    }
}

class qtem {
    int priority;
    boolean ud;
    
    qtem(int priority) {
        this.priority = priority;
        this.ud = false;
    }
}
```

기강이의 풀이:

1. queue에 priorities를 넣어준다. 이때 찾으려는 것은 ud를 true로 바꿔준다.
2. poll()로 가장 먼저 넣은 것을 꺼내서 비교한다.
3. 찾으려는 것과 같은 priority를 갖고 있으며, ud가 true면 answer를 리턴, false면 answer을 1 올리고 다시 비교한다.
4. 다르면 다시 queue에 넣어준다.



### 2020.06.03 알고리즘

문제: https://programmers.co.kr/learn/courses/30/lessons/64061

소스코드:

```java
class Solution {
    public int[] solution(int n) {
	int len = (int)Math.pow(2, n)-1;    //double 값이라 (int)~
	int[] answer = new int[len];
	
	String ansS = "0";
	String updown;
	for(int i = 2; i <= n; i++) {
		updown = "1";
		StringBuilder space = new StringBuilder("0");
		for(int j = 0; j < ansS.length(); j++) {
			space.append(ansS.charAt(j) + updown);
			updown = updown.equals("1") ? "0" : "1";
		}
		ansS = space.toString();
	}
	
	for(int i = 0; i < ansS.length(); i++) {    //int로 바꿔서 넣어줌
		answer[i] = ansS.charAt(i) - 48;    //char 0 == int 48, char 1 == int 49
        }
	
	return answer;
	}
}
```

기강이의 풀이:

1. answer의 길이를 2의 n승-1로 둔다.
2. space에 ansS의 값을 기준으로 맞는 0 혹은 1을 넣어준다.
3. 그것을 ansS에 넣어준다.
4. 종이를 n번만큼 접었으면, answer[i]에 넣어준다. 






### 2020.06.02 알고리즘

문제: https://programmers.co.kr/learn/courses/30/lessons/64061

특이사항: 6월 2일 16시 30분에 있는 면접 준비로 인해 하지 못했습니다.
- 이에 6월 첫째주 주말까지 6월 1,2일 문제를 풀어야합니다.

### 2020.06.01 알고리즘

문제: https://programmers.co.kr/learn/courses/30/lessons/42579

소스코드:

```java
import java.util.*;
class Solution {
	public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
        
		HashMap<String, Integer> genreHash = new HashMap<String, Integer>();
		
		for(int i = 0; i < genres.length; i++) {
			genreHash.put(genres[i],
                          genreHash.getOrDefault(genres[i], 0) + plays[i]);
		}
		
		return answer;
    }
}
```

기강이의 풀이 시도:

1. HashMap에 값을 넣었다.
2. ...

난관:

1. HashMap에 넣은 값을 어떻게 써야할지 모르겠다.
2. 비교해서 수록하는 방법이 궁금해졌다.



### 2020.05.29 알고리즘

문제: https://programmers.co.kr/learn/courses/30/lessons/49993

소스코드:

```java
class Solution {
	public int solution(String skill, String[] skill_trees) {
		int answer = skill_trees.length;
		int idx1, idx2;

		for(int i = 0; i < skill_trees.length; i++) {
			idx1 = skill_trees[i].indexOf(skill.charAt(0));
			
			for(int j = 1; j < skill.length(); j++) {
				idx2 = skill_trees[i].indexOf(skill.charAt(j));
				if(idx1 > idx2 && idx2 != -1 || idx == -1 && idx2 != -1) {
					answer--;
					break;
				}
				idx1 = idx2;
			}
		}

		return answer;
	}
}
```

기강이의 풀이:

1. skill_trees의 길이만큼 answer로 해둔다.
2. 변수 2개를 만든다.
3. idx1에는 skill의 비교 기준 문자를, idx2에는 skill의 비교 대상 문자를 넣는다.
4. 만약 idx1이 idx2보다 크면 idx2가 더 앞에 위치한 것이기 때문에 answer 1개를 깎는다. 또한, indexOf는 해당 문자가 없으면 -1을 리턴하기 때문에 idx1이 없는데 idx2이 있다면 그것도 안되는 것이기 때문에 answer을 1개 깎는다.
5. 이후 skill의 남은 문자열을 비교하기 위해 idx1에 idx2를 대입한다.



### 2020.05.28 알고리즘

문제: https://programmers.co.kr/learn/courses/30/lessons/42576

소스코드:

```java
import java.util.Arrays;
class Solution {
	public String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);

		for(int i = 0; i < completion.length; i++) {
			if(! participant[i].equals(completion[i])) {
				return participant[i];
			}
		}

		return participant[participant.length-1];
	}
}
```

기강이의 풀이:

1. 두 문자열 배열을 Arrays.sort를 통해 오름차순 정렬을 해준다.
2. 정렬했기 때문에 같아야 한다.
3. participant에 있는데 completion에 없으면 안 들어온 사람이다.
4. 다 비교했는데 같았으면 participant의 마지막 인덱스 사람이 안 들어온 것이므로 return 해준다.





### 2020.05.27 알고리즘

기강이의 풀이:

1. 피보나치로 배열을 채웠다.
2. 직사각형의 둘레를 구하기 위해 (맨 뒤 인덱스 * 4) + ((맨 뒤-1 인덱스) * 2) 를 리턴해줬다.

오늘의 난관

1. 효율성에서 0점을 맞았다. (효율성 만점 33.3점)

```
//첫 코드
public long solution(int N) {
        int[] arr = new int[N];
        int a = 1, b = 1, c = 0;

        arr[0] = 1;
        arr[1] = 1;

        for(int i = 2; i < N; i++) {	//피보나치
	        c = a + b;
	        arr[i] = c;
	        a = b;
	        b = c;
        }
		...
```

​	이를 해결하기 위해 int 배열을 long 배열로 바꿨으며, 필요없는 변수를 없애고, for문의 코드를 바꿨다.

```java
	long[] arr = new long[N];
	...
	for(int i = 2; i < N; i++) {	//피보나치
	        arr[i] = arr[i-1] + arr[i-2];
        }
```





### 2020.05.26 알고리즘

기강이의 풀이:

1. 문자열 크기와 그 크기를 2로 나눴다.
2. 나눈 크기가 홀수인 경우와 짝수인 경우를 나눴다.





### 2020.05.25 알고리즘

기강이의 풀이: 문자열 크기의 배열 만들고 char로 하나씩 넣어서 P와 Y의 갯수를 비교했다.

1차 수정
- 문자열에 .toLowerCase 사용해서 비교하는 코드를 줄였다.
