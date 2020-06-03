class Solution {
    public int[] solution(int n) {
        int len = (int)Math.pow(2, n)-1;    //double 값이라 (int)~
        int[] answer = new int[len];
        
        String ansS = "0";
        String updown;
        for(int i = 2; i <= n; i++) {
            updown = "1";
            StringBuilder space = new StringBuilder("0");
            for(int j = 0; j < ansS.length(); j++) {
                space.append(ansS.charAt(j) + updown);
                updown = updown.equals("1") ? "0" : "1";
            }
            ansS = space.toString();
        }
        
        for(int i = 0; i < ansS.length(); i++) {    //int로 바꿔서 넣어줌
            answer[i] = ansS.charAt(i) - 48;    //char 0 == int 48, char 1 == int 49
        }
        
        return answer;
    }
}