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
            if(hashSet.size()-1!=i) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
            }
            if(words[i].charAt(0)!=words[i-1].charAt(words[i-1].length()-1)) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
            }
        }

        return answer;
    }
}
