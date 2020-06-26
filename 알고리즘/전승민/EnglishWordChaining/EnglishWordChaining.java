import java.util.HashSet;
import java.util.Set;

public class EnglishWordChaining {
    public static void main(String[] args) {
    }

    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        Set<String> hashSet = new HashSet<String>();

        hashSet.add(words[0]);
        for(int i=1; i<words.length; i++) {
            hashSet.add(words[i]);
            if(hashSet.size()!=i+1 || firstIndex(words[i])!=lastIndex(words[i-1])) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
            }
        }
        return answer;
    }

    static char lastIndex(String str) {
        return str.charAt(str.length()-1);
    }

    static char firstIndex(String str) {
        return str.charAt(0);
    }
}
//https://programmers.co.kr/learn/courses/30/lessons/12981