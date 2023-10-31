import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        int[] arr = new int[elements.length*2];
        for(int i=0;i<arr.length;i++){
            if(i>elements.length-1) arr[i] = elements[i-elements.length];
            else arr[i] = elements[i];
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=1;i<=elements.length;i++){
            for(int j=0;j<elements.length;j++){
                int sum = 0;
                for(int k=j;k<j+i;k++){
                    sum += arr[k];
                }
                set.add(sum);
            }
        }
        
        return answer = set.size();
    }
}