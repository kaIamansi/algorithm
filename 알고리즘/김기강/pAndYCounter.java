package homework2;

public class pAndYCounter {
	    boolean solution(String s) {
	        int c1 = 0, c2 = 0;
	        char[] array_s = new char[s.length()];
	        
	        for(int i = 0;i < array_s.length; i++){ 
		        array_s[i]=(s.charAt(i));
	        }
	        
	        for(int i = 0; i < array_s.length; i++) {
	            if(array_s[i] == 'p' || array_s[i] == 'P') {
	                c1++;
	            } else if(array_s[i] == 'y' || array_s[i] == 'Y') {
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
