class Solution {
    public int solution(String s) {
        int answer = 0;
        
        while(s.length()!=0){
            answer ++;
            
            char ch = s.charAt(0);
            int start = 1;
            int end = 0;
            
            for(int i=1;i<s.length();i++){
                if(ch == s.charAt(i))
                    start++;
                else
                    end++;
                
                if(start==end)
                    break;
            } s = s.substring(start+end);
        }
        
        return answer;
    }
}
