public class NumberOf124Country {
    public static void main(String[] args) {
        for(int i=1; i<10; i++) {
            System.out.println(i + " : " + new NumberOf124Country().solution(i));
        }
    }

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        String[] arr = new String[]{"4","1","2"};
        while (n>0) {
            String str;
            str = arr[n % 3];
            if (n % 3 == 0) { n--; }
            n /= 3;
            answer.insert(0, str);
        }
        return answer.toString();
    }
}//https://programmers.co.kr/learn/courses/30/lessons/12899?language=java%E3%85%8D
