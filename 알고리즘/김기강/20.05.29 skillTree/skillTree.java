class Solution {
	public int solution(String skill, String[] skill_trees) {
		int answer = skill_trees.length;
		int idx1, idx2;

		for(int i = 0; i < skill_trees.length; i++) {
			idx1 = skill_trees[i].indexOf(skill.charAt(0));

			for(int j = 1; j < skill.length(); j++) {
				idx2 = skill_trees[i].indexOf(skill.charAt(j));
				if(idx1 > idx2 && idx2 != -1 || idx == -1 && idx2 != -1) {
					answer--;
					break;
				}
				idx1 = idx2;
			}
		}

		return answer;
	}
}
