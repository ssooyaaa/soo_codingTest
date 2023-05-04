import java.util.*;
class Solution {
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[places.length];
        
        for(int i=0;i<places.length;i++){
            String[] map = places[i];
            
            boolean check = true;
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    if(map[j].charAt(k)=='P'){
                        if(!bfs(j,k,map)){
                           check = false;
                        }
                    }
                }
                
            }
            answer[i] = check?1:0;
        }
        return answer;
    }
    
    public static boolean bfs(int j,int k, String[] map){
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{j,k});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int i=0;i<4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                
                if(nx<0 || ny<0 || nx>=5 || ny>=5 || (nx==j && ny==k)) continue;
                
                int d = Math.abs(nx-j) + Math.abs(ny-k);
                
                if(map[nx].charAt(ny)=='P' && d<=2) return false;
                else if(map[nx].charAt(ny)=='O' && d<2) q.add(new int[] {nx, ny});
            }
        }
        return true;
    }
    
}