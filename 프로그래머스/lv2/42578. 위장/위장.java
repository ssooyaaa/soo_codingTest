import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0;i<clothes.length;i++){
            String cloth = clothes[i][1];
            map.put(cloth, map.getOrDefault(cloth,1)+1);
        }
        
        for(String key : map.keySet()){
            answer *= map.get(key);
        }
        
        
        return answer-1;
    }
}