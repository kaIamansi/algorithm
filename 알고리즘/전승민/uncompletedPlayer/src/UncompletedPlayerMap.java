import java.util.HashMap;
import java.util.Map;

public class UncompletedPlayerMap {
    public static void main(String[] args) {
        String[] part = new String[]{"asdf", "qwer", "zxcv", "asdf"};
        String[] comp = new String[]{"asdf", "qwer", "zxcv"};
        System.out.println(new UncompletedPlayerMap().solution(part,comp));
    }
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        int length = participant.length;
        for(int i=0; i<length-1; i++) {
            if(map.containsKey(completion[i])) {
                map.put(completion[i], map.get(completion[i])+1);
            } else {
                map.put(completion[i], 1);
            }
        }
        for (String str : participant) {
            Integer value = map.get(str);
            if (value == null || value == 0) {
                return str;
            } else {
                map.put(str, --value);
            }
        }
        return "";
    }
    //https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
}
