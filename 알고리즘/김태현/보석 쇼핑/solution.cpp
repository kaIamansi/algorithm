#include <string>
#include <vector>
#include <unordered_set>
#include <list>
#include <unordered_map>
using namespace std;

vector<int> solution(vector<string> gems) {
    vector<int> answer = vector<int>{ 1, 10000000 };

    auto set = unordered_set<string>(gems.begin(), gems.end());
    unordered_map<string, int> dictionary;

    list<int> li;
    for (int i = 0; i < gems.size(); i++) {
        if (dictionary.find(gems[i]) == dictionary.end())
            dictionary.insert(make_pair(gems[i], i + 1));
        else {
            li.remove(dictionary[gems[i]]);
            dictionary[gems[i]] = i + 1;
        }
        li.emplace_back(i + 1);

        if (dictionary.size() == set.size() && answer[1] - answer[0] > li.back() - li.front()) {
            answer[0] = li.front();
            answer[1] = li.back();
        }
    }

    return answer;
}
