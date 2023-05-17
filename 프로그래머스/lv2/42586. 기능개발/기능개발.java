import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> countList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++){
            if((100-progresses[i])%speeds[i]==0){
                q.add((100-progresses[i])/speeds[i]);
            }else{
                q.add((100-progresses[i])/speeds[i]+1);
            }
        }
        
        int a = q.poll();
        int count = 1;
        
        while(!q.isEmpty()){
            if(a>=q.peek()){
                count++;
                q.poll();
            }else{
                countList.add(count);
                count = 1;
                a = q.poll();
            }
        }
        
        countList.add(count);
        
        int[] answer = new int[countList.size()];
        
        for(int i=0;i<countList.size();i++){
            answer[i] = countList.get(i);
        }
        return answer;
    }
}