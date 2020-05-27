public class PAndYCounter {
    public static void main(String[] args) {
        System.out.println(new PAndYCounter().solution("pPoooyYy"));
    }

    boolean solution(String s) {
        int pCounter = 0;
        int yCounter = 0;

        char[] arr = s.toLowerCase().toCharArray();

        for(char item : arr) {
            if(item == 'p') pCounter++;
            else if(item == 'y') yCounter++;
        }

        return pCounter==yCounter;
    }
    //https://programmers.co.kr/learn/courses/30/lessons/12916
}
