using System;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        bool[] boolarr = new bool[priorities.Length];
        boolarr[location] = true;
        Queue<bool> check = new Queue<bool>(boolarr);
        Queue<int> queue = new Queue<int>(priorities);
        while(queue.Count() > 0) {
            var linq = from n in queue where(n > queue.Peek()) select n;
            if(linq.Count() != 0) {
                check.Enqueue(check.Dequeue());
                queue.Enqueue(queue.Dequeue());
            }
            else {
                if(check.Peek()) {
                    return answer;
                }
                else {
                    check.Dequeue();
                    queue.Dequeue();
                    answer++;
                }
            }
        }
        
        return answer;
    }
}