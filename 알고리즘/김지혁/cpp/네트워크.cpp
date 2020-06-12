#include <string>
#include <vector>

using namespace std;

void DFS(int idx, vector<bool>& check, vector<vector<int>> computers) {
	for (int a = 0; a < computers.size(); a++) {
		check[idx] = true;
		if (computers[idx][a] && !check[a]) {
			
			DFS(a, check, computers);
		}

	}
}

int solution(int n, vector<vector<int>> computers) {
	int answer = 0;
	vector<bool> check(200);
	fill(check.begin(), check.begin() + computers.size(), false);
	for (int i = 0; i < n; i++) {
		if (!check[i]) {
			DFS(i, check, computers);
			answer++;
		}
			
	}

	return answer;
}