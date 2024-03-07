import java.util.*;

class Solution {
    
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    
    static int[] start = new int[2];
    static int[] lever = new int[2];
    
    public int solution(String[] maps) {
        
        r = maps.length;
        c = maps[0].length();
        
        map = new char[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                map[i][j] = maps[i].charAt(j);
                
                if(map[i][j]=='S') start = new int[]{i, j};
                else if(map[i][j]=='L') lever = new int[]{i, j};
            }
        }
        
        visited = new boolean[r][c];
        int startToLever = bfs(start, 'L');
        
        visited = new boolean[r][c];
        int leverToEnd = bfs(lever, 'E');
        
        if(startToLever==-1 || leverToEnd==-1)
            return -1;
        
        return startToLever+leverToEnd;
    }
    
    public static int bfs(int[] point, char target){
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{point[0], point[1], 0});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            int x = now[0];
            int y = now[1];
            int count = now[2];
            visited[x][y] = true;
            
            if(map[x][y]==target) return count;
            
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if((nx>=0 && ny>=0 && nx<r && ny<c) && !visited[nx][ny] && map[nx][ny]!='X'){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, count+1});
                }
            }
        }
        
        return -1;
    }
}