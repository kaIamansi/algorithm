#include <string>
#include <vector>
#include <unordered_set>
#include <unordered_map>
#include <map>
using namespace std;

vector<int> solution(vector<string> gems) {
    vector<int> answer = vector<int>{ 1, 10000000 };

    auto set = unordered_set<string>(gems.begin(), gems.end());
    unordered_map<string, int> dictionary;

    map<int, string> lastLocation;
    int min = 10000000;
    for (int i = 0; i < gems.size(); i++) {
        if (dictionary.find(gems[i]) == dictionary.end()) {
            dictionary.insert(make_pair(gems[i],i+1));
            lastLocation.insert(make_pair(i + 1, gems[i]));
            if (min == 10000000) min = i + 1;
        }
        else {
            if (gems[i] == lastLocation[min])
                min = (++lastLocation.begin())->first;

            lastLocation.erase(dictionary[gems[i]]);
            lastLocation.insert(make_pair(i + 1, gems[i]));
            dictionary[gems[i]] = i + 1;
        }

        if (dictionary.size() == set.size() && answer[1] - answer[0] > i + 1 - min) {
            answer[0] = min;
            answer[1] = i+1;
        }
    }

    return answer;
}
