문제를 간단하게 요약하자면 10진수를 3진수로 바꾸되, 숫자별 표현법을 맞춰서 출력하라는 문제이다. 그래서 처음에는 그냥 계속 3으로 나눠서 나머지를 모아서 표현법에 맞춰 출력하면 되는 줄 알았다. 하지만 작은 문제가 있었다.

---
* 1차 코드
~~~cpp
#include <string>
#include <vector>

using namespace std;

char ChangeTo124(int n) {
	switch (n) {
	case 0: return '1';
	case 1:	return '2';
	case 2: return '4';
	}
}

string solution(int n) {
	string answer = "";

    n--;
    if(n == 1) return "1";

	while (n > 0) {
		answer.insert(answer.begin(), ChangeTo124(n % 3));
		n /= 3;
	}
	return answer;
}
~~~
---

숫자 4는 "11"로 나와야 하는데 "21"이 나온다. 아마 0을 표현하는 수가 없기 때문인 것으로 보인다. 즉, 기존의 진법들과는 다르게 생각해야 했던 것이다. 자릿수를 늘리려면 추가 작업이 필요했다. 그것이 `while` 문 안에 `n--`가 들어있는 이유이다.

---
* 최종 코드
~~~cpp
#include <string>
#include <vector>

using namespace std;

char ChangeTo124(int n) {
	switch (n) {
	case 0: return '4';
	case 1:	return '1';
	case 2: return '2';
	}
}

string solution(int n) {
	string answer = "";

	while (n > 0) {
		answer.insert(answer.begin(), ChangeTo124(n % 3));
		n--;
		n /= 3;
	}
	return answer;
}
~~~
