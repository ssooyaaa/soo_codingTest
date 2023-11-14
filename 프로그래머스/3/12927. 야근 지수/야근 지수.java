import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<works.length;i++){
            queue.add(works[i]);
        }
        
        for(int i=0;i<n;i++){
            int now = (int)queue.poll();
            if(now<=0) break;
            queue.add(now-1);
        }
       
        while(!queue.isEmpty()){
            answer += Math.pow(queue.poll(), 2);
        }
        
        return answer;
    }
}