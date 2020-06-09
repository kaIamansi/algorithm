#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
	int answer = 0;
	int uniform[30];
	std::fill_n(uniform, 30, 1);
	for (int i = 0; i < reserve.size(); i++) {
		uniform[reserve[i]]++;
	}
	for (int i = 0; i < lost.size(); i++) {
		uniform[lost[i]]--;
	}
	for (int i = 1; i < n + 1; i++) {
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