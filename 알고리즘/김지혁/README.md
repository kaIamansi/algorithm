## algorithm workspace
# 2020/06/09
### 문제: 체육복(https://programmers.co.kr/learn/courses/30/lessons/42862)

### 코드(C++)
```c++
#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
	int answer = 0;
	int uniform[30];
	std::fill_n(uniform, 30, 1);
	for (int i = 0; i < reserve.size(); i++) {
		uniform[reserve[i] - 1]++;
	}
	for (int i = 0; i < lost.size(); i++) {
		uniform[lost[i] - 1]--;
	}
	for (int i = 0; i < n; i++) {
		if (uniform[i] == 0) {
			if (i > 0 && uniform[i - 1] > 1) {
				uniform[i - 1]--;
				uniform[i]++;
			}
			else if (i < n && uniform[i + 1] > 1) {
				uniform[i + 1]--;
				uniform[i]++;
			}
		}
		if (uniform[i] > 0)
			answer++;
	}
	return answer;
}
```
# 2020/06/08
### 문제: 프린터(https://programmers.co.kr/learn/courses/30/lessons/42587)
- 예전에 c++로 풀어서 c#으로 다시 풀었다.

#### 다시 푼 것(C#)
```c#
using System;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        bool[] boolarr = new bool[priorities.Length];
        boolarr[location] = true;
        Queue<bool> check = new Queue<bool>(boolarr);
        Queue<int> queue = new Queue<int>(priorities);
        while(queue.Count() > 0) {
            var linq = from n in queue where(n > queue.Peek()) select n;
            if(linq.Count() != 0) {
                check.Enqueue(check.Dequeue());
                queue.Enqueue(queue.Dequeue());
            }
            else {
                if(check.Peek()) {
                    return answer;
                }
                else {
                    check.Dequeue();
                    queue.Dequeue();
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
```
#### 예전코드(C++)
```c++
#include <string>
#include <vector>

using namespace std;

int solution(vector<int> priorities, int location) {
	int answer = 0;
	bool changed = false;

	while (true)
	{
		for (int i = 1; i < priorities.size(); i++)
		{
			if (priorities[0] < priorities[i])
			{
				priorities.emplace_back(priorities[0]);
				priorities.erase(priorities.begin());

				if (location == 0) location = priorities.size() -1;
				else location--;
				changed = true;

				break;
			}
		}

		if (!changed)
		{
			priorities.erase(priorities.begin());
			answer++;
			if (location == 0)
				return answer;
			else
				location--;
		}
		changed = false;
	}
}
```
# 2020/06/03
### 문제: 종이접기(https://programmers.co.kr/learn/courses/30/lessons/62049)

### 코드(C++)
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
- n이 1일 때는 0으로 지정
- answer을 {0, 0, 1}로 초기화
- 3이상이면 
    1. answer + 0 + !(rewsna)을 arr 에 저장
    2. answer에 arr 저장 후 반복
