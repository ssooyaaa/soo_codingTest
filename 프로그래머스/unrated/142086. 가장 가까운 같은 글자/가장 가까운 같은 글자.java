class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
       
        
        for(int i=0;i<s.length();i++){
            int index = -1;
            if(i==0){
                answer[i] = -1;
                continue;
            }
            
            for(int j=i-1;j>=0;j--){
                if(s.charAt(i)==s.charAt(j)){
                    index = i-j;
                    break;
                }
            } answer[i] = index;
        }
        
        return answer;
    }
}