#include <string>
#include <vector>
#include <utility>
using namespace std;

vector<int> solution(vector<string> gems) {
	vector<int> answer;

	//first는 이름 second는 인덱스
	pair<string, int> top;
	pair<string, int> last;
	bool check;
	top = make_pair(gems[0], 0);
	last = top;
	int i, j;
	i = 1;
	// for (i = 1; i < gems.size(); i++) {
	while (i < gems.size()) {
		check = false;
		for (j = top.second; j < i; j++) {
			if (gems[i] == gems[j]) {
				check = true;
				break;
			}
		}
		if (!check) last = make_pair(gems[i], i);

		if (top.first == gems[i]) {
			i = top.second + 2;
			top = make_pair(gems[top.second + 1], top.second + 1);
		}
		else
			i++;
	}
	answer.push_back(top.second + 1);
	answer.push_back(last.second +1);
	return answer;
}