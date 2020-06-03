import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = sort(new ArrayList(),n);
        int[] arr = new int[answer.size()];
        for(int i=0;i<arr.length;i++){
            arr[i] = answer.get(i);
        }
        return arr;
    }
    public static List sort(List<Integer> answer,int n) {
        if(n==1) {
            answer.add(0);
            return answer;
        }else{
            answer = sort(answer,--n);
            List<Integer> b = new ArrayList();
            b.addAll(answer);
            answer.add(0);
            for (int i=0;i<b.size();i++) {
                if(b.get(i)==1) b.set(i,0);
                else b.set(i,1);
            }
            Collections.reverse(b);
            answer.addAll(b);
        }
        return answer;
    }
}
