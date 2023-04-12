import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        List<int[]> list = new ArrayList<>();
        //yellow격자 list
        for(int i=1;i<=yellow;i++){
            if(yellow%i==0){
                list.add(new int[]{i,(yellow/i)});
            }
        }
        
        for(int i=0;i<list.size();i++){
            if((list.get(i)[0]+list.get(i)[1])*2+4 == brown){
                answer[0] = list.get(i)[0]+2;
                answer[1] = list.get(i)[1]+2;
            }
        }
        
        return answer;
    }
}