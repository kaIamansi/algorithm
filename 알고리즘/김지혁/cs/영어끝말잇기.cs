using System;
using System.Collections.Generic;
class Solution
{
    public int[] solution(int n, string[] words)
    {
        int[] answer = { 0, 0 };
        List<string> buff = new List<string>();
        int human = 2;
        int turn = 1;
        for (int i = 1; i < words.Length; i++)
        {
            if (human > n)
            {
                human = 1;
                turn++;
            }
            
            if (buff.Contains(words[i]))
            {
                
                answer[0] = human;
                answer[1] = turn;
                return answer;
            }
            
            else if (words[i - 1][words[i - 1].Length - 1] != words[i][0])
            {
                answer[0] = human;
                answer[1] = turn;
                return answer;
            }
            
            else
                buff.Add(words[i-1]);
            human++;
        }

        return answer;
    }
}