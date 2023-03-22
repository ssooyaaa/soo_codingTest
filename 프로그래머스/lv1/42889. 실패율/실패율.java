import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
       
        int[] answer = new int[N];
        HashMap<Integer,Double> map = new HashMap<>();
        
        for(int i=1;i<N+1;i++){
            int stage = i;
            int noUser = 0;
            int inStageUser = 0;
            
            for(int j=0;j<stages.length;j++){
                //스테이지 클리어X
                if(stage == stages[j]){
                    noUser++;
                }
                //스테이지 클리어O
                if(stage <= stages[j]){
                    inStageUser++;
                }
            }
            
            //실패율
            double failureRate = 0;
            if(noUser !=0 && inStageUser !=0){
                failureRate = (double)noUser / (double)inStageUser;
            }
            
            map.put(stage, failureRate);

        }
        
        //value 순으로 정렬 - 큰 값의 key부터 제거
        for(int i=0;i<N;i++){
            double max = -1;
            int maxKey = 0;
            
            for(Integer key : map.keySet()){
                if(max < map.get(key)){
                    max = map.get(key);
                    maxKey = key;
                }
            }
            
            answer[i] = maxKey;
            map.remove(maxKey);
        }
        
        return answer;
        
    }
}