class Solution {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String element:skill_trees) {
            int index =0;
            for (int i=0;i<element.length();i++){
                if(element.charAt(i)==skill.charAt(index)) index++;
                else if(element.charAt(i)!=skill.charAt(index)&&skill.indexOf(element.charAt(i))!=-1) break;
                if(i==element.length()-1||index==skill.length()) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}