public class Country124 {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }
    public static String solution(int n) {
        int[] arr={1,2,4};
        String answer = "";

        if(n==0)
            return "";
        else
            answer = solution(((n-1)/3)) + arr[(n-1)%3];
        return answer;
    }
}