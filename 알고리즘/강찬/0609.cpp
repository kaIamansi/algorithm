#include <utility>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<int> priorities, int location) {
    vector<int>::iterator iter;
    int answer = 0;
    int num = 9;
    int size = 0;
    vector<pair<int, int>> v;
    for (int i = 0; i < priorities.size(); i++)
    {
        v.push_back(make_pair(priorities[i], i));
    }

    while (true)
    {
        size = v.size();
        cout << "num is " << num << endl;
        iter = find(priorities.begin(), priorities.end(), num);
        for (int i = 0; i < size; i++)
        {
            if (iter == priorities.end())
            {
                break;
            }
            if (v.front().first == num && v.front().second == location)
            {
                answer++;
                return answer;
            }
            else if (v.front().first == num)
            {
                v.erase(v.begin());
                answer++;
                if(num > 1)
                    break;
            }
            else
            {
                // cout << v.front().first << " is go back" << endl;
                v.push_back(v.front());
                v.erase(v.begin());
            }
        }
        num--;
    }
}

int main() {
    vector<int> v = { 1, 1, 9, 1, 1, 1 };
    int loc = 0;

    cout << solution(v, loc);
}