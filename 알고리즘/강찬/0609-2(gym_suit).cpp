#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    vector<int> student(n, 1);
    for(int i = 0; i < lost.size(); i++) {
        student[ lost[i]-1 ]--; // Ã¼À°º¹À» ÀÒ¾î¹ö¸° ÇÐ»ýÀÇ Ã¼À°º¹ °¹¼ö -1
    }
    for(int i = 0; i < reserve.size(); i++) {
        student[ reserve[i]-1  ]++; // ¿©ºÐ Ã¼À°º¹À» °¡Áø ÇÐ»ýÀÇ Ã¼À°º¹ °¹¼ö +1
    }
    
    for(int i = 0; i < student.size(); i++) {
        if(i != 0 && student[i] > 1 && student[i-1] == 0) {
            student[i]--;
            student[i-1]++;
        }
        if(i != student.size() && student[i] > 1 && student[i+1] == 0)
        {
            student[i]--;
            student[i+1]++;
        }
    }
    for(int i = 0; i < student.size(); i++) {
        if(student[i] > 0) {
            answer++;
        }
    }
    
    return answer;
}