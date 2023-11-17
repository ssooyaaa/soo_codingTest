import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] answer = {a,b,c,d};
        
        Arrays.sort(answer);
        
        if(answer[0]==answer[3])
            return 1111*answer[0];
        
        else if(answer[0]==answer[2])
            return (int)Math.pow((10*answer[0]+answer[3]),2);
        
        else if(answer[1]==answer[3])
            return (int)Math.pow((10*answer[1]+answer[0]),2);
        
        else if(answer[0]==answer[1] && answer[2] ==answer[3])
            return (answer[0]+answer[2])*Math.abs(answer[0]-answer[2]);
        
        else if(answer[0]==answer[1] || answer[1]==answer[2] || answer[2]==answer[3]){
            if(answer[0]==answer[1])
                return answer[2]*answer[3];
            else if(answer[1]==answer[2])
                return answer[0]*answer[3];
            else return answer[0]*answer[1];
        }
        
        else return answer[0];
        
    }
}