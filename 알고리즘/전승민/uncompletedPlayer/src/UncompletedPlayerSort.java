import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class UncompletedPlayerSort {
    public static void main(String[] args) {
        String[] part = new String[]{"asdf", "qwer", "zxcv", "asdf"};
        String[] comp = new String[]{"asdf", "qwer", "zxcv"};
        System.out.println(new UncompletedPlayerSort().solution(part,comp));
    }
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int length = completion.length;
        for(int i=0; i<length; i++) {
            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[length];
    }
    //https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
}
