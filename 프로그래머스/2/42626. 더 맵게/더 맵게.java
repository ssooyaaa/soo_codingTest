import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<scoville.length;i++){
            pq.add(scoville[i]);
        }
        
        while(pq.peek()<K){
            
            int first = pq.poll();
            int second = pq.poll();
            
            int sc = first + (second*2);
            
            if(pq.isEmpty() && sc<K) return -1;
            
            pq.add(sc);
            answer++;
            
        }
        
        return answer;
    }
}