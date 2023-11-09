import java.util.*;

class Solution {
    boolean[] visited;
    int count;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        
        return count;
    }
    
    public void dfs(int depth, int k, int[][] dungeons){
        for(int i=0;i<dungeons.length;i++){
            if(dungeons[i][0]<=k && !visited[i]){
                visited[i] = true;
                dfs(depth+1, k-dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        count = Math.max(depth, count);
    }
}