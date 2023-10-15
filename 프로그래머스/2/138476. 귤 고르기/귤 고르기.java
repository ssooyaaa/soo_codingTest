import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }
        
        List<Integer> key = new ArrayList<>(map.keySet());
        
        key.sort((o1,o2) -> map.get(o2)-map.get(o1));
        
        int index = 0;
        while(k>0){
            k -= map.get(key.get(index));
            answer++;
            index++;
        }
        
        return answer;
    }
}