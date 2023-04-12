class Solution {
    static boolean[] visited;
    static int count = 0;
        
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        visited = new boolean[dungeons.length];
        
        dfs(0,k,dungeons);
        
        return count;
    }
    
    public void dfs(int depth, int k, int[][] dungeons){
       for(int i=0;i<dungeons.length;i++){
           if(!visited[i] && dungeons[i][0]<=k){
               visited[i] = true;
               dfs(depth+1, k-dungeons[i][1], dungeons);
               visited[i] = false;
           }
       }
        count = Math.max(count, depth);
    }
}