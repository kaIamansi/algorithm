#include <vector>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    vector<bool> check(200000);
    for(int i = 0; i < nums.size();i++) {
        if(!check[nums[i]]) {
            check[nums[i]] = true;
            answer++;
        }
    }
    if(answer < nums.size() / 2) return answer;
    else return (nums.size() /2);
}