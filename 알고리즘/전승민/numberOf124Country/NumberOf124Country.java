public class NumberOf124Country {
    public static void main(String[] args) {
        for(int i=1; i<10; i++) {
            System.out.println(i + " : " + new NumberOf124Country().solution(i));
        }
    }

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        while (n>0) {
            int remain = n % 3;
            String str;
            n /= 3;
            if (remain == 0) {
                str = "4";
                n--;
            } else {
                str = Integer.toString(remain);
            }
            answer.insert(0, str);
        }
        return answer.toString();
    }
}

// 0 : 1
// 1 : 2
// 2 : 4
// 3 : 11
// 4 : 12
// 5 : 14
// 6 : 21

