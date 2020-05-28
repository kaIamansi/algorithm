#include <string>
#include <string>
#include <iostream>
#include <vector>

using namespace std;

long long solution(int N) {
    long long answer = 0;
    int sum = 0;
    if (N == 1) return 4;
    
    /*vector<int> v{ 1, 1, 2, 3 };

    if (N == 1) return 4;
    else if (N == 2) return 6;
    else if (N == 3) return 10;
    else if (N == 4) return 16;

    for (int i = 4; i < N; i++)
    {
        sum = v[3] + v[2];
        v.push_back(sum);
        v.erase(v.begin());
    }
    int ans = v[0] + (v[1] + v[2]) * 2 + v[3] * 3;
    answer = (long long)ans;*/

    vector<long long> vec(2, 1);
    for (int i = 2; i < N; i++)
    {
        vec.push_back(vec[i - 1] + vec[i-2]);
    }

    answer = ((vec[N - 1]) * 4 + (vec[N - 2]) * 2);

    return answer;
}

int main()
{
    cout << solution(5);
}
