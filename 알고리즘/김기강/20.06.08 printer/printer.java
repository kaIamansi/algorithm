import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        
        Queue<qtem> queue = new ArrayDeque<>();
        for(int i = 0 ; i < priorities.length ; i++) {
            qtem tem  = new qtem(priorities[i]);
            if(i == location) {
                tem.ud = true;
            }
            queue.add(tem);
        }
        Arrays.sort(priorities);
        
        int where = priorities.length -1;
        
        while(!queue.isEmpty()) {
            qtem tem = queue.poll();
            if(tem.priority == priorities[where]) {
                if(tem.ud) {
                    return answer;
                }
                answer++;
                where--;
            } else {
                queue.add(tem);
            }   
        }
        
        return answer;
    }
}

class qtem {
    int priority;
    boolean ud;
    
    qtem(int priority) {
        this.priority = priority;
        this.ud = false;
    }
}