import java.util.*;

class Solution {
    
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static int[] oil;
    
    static int n,m;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;
        
        visited = new boolean[n][m];
        oil = new int[m];
        
        for(int i=0;i<n; i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && land[i][j]==1){
                    bfs(i,j,land);
                }
            }
        }
        
        Arrays.sort(oil);
        
        return oil[m-1];
    }
    
    public void bfs(int x, int y, int[][] land){
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        
        int count = 1;
        Set<Integer> set = new HashSet<>();
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            set.add(now[1]);
            
            for(int i=0;i<4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                
                if(!check(nx, ny)) continue;
                
                if(land[nx][ny]==1 && !visited[nx][ny]){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    count += 1;
                }
            }
        }
        
        for(int idx : set){
            oil[idx] += count;
        }
        
    }
    
    public boolean check(int x, int y){
        if(x<0 || x>=n || y<0 || y>=m) return false;
        
        return true;
    }
}