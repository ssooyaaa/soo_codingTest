import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(n, computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int n, int[][] computers, int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int j=0;j<n;j++){
                if(!visited[j] && computers[now][j]==1){
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
    }
}