## algorithm workspace





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
