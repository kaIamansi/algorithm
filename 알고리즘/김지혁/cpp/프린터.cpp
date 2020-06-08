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