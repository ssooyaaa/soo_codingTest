import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        LinkedList<String> cache = new LinkedList<>();
        
        if(cacheSize==0) return 5*cities.length;
        
        for(String city : cities){
            city = city.toUpperCase();
            
            if(cache.remove(city)){
                answer += 1;
                cache.add(city);
            }else{
                answer += 5;
                if(cache.size()>=cacheSize) cache.remove(0);
                cache.add(city);
            }
        }
        return answer;
    }
}