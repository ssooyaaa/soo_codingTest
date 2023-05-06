import java.util.*;

class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<str.length;i++){
            list.add(Integer.parseInt(str[i]));
        }
        
        Collections.sort(list);
        
        String answer = "";
        
        String min = (list.get(0)).toString();
        String max = (list.get(list.size()-1)).toString();
        answer = min+" "+max;
        
        return answer;
    }
}