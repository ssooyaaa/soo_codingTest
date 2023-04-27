import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int endPoint = 0, count = 0;
        
        for(int i=0;i<section.length;i++){
            if(endPoint<=section[i]){
                endPoint = section[i]+m;
                count++;
            }
        }
       
       
        return count;
    }
}