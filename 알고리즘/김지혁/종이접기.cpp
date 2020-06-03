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

int main(void) {
	vector<int> arr = solution(3);
	for (int i = 0; i < arr.size(); i++) {
		cout << arr[i] << endl;
	}
}
