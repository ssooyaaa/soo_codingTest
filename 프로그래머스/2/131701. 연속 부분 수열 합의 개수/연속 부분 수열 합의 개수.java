import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        int len = elements.length;
        int[] arr = new int[len*2];
        
        for(int i=0;i<len*2;i++){
            if(i>=len)
                arr[i] = elements[i-len];
            else
                arr[i] = elements[i];
        }
        
        int count = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0;i<len;i++){
            count++;
            int sum = 0;
            
            for(int j=0;j<len;j++){
                sum = 0;
                for(int k=j;k<j+count;k++){
                    sum += arr[k];
                }
                set.add(sum);
            }
        }
        answer = set.size();
        return answer;
    }
}