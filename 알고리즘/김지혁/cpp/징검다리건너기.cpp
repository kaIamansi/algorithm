#include <string>
#include <vector>

using namespace std;

int solution(vector<int> stones, int k) {
    int answer = 0;
    int jump = 0;
	while (1) {
		for (int i = 0; i < stones.size(); i++) {
			if (stones[i] <= 0)
			{
				jump++;
				if (jump >= k)
					return answer;
			}
			else
				jump = 0;
			stones[i]--;
		}
		answer++;
	}
}