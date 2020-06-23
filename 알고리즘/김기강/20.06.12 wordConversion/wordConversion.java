class Solution {
    int compare = 0;    //걸린 횟수 저장
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] went = new boolean[words.length]; //네트워크처럼 갔던 곳 확인용
        
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(target)) {   //words 배열에 타겟이 있으면 확인한다. 원래 없었는데 넣으니까 시간이 빨라졌다 히히.
                toTarget(begin, target, words, went, 0);
            }
        }
        
        answer = compare;   //걸린 횟수
        
        return answer;
    }
    
    public void toTarget(String begin, String target, String[] words, boolean[] went, int count) {
        for(int i = 0; i < words.length; i++) {
            if(begin.equals(target)) {      //비교를 시작한 것과 target이 같으면 compare을 바꿔준다.
                compare = compare > count ? compare : count;
                //compare = Math.max(compare, count);   //비교하는 다른 방법 찾다가 Math.max가 있어서 써봤다.
                return;
            }
            
            if(went[i] == true) {   //갔던 곳이면 다음으로 넘어간다.
                continue;
            }
            
            int check = 0;
            for(int j = 0; j < target.length(); j++) {      //글자를 비교한다.
                if(words[i].charAt(j) != begin.charAt(j)) {
                    check++;
                }
            }
            
            if(check == 1 && went[i] == false) {    //한 글자만 달라야 이동 가능하다.
                begin = words[i];
                went[i] = true;
                toTarget(begin, target, words, went, count+1);
            }
        }
        
    }
}