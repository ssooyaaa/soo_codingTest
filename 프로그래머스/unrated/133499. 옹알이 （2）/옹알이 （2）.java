class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String word : babbling){
            if(check(word))
                answer++;
        }
        
        return answer;
    }
    
    public boolean check(String s){
        String[] word = {"aya","ye","woo","ma"};
        String[] repeat = {"ayaaya","yeye","woowoo","mama"};
        
        for(String rCheck : repeat){
            if(s.contains(rCheck))
                return false;
        }
        
        String[] sp = s.split("aya|ye|woo|ma");
        if(sp.length==0)
            return true;
        return false;
    
    }
}