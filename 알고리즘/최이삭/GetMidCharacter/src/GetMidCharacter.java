public class GetMidCharacter {
    public static void main(String[] args) {
        System.out.println(new GetMidCharacter().solution("asdff"));
    }
    public String solution(String s) {
        int length = s.length()-1;
        return s.substring(length/2, length/2+length%2+1);
    }
}
