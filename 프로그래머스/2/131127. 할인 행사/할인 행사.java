import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wMap = new HashMap<>();
        for(int i=0;i<want.length;i++){
            String w = want[i];
            int n = number[i];
            
            wMap.put(w, n);
        }
        
        Map<String, Integer> dMap = new HashMap<>();
        for(int i=0;i<10;i++){
            dMap.put(discount[i], dMap.getOrDefault(discount[i],0)+1);
        }
        
        if(check(wMap, dMap)) answer++;
        
        for(int i=1;i<discount.length-9;i++){
            String prev = discount[i-1];
            dMap.put(prev, dMap.getOrDefault(prev,0)-1);
            
            if(dMap.get(prev)<=0){
                dMap.remove(prev);
            }
            
            dMap.put(discount[i+9], dMap.getOrDefault(discount[i+9],0)+1);
            
            if(check(wMap, dMap)) answer++;
        }
        
        
        return answer;
    }
    
    public boolean check(Map<String, Integer> wMap, Map<String, Integer> dMap){
        for(String key : wMap.keySet()){
            if(!dMap.containsKey(key) || dMap.get(key)!=wMap.get(key)) return false;
        }
        return true;
    }
}