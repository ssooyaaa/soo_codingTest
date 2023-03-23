import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        
        HashSet<Integer> result = new HashSet<>();
        
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                int sum = numbers[i]+numbers[j];
                
                result.add(sum);
            }
        }
        
       
        int[] answer = new int[result.size()];
        int index=0;
        for(int i : result){
            answer[index]=i;
            index++;   
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}