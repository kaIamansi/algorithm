import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
		HashMap<String, Integer> genreHash = new HashMap<String, Integer>();
		
		for(int i = 0; i < genres.length; i++) {
			genreHash.put(genres[i], genreHash.getOrDefault(genres[i], 0) + plays[i]);
		}
        
        return answer;
    }
}