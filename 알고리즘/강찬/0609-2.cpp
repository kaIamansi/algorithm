#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    answer = n - lost.size();

    for (int i = 0; i < lost.size(); i++) {
        for (int j = 0; j < reserve.size(); j++) {
            if (lost[i] <= reserve[j]) {
                answer++;
                lost[i] = 50000;
                reserve[j] = 0;
            }
        }
    }

    return answer;
}