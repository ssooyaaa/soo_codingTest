class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        
        for(int i=0;i<computers.length;i++){
            if(!visited[i]){
                answer++;
                dfs(i,visited,computers);
            }
        }
        
        return answer;
    }
    
    void dfs(int n, boolean[] visited, int[][] computers){
        visited[n] = true;
        
        for(int i=0;i<computers.length;i++){
            if(!visited[i] && computers[n][i]==1){
                dfs(i,visited, computers);
            }
        }
    }
}