import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int[] si = new int[row_end-row_begin+1];
        
        Arrays.sort(data, new Comparator<int[]>(){
           public int compare(int[] o1, int[] o2){
               if(o1[col-1]==o2[col-1])
                   return o2[0]-o1[0];
               
               return o1[col-1]-o2[col-1];
           } 
        });
        
        int idx = 0;
        for(int i=row_begin-1;i<=row_end-1;i++){
            for(int j=0;j<data[0].length;j++){
                si[idx] += data[i][j]%(i+1);
            }
            
            idx++;
        }
        
        int answer = si[0];
        for(int i=1;i<si.length;i++){
            answer = answer ^ si[i];
        }
        
        
        return answer;
    }
}