import java.util.*;
class Solution {
    static String[] arr;
    static List<String> list;
    
    public int solution(String word) {
        int answer = 0;
        
        list = new ArrayList<>();
        arr = new String[]{"A","E","I","O","U"};
        recur("",0);
        
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    static void recur(String s, int depth){
        list.add(s);
        
        if(depth==5){
            return;
        }
        for(int i=0;i<arr.length;i++){
            recur(s+arr[i],depth+1);
        }
    }
    
}