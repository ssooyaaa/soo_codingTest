import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String,Integer> termMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        int rtoday = getDay(today);
        
        for(int i=0;i<terms.length;i++){
            String[] term = terms[i].split(" ");
        
            termMap.put(term[0],Integer.parseInt(term[1]));
        }
        
        for(int i=0;i<privacies.length;i++){
            String[] privacy = privacies[i].split(" ");
            
            int privacyCount = getDay(privacy[0]);
            int total = privacyCount + (termMap.get(privacy[1])*28);
            
            if(rtoday>=total){
                answer.add(i+1);
            }
        }
        
        
        return answer.stream().mapToInt(integer -> integer).toArray();
    }
    
    public int getDay(String num){
        String total = num.replace(".","");
        int year = Integer.parseInt(total.substring(0,4));
        int month = Integer.parseInt(total.substring(4,6));
        int day = Integer.parseInt(total.substring(6,8));
        int count = (year*12*28)+(month*28)+day;
        
        return count;
    }
}