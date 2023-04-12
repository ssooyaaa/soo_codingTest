import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] arr = new String[numbers.length];
        
        for(int i=0;i<arr.length;i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });
        
        if(arr[0].equals("0")) return "0";
        
        for(String s:arr)
            answer += s;
        
        
        return answer;
    }
}