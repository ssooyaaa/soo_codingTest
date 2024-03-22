import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                if(board[i].charAt(j)=='R')
                    answer = bfs(board, i, j);
            }
        }
        return answer;
    }
    
    public int bfs(String[] board, int x, int y){
        int n = board.length;
        int m = board[0].length();
        
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{1,-1,0,0};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        
        int[][] visited = new int[n][m];
        visited[x][y] = 1;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            x = now[0];
            y = now[1];
            
            for(int i=0;i<4;i++){
                int nx = x;
                int ny = y;
                
                while(nx>=0 && nx<n && ny>=0 && ny<m && board[nx].charAt(ny)!='D'){
                    nx += dx[i];
                    ny += dy[i];
                }
                
                nx -= dx[i];
                ny -= dy[i];
                
                if(board[nx].charAt(ny)=='G') return visited[x][y];
                
                if(visited[nx][ny]==0){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = visited[x][y]+1;
                }
            }
        }
        
        return -1;
    }
}