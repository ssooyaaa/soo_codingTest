import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};
        
        if(n>s){
            return new int[]{-1};
        }
        
        int share = s/n;
        int remainder = s%n;
        
        answer = new int[n];
        
        Arrays.fill(answer, share);
        
        for(int i=0;i<remainder;i++){
            answer[n-i-1] = answer[n-i-1]+1;
        }
        
        return answer;
    }
}