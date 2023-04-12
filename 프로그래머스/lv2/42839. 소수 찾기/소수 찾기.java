import java.util.*;
class Solution {
    
    static HashSet<Integer> set = new HashSet<>();
    static char[] arr;
    static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for(int i=0;i<numbers.length();i++){
            arr[i] = numbers.charAt(i);
        }
        
        dfs("",0);
        answer = set.size();
        return answer;
    }
    
    public void dfs(String st, int index){
        int num;
        if(st!=""){
            num = Integer.parseInt(st);
            if(isPrime(num)) set.add(num);
        }
        if(index==arr.length) return;
        
        for(int i=0;i<arr.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            
            dfs(st+arr[i], index+1);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int num){
        if(num<2) return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}