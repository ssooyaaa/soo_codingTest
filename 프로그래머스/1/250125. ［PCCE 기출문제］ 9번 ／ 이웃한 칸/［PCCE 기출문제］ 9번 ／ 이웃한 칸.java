import java.util.*;

class Solution {
    
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static int answer=0;
    static int nh, nw;
    
    public int solution(String[][] board, int h, int w) {
        
        visited = new boolean[board.length][board[0].length];
        nh = h;
        nw = w;
        
        dfs(board, h, w);
        
        return answer;
    }
    
    public void dfs(String[][] board, int x, int y){
        visited[x][y] = true;
        String color = board[x][y];
        
        for(int i=0;i<4;i++){
            int nx = nh+dx[i];
            int ny = nw+dy[i];
            
            if(nx>=0 && ny>=0 && nx<board.length && ny<board.length){
                if(!visited[nx][ny] && board[nh][nw].equals(board[nx][ny])){
                    answer++;
                    dfs(board, nx, ny);
                }
            }
        }
    }
}