class Solution {
    public String solution(String s) {
        String result;
        int len = s.length();
        int mid = len/2;
        
        if(len % 2 == 0) {
            result = String.valueOf(s.charAt(mid - 1));
            result += String.valueOf(s.charAt(mid));
        } else{
            result = String.valueOf(s.charAt(mid));
        }
        return result;  
    }
}
