import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            visited[now[0]][now[1]]=true;
            for(int i=0;i<4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                
                if(nx<0 || ny<0 || nx>=maps.length || ny>=maps[0].length)
                    continue;
                if(visited[nx][ny] || maps[nx][ny]==0)
                    continue;
                maps[nx][ny] = maps[now[0]][now[1]]+1;
                visited[nx][ny] = true;
                q.offer(new int[]{nx,ny});
                
                
                
            }
        }
        
        answer = maps[maps.length-1][maps[0].length-1];
        if(answer==0 || answer==1)
            answer = -1;
        
        return answer;
    }
}