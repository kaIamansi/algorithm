#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    int num;
    int arr[30][30] = {0};

    for (int i = 0; i < skill_trees.size(); i++) // 스킬트리 개수만큼 돌림
    {
        for (int j = 0; j < skill.size(); j++) // B C D 위치 검사
        {
            num = skill_trees[i].find(skill[j]);
            if (num == -1)
                num = 5000000;
            arr[i][j] = num; // 값이 차례대로 배열에 들어감
            cout << num << ' ';
           /*
            2 0 3
            0 1 3
            2 3 -1
            -1 0 1
            */
        }
        cout << endl;
        if (is_sorted(&arr[i][0], &arr[i][skill.size()]))
            answer += 1;
    }

    return answer;
}

int main()
{
    string str = "CBD";
    vector<string> vec;
    vec.push_back("BACDE"); // X
    vec.push_back("CBADF"); // O
    vec.push_back("AECB"); // O
    vec.push_back("BDA"); // X

    cout << solution(str, vec);
}