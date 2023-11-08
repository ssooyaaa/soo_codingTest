import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> q = new LinkedList<>();
       
        for(int i=0;i<cities.length;i++){
            String city = cities[i].toUpperCase();
        
            if(!q.contains(city)){
                if(cacheSize==0){
                    answer += 5;
                    continue;
                }
                
                if(q.size()<cacheSize){
                    q.add(city);
                }else{
                    q.poll();
                    q.add(city);
                }
                
                answer += 5;
                
            }else{
                q.remove(city);
                q.add(city);
                answer++;
            }
        }
        
        return answer;
    }
}