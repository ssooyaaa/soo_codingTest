import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        int count = 1;
        set.add(words[0]);
        
        for(int i=1;i<words.length;i++){
            if(set.contains(words[i]))
                break;
            
            if(words[i].charAt(0)==words[i-1].charAt(words[i-1].length()-1)){
                set.add(words[i]);
                count++;
            }else break;
        }
        
        if(count == words.length) answer = new int[]{0,0};
        else answer = new int[]{count%n+1, count/n+1};
        
        return answer;
    }
}