class Solution {
    boolean solution(String s) {
	int c1 = 0, c2 = 0;
	char[] array_s = new char[s.length()];
	        
	for(int i = 0;i < array_s.length; i++){ 
		array_s[i]=(s.toLowerCase().charAt(i));
	}
	        
	for(int i = 0; i < array_s.length; i++) {
		if(array_s[i] == 'p') {
			c1++;
	        	} else if(array_s[i] == 'y') {
	           		c2++;
	        	}
	}

	if(c1 == c2) {
		return true;
        	} else {
		return false;
	}
    }
}