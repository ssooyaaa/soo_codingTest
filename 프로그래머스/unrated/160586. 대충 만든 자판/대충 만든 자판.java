import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<keymap.length;i++){
            for(int j=0;j<keymap[i].length();j++){
                char ch = keymap[i].charAt(j);
                if(map.getOrDefault(ch,101)>j){
                    map.put(ch,j+1);
                }
            }
        }
        
        for(int i=0;i<targets.length;i++){
            int sum = 0;
            for(int j=0;j<targets[i].length();j++){
                char ch = targets[i].charAt(j);
                
                if(!map.containsKey(ch)){
                    sum = -1;
                    break;
                } sum += map.get(ch);
            } answer[i] = sum;
        }
        
        return answer;
    }
}