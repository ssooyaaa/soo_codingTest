import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int a=0;a<commands.length;a++){
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            int[] subArr = new int[j-i+1];
            
            System.arraycopy(array,i-1,subArr,0,j-i+1);
        
            Arrays.sort(subArr);
            
            int num = subArr[k-1];
            answer[a] = num;
        }
        
        return answer;
    }
    
   
}