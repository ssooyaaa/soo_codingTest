import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        //체육복 개수
        int[] count = new int[n];
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int cloth:reserve){
            count[cloth-1]++;
        }
        
        for(int cloth:lost){
            count[cloth-1]--;
        }
        
        for(int i=0;i<count.length;i++){
            if(count[i] == -1){
                if(i!=0 && count[i-1] == 1){
                    count[i-1]--;
                    count[i]++;
                }else if(i!=count.length-1 && count[i+1] == 1){
                    count[i+1]--;
                    count[i]++;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<count.length;i++){
            if(count[i]==0 ||count[i]==1)
                list.add(count[i]+1);
        }
        
        return list.size();
    }
}