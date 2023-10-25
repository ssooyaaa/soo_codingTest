import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> repq = new PriorityQueue<>(Collections.reverseOrder());
        
        int index = 0;
        for(int i=0;i<operations.length;i++){
            String[] operate = operations[i].split(" ");
            
            if(operate[0].equals("I")){
                pq.offer(Integer.parseInt(operate[1]));
                repq.offer(Integer.parseInt(operate[1]));
                index++;
            }else{
                if(index>0){
                    index--;
                    if(operate[1].equals("1")) repq.poll();
                    else pq.poll();
                }
            }
            
            if(index<=0){
                pq = new PriorityQueue<>();
                repq = new PriorityQueue<>(Collections.reverseOrder());
            }
            
        }
        if(index==0){
                return new int[]{0,0};
        }else{
            return new int[]{repq.poll(),pq.poll()};
        }
    }
}