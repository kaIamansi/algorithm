## algorithm workspace
# 2020/06/03
+ 문제: 종이접기

```c++
#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int n) {
	vector<int> answer;
	vector<int> arr;
	vector<int> tmp{ 0,0,1 };
	if (n == 1) {
		answer.push_back(0);
		return answer;
	}
	answer.swap(tmp);
	for (int i = 2; i < n; i++) {
		arr.insert(arr.begin(), answer.begin(), answer.end());
		arr.push_back(0);
		for (int j = answer.size() - 1; j >= 0; j--) {
			arr.push_back(!answer[j]);
		}
		answer = arr;
		arr.clear();
	}
	return answer;
}
```

### 풀이
+ n이 1일 때는 0으로 지정
+ answer을 {0, 0, 1}로 초기화
+ 3이상이면 
    1. answer + 0 + !(rewsna)을 arr 에 저장
    2. answer에 arr 저장 후 반복
