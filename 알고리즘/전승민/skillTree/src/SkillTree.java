public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int result = 0;
        int[] alphabetArr = new int[26];
        int length = skill.length();

        for(int i = 0; i < length; i++) {
            int alphabet = (int)skill.charAt(i) - 65;
            alphabetArr[alphabet] = i+1;
        }

        for(String s : skill_trees) {
            length = s.length();
            int count = 1;
            for(int i=0; i<length; i++) {
                int alphabet = (int)s.charAt(i) - 65;
                if(alphabetArr[alphabet]==0) { }
                else if(alphabetArr[alphabet]==count) {
                    count++;
                } else {
                    count = -1;
                    break;
                }
            }
            if(count!=-1) {
                result++;
            }
        }

        return result;
    }
}
