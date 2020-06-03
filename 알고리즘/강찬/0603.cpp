#include <string>
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

void reverseVec(vector<int>& input)
{
    reverse(input.begin(), input.end());
    for (int i = 0; i < input.size(); i++)
    {
        if (input[i] == 0)
            input[i] = 1;
        else
            input[i] = 0;
    }
}

vector<int> solution(int n) {
    vector<int> answer = {0, 0, 1};
    vector<int> copyninja;
    if (n == 1)
    {
        answer.clear();
        answer.push_back(0);
        return answer;
    }

    // 0 0 1 상태로 들어옴
    for (int i = 0; i < n-2; i++)
    {
        copyninja.clear();
        copyninja.assign(answer.begin(), answer.end());
        copyninja.insert(copyninja.begin(), 0);
        // 기존 값 복사
        reverseVec(answer);
        answer.swap(copyninja);
        answer.insert(answer.end(), copyninja.begin(), copyninja.end());
        }
    return answer;
}

int main()
{
    solution(3);
}