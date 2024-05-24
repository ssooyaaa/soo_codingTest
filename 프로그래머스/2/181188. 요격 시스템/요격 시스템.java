import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> {return o1[1]-o2[1];});
        
        int end = -1;
        for(int[] target : targets){
            if(end == -1){
                answer++;
                end = target[1]-1;
                continue;
            }
            
            if(end >= target[0] && end <=target[1])
                continue;
            answer++;
            end = target[1]-1;
        }
        
        return answer;
    }
}