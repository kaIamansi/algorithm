public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = new String[]{"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(new SkillTree().solution(skill, skill_trees));
    }

    public int solution(String skill, String[] skill_trees) {
        int result = 0;
        int[] alphabetArr = checkSkillSequence(skill);

        for(String s : skill_trees) {
            if(isCollectSkillTree(s, alphabetArr)) {
                result++;
            }
        }

        return result;
    }

    private static int[] checkSkillSequence(String skill) {
        int[] alphabetArr = new int[26];
        int length = skill.length();
        for(int i = 0; i < length; i++) {
            alphabetArr[getAlphabetIndex(skill.charAt(i))] = i+1;
        }
        return alphabetArr;
    }

    private static int getAlphabetIndex(char c) {
        return c - 65;
    }

    private static boolean isCollectSkillTree(String skillTree, int[] alphabetArr) {
        int length = skillTree.length();
        int count = 1;
        for(int i=0; i<length; i++) {
            int alphabet = getAlphabetIndex(skillTree.charAt(i));
            if(alphabetArr[alphabet]==0) { }
            else if(alphabetArr[alphabet]==count) {
                count++;
            } else {
                count = -1;
                break;
            }
        }
        if(count!=-1) {
            return true;
        } else {
            return false;
        }
    }
}
