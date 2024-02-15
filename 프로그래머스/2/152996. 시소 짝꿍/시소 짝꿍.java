import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i=0;i<weights.length;i++){
            map.put(weights[i], map.getOrDefault(weights[i],0)+1);
            set.add(weights[i]);
        }
        
        for(int weight:set){
            long people = map.get(weight);
            
            int temp = weight*2;
            if(temp%3==0 && map.containsKey(temp/3)){
                answer += map.get(temp/3)*people;
            }
            if(temp%4==0 && map.containsKey(temp/4)){
                answer += map.get(temp/4)*people;
            }
            
            temp = weight*3;
            if(temp%2==0 && map.containsKey(temp/2)){
                answer += map.get(temp/2)*people;
            }
            if(temp%4==0 && map.containsKey(temp/4)){
                answer += map.get(temp/4)*people;
            }
            
            temp = weight*4;
            if(temp%2==0 && map.containsKey(temp/2)){
                answer += map.get(temp/2)*people;
            }
            if(temp%3==0 && map.containsKey(temp/3)){
                answer += map.get(temp/3)*people;
            }
            
            if(people>1){
                answer += people*(people-1)/2;
            }
            
            map.remove(weight);
        }
        
        return answer;
    }
}