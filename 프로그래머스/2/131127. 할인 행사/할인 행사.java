import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i=0;i<want.length;i++)
            wantMap.put(want[i], number[i]);
        
        Map<String, Integer> discountMap = new HashMap<>();
        for(int i=0;i<10;i++)
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i],0)+1);
        
        if(check(wantMap, discountMap))
            answer++;
        
        for(int i=1;i<discount.length-9;i++){
            String prev = discount[i-1];
            int end = i+9;
            
            discountMap.put(prev, discountMap.getOrDefault(prev,0)-1);
            if(discountMap.get(prev)==0)
                discountMap.remove(prev);
            discountMap.put(discount[end], discountMap.getOrDefault(discount[end],0)+1);
            
            if(check(wantMap, discountMap)) 
                answer++;
        }
        
        
        return answer;
    }
    
    static boolean check(Map<String, Integer> wantMap, Map<String, Integer> discountMap){
        for(String key:discountMap.keySet()){
            if(!wantMap.containsKey(key) || discountMap.get(key) != wantMap.get(key))
                return false;
        }
        return true;
    }
}