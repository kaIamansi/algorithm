#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    queue<int> q;
    int visit[210] = { 0 };

    for (int i = 0; i < n; i++) {
        if (!visit[i]) {
            answer++;
            visit[i] = 1;
            q.push(i);
        }
        while (!q.empty()) {
            int now = q.front();
            q.pop();

            for (int j = 0; j < n; j++) {
                if (j != now && computers[now][j] == 1 && visit[j] == 0) {
                    q.push(j);
                    visit[j] = 1;
                }
            }
        }
    }

    return answer;
}