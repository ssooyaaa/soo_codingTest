import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int last = attacks[attacks.length-1][0];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<attacks.length;i++){
            map.put(attacks[i][0], attacks[i][1]);
        }
        
        int conti = 0;
        int max = health;
        int current = health;
        
        for(int i=1;i<=last;i++){
            if(map.containsKey(i)){
                current -= map.get(i);
                
                conti = 0;
                if(current<=0) return -1;
            }else{
                conti++;
                current += bandage[1];
                
                if(conti>=bandage[0]){
                    current += bandage[2];
                    conti = 0;
                }
                
                if(current>max) current = max;
            }
        }
        
        answer = current;
        
        return answer;
    }
}