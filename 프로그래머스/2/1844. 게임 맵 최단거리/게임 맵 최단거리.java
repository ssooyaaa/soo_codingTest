import java.util.*;

class Solution {
    
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};
    boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        visited = new boolean[maps.length][maps[0].length];
        
        bfs(0,0,maps);
        
        if(maps[maps.length-1][maps[0].length-1]==0 || maps[maps.length-1][maps[0].length-1]==1)
            return -1;
        
        answer = maps[maps.length-1][maps[0].length-1];
        return answer;
    }
    
    public void bfs(int x, int y, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{x,y});
        maps[x][y] = 1;
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int i=0;i<4;i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(nx>=0 && ny>=0 && nx<maps.length && ny<maps[0].length){
                    if(!visited[nx][ny] && maps[nx][ny]==1){
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[now[0]][now[1]]+1;
                    }
                }
            }
        }
    }
}