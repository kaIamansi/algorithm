#include <string>
#include <vector>

using namespace std;

void bfs(int start, vector<int> graph[], bool check[]){
	queue<int> q;

	q.push(start);
	check[start] = true;

	while(!q.empty()){
		int tmp = q.front();
		q.pop();
		printf("%d ",tmp);
		for(int i=0; i<graph[tmp].size(); i++){
			if(check[graph[tmp][i]] == false){
				q.push(graph[tmp][i]);
				check[graph[tmp][i]] = true;
			}
		}
	}

}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    return answer;
}