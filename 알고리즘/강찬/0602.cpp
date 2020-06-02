#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    int depth = 0;
    int sip = 0;
    vector<int> box = { 0 };
    for (int i = 0; i < moves.size(); i++) // 집게 뽑기만큼 회전 
    {
        sip = moves[i] - 1;
        // cout << "이번 sip값은 " << sip << endl;
        while (1)
        {
            if (depth == board.size())
            {
                depth = 0;
                break;
            }
            else if (board[depth][sip] == 0)
            {
                depth++;
            }
            else if (box.back() == board[depth][sip]) { // 박스에 들어있는 인형과 뽑은 인형이 겹칠 때
                // cout << "box에 넣어서 터진 인형은: " << box.back() << endl;
                box.pop_back();
                answer += 2;
                // cout << "펑 터진 인형점수: " << answer << endl;
                board[depth][sip] = 0;
                depth = 0;
                break;
            }
            else // 겹치지 않았을 때 인형 값을 box에 넣고 break문 실행
            {
                box.push_back(board[depth][sip]);
                board[depth][sip] = 0;
                // cout << "box에 넣은 인형은: " << box.back() << endl;    
                depth = 0;
                break;
            }
        }
    }

    return answer;
}