import java.util.HashMap;
class Solution {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        var product = new HashMap<String, Integer>();

        for (int i = 0; i < completion.length; i++) {
            if (product.containsKey(completion[i])) {
                product.put(completion[i], product.get(completion[i]) + 1);
            } else {
                product.put(completion[i], 1);
            }
        }

        for (int i = 0; i < participant.length; i++) {
            if (product.containsKey(participant[i])) {
                if (product.get(participant[i]) == 0) {
                    return participant[i];
                } else product.put(participant[i], product.get(participant[i]) - 1);
            } else return participant[i];
        }
        return answer;
    }
}